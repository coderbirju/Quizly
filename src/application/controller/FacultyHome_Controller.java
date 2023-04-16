package application.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import application.model.Quiz;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class FacultyHome_Controller {

    @FXML
    private TableColumn<Quiz, LocalDateTime> colDate;

    @FXML
    private TableColumn<Quiz, String> colId;

    @FXML
    private TableColumn<Quiz, String> colName;

    @FXML
    private AnchorPane lblTitle;

    @FXML
    private TableView<Quiz> tblQuiz;

    

 // Connect to MongoDB database
 // Query database to retrieve list of quizzes for logged-in faculty member
 // Create ObservableList of Quiz objects
 // Populate ObservableList with quiz data retrieved from MongoDB
  
//ObservableList<Quiz> quizList = FXCollections.observableArrayList();

    
    public void initialize() throws IOException {
    	
    	colId.setCellValueFactory(new PropertyValueFactory<Quiz,String>("quizId"));
    	colId.setCellValueFactory(new PropertyValueFactory<Quiz,String>("QuizName"));
    	//tblQuiz.setItems(quizList);
    	
    }

    
}