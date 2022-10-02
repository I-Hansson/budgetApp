package org.chalmers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.chalmers.model.OverallSpentPieChart;

import java.net.URL;
import java.util.ResourceBundle;


public class OverviewView implements Initializable {


    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;


    @FXML Pane pieChartOverview;
    @FXML PieChart overallSpentPieChart;

    @FXML Pane pieChartConnectedInfo;
    @FXML TextArea overviewMessageTextArea;
    @FXML ScrollPane budgetPostsFlowPane;
    @FXML Button newTransactionButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OverallSpentPieChart hej = new OverallSpentPieChart();

        //this.overallSpentPieChart.setStyle("-fx-pie-label-visible:False;");
        this.overallSpentPieChart.getData().addAll(hej.getData());



    }
}





