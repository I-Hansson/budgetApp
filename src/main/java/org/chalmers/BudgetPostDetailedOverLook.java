package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.chalmers.model.ModelFacade;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BudgetPostDetailedOverLook extends AnchorPane {

    private final ModelFacade facade = ModelFacade.getInstance();
    private final Calendar today = new GregorianCalendar();

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
        spent = (getBudgetPostBudgetCap() - getBudgetPostBalance());
        detailedSpent.setText(String.valueOf(spent));
        detailedAverage.setText(String.valueOf(getBudgetPostAverage()));


    }

    private double getBudgetPostBalance(){
        return facade.getSelectedBudgetPost().getCurrentBalance();
    }


    private double getBudgetPostBudgetCap(){
        return facade.getSelectedBudgetPost().getBudgetCap();
    }

    private double getBudgetPostAverage(){
        return Math.round(100* (getBudgetPostBalance() / today.get(Calendar.DAY_OF_MONTH))) / 100.0;
    }
}
