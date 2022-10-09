package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.chalmers.Controllers.BudgetPostItemController;
import org.chalmers.Controllers.OverviewController;
import org.chalmers.model.ModelFacade;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BudgetPostsView implements Initializable {

    @FXML FlowPane AddTransactionFlowPane;

    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;
    @FXML Button newTransactionButton;

    @FXML GridPane budgetPostsViewGridPane;
    @FXML Text currentBudgetMonth;

    private Stage stage;
    private Scene scene;
    private Parent root;
    OverviewController overviewController = new OverviewController();
    ModelFacade facade = ModelFacade.getInstance();
    BudgetPostItemController itemController = new BudgetPostItemController();


    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
    update();
    }
    public void update(){
        currentBudgetMonth.setText(facade.getUser().getCurrentBudget().getMonth());
        this.budgetPostsViewGridPane.getChildren().clear();
        itemController.createBudgetItems();
        for(int i = 0;i<4; i++) {
            this.budgetPostsViewGridPane.add(itemController.getItem().get(i), i, 0);
        }
    }

    @FXML
    public void nextMonth(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        overviewController.clickedNextMonth();
        update();
    }
    @FXML
    public void prevMonth(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        System.out.println("next");
        overviewController.clickedPrevMonth();
        update();
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







}



