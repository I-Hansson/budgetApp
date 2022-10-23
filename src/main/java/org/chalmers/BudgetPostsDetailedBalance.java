package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Text;
import org.chalmers.model.ModelFacade;

import java.io.IOException;

/**
 * @author Jonathan
 */

public class BudgetPostsDetailedBalance extends AnchorPane {

    @FXML Text budgetPostAmount;
    @FXML AnchorPane budgetPostColorBakground;

    ModelFacade facade = ModelFacade.getInstance();


    public BudgetPostsDetailedBalance(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BudgetPostsDetailedBalance.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        budgetPostAmount.setText(String.valueOf((facade.getSelectedBudgetPost().getCurrentBalance())) + " Kr");
        budgetPostColorBakground.setStyle(
                "-fx-background-color: rgb(" + facade.getSelectedBudgetPost().getColor() + " );"
        );

    }
}
