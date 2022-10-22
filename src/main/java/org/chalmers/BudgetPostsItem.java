package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.chalmers.Controllers.BudgetPostdetailedViewController;

import java.io.IOException;

/**
 * @author Jonathan
 */

public class BudgetPostsItem extends AnchorPane {


    BudgetPostdetailedViewController budgetPostdetailedViewController = new BudgetPostdetailedViewController();


    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    AnchorPane paneBudgetPost;
    @FXML
    Text budgetBannerName;
    @FXML
    Text budgetBannerDescription;
    @FXML
    Text budgetBannerAmount;
    @FXML
    Text budgetBannerLastTransaction;
    @FXML
    BorderPane budgetBannerColorBoard;
    @FXML
    Text budgetBannerAmountTransactions;
    @FXML
    Text budgetBannerMAX;


    public BudgetPostsItem(String bpNamn, String bpDesc, double amount, int amountTransactions, String color, double currentAmount) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BudgetPostsItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        budgetBannerName.setText(bpNamn);
        budgetBannerDescription.setText(bpDesc);
        budgetBannerAmount.setText(currentAmount + "kr");
        budgetBannerMAX.setText(amount + "kr");
        budgetBannerAmountTransactions.setText("Total transactions: " + amountTransactions);
        budgetBannerLastTransaction.setText("");
        budgetBannerColorBoard.setStyle("-fx-background-color: rgb(" + color + " );");

        paneBudgetPost.setOnMouseClicked(mouseEvent -> {
            System.out.println(this.budgetBannerName.getText());
            budgetPostdetailedViewController.setCorrspondingId(((this.budgetBannerName.getText())));

            try {
                root = FXMLLoader.load(getClass().getResource("BudgetPostDetailed.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        });

    }

}




