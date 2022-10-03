package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.io.IOException;

public class BudgetPostsItem extends AnchorPane {


    @FXML Text budgetBannerName;
    @FXML Text budgetBannerDescription;
    @FXML Text budgetBannerAmount;
    @FXML Text budgetBannerLastTransaction;
    @FXML BorderPane budgetBannerColorBoard;
    @FXML Text budgetBannerAmountTransactions;




    public BudgetPostsItem(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BudgetPostsItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        budgetBannerName.setText("Yaki-Da");
        budgetBannerDescription.setText("Här samlas alla gånger användaren har varit på Yaki-Da");
        budgetBannerAmount.setText(3420 + "kr");
        budgetBannerAmountTransactions.setText("Total transactions: " + 32);
        budgetBannerLastTransaction.setText("3/10 - 2022");
        budgetBannerColorBoard.setBackground(Background.fill(Paint.valueOf("#1E77BD")));



    }
}
