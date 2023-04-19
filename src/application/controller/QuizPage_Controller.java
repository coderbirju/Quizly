package application.controller;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.RadioButton;

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
	   	 quiz = student.getQuiz(quizId);
   	
   	if(quizId.isEmpty()) {
   		 Alert alert = new Alert(Alert.AlertType.ERROR);
   	        alert.setHeaderText("Error");
   	        alert.setContentText("Quiz ID field cannot be empty");
   	        alert.showAndWait();
   	        return;
   	}
   	
   	if(quiz==null) {
   		Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setHeaderText("Error");
	        alert.setContentText("Incorrect quiz ID or Time out!");
	        alert.showAndWait();
	        return;
   	}
   	
   	

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
        System.out.println("response " + response.getStatus() + " reason " + response.getReason());
        
        if(selected.equals(quiz.getCorrectAnswer()))
        {
        Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Quiz Result pass");
    	alert.setHeaderText(null);
    	alert.setContentText("Congratulations your answer is correct!");
    	 alert.showAndWait();
    	 return;

        }
        
        else {
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Quiz Result Fail");
        	alert.setHeaderText(null);
        	alert.setContentText("Oh no your answer is incorrect!");
        	 alert.showAndWait();
        	 return;
        }
      }

}