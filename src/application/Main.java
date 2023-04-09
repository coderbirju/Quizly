package application;
	
import java.io.IOException; 

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	private ConnectToDB  mongoConnect;
	@Override
	public void start(Stage primaryStage) throws IOException {
	
	mongoConnect = new ConnectToDB();
	
	Parent root = FXMLLoader.load(getClass().getResource("/application/view/FacultyLogin.fxml"));
	Scene scene = new Scene(root, 600, 400);
	primaryStage.setTitle("MyJavaFX");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
    public void stop() throws Exception {
        // Close the MongoManager instance
		System.out.println("Close connection ");
		mongoConnect.close();
    }
}

