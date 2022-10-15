package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.chalmers.Controllers.BudgetPostController;


import org.chalmers.Controllers.BudgetPostItemController;
import org.chalmers.Controllers.OverviewController;
import org.chalmers.model.ModelFacade;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BudgetPostsView implements Initializable {



    @FXML AnchorPane addBudgetPostGreyBackground;
    @FXML AnchorPane newBudgetPostPane;

    @FXML TextField budgetPostName;
    @FXML TextField budgetMax;
    @FXML ColorPicker budgetPostColor;
    @FXML TextArea budgetPostDescription;

    @FXML Label errorLabel;

    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;
    @FXML Button newTransactionButton;

    @FXML GridPane budgetPostsViewGridPane;
    @FXML Text currentBudgetMonth;




    private Stage stage;
    private Scene scene;
    private Parent root;

    private BudgetPostController budgetcontroller = new BudgetPostController();
    private OverviewController overviewController = new OverviewController();
    private ModelFacade facade = ModelFacade.getInstance();
    private BudgetPostItemController itemController = new BudgetPostItemController();


    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        update();
    }

    public void update(){
        currentBudgetMonth.setText(facade.getUser().getCurrentBudget().getMonth()+ " " + facade.getUser().getCurrentBudget().getYear());
        this.budgetPostsViewGridPane.getChildren().clear();
        itemController.createBudgetItems();
        for(int i = 0;i< itemController.getItem().size(); i++) {
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
    public void goToAddBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        addBudgetPostGreyBackground.toFront();
        newBudgetPostPane.toFront();
        clearInputInfo();
    }

    @FXML
    public void addBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        if (checkInformation()){
            budgetcontroller.createBudgetPost(budgetPostName.getText(),budgetMax.getText(), String.valueOf(budgetPostColor.getValue()), budgetPostDescription.getText());
            rightInputFeedback();
        }else{
            wrongInformation();
        }

    }

    @FXML
    public void closeWindow(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        addBudgetPostGreyBackground.toBack();
        newBudgetPostPane.toBack();
        clearInputInfo();
    }



    @FXML
    public void SwitchToOverview(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        clearInputInfo();

    }

    @FXML
    public void SwitchToPastTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("PastTransactionView.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        clearInputInfo();
    }
    @FXML
    public void SwitchToAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddTransaction.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        clearInputInfo();
    }



    @FXML
    public void SwitchToDetailedBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BudgetPostDetailed.fxml"));
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        clearInputInfo();


    }


    private boolean checkInformation() {


        if (budgetPostDescription.getText().isEmpty()){
            return false;
        }
        if (budgetPostName.getText().isEmpty()){
            return false;
        }
        if (budgetMax.getText().isEmpty()){
            return false;
        }

        for (int i = 0; i < budgetMax.getText().length(); i++) {
            if (Character.isLetter(budgetMax.getText().charAt(i))) {
                return false;
            }}

        for (int i = 0; i < budgetPostName.getText().length(); i++) {
            if (Character.isDigit(budgetPostName.getText().charAt(i))) {
                return false ;
            }
        }
        return true;
    }

    private void wrongInformation(){
        errorLabel.setTextFill(Paint.valueOf("FF0000"));
        errorLabel.setText("The information is incorretctly filled out!");
    }
    private  void rightInputFeedback(){
        errorLabel.setText("The budget post have been added!");
        errorLabel.setTextFill(Paint.valueOf( "1E77BD" ));
    }

    private void clearInputInfo(){
        errorLabel.setText("");
        budgetPostName.setText("");
        budgetMax.setText("");
        budgetPostDescription.setText("");

    }






}



