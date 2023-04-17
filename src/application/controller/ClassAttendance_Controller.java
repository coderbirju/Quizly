package application.controller;
import application.model.Professor;
import application.model.Quiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ClassAttendance_Controller {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtQuizCode;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private Button btnDownload;

    @FXML
    void resetSearch(ActionEvent event) {
    	txtQuizCode.setText("");
    	txtResult.setText("");
    }

    @FXML
    //new713
    void searchQuiz(ActionEvent event) {
    	String quizId = txtQuizCode.getText();
    	System.out.println("quiz ID from user is"+quizId);
    	 Professor prof = new Professor();
    	 Quiz quiz = prof.fetchQuizById(quizId);
//   	 System.out.println("quiz of that quizid"+quiz.toString());
//    	System.out.println(prof.getQuizAttendance(quiz).toString());
//    	txtResult.setText(prof.getQuizAttendance(quiz).toString());
    }
    
    @FXML
    void download(ActionEvent event) {
    	

    	// Create an ArrayList of student name from response
    	ArrayList<String> list = new ArrayList<>();
    	list.add("Hello");
    	list.add("World");
    	list.add("!");

    	Stage primaryStage = (Stage) btnDownload.getScene().getWindow();
        // prompt the user to select a file to save the names to
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file", "*.txt"));
        File file = fileChooser.showSaveDialog(primaryStage);

        // if the user selected a file, write the names to the file
        if (file != null) {
            try (PrintWriter writer = new PrintWriter(file)) {
                for (String names : list) {
                    writer.println(names);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        
 

    }
    
}
