package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FacultyLoginController {
	
	@FXML
	private Label lblStatus;
	
	@FXML
	private TextField txtUserName;
	
	@FXML
	private TextField txtPassword;
	
	public void Login(ActionEvent action) throws IOException {
		if(txtUserName.getText().equals("user")&& txtPassword.getText().equals("pass")) {
			lblStatus.setText("Login Sucess!");
			Stage primaryStage = (Stage) txtUserName.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("FacultyLandingPage.fxml"));
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setTitle("MyJavaFX");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else {
			lblStatus.setText("Incorrect Username or password!");
		}
	}
	
}
