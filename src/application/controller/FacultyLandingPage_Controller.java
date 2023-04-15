package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    private Button btnSignOut;

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
    void signOut(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) btnCreateQuiz.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/UserLogin.fxml"));
		Scene scene = new Scene(root, 800, 435);
		primaryStage.setTitle("User Login");
		primaryStage.setScene(scene);
		primaryStage.show();
    }

}
