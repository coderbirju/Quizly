
package application.controller;

import application.model.User;
import java.io.IOException;
import application.model.Student;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StudentLandingPage_Controller {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btnAttendance;

    @FXML
    private Button btnCreateQuiz;

    @FXML
    private FontAwesomeIcon btnLofout;

    @FXML
    private Button btnSignOut;

    @FXML
    private AnchorPane navBarSection;

    @FXML
    void attendance(ActionEvent event) {
    	
    }

    @FXML
    void createQuiz(ActionEvent event) {

    }

    @FXML
    void signOut(ActionEvent event) {
    
    }
    
    
    public void initialize() throws IOException {
    	System.out.println("Inside initialize");
    	Student student = new Student();
//    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/view/StudentLanding.fxml"));
//    	borderPane.setCenter(view);
    }


}
