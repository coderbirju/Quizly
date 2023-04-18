package application.model;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import application.ConnectToDB;

public class Quiz {
	private String Question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private int rating;
	private String Professor;
	private String QuizName;
	private String quizId;
	private LocalDateTime endTime;
	private List<Response> Responses;
	
	public Quiz(String question, String option1, String option2, String option3, String option4, int rating,
			String professor, String quizName, LocalDateTime endTime, List<Response> responses) {
		setQuestion(question);
		setOption1(option1);
		setOption2(option2);
		setOption3(option3);
		setOption4(option4);
		setRating(rating);
		setEndTime(endTime);
		setProfessor(professor);
		setQuizName(quizName);
		setResponses(responses);
	}
	
	public Quiz(String question, String option1, String option2, String option3, String option4,
			String professor, long endMins, String quizName) {

		setQuestion(question);
		setOption1(option1);
		setOption2(option2);
		setOption3(option3);
		setOption4(option4);
		setRating(0);
		setEndTime(endTime);
		setProfessor(professor);
		setQuizName(quizName);
		setResponses(new ArrayList<>());
	
		Random rand = new Random();
		int randomNumber = rand.nextInt(900) + 100;
		setQuizId(quizName.substring(0, 3) + randomNumber);
		
		LocalDateTime now = LocalDateTime.now();
		setEndTime(now.plusMinutes(endMins));
		
	}
	
	protected Quiz(String quizId, String quizName, LocalDateTime endTime) {
		setQuizId(quizId);
		setQuizName(quizName);
		setEndTime(endTime);
		setQuestion("");
		setOption1("");
		setOption2("");
		setOption3("");
		setOption4("");
		setRating(0);
		setProfessor("");
		setResponses(new ArrayList<>());
	}
	
	
	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getQuizId() {
		return quizId;
	}
	
	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}
	
	
	public String saveQuiz() {
		try {
			ConnectToDB db = ConnectToDB.getInstance();
			MongoCollection<Document> collection = db.getCollection("quiz");

			Document quizDocument = new Document()
				.append("quizId", this.getQuizId())
		        .append("question", this.getQuestion())
		        .append("option1", this.getOption1())
		        .append("option2", this.getOption2())
		        .append("option3", this.getOption3())
		        .append("option4", this.getOption4())
		        .append("rating", this.getRating())
		        .append("professor", this.getProfessor())
		        .append("quizName", this.getQuizName())
		        .append("endTime", this.getEndTime())
		        .append("responses", new ArrayList<Document>());
			
			System.out.println("adding this quiz" + quizDocument.toString());
			
			collection.insertOne(quizDocument);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return this.getQuizId();
	}

	public String getProfessor() {
	return Professor;
	}
	
	public void setProfessor(String professor) {
		Professor = professor;
	}
	
	public String getQuizName() {
		return QuizName;
	}
	
	public void setQuizName(String quizName) {
		QuizName = quizName;
	}
	
	public List<Response> getResponses() {
		return Responses;
	}
	
	public void setResponses(List<Response> responses) {
		Responses = responses;
	}

	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
