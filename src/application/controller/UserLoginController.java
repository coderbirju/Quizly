package application.controller;

import java.io.IOException;

import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class UserLoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblStatus;

    @FXML
    private RadioButton radioFaculty;

    @FXML
    private RadioButton radioStudent;
    
    @FXML
    private ToggleGroup tgRole;
    
    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void Login(ActionEvent event) throws IOException {
		String username = txtUserName.getText();
		String password = txtPassword.getText();
		String role ="";
		if(radioFaculty.isSelected()) {
			role = "PROFFESSOR";
		}
		else {
			role = "STUDENT";
		}
		
		User user = User.getInstance(username, password, role);
		
		if(user != null) {
			lblStatus.setText("Login Sucess!");
			Stage primaryStage = (Stage) txtUserName.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/FacultyLandingPage.fxml"));
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setTitle("MyJavaFX");
			primaryStage.setScene(scene);
			primaryStage.show();
		} else {
			lblStatus.setText("Incorrect Username or password!");
		}
    }

}





