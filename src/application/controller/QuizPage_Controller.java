package application.controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class QuizPage_Controller {
	
	@FXML
	private TextField Code;

    @FXML
    private Button submit;
    
    @FXML
    private BorderPane borderPane;

    @FXML
    private AnchorPane viewArea;
    
    @FXML
    private Label errorMessage; 

    @FXML
    void submit(ActionEvent event) throws IOException {
        String enteredCode = Code.getText(); 
        if (enteredCode.equals("1234")) { 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/QuizPageFinal.fxml"));
            Parent root = loader.load();
           
            AnchorPane quizPageFinal = (AnchorPane) root;
            
            viewArea.getChildren().setAll(quizPageFinal);
            errorMessage.setText("");
        } else {
 
            errorMessage.setText("Invalid code entered!");
        }
    }
}