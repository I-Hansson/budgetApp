package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class AddTransaction extends AnchorPane{







    @FXML AnchorPane NewTransactionPane;
    @FXML ImageView XnewTransaction;
    @FXML ImageView XnewBudgetPost;
    @FXML AnchorPane newBudgetPostPane;
    @FXML TextFlow BudgetPostsTextFlowPane;


    public AddTransaction(){


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddTransaction.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }


}
