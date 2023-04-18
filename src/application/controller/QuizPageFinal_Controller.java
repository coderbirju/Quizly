package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class QuizPageFinal_Controller {
	
	@FXML
	private ToggleGroup toggleGroup;

    @FXML
    private Button btnSubmit;
    
    @FXML
    private Label errorMessage; 
    
    @FXML
    private AnchorPane viewArea;

    @FXML
    private RadioButton btnradio;

    @FXML
    private TextField txtField;
    
    @FXML
    private RadioButton btnradio1;

    @FXML
    private RadioButton btnradio2;

    @FXML
    private RadioButton btnradio3;

    @FXML
    private RadioButton btnradio4;
    
    @FXML
    private BorderPane borderPane;

    @FXML
    void option1(ActionEvent event) {

    }

    @FXML
    void option2(ActionEvent event) {

    }

    @FXML
    void option3(ActionEvent event) {

    }

    @FXML
    void option4(ActionEvent event) {

    }

    @FXML
    void submit(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/FinalPage.fxml"));
        AnchorPane finalPage = loader.load();

        // Get the parent AnchorPane
        AnchorPane parentAnchorPane = (AnchorPane) btnSubmit.getParent();

        // Set the AnotherPage.fxml as the content of the parent AnchorPane
        parentAnchorPane.getChildren().setAll(finalPage);

    }

    @FXML
    void txtRating(ActionEvent event) {

    }

}
