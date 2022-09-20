package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {




    private Scene scene;
    private Stage stage;
    private Parent root;


    @FXML AnchorPane signAnchorPane;


    @FXML
    public void SwitchToOverviewPage (javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        App.setRoot("Overview");
    }

}



