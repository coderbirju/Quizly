package application.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class CreateQuiz_Controller {

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
    void newQuiz(ActionEvent event) {
    	String question = txtQuestion.getText();
    	String option1 = txtOption1.getText();
    	String option2 = txtOption2.getText();
    	String option3 = txtOption3.getText();
    	String option4 = txtOption4.getText();
    	
    	
    }

}
