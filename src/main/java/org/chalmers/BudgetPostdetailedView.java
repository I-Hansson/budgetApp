package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BudgetPostdetailedView implements Initializable {



    @FXML FlowPane paneColorAmount;
    @FXML AnchorPane paneLastTransacions;
    @FXML AnchorPane paneGrapgh;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        update();

    }

    public void update(){
        this.paneColorAmount.getChildren().clear();
        this.paneColorAmount.getChildren().add(new BudgetPostsDetailedBalance());
        this.paneLastTransacions.getChildren().clear();
        this.paneLastTransacions.getChildren().add(new BudgetPostsDetailedLastTransactions());

    }






}
