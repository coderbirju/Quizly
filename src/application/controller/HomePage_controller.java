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
    private Button btnStart;

    @FXML
    void click(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) btnStart.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/UserLogin.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Quizly");
		primaryStage.setScene(scene);
		primaryStage.show();
    }

}
