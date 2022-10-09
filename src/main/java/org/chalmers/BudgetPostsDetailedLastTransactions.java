package org.chalmers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BudgetPostsDetailedLastTransactions extends AnchorPane {

    public BudgetPostsDetailedLastTransactions(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BudgetPostdetailedLastTransactions.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }



    }






}
