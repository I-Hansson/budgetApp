package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import java.util.Calendar;

/**
 * Acts as the view class for Budget Post Detailed Last Transactions.
 *
 * @author Jonathan
 */

public class BudgetPostsDetailedLastTransactions extends AnchorPane {

    @FXML Label budgetPostDetailedLastTransaction;
    @FXML Label budgetPostDetailedLastTransactionDate;
    @FXML Label budgetPostDetailedLastTransactionAmount;

    /**
     * Creates the dynamic view.
     * @param transactionName specific name of the transaction.
     * @param date specific chosen date of the transaction.
     * @param amount specific amount of the transaction.
     */

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
