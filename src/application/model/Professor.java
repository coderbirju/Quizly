package application.model;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import application.ConnectToDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Professor extends User  {
	
	private ObservableList<Quiz> quizzes;
	private User loggedInUser;
	
	public Professor() {
		super();
		//System.out.println("Inside professor -> this.loggedInUser = " + getUserName());
		quizzes = FXCollections.observableArrayList();
		loggedInUser = User.getLoggedInUser();
		fetchQuizzes();
	}


	public String createQuiz(String question, String option1, String option2, String option3, String option4, String correctAns, String QuizName, long endMins) {
		if(loggedInUser == null || loggedInUser.getRole() != "PROFESSOR") {
			return "Not allowed";
		}
		Quiz newQuiz = new Quiz(question, option1,option2,option3,option4, correctAns, loggedInUser.getUserName(), endMins, QuizName);
		String uniqueId = newQuiz.saveQuiz();
		return uniqueId;
	}
	
	public ObservableList<Quiz> getQuizzes() {
		return this.quizzes;
	}
	
	
	public Quiz fetchQuizById(String quizId) {
		ConnectToDB db = ConnectToDB.getInstance();
		MongoCollection<Document> collection = db.getCollection("quiz");
		Document query = new Document("quizId", quizId);
		Document quizDocument = collection.find(query).first();
		
		if(quizDocument != null) {
			List<Document> responseDocuments = quizDocument.getList("responses", Document.class);
			List<Response> responses = new ArrayList<>();
			if(responseDocuments != null && responseDocuments.size() > 0) {
				for (Document responseDocument : responseDocuments) {
					Response response = new Response(responseDocument.getString("choice"),responseDocument.getString("Student"), responseDocument.getString("rating"));
					responses.add(response);
				}
			}
			
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
					convertToLocalDateTime(quizDocument.getString("endTime")),
					responses
					);
//					quizDocument.getDate("endTime").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
			return quiz;
		} else
			return null;
	}
	
	
	public List<String> getQuizAttendance(Quiz quiz) {
		List<String> studentNames = new ArrayList<>();
		List<Response> responses = quiz.getResponses();
		for(Response response : responses) {
			String name = response.getStudent();
			studentNames.add(name);
		}
		return studentNames;
	}
	
	
	public static LocalDateTime convertToLocalDateTime(String dateToConvert) {
		DateConverterUtil converter = new DateConverterUtil();
		LocalDateTime date = converter.stringToDateTime(dateToConvert);
		System.out.println("convertToLocalDateTime ============ " + date);
        return date;
    }
	
	
	public void fetchQuizzes() {
		ConnectToDB db = ConnectToDB.getInstance();
		MongoCollection<Document> collection = db.getCollection("quiz");
		Document query = new Document("professor", loggedInUser.getUserName());
		FindIterable<Document> iterable = collection.find(query);
		
		
		for(Document document : iterable) {
			if(document != null) {
				Quiz leanQuiz = new Quiz(document.getString("quizId"), document.getString("quizName"), convertToLocalDateTime(document.getString("endTime")));
				this.quizzes.add(leanQuiz);
			}
		}
	}
	
	
	public QuizAnalytics getQuizAnalytics(String quizId) {
		QuizAnalytics analytics = new QuizAnalytics();
		Quiz takenQuiz = null;
		
		for(Quiz quiz : this.quizzes) {
			if(quiz.getQuizId().equals(quizId)) {
				takenQuiz = fetchQuizById(quizId);
			}
		}
		
		if(takenQuiz != null) {
			
			long avgRating = 0;
			long totalRating = 0;
			List<Response> responses = takenQuiz.getResponses();
			long numOfResponses = responses.size();
			for(Response response : responses) {
				totalRating += Long.parseLong(response.getRating());
				switch(response.getChoice()) {
					case "1": analytics.setOption1(analytics.getOption1() + 1);
					break;
					case "2": analytics.setOption2(analytics.getOption2() + 1);
					break;
					case "3": analytics.setOption3(analytics.getOption3() + 1);
					break;
					case "4": analytics.setOption4(analytics.getOption4() + 1);
					break;
				}
			}
			if(numOfResponses > 0) {
				avgRating = totalRating/numOfResponses;
				analytics.setAvgRating(avgRating);
			}
		}
		
		return analytics;
	}
	
}
