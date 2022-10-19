package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.chalmers.model.ITransaction;
import org.chalmers.model.Transaction;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PastTransactionItem extends AnchorPane {


    @FXML Text nameTransaction;
    @FXML Text costTransaction;
    @FXML Text remainingBalanceTransation;
    @FXML Text descriptionTransaction;
    @FXML Text dateTransaction;
    @FXML Text dayTransaction;
    @FXML Text budgetpostTransaction;
    @FXML BorderPane colorBoardTransaction;



    public PastTransactionItem(ITransaction transaction){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PastTransactionItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }



        nameTransaction.setText(transaction.getName());
        costTransaction.setText(transaction.getAmount()+ " kr");

        dateTransaction.setText(DateStringFormatter.getFormattedDate(transaction.getDate()));
        descriptionTransaction.setText(transaction.getDescription());
        dayTransaction.setText(DateStringFormatter.getDayOfWeekAsString(transaction.getDate()));
        budgetpostTransaction.setText(transaction.getBudgetPostName());
        colorBoardTransaction.setStyle("-fx-background-color: rgb("+ transaction.getBudgetPostColor()+" );");
    }


}



