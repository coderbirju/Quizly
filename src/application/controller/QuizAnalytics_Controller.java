package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.controlsfx.control.Rating;

import application.model.Professor;
import application.model.Quiz;
import application.model.QuizAnalytics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class QuizAnalytics_Controller {

    @FXML
    private Button btnAnalytics;

    @FXML
    private Button btnRatings;

    @FXML
    private Button btnReset2;

    @FXML
    private Button btnSearch2;

    @FXML
    private TextField txtQuizCode2;
    
    @FXML
    private Label lblQuestion;

    @FXML
    private Label lblOption1;

    @FXML
    private Label lblOption2;

    @FXML
    private Label lblOption3;

    @FXML
    private Label lblOption4;
    
    @FXML
    private Rating classRatings;

    @FXML
    void classRatings(ActionEvent event) {

    }

    //List<Integer> barchartData = new ArrayList<>();
    public void initialize() throws IOException {
    	classRatings.setDisable(true);
    }
	 
	 
    
    @FXML
    void quizAlanytics(ActionEvent event) throws IOException {
    	 Professor prof = new Professor();
    	String quizId = txtQuizCode2.getText();
    	QuizAnalytics analytics = prof.getQuizAnalytics(quizId);
    	int counter1 = analytics.getOption1();
    	int counter2 =  analytics.getOption2();
    	int counter3 = analytics.getOption3();
    	int counter4 =  analytics.getOption4();
    	Stage newWindow = new Stage();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/BarChart.fxml"));
    	Parent root = loader.load();
    	BarChart_Controller scene2Controller = loader.getController();
    	 scene2Controller.setData(counter1, counter2, counter3, counter4);
    	Scene newScene = new Scene(root);
    	newWindow.setScene(newScene);
    	newWindow.show();

    }

    @FXML
    void resetSearch(ActionEvent event) {
    	txtQuizCode2.setText("");

    }

    @FXML
    void searchQuiz2(ActionEvent event) {
    	
    	String quizId = txtQuizCode2.getText();
    	 Professor prof = new Professor();
    	Quiz quiz = prof.fetchQuizById(quizId);
    	
    	if(quizId.isEmpty()) {
    		 Alert alert = new Alert(Alert.AlertType.ERROR);
    	        alert.setHeaderText("Error");
    	        alert.setContentText("Quiz ID field cannot be empty");
    	        alert.showAndWait();
    	        return;
    	}

    
    	QuizAnalytics analytics = prof.getQuizAnalytics(quizId);
    	double rating = analytics.getAvgRating();
    	classRatings.setRating(rating);
    	//System.out.println("rating counter"+rating);
    	lblQuestion.setText(quiz.getQuestion());
    	lblOption1.setText(quiz.getOption1());
      	lblOption2.setText(quiz.getOption2());
      	lblOption3.setText(quiz.getOption3());
      	lblOption4.setText(quiz.getOption4());
      	
      	
    	
    }

}
