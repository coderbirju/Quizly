package application.controller;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.RadioButton;

import java.util.Optional;

import org.controlsfx.control.Rating;


import application.model.ApiResponse;
import application.model.Quiz;
import application.model.Student;



public class QuizPage_Controller {

	//private String currentQuizId;
    @FXML
    private Button btnSubmitquiz;

    @FXML
    private Button btnsubmit;

    @FXML
    private Rating classRatings;
    
    @FXML
    private Label lblQuestion;

    @FXML
    private ToggleGroup toggleGroup;
    
    @FXML
    private AnchorPane QuizPane;

    @FXML
    private RadioButton radioOption1;

    @FXML
    private RadioButton radioOption2;

    @FXML
    private RadioButton radioOption3;

    @FXML
    private RadioButton radioOption4;

    @FXML
    private TextField txtQuizCode;

    @FXML
    private AnchorPane viewArea;
    
    Student student = new Student();
	Quiz quiz;

    @FXML
    void submit(ActionEvent event) {
    	String quizId = txtQuizCode.getText();
	   
   	
   	if(quizId.isEmpty()) {
   		 Alert alert = new Alert(Alert.AlertType.ERROR);
   	        alert.setHeaderText("Error");
   	        alert.setContentText("Quiz ID field cannot be empty");
   	        alert.showAndWait();
   	        return;
   	}
   	
	 quiz = student.getQuiz(quizId);
   	
   	if(quiz==null) {
   		Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setHeaderText("Error");
	        alert.setContentText("Incorrect quiz ID or Time out!");
	        alert.showAndWait();
	        return;
   	}
   	
   	

	lblQuestion.setText(quiz.getQuestion());
	radioOption1.setText(quiz.getOption1());
	radioOption2.setText(quiz.getOption2());
	radioOption3.setText(quiz.getOption3());
	radioOption4.setText(quiz.getOption4());
  	
	QuizPane.setVisible(true);
  	
   	
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
        
        String selected = "";
        
        if(radioOption1.isSelected()) {
        	selected = "1";
        } else if(radioOption2.isSelected()) {
        	selected = "2";
        } else if(radioOption3.isSelected()) {
        	selected = "3";
        } else if(radioOption4.isSelected()) {
        	selected = "4";
        }
        String rating = Double.toString(classRatings.getRating());
        
        ApiResponse response = student.submitQuiz(selected, rating);
        //System.out.println("response " + response.getStatus() + " reason " + response.getReason());
        
        if(response.getStatus().equals("Fail")) {
        	Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText(response.getReason());
            alert.showAndWait();
            Optional<ButtonType> result = alert.showAndWait();
        	if (result.isPresent() && result.get() == ButtonType.OK) {
        	    // The user clicked the OK button
        	 QuizPane.setVisible(false);
        	}
        	 return;
        } 
        else if(selected.equals(quiz.getCorrectAnswer())) {
	        Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Quiz Result pass");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Congratulations your answer is correct!");
	    	 //alert.showAndWait();
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.isPresent() && result.get() == ButtonType.OK) {
	    	    // The user clicked the OK button
	    	 QuizPane.setVisible(false);
	    	}
	    	 return;
        }
        
        else {
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Quiz Result Fail");
        	alert.setHeaderText(null);
        	alert.setContentText("Oh no your answer is incorrect!");
        	// alert.showAndWait();
        	 Optional<ButtonType> result = alert.showAndWait();
         	if (result.isPresent() && result.get() == ButtonType.OK) {
         	    // The user clicked the OK button
         	 QuizPane.setVisible(false);
         	}
        	 return;
        }
      }

}