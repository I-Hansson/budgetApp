package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.chalmers.Controllers.OverviewController;

import java.net.URL;
import java.util.ResourceBundle;


public class OverviewPage implements Initializable {

    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;


    @FXML Pane pieChartOverview;
    @FXML Pane pieChartConnectedInfo;
    @FXML TextArea overviewMessageTextArea;
    @FXML ScrollPane budgetPostsFlowPane;
    @FXML Button newTransactionButton;

    private OverviewController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }


}

