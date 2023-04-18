package application.controller;
import application.model.Professor;
import application.model.Quiz;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
public class ClassAttendance_Controller {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtQuizCode;
    
    @FXML
    private Button btnDownload;

    @FXML
    private TableColumn<String, String> colStudent;

    @FXML
    private TableView<String> tblStudentView;
    
    @FXML
    void resetSearch(ActionEvent event) {
    	txtQuizCode.setText("");
    	//txtResult.setText("");
    	tblStudentView.getItems().clear();
    	tblStudentView.refresh();
    }

    @FXML
    //new713
    void searchQuiz(ActionEvent event) {
    	String quizId = txtQuizCode.getText();
    	
    	if(quizId.isEmpty()) {
    		 Alert alert = new Alert(Alert.AlertType.ERROR);
    	        alert.setHeaderText("Error");
    	        alert.setContentText("Quiz ID field cannot be empty");
    	        alert.showAndWait();
    	        return;
    	}
    	
    	//System.out.println("quiz ID from user is"+quizId);
    	 Professor prof = new Professor();
    	 Quiz quiz = prof.fetchQuizById(quizId);
    	 List<String> studentList = prof.getQuizAttendance(quiz);
//    	 for (String s : studentList) {
//    		 txtResult.appendText(s + "\n");
//    		}
    	 
    	 colStudent.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
    	// tblStudentView.getColumns().add(colStudent);
    	 tblStudentView.setItems(FXCollections.observableArrayList(studentList));
   
  // txtResult.setText(prof.getQuizAttendance(quiz).toString());
    }
    
    @FXML
    void download(ActionEvent event) {
    	// Create an ArrayList of student name from response
    	String quizId = txtQuizCode.getText();
    	if(quizId.isEmpty()) {
   		 Alert alert = new Alert(Alert.AlertType.ERROR);
   	        alert.setHeaderText("Error");
   	        alert.setContentText("Quiz ID field cannot be empty");
   	        alert.showAndWait();
   	     return;
   	}
    	//System.out.println("quiz ID from user is"+quizId);
    	 Professor prof = new Professor();
    	 Quiz quiz = prof.fetchQuizById(quizId);
    	 List<String> studentList = prof.getQuizAttendance(quiz);


    	Stage primaryStage = (Stage) btnDownload.getScene().getWindow();
        // prompt the user to select a file to save the names to
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file", "*.txt"));
        File file = fileChooser.showSaveDialog(primaryStage);

        // if the user selected a file, write the names to the file
        if (file != null) {
            try (PrintWriter writer = new PrintWriter(file)) {
                for (String names : studentList) {
                    writer.println(names);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	alert.setHeaderText("Status");
	        alert.setContentText("Download Sucess!");
	        alert.showAndWait();

    }
    
}
