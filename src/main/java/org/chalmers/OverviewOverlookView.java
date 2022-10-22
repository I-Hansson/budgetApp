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
 * @author Jonathan
 */

public class OverviewOverlookView extends AnchorPane {

    private final ModelFacade facade = ModelFacade.getInstance();
    private final Calendar today = new GregorianCalendar();

    @FXML Label remainingBalance;
    @FXML Label averageDailySpent;

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

    public double getOverlookBalance(){
        return facade.getBudgetCap() - facade.getCurrentBudgetBalance();
    }

    public double getOverlookAverage(){
        if (facade.getCurrentBudgetCalendar().get(Calendar.MONTH) == today.get(Calendar.MONTH)){
            return Math.round(100* (facade.getCurrentBudgetBalance() / today.get(Calendar.DAY_OF_MONTH))) / 100.0;
        }
        return Math.round(100*
                (facade.getCurrentBudgetBalance() / 31))
                / 100.0;
    }
}
