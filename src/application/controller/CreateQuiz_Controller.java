package application.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

import application.model.Professor;
public class CreateQuiz_Controller {

	Professor prof;
    @FXML
    private Button btnCreateQuiz;

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
    void newQuiz(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) btnCreateQuiz.getScene().getWindow();
    	prof = new Professor();
    	String question = txtQuestion.getText();
    	String option1 = txtOption1.getText();
    	String option2 = txtOption2.getText();
    	String option3 = txtOption3.getText();
    	String option4 = txtOption4.getText();
    	
    	String quizId = prof.createQuiz(question, option1, option2, option3, option4, "Test Quiz", 5);
    	System.out.println("Quiz created with id ----->" + quizId);
    	Parent root = FXMLLoader.load(getClass().getResource("/application/view/FacultyLandingPage.fxml"));
		Scene scene = new Scene(root, 800, 435);
		primaryStage.setTitle("User Login");
		primaryStage.setScene(scene);
		primaryStage.show();
    	
    }

}
