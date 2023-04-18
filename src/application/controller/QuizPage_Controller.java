package application.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;

import org.bson.Document;
import org.controlsfx.control.Rating;

import com.mongodb.client.MongoCollection;

import application.model.ApiResponse;
import application.model.Professor;
import application.model.Quiz;
import application.model.QuizAnalytics;
import application.model.Student;



public class QuizPage_Controller {

	private String currentQuizId;
    @FXML
    private Button btnSubmitquiz;

    @FXML
    private Button btnsubmit;

    @FXML
    private Rating classRatings;

    @FXML
    private Label lblOption1;

    @FXML
    private Label lblOption2;

    @FXML
    private Label lblOption3;

    @FXML
    private Label lblOption4;
    
    @FXML
    private Label lblQuestion;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private TextField txtQuizCode;

    @FXML
    private AnchorPane viewArea;

    @FXML
    void submit(ActionEvent event) {
    	String quizId = txtQuizCode.getText();
   	 Professor prof = new Professor();
   	Quiz quiz = prof.fetchQuizById(quizId);
   	
   	if(quizId.isEmpty()) {
   		 Alert alert = new Alert(Alert.AlertType.ERROR);
   	        alert.setHeaderText("Error");
   	        alert.setContentText("Quiz ID field cannot be empty");
   	        alert.showAndWait();
   	        return;
   	}
   	
   	Quiz quiz1 = prof.fetchQuizById(quizId);
	

	lblQuestion.setText(quiz.getQuestion());
	lblOption1.setText(quiz.getOption1());
  	lblOption2.setText(quiz.getOption2());
  	lblOption3.setText(quiz.getOption3());
  	lblOption4.setText(quiz.getOption4());
  	
  	
   	
    }

    @FXML
    void submitQuiz(ActionEvent event) {
    	
    	if (toggleGroup.getSelectedToggle() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Please select an answer");
            alert.showAndWait();
            return;
        }

        if (classRatings.getRating() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Please rate the class");
            alert.showAndWait();
            return;
        }
        
      }

}