package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.chalmers.Controllers.OverviewOverlookController;

import java.io.IOException;

public class OverviewOverlookView extends AnchorPane {

    OverviewOverlookController overviewOverlookController = new OverviewOverlookController();

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


        remainingBalance.setText(String.valueOf(overviewOverlookController.getOverlookBalance()));
        averageDailySpent.setText(overviewOverlookController.getOverlookAverage());



    }
}
