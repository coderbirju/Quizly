package application.model;

public class Response {
	private String choice;
	private String student;
	private String rating;
	
	public Response(String choice, String student, String rating) {
		this.choice = choice;
		this.student = student;
		this.rating = rating;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
}
