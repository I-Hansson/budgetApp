package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.chalmers.model.ModelFacade;

import java.io.IOException;

public class BudgetPostDetailedOverLook extends AnchorPane {

    private final ModelFacade facade = ModelFacade.getInstance();

    @FXML
    private Label detailedSpent;
    @FXML
    private Label detailedAverage;

    public BudgetPostDetailedOverLook(){


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BudgetPostDetailedOverlook.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        double spent = (facade.getSelectedBudgetPost().getBudgetCap()) - facade.getSelectedBudgetPost().getCurrentBalance();
        detailedSpent.setText(String.valueOf(spent));
        detailedAverage.setText(String.valueOf(facade.getSelectedBudgetPost().getBudgetCap()));


    }



}
