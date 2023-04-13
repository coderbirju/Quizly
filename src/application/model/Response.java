package application.model;

public class Response {
	private int choice;
	private String student;
	private int rating;
	
	public Response(int choice, String student, int rating) {
		super();
		this.choice = choice;
		this.student = student;
		this.rating = rating;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
