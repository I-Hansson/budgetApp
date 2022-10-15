package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.chalmers.Controllers.BudgetPostdetailedViewController;
import org.chalmers.model.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BudgetPostdetailedView implements Initializable {

    BudgetPostdetailedViewController budgetPostdetailedViewController = new BudgetPostdetailedViewController();

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML FlowPane paneColorAmount;
    @FXML FlowPane paneLastTransacions;
    @FXML FlowPane paneGraphHigh;
    @FXML FlowPane paneGraphLow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateD();
    }

    public void updateD(){
        this.paneColorAmount.getChildren().clear();
        this.paneColorAmount.getChildren().add(new BudgetPostsDetailedBalance());
        this.paneLastTransacions.getChildren().clear();

                // TODO Beror på modellen :/, vet ej hur jag ska komma runt det (Av typen "Transaction")

            for(Transaction Tr : budgetPostdetailedViewController.getCurrentBudgetPost().getTransactions()){
                this.paneLastTransacions.getChildren().add(new BudgetPostsDetailedLastTransactions(Tr.getName(),Tr.getTransactionDate(),Tr.getDateOfTransaction(),Tr.getAmount()));
                }
            }



    @FXML
    public void SwitchToPastTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("PastTransactionView.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    public void SwitchToBudgetPosts(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("BudgetPostsView.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    public void SwitchToAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddTransaction.fxml"));
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    public void SwitchToOverview(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }




}
