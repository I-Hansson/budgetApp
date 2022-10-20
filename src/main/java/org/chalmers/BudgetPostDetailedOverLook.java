package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.chalmers.Controllers.BudgetPostDetailedOverLookController;

import java.io.IOException;

public class BudgetPostDetailedOverLook extends AnchorPane {

    BudgetPostDetailedOverLookController budgetPostDetailedOverLookController = new BudgetPostDetailedOverLookController();

    private double spent;

    @FXML
    Label detailedSpent;
    @FXML
    Label detailedAverage;

    public BudgetPostDetailedOverLook(){


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BudgetPostDetailedOverlook.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        spent = (budgetPostDetailedOverLookController.getBudgetPostBudgetCap() - budgetPostDetailedOverLookController.getBudgetPostBalance());
        detailedSpent.setText(String.valueOf(spent));
        detailedAverage.setText(String.valueOf(budgetPostDetailedOverLookController.getBudgetPostAverage()));


    }



}
