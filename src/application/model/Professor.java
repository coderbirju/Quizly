package application.model;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import application.ConnectToDB;

import java.time.ZoneId;
import java.util.ArrayList;

public class Professor  {
	
	private List<String> quizIds;
	private User loggedInUser;
	
	public Professor() {
		super();
		this.loggedInUser = User.getLoggedInUser();
		System.out.println("Inside professor -> this.loggedInUser = " + this.loggedInUser.getUserName());
		quizIds = new ArrayList<>();
		fetchQuizIds();
//		String ret1 = createQuiz("What is the capital of France?", "Paris", "Madrid", "Berlin", "London", "European Capitals Quiz", 30);
//		System.out.println("ret1" + ret1);
//		createQuiz("What is the tallest mammal?", "Giraffe", "Elephant", "Hippopotamus", "Rhino", "Animal Kingdom Quiz", 45);
//		createQuiz("What is the boiling point of water?", "100 degrees Celsius", "50 degrees Celsius", "200 degrees Celsius", "0 degrees Celsius", "Chemistry Quiz", 60);

	}


	public String createQuiz(String question, String option1, String option2, String option3, String option4, String QuizName, long endMins) {
		System.out.println(" insife createQuiz loggedInUser -> " + loggedInUser + " loggedInUser.getRole() " + loggedInUser.getRole());
		if(loggedInUser == null || loggedInUser.getRole() != "PROFESSOR")
			return "Not allowed";
		Quiz newQuiz = new Quiz(question, option1,option2,option3,option4,loggedInUser.getUserName(), endMins, QuizName);
		String uniqueId = newQuiz.saveQuiz();
		return uniqueId;
	}
	
	public List<String> getQuizIds() {
		return this.quizIds;
	}
	
	private void fetchQuizIds() {
		ConnectToDB db = ConnectToDB.getInstance();
		MongoCollection<Document> collection = db.getCollection("quiz");
		Document query = new Document("professor", loggedInUser.getUserName());
		FindIterable<Document> iterable = collection.find(query);
		
		for(Document document : iterable) {
			String quizId = document.getString("quizId");
			this.quizIds.add(quizId);
		}
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
					Response response = new Response(quizDocument.getInteger("choice"),responseDocument.getString("Student"), quizDocument.getInteger("rating"));
					responses.add(response);
				}
			}
			
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
					responses
					);
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
	
	
	
	
	
}
