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

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.util.Duration;
import javafx.stage.Stage;
import org.chalmers.Controllers.OverviewController;

import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ITransaction;
import org.chalmers.model.ModelFacade;

/**
 * @author Jonathan
 */


public class OverviewView implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML FlowPane AddTransactionFlowPane;
    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;
    @FXML Text currentBudgetMonth;


    @FXML FlowPane overlookPane;


    @FXML FlowPane PiechartFlowPane;


    @FXML GridPane budgetPostsGridPane;
    @FXML Button newTransactionButton;

    @FXML
    ListView<Label> latestTransactionsListView;

    @FXML ImageView rightArrow;
    @FXML ImageView leftArrow;


    // controllers
    OverviewController overviewController = new OverviewController();
    ModelFacade facade = ModelFacade.getInstance();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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


        this.overlookPane.getChildren().clear();
        this.overlookPane.getChildren().add(new OverviewOverlookView());

        currentBudgetMonth.setText(DateStringFormatter.getMonthAsString(facade.getUser().getCurrentBudget().getDate()) + " " + facade.getUser().getCurrentBudget().getDate().get(Calendar.YEAR));
        this.PiechartFlowPane.getChildren().clear();
        this.budgetPostsGridPane.getChildren().clear();
        this.PiechartFlowPane.getChildren().add(new OverviewPieChart());

        createBudgetPostCards();

        for (int i = 0; i <overviewController.getBudgetPostCards().size(); i++){
            budgetPostsGridPane.add(overviewController.getBudgetPostCards().get(i),i,0);
        }

        latestTransactionsListView.getItems().clear();
        for (ITransaction transaction : overviewController.getLatestTransactions()) {
            Label tempLabel = new Label("-" + transaction.getAmount() + "kr " + transaction.getName());
            latestTransactionsListView.getItems().add(tempLabel);
        }
    }


    public void createBudgetPostCards(){
        overviewController.getBudgetPostCards();
        for (IBudgetPost i : overviewController.getBudgetPostsfromUser()){
            overviewController.getBudgetPostCards().add(new OverviewBudgetPost(i.getName(), i.getCurrentBalance(), i.getCurrentBalance()/i.getBudgetCap(), i.getColor(),getComplementColor(i.getColor())));
        }

    }

    public String getComplementColor(String rgb) {
        Color color = Color.web("rgb(" + rgb + ")");
        Color newColor = color.brighter();
        return ""+newColor.getRed()*255+"," + newColor.getGreen()*255 +","+ newColor.getBlue()*255;
    }


}







