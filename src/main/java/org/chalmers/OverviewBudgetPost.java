package org.chalmers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
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

    public OverviewBudgetPost(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OverviewBudgetPost.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }



        budgetPostName.setText("HHh");
        budgetPostTotalAmount.setText(String.valueOf(4334));
        increasingPaneBudgetPost.setPrefHeight(146);
        budgetPostCard.setOpacity(1);
        AnchorPaneBudgetPostCard.setOpacity(1);
    }
}