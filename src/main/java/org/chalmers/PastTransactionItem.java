package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.chalmers.model.ITransaction;
import java.io.IOException;

/**
 * Acts as a view class for Past Transaction Item.
 * Depends on:
 * @author Jonathan
 */

public class PastTransactionItem extends AnchorPane {

    @FXML Text nameTransaction;
    @FXML Text costTransaction;
    @FXML Text descriptionTransaction;
    @FXML Text dateTransaction;
    @FXML Text dayTransaction;
    @FXML Text budgetpostTransaction;
    @FXML BorderPane colorBoardTransaction;

    /**
     * Creates the dynamic view.
     * @param transaction The transaction which will be presented.
     */

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



