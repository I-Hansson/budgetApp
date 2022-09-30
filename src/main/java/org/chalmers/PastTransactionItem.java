package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;


import java.io.IOException;

public class PastTransactionItem extends AnchorPane {


    @FXML Text nameTransaction;
    @FXML Text costTransaction;
    @FXML Text remainingBalanceTransation;
    @FXML Text descriptionTransaction;
    @FXML Text dateTransaction;
    @FXML Text dayTransaction;
    @FXML Text budgetpostTransaction;
    @FXML BorderPane colorBoardTransaction;


    public PastTransactionItem(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PastTransactionItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }



        nameTransaction.setText("HHh");
        costTransaction.setText(2490 + "kr");
        remainingBalanceTransation.setText(42149 + "kr");
        dateTransaction.setText("3/10 - 2022");
        descriptionTransaction.setText("Yaki-Da, helkväll");
        dayTransaction.setText("Lördag");
        budgetpostTransaction.setText("Nöje");
    }


}



