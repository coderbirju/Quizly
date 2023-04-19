package application.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import application.ConnectToDB;

public class Student extends User {
	
	private ConnectToDB db;
	private String currentQuizId;
	private User loggedInUser;
	
	public Student() {
		db = ConnectToDB.getInstance();
		loggedInUser = User.getLoggedInUser();
		
	}
	
	public Quiz getQuiz(String quizId) {
		this.currentQuizId = quizId;
		System.out.println("this.currentQuizId - getQuiz " + this.currentQuizId);
		MongoCollection<Document> collection = db.getCollection("quiz");
		Document query = new Document("quizId", quizId);
		Document quizDocument = collection.find(query).first();
		
		System.out.println("outside quizDocument ");
		if(quizDocument != null) {
			System.out.println("inside quizDocument " );
						
			Quiz quiz = new Quiz(
					quizDocument.getString("quizId"),
					quizDocument.getString("question"),
					quizDocument.getString("option1"),
					quizDocument.getString("option2"),
					quizDocument.getString("option3"),
					quizDocument.getString("option4"),
					quizDocument.getString("correctAnswer"),
					quizDocument.getInteger("rating"),
					quizDocument.getString("professor"),
					quizDocument.getString("quizName"),
					quizDocument.getDate("endTime").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
					new ArrayList<>()
					);
//			LocalDateTime now = LocalDateTime.now();
//			ZoneId zoneId = ZoneId.systemDefault();
//			ZonedDateTime zonedDateTime = ZonedDateTime.of(now, zoneId);
//			System.out.println("zonedDateTime " + zonedDateTime + "quiz.getEndTime() " + quiz.getEndTime());
//			System.out.println("zonedDateTime.isBefore(quiz.getEndTime() " + quiz.getEndTime().isAfter(zonedDateTime.toLocalDateTime()));
			System.out.println("quiz inside getQuiz " + quiz.toString() + quiz.getQuizId());
			return quiz;
//			if(now.isBefore(quiz.getEndTime())) {
//				return quiz;				
//			}
//			else 
//				return null;
		} else
			return null;
	}
	
	public ApiResponse submitQuiz(String optionSelected, String rating) {
		MongoCollection<Document> collection = db.getCollection("quiz");
		System.out.println("currentQuizId - submitQuiz" + this.currentQuizId);
		Document query = new Document("quizId", this.currentQuizId);
		Document quizDocument = collection.find(query).first();
		ApiResponse apiResponse = new ApiResponse("Fail", "Cannot find quiz");
		if(quizDocument != null) {
			List<Document> responseDocuments = quizDocument.getList("responses", Document.class);
			if(responseDocuments != null && responseDocuments.size() > 0) {
				for (Document responseDocument : responseDocuments) {
					Response response = new Response(responseDocument.getString("choice"),responseDocument.getString("Student"), responseDocument.getString("rating"));
					
					if(response.getStudent().equals(loggedInUser.getUserName())) {
						apiResponse.setReason("User has already attempted quiz");
						return apiResponse;
					}
				}
			}
			Response newResponse = new Response(optionSelected, loggedInUser.getUserName(), rating);
			Document responseDocument = new Document()
                    .append("choice", newResponse.getChoice())
                    .append("Student", newResponse.getStudent())
                    .append("rating", newResponse.getRating());
			responseDocuments.add(responseDocument);
			quizDocument.put("responses", responseDocuments);
			collection.replaceOne(query, quizDocument);
			apiResponse.setStatus("Success");
			apiResponse.setReason("Response added");
			
		}
		return apiResponse;
	}

}
