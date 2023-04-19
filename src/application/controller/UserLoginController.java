package application.controller;

import java.io.IOException;

import java.util.Optional;

import application.model.User;
//import application.model.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
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
		
		if(username.isEmpty()||password.isEmpty()||(radioFaculty.isSelected()==false&&radioStudent.isSelected()==false)) {
			lblStatus.setText("     One or more field is empty!");
		}
		
		else {
			if(radioFaculty.isSelected()) {
				role = "PROFESSOR";
			}
			else {
				role = "STUDENT";
			}
			
			User user = User.getInstance(username, password, role);
			
			if(user != null) {
	            String fxmlFile;
	            Stage primaryStage = (Stage) txtUserName.getScene().getWindow();
	            if (role.equals("PROFESSOR") && user.getRole().equals("PROFESSOR")) {
	                fxmlFile = "/application/view/FacultyLandingPage.fxml";
	            } else if (role.equals("STUDENT") && user.getRole().equals("STUDENT")){
	                fxmlFile = "/application/view/LandingStudentPage.fxml";
	            } else {
	            	 lblStatus.setText("Incorrect role!");
	            	 fxmlFile = "";
	            	 return;
	            }
	            lblStatus.setText("Login Sucess!");
	            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
	            Scene scene = new Scene(root);
	            primaryStage.setTitle("Faculty Dashboard");
	            primaryStage.setScene(scene);
	            primaryStage.show();
	            
	        } else {
	        	Alert alert = new Alert(AlertType.ERROR);
	        	alert.setTitle("Login Failed!");
	        	alert.setHeaderText(null);
	        	alert.setContentText("Please try again,Incorrect Username or password!");
	        	alert.showAndWait();
	            lblStatus.setText("Incorrect Username or password!");
	            
	        }
		}
		
	
    }

}





