package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.chalmers.Controllers.BudgetPostController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BudgetPostsView implements Initializable {

   private BudgetPostController controller = new BudgetPostController();

    @FXML AnchorPane addBudgetPostGreyBackground;
    @FXML AnchorPane newBudgetPostPane;

    @FXML TextArea budgetPostName;
    @FXML TextArea budgetMax;
    @FXML ChoiceBox budgetPostColor;
    @FXML TextArea budgetPostDescription;


    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;
    @FXML Button newTransactionButton;

    @FXML GridPane budgetPostsViewGridPane;




    private Stage stage;
    private Scene scene;
    private Parent root;




    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {

        for(int i = 0;i<4; i++) {
            this.budgetPostsViewGridPane.add(new BudgetPostsItem(), i, 0);

        }
    }

    @FXML
    public void goToAddBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        addBudgetPostGreyBackground.toFront();
        newBudgetPostPane.toFront();
    }

    @FXML
    public void addBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        controller.createBudgetPost(budgetPostName.getText(),budgetMax.getText(), String.valueOf(budgetPostColor.getValue()), budgetPostDescription.getText());
        addBudgetPostGreyBackground.toBack();
        newBudgetPostPane.toBack();
    }

    @FXML
    public void closeWindow(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        addBudgetPostGreyBackground.toBack();
        newBudgetPostPane.toBack();
    }



    @FXML
    public void SwitchToOverview(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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
    public void SwitchToAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddTransaction.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    public void SwitchToDetailedBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BudgetPostDetailed.fxml"));
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }




}



