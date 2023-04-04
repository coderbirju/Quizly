package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	Button btOK = new Button("Hello World");
	Scene scene = new Scene(btOK, 200, 250);
	primaryStage.setTitle("MyJavaFX");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}