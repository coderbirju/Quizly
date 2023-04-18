package application.model;

public class QuizAnalytics {
	private int option1;
	private int option2;
	private int option3;
	private int option4;
	private double avgRating;
	
	public QuizAnalytics(int option1, int option2, int option3, int option4, float avgRating) {
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.avgRating = avgRating;
	}
	
	public QuizAnalytics() {
		this.option1 = 0;
		this.option2 = 0;
		this.option3 = 0;
		this.option4 = 0;
		this.avgRating = 0;
	}

	public int getOption1() {
		return option1;
	}

	public void setOption1(int option1) {
		this.option1 = option1;
	}

	public int getOption2() {
		return option2;
	}

	public void setOption2(int option2) {
		this.option2 = option2;
	}

	public int getOption3() {
		return option3;
	}

	public void setOption3(int option3) {
		this.option3 = option3;
	}

	public int getOption4() {
		return option4;
	}

	public void setOption4(int option4) {
		this.option4 = option4;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	
}
