package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import org.chalmers.Controllers.BudgetPostsDetailedBalanceController;

import java.io.IOException;

/**
 * @author Jonathan
 */

public class BudgetPostsDetailedBalance extends AnchorPane {


    BudgetPostsDetailedBalanceController budgetPostsDetailedBalanceController = new BudgetPostsDetailedBalanceController();


    @FXML Text budgetPostAmount;
    @FXML AnchorPane budgetPostColorBakground;


    public BudgetPostsDetailedBalance(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BudgetPostsDetailedBalance.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        budgetPostAmount.setText(budgetPostsDetailedBalanceController.getRemainingBalance() + " Kr");
        budgetPostColorBakground.setStyle(
                "-fx-background-color: rgb(" + budgetPostsDetailedBalanceController.getBudgetPostColor() + " );"
        );

    }
}
