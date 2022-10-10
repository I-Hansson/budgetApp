package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.io.IOException;

public class BudgetPostsDetailedBalance extends AnchorPane {


    @FXML Text budgetPostAmount;
    @FXML AnchorPane budgetPostColorBakground;


    public BudgetPostsDetailedBalance(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BudgetPostsDetailedBalance.fxml"));
        fxmlLoader.setRoot(this);


        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
