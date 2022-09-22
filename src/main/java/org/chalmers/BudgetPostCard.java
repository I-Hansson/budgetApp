package org.chalmers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import org.chalmers.Controllers.BudgetPostPanelController;

import java.io.IOException;

public class BudgetPostCard {

    @FXML Text budgetPostName;
    @FXML Text budgetPostTotalAmount;
    @FXML AnchorPane budgetPostCard;
    @FXML AnchorPane increasingPaneBudgetPost;
    @FXML AnchorPane AnchorPaneBudgetPostCard;

    private BudgetPostPanelController controller;


        public BudgetPostCard() {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/BudgetPostPanel.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try{
                fxmlLoader.load();
            } catch (IOException exception){
                throw new RuntimeException(exception);
            }

            this.controller = new BudgetPostPanelController();

            budgetPostName.setText("HEHEHE");
            budgetPostTotalAmount.setText("43453543");
            increasingPaneBudgetPost.setPrefHeight(130);


        }



    }

