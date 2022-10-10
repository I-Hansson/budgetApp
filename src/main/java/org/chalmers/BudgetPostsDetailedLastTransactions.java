package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.chalmers.Controllers.BudgetPostsDetailedLastTransactionsController;

import java.io.IOException;

public class BudgetPostsDetailedLastTransactions extends AnchorPane {

    BudgetPostsDetailedLastTransactionsController budgetPostsDetailedLastTransactionsController = new BudgetPostsDetailedLastTransactionsController();



    @FXML Label budgetPostDetailedLastTransaction;

    public BudgetPostsDetailedLastTransactions(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BudgetPostDetailedLastTransactions.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);


        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        budgetPostDetailedLastTransaction.setText(budgetPostsDetailedLastTransactionsController.getTransaction());

    }






}
