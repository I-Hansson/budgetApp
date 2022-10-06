package org.chalmers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;


import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import org.chalmers.Controllers.BudgetPostPanelController;
import javafx.stage.Stage;




public class OverviewView implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML FlowPane AddTransactionFlowPane;

    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;


    @FXML FlowPane PiechartFlowPane;


    @FXML GridPane budgetPostsGridPane;
    @FXML Button newTransactionButton;
    // controllers

    BudgetPostPanelController  budgetCardController = new BudgetPostPanelController();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       this.PiechartFlowPane.getChildren().add(new OverviewPieChart());
       for (int i = 0; i < 4; i++){
           budgetPostsGridPane.add(budgetCardController.getBudgetPostCards().get(i),i,0);
       }
    }

    @FXML
    public void SwitchToPastTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("PastTransactionView.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    public void SwitchToBudgetPosts(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("BudgetPostsView.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    public void SwitchToAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddTransaction.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }}







