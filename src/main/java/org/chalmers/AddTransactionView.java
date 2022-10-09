package org.chalmers;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.chalmers.Controllers.AddTransactionBudgetPostsController;
import org.chalmers.Controllers.AddTransactionController;
import org.chalmers.model.BudgetPost;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddTransactionView implements Initializable {

   private AddTransactionController addTransactionController = new AddTransactionController();
   private AddTransactionBudgetPostsController budgetPostsController = new AddTransactionBudgetPostsController();





    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML TextArea transactionName;
    @FXML TextArea transactionDescription;
    @FXML TextArea transacionAmount;
    @FXML DatePicker datePicker;


    @FXML ImageView XnewBudgetPost;
    @FXML AnchorPane newBudgetPostPane;
    @FXML FlowPane BudgetPostsTexFlowPane;
    @FXML AnchorPane doneShadowPane;
    @FXML AnchorPane transactionDonePane;
    @FXML Button donePaneButton;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        for (BudgetPost post : budgetPostsController.getBudgetPosts()){
            this.BudgetPostsTexFlowPane.getChildren().add(new AddTransactionBudgetPosts(post.getId().getName()));
                }
        }


    @FXML
    public void showAddBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        newBudgetPostPane.toFront();
    }
    @FXML
    public void closeAddBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
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
    public void SwitchToBudgetPosts(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("BudgetPostsView.fxml"));
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

    public void closeDonePane(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        doneShadowPane.toBack();
        transactionDonePane.toBack();

    }

    @FXML
    public void doneAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        addTransactionController.newTransaction(Double.parseDouble(transacionAmount.getText()), transactionName.getText(), transactionDescription.getText(), datePicker.getValue(),AddTransactionBudgetPosts.getGroupValue());
        doneShadowPane.toFront();
        transactionDonePane.toFront();
    }
}



