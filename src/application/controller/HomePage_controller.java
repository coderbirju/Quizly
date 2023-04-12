package application.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePage_controller {

    @FXML
    private Button btnFaculty;

    @FXML
    private Button btnStudent;

    @FXML
    void FacultyLogin(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) btnFaculty.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/FacultyLogin.fxml"));
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    void StudentLogin(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) btnFaculty.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource(".fxml"));
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
    }

}
