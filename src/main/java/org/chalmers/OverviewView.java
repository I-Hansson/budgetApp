package org.chalmers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;

import java.net.URL;

import java.util.ResourceBundle;


import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import org.chalmers.Overviewpiechart;


public class OverviewView implements Initializable {


    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;


    @FXML FlowPane PiechartFlowPane;

    @FXML TextArea overviewMessageTextArea;
    @FXML GridPane budgetPostsGridPane;
    @FXML Button newTransactionButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.PiechartFlowPane.getChildren().add(new Overviewpiechart());
       for(int i = 0;i<4; i++){
            this.budgetPostsGridPane.add(new OverviewBudgetPost(),i,0);
        }

    }

}







