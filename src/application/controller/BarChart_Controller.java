package application.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;


public class BarChart_Controller {

    @FXML
    private BarChart<String, Integer> chartQuiz;

    public void setData(int counter1,int  counter2,int counter3, int counter4) {
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        series1.setName("Option1");
        series1.getData().add(new XYChart.Data<>("Counter", counter1));
        chartQuiz.getData().add(series1);
        
        XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
        series2.setName("Option2");
        series2.getData().add(new XYChart.Data<>("Counter", counter2));
        chartQuiz.getData().add(series2);
        
        XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
        series3.setName("Option3");
        series3.getData().add(new XYChart.Data<>("Counter", counter3));
        chartQuiz.getData().add(series3);
        
        XYChart.Series<String, Integer> series4 = new XYChart.Series<>();
        series4.setName("Option4");
        series4.getData().add(new XYChart.Data<>("Counter", counter4));
        chartQuiz.getData().add(series4);
    }
    
}
