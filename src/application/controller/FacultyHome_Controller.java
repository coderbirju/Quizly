package application.controller;

import java.io.IOException;

import java.time.LocalDateTime;

import application.model.Professor;
import application.model.Quiz;
import application.model.QuizManager;
import javafx.collections.ObservableList;
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
  

    QuizManager quizManager = new Professor();
	
    ObservableList<Quiz> quizList = quizManager.getQuizzes();
	
 
    
    public void initialize() throws IOException {
    	
    	
       // System.out.println(quizList.toString());
        
        colId.setCellValueFactory(new PropertyValueFactory<Quiz,String>("quizId"));
    	colName.setCellValueFactory(new PropertyValueFactory<Quiz,String>("QuizName"));
    	colDate.setCellValueFactory(new PropertyValueFactory<Quiz,LocalDateTime>("endTime"));
    	tblQuiz.setItems(quizList);
    	
    	
    }

    
}

