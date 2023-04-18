package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.Rating;

import application.model.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;

public class QuizAnalytics_Controller {

    @FXML
    private Button btnAnalytics;

    @FXML
    private Button btnRatings;

    @FXML
    private Button btnReset2;

    @FXML
    private Button btnSearch2;

    @FXML
    private TextField txtQuizCode2;
    

    @FXML
    private Label lblOption1;

    @FXML
    private Label lblOption2;

    @FXML
    private Label lblOption3;

    @FXML
    private Label lblOption4;
    
    @FXML
    private Rating classRatings;

    @FXML
    void classRatings(ActionEvent event) {

    }

    List<Integer> barchartData = new ArrayList<>();
    
    @FXML
    void quizAlanytics(ActionEvent event) throws IOException {
    	int counter1 = 1;
    	int counter2 = 2;
    	int counter3 = 3;
    	int counter4 = 4;
    	Stage newWindow = new Stage();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/BarChart.fxml"));
    	Parent root = loader.load();
    	BarChart_Controller scene2Controller = loader.getController();
    	 scene2Controller.setData(counter1, counter2, counter3, counter4);
    	Scene newScene = new Scene(root);
    	newWindow.setScene(newScene);
    	newWindow.show();


//    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/BarChart.fxml"));
//         Parent root = loader.load();
//         BarChart_Controller scene2Controller = loader.getController();
//         // scene2Controller.setData(barchartData);
//         scene2Controller.setData(counter1, counter2, counter3, counter4);
//         Stage stage = new Stage();
//         Scene scene = new Scene(root);
//          stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         stage.setScene(scene);
//         stage.show();
    }

    @FXML
    void resetSearch(ActionEvent event) {
    	txtQuizCode2.setText("");

    }

    @FXML
    void searchQuiz2(ActionEvent event) {
String quizId = txtQuizCode2.getText();
    	
    	if(quizId.isEmpty()) {
    		 Alert alert = new Alert(Alert.AlertType.ERROR);
    	        alert.setHeaderText("Error");
    	        alert.setContentText("Quiz ID field cannot be empty");
    	        alert.showAndWait();
    	        return;
    	}

    	// Professor prof = new Professor();
    	 //barchartData = prof.getdata
    	
    	double rating = 3.4;
    	classRatings.setRating(rating);
    }

}
