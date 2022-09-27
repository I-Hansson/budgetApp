package org.chalmers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.chalmers.model.OverallSpentPieChart;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;


public class OverviewView implements Initializable {


    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;


    @FXML Pane pieChartOverview;
    @FXML PieChart overallSpentPieChart;

    @FXML Pane pieChartConnectedInfo;
    @FXML TextArea overviewMessageTextArea;
    @FXML GridPane budgetPostsGridPane;
    @FXML Button newTransactionButton;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OverallSpentPieChart hej = new OverallSpentPieChart();

        //this.overallSpentPieChart.setStyle("-fx-pie-label-visible:False;");
        this.overallSpentPieChart.getData().addAll(hej.getData());


        try {
            updateBudgetPostPanel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateBudgetPostPanel () throws IOException {

        for (int i = 0; i < 4; i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("BudgetPostPanel.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            BudgetPostCard budgetPostCard = fxmlLoader.getController();
            budgetPostCard.setData();

            budgetPostsGridPane.add(anchorPane, i, 0);

        }

    }

}





