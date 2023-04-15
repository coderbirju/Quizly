module Quizly {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires org.mongodb.driver.sync.client;
	requires org.mongodb.bson;
	requires org.mongodb.driver.core;
	requires fontawesomefx;
	
	opens application.controller to javafx.graphics, javafx.fxml;
//	opens application.model to org.mongodb.driver.sync.client, com.mongodb.client.MongoClients, com.mongodb.client.MongoDatabase; 
    opens application.view to javafx.graphics, javafx.fxml;
    opens application to javafx.graphics, javafx.fxml;
}
//--add-modules javafx.controls,javafx.fxml