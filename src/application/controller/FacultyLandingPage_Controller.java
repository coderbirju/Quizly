package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class FacultyLandingPage_Controller {

    @FXML
    private BorderPane borderPane;
    
    @FXML
    private Button btnAnalytics;

    @FXML
    private Button btnAttendance;

    @FXML
    private Button btnCreateQuiz;

    @FXML
    private FontAwesomeIcon btnLofout;

    @FXML
    private AnchorPane navBarSection;
    
    @FXML
    private AnchorPane viewArea;
    

    @FXML
    void attendance(ActionEvent event) throws IOException {
    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/view/ClassAttendance.fxml"));
    	borderPane.setCenter(view);
    }

    @FXML
    void createQuiz(ActionEvent event) throws IOException {
    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/view/AddQuiz.fxml"));
    	borderPane.setCenter(view);
    }

    @FXML
    void quizAnalytics(ActionEvent event) throws IOException {
    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/view/QuizAnalytics.fxml"));
    	borderPane.setCenter(view);
    }

    @FXML
    void signOut(MouseEvent event) {

    }

}
