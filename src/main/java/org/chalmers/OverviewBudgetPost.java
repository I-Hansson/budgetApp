package org.chalmers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import org.chalmers.Controllers.BudgetPostPanelController;
import org.chalmers.model.BudgetPost;

import java.io.IOException;

public class OverviewBudgetPost extends AnchorPane{

    @FXML Text budgetPostName;
    @FXML Text budgetPostTotalAmount;
    @FXML AnchorPane budgetPostCard;
    @FXML AnchorPane increasingPaneBudgetPost;
    @FXML AnchorPane AnchorPaneBudgetPostCard;

    public OverviewBudgetPost(String name, String moneyLeft, double procent, String color, String complementColor){
        ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OverviewBudgetPost.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);


        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        budgetPostName.setText(name);
        budgetPostTotalAmount.setText( moneyLeft + " Kr");
        budgetPostCard.setStyle("-fx-background-color: rgba("+ color+" );");
        increasingPaneBudgetPost.setStyle("-fx-background-color: rgba("+ complementColor+" );");
        increasingPaneBudgetPost.setPrefHeight(250*procent);
    }
}