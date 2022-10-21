package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import java.util.Calendar;

/**
 * @author Jonathan
 */

public class BudgetPostsDetailedLastTransactions extends AnchorPane {

    @FXML Label budgetPostDetailedLastTransaction;
    @FXML Label budgetPostDetailedLastTransactionDate;
    @FXML Label budgetPostDetailedLastTransactionAmount;

    public BudgetPostsDetailedLastTransactions(String transactionName,Calendar date, double amount){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BudgetPostDetailedLastTransactions.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);


        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        budgetPostDetailedLastTransaction.setText("Name: "+ transactionName);
        budgetPostDetailedLastTransactionDate.setText("Date: " + DateStringFormatter.getFormattedDate(date));
        budgetPostDetailedLastTransactionAmount.setText("Cost: " + amount + " kr");
    }
}
