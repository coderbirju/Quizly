package application.controller;

import java.io.IOException;

import application.model.Student;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StudentLanding_Controller {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btnSignOut;

    @FXML
    private Button btnTakeQuiz;

    @FXML
    private AnchorPane navBarController;
    
    @FXML
    private AnchorPane viewArea;

    @FXML
    void QuizPage(ActionEvent event) throws IOException {
    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/view/QuizPage.fxml"));
    	borderPane.setCenter(view);
    	Student student = new Student();
    }

    @FXML
    void SignOut(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) btnTakeQuiz.getScene().getWindow();
    	User.signOut();
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/UserLogin.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("User Login");
		primaryStage.setScene(scene);
		primaryStage.show();
    }

}
