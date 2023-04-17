package application.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
		System.out.println("loggedInUser " + loggedInUser.getUserName());
		// to be del
		Quiz dummyQuiz = getQuiz("new713");
		ApiResponse resp = submitQuiz(4, 4);
		System.out.println(resp.getStatus() + " " + resp.getReason());
		
	}
	
	public Quiz getQuiz(String quizId) {
		currentQuizId = quizId;
		MongoCollection<Document> collection = db.getCollection("quiz");
		Document query = new Document("quizId", quizId);
		Document quizDocument = collection.find(query).first();
		
		if(quizDocument != null) {
						
			Quiz quiz = new Quiz(
					quizDocument.getString("question"),
					quizDocument.getString("option1"),
					quizDocument.getString("option2"),
					quizDocument.getString("option3"),
					quizDocument.getString("option4"),
					quizDocument.getInteger("rating"),
					quizDocument.getString("professor"),
					quizDocument.getString("quizName"),
					quizDocument.getDate("endTime").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
					new ArrayList<>()
					);
			LocalDateTime now = LocalDateTime.now();
			if(quiz.getEndTime().isAfter(now)) {
				return quiz;				
			}
			else 
				return null;
		} else
			return null;
	}
	
	public ApiResponse submitQuiz(int optionSelected, int rating) {
		MongoCollection<Document> collection = db.getCollection("quiz");
		Document query = new Document("quizId", currentQuizId);
		Document quizDocument = collection.find(query).first();
		ApiResponse apiResponse = new ApiResponse("Fail", "Cannot find quiz");
		if(quizDocument != null) {
			List<Document> responseDocuments = quizDocument.getList("responses", Document.class);
			if(responseDocuments != null && responseDocuments.size() > 0) {
				for (Document responseDocument : responseDocuments) {
					Response response = new Response(quizDocument.getInteger("choice"),responseDocument.getString("Student"), quizDocument.getInteger("rating"));
					if(response.getStudent() == getUserName()) {
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
