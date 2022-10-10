package org.chalmers;


import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.util.Duration;
import org.chalmers.Controllers.BudgetPostPanelController;
import javafx.stage.Stage;
import org.chalmers.Controllers.OverviewController;

import org.chalmers.model.ModelFacade;
import org.chalmers.model.Transaction;


public class OverviewView implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML FlowPane AddTransactionFlowPane;
    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;
    @FXML Text currentBudgetMonth;



    @FXML FlowPane PiechartFlowPane;


    @FXML GridPane budgetPostsGridPane;
    @FXML Button newTransactionButton;

    @FXML
    ListView<Label> latestTransactionsListView;

    @FXML ImageView rightArrow;
    @FXML ImageView leftArrow;


    // controllers
    OverviewController overviewController = new OverviewController();
    BudgetPostPanelController  budgetCardController = new BudgetPostPanelController();
    ModelFacade facade = ModelFacade.getInstance();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        facade.addTransaction("Uber",100,"Transport","JKPG to GBG");
        facade.addTransaction("ICA",100,"Matvaror","milk, sugar");
        facade.addTransaction("H&M",100,"Kläder","T-shirt");
        update();

        Text[] textsWithVHints = {overviewTitelPanel, budgetPostsTitelPanel, pastTransactionsTitelPanel};
        for (Text text : textsWithVHints) {
            labelHinting(text);
        }

        addArrowHinting();
    }

    private void addArrowHinting() {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(100));
        scaleTransition.setCycleCount(1);
        rightArrow.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scaleTransition.setFromY(1);
                scaleTransition.setFromX(1);
                scaleTransition.setToY(1.2);
                scaleTransition.setToX(1.2);
                scaleTransition.setNode(rightArrow);
                scaleTransition.play();
            }
        });

        leftArrow.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scaleTransition.setFromY(1);
                scaleTransition.setFromX(1);
                scaleTransition.setToY(1.2);
                scaleTransition.setToX(1.2);
                scaleTransition.setNode(leftArrow);
                scaleTransition.play();
            }
        });
        rightArrow.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scaleTransition.setFromY(1.2);
                scaleTransition.setFromX(1.2);
                scaleTransition.setToY(1);
                scaleTransition.setToX(1);
                scaleTransition.setNode(rightArrow);
                scaleTransition.play();
            }
        });
        leftArrow.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scaleTransition.setFromY(1.2);
                scaleTransition.setFromX(1.2);
                scaleTransition.setToY(1);
                scaleTransition.setToX(1);
                scaleTransition.setNode(leftArrow);
                scaleTransition.play();
            }
        });

    }

    @FXML
    public void labelHinting(Text text) {
        text.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            }
        });
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
        System.out.println("2");
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

    }

    @FXML
    public void nextMonth(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        overviewController.clickedNextMonth();
        update();
    }
    @FXML
    public void prevMonth(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        overviewController.clickedPrevMonth();
        update();
    }
    public void update(){

        currentBudgetMonth.setText(facade.getUser().getCurrentBudget().getMonth());
        this.PiechartFlowPane.getChildren().clear();
        this.budgetPostsGridPane.getChildren().clear();
        this.PiechartFlowPane.getChildren().add(new OverviewPieChart());
        budgetCardController.createBudgetPostCards();
        for (int i = 0; i < 4; i++){
            budgetPostsGridPane.add(budgetCardController.getBudgetPostCards().get(i),i,0);
        }

        latestTransactionsListView.getItems().clear();
        for (Transaction transaction : overviewController.getLatestTransactions()) {
            Label tempLabel = new Label("-" + transaction.getAmount() + "kr " + transaction.getName());
            latestTransactionsListView.getItems().add(tempLabel);
        }
    }
}







