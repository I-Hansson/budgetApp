package org.chalmers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.chalmers.App;

import java.io.IOException;

public class LogInView {

    App app;

    @FXML AnchorPane signAnchorPane;


    @FXML
    public void SwitchToOverviewPage (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        app.setRoot("Overview");
    }

}
