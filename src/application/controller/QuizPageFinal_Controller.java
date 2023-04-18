package application.controller;

import java.io.IOException;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.controlsfx.control.Rating;

public class QuizPageFinal_Controller {
	
	
    @FXML
    private Button btnSubmit;
    
    @FXML
    private Label errorMessage;
      
    @FXML
    private AnchorPane viewArea;

    @FXML
    private RadioButton rboption1;
    
    @FXML
    private RadioButton rboption2;
    
    @FXML
    private RadioButton rboption3;
    
    @FXML
    private RadioButton rboption4;

    @FXML
    private Rating rating;
   
    @FXML
    private BorderPane borderPane; 
    
   // private ToggleGroup toggleGroup;

    //public void initialize() {
        // Create a new instance of ToggleGroup and assign it to the radio buttons
        //toggleGroup = new ToggleGroup();
        //rboption1.setToggleGroup(toggleGroup);
      //  rboption2.setToggleGroup(toggleGroup);
        //rboption3.setToggleGroup(toggleGroup);
       // rboption4.setToggleGroup(toggleGroup);
   // }



    @FXML
    void submit(ActionEvent event) throws IOException {
    	//if (toggleGroup.getSelectedToggle() != null && !rating.getRating().isEmpty()) {
            
           // FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/FinalPage.fxml"));
           // AnchorPane finalPage = loader.load();

          //  AnchorPane parentAnchorPane = (AnchorPane) btnSubmit.getParent();

           // parentAnchorPane.getChildren().setAll(finalPage);
        } //else {
           // errorMessage.setText("Please select an option and enter a value.");
      //  }

    //}

    @FXML
    void txtRating(ActionEvent event) {

    }

}
