package application.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import application.model.Professor;
public class CreateQuiz_Controller {

	Professor prof;

    @FXML
    private Button btnCreateQuiz;

    @FXML
    private Label lblQuizCode;

    @FXML
    private TextArea txtOption1;

    @FXML
    private TextArea txtOption2;

    @FXML
    private TextArea txtOption3;

    @FXML
    private TextArea txtOption4;

    @FXML
    private TextArea txtQuestion;

    @FXML
    private TextArea txtQuizName;

    @FXML
    private TextField txtQuizTime;

    @FXML
    void newQuiz(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) btnCreateQuiz.getScene().getWindow();
    	prof = new Professor();
    	String question = txtQuestion.getText();
    	String option1 = txtOption1.getText();
    	String option2 = txtOption2.getText();
    	String option3 = txtOption3.getText();
    	String option4 = txtOption4.getText();
    	String correctAns = "1";
    	Long quizTime = Long.parseLong(txtQuizTime.getText());
    	String quizName = txtQuizName.getText();
    	
    	if(question.isEmpty()||option1.isEmpty()||option2.isEmpty()||option3.isEmpty()||option4.isEmpty()||quizTime==0||quizName.isEmpty()) {
      		 Alert alert = new Alert(Alert.AlertType.ERROR);
      	        alert.setHeaderText("Error");
      	        alert.setContentText("One or more field is empty!!");
      	        alert.showAndWait();
      	     return;
      	}
    	
    	String quizId = prof.createQuiz(question, option1, option2, option3, option4, correctAns,  quizName, quizTime);
    	lblQuizCode.setText(quizId);
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("New Quiz created!");
    	alert.setHeaderText(null);
    	alert.setContentText("Your quiz code is: "+quizId);
    	//alert.showAndWait();

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.isPresent() && result.get() == ButtonType.OK) {
    	    // The user clicked the OK button
        	Parent root = FXMLLoader.load(getClass().getResource("/application/view/FacultyLandingPage.fxml"));
    		Scene scene = new Scene(root);
    		primaryStage.setTitle("User Login");
    		primaryStage.setScene(scene);
    		primaryStage.show();
    	} 

    	
    }

}
