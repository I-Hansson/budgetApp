package org.chalmers;

import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
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
        budgetPostCard.setStyle("-fx-background-color: rgb("+ color+" );");
        increasingPaneBudgetPost.setStyle("-fx-background-color: rgb("+ complementColor+" );");

        increasingPaneBudgetPost.setPrefHeight(250);

        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(1000));
        translate.setByY(250*(procent/2));
        translate.setCycleCount(1);
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(increasingPaneBudgetPost);
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setByY(-procent);
        scaleTransition.setCycleCount(1);

        ParallelTransition pt = new ParallelTransition(increasingPaneBudgetPost, scaleTransition, translate);
        pt.play();

    }
}