package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import org.chalmers.Controllers.BudgetPostdetailedViewController;

import java.io.IOException;

/**
 * Acts as the view class for Budget Post Item.
 * Depends on: BudgetPostdetailedViewController and SceneController.
 * @author Jonathan
 */

public class BudgetPostsItem extends AnchorPane {

    BudgetPostdetailedViewController budgetPostdetailedViewController = new BudgetPostdetailedViewController();

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

    SceneController sceneController = new SceneController();

    /**
     * Creates the dynamic view.
     * @param bpNamn The budget post name.
     * @param bpDesc The budget post description.
     * @param amount The budget post.
     * @param amountTransactions The amount of transactions in budget post.
     * @param color The specific color.
     * @param currentAmount The amount remaining.
     */

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
            sceneController.budgetPostDetailed(mouseEvent);

        });

    }

}




