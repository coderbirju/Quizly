module Quizly {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
//	exports application.controller;
//	
//	opens application.controller to javafx.graphics, javafx.fxml;
//    opens application.view to javafx.graphics, javafx.fxml;
    opens application to javafx.graphics, javafx.fxml;
}
