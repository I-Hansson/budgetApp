package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.chalmers.model.ModelFacade;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Act as the view class for the Overview Overlook View.
 * Depends on: ModelFacade,
 * @author Jonathan
 */

public class OverviewOverlookView extends AnchorPane {

    ModelFacade facade = ModelFacade.getInstance();

    @FXML Label remainingBalance;
    @FXML Label averageDailySpent;


    /**
     * Creates the dynamic view.
     */

    public OverviewOverlookView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OverviewOverlook.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (
                IOException exception) {
            throw new RuntimeException(exception);
        }

        remainingBalance.setText(String.valueOf(getOverlookBalance()) + " kr");
        averageDailySpent.setText(String.valueOf(getOverlookAverage()) + " kr");
    }


    private double getOverlookBalance(){
        return facade.getBudgetCap() - facade.getCurrentBudgetBalance();
    }

    private double getOverlookAverage(){
        Calendar today = new GregorianCalendar();
        return Math.round(100* (facade.getCurrentBudgetBalance() / today.get(Calendar.DAY_OF_MONTH))) / 100.0;
    }
}
