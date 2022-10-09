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




    public BudgetPostsItem(String bpNamn,String bpDesc, double amount, int amountTransactions, String color ){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BudgetPostsItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        budgetBannerName.setText(bpNamn);
        budgetBannerDescription.setText(bpDesc );
        budgetBannerAmount.setText(amount + "kr");
        budgetBannerAmountTransactions.setText("Total transactions: " + amountTransactions);
        budgetBannerLastTransaction.setText("bajs");
        budgetBannerColorBoard.setStyle("-fx-background-color: rgb("+ color +" );");



    }
}
