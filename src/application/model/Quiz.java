package application.model;

import java.util.List;
import java.util.ArrayList;

public class Quiz {
	private String Question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private int rating;
	private String Professor;
	private String QuizName;
	private List<Response> Responses;
	
	
	public Quiz(String question, String option1, String option2, String option3, String option4, int rating,
			String professor, String quizName, List<Response> responses) {
		super();
		Question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rating = rating;
		Professor = professor;
		QuizName = quizName;
		Responses = responses;
	}
	
	public Quiz(String question, String option1, String option2, String option3, String option4,
			String professor, String quizName) {
		super();
		Question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rating = 0;
		Professor = professor;
		QuizName = quizName;
		Responses = new ArrayList<>();
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

//{
//	"St": ["3", "8"]
//}
