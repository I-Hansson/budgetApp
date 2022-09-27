package org.chalmers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import org.chalmers.Controllers.BudgetPostPanelController;
import org.chalmers.model.BudgetPost;

import java.io.IOException;

public class BudgetPostCard extends AnchorPane{

    @FXML Text budgetPostName;
    @FXML Text budgetPostTotalAmount;
    @FXML AnchorPane budgetPostCard;
    @FXML AnchorPane increasingPaneBudgetPost;
    @FXML AnchorPane AnchorPaneBudgetPostCard;

    public void setData(){
        budgetPostName.setText("HHh");
        budgetPostTotalAmount.setText(String.valueOf(4334));
        increasingPaneBudgetPost.setPrefHeight(146);
        budgetPostCard.setOpacity(1);
        AnchorPaneBudgetPostCard.setOpacity(1);
    }

}