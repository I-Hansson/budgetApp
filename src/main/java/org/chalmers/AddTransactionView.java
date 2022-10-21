package org.chalmers;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.chalmers.Controllers.AddTransactionBudgetPostsController;
import org.chalmers.Controllers.AddTransactionController;
import org.chalmers.Controllers.BudgetPostController;
import org.chalmers.model.IBudgetPost;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * @author Jonathan
 */
public class AddTransactionView implements Initializable {

   private AddTransactionController addTransactionController = new AddTransactionController();
   private AddTransactionBudgetPostsController addTransactionBudgetPostsController = new AddTransactionBudgetPostsController();

    //TODO Might be wrong to use the BudgetPostController

   private BudgetPostController budgetPostController = new BudgetPostController();

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML TextField addBudgetPostNameField;
    @FXML TextField addBudgetPostMaxField;
    @FXML TextArea addBudgetPostDescriptionArea;
    @FXML ColorPicker colorPicker;

    @FXML Label errorLabel;
    @FXML Label budgetPostErrorLabel;

    @FXML TextField transactionName;
    @FXML TextArea transactionDescription;
    @FXML TextField transactionAmount;
    @FXML DatePicker datePicker;


    @FXML ImageView XnewBudgetPost;
    @FXML AnchorPane newBudgetPostPane;
    @FXML FlowPane BudgetPostsTexFlowPane;
    @FXML AnchorPane doneShadowPane;
    @FXML AnchorPane transactionDonePane;
    @FXML Button donePaneButton;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        update();
        }
    public void update(){
        this.BudgetPostsTexFlowPane.getChildren().clear();
        for (IBudgetPost post : addTransactionBudgetPostsController.getBudgetPosts()){
            this.BudgetPostsTexFlowPane.getChildren().add(new AddTransactionBudgetPosts(post.getName()));
        }
    }

    @FXML
    public void showAddBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        newBudgetPostPane.toFront();
        clearInputInfo();
    }
    @FXML
    public void closeAddBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        closeDoneAddBudgetPost();
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
    public void SwitchToBudgetPosts(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("BudgetPostsView.fxml"));
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

    public void closeDonePane(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        doneShadowPane.toBack();
        transactionDonePane.toBack();

    }

    @FXML
    public void doneAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException{

        if (checkInformationAddTransaction()){
            addTransactionController.newTransaction(
                    Double.parseDouble(transactionAmount.getText()),
                    transactionName.getText(),
                    transactionDescription.getText(),
                    datePicker.getValue(),
                    AddTransactionBudgetPosts.getGroupValue()
            );
            doneShadowPane.toFront();
            transactionDonePane.toFront();
            clearInputInfo();
        } else {wrongAddTransactionInformation();}
    }

    //TODO Put in color

    @FXML
    public void doneAddBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException{

        if (checkInformationAddBudgetPost()){
            budgetPostController.createBudgetPost(
                    addBudgetPostNameField.getText(),
                    addBudgetPostMaxField.getText(),
                    addBudgetPostDescriptionArea.getText(),
                    colorPicker.getValue().toString()
            );
            update();
            feedBackAddingBudgetPost();
        } else {
            wrongAddBudgetPostInformation();
        }
    }

    public void closeDoneAddBudgetPost(){newBudgetPostPane.toBack();}

    //TODO This could probably be done in a more general method
    //TODO Put in for Date and color

    private boolean checkInformationAddTransaction() {

        if (transactionName.getText().isEmpty()){
            return false;}

        if (transactionDescription.getText().isEmpty()){
            return false;}

        if (transactionAmount.getText().isEmpty()){
            return false;}

        for (int i = 0; i < transactionAmount.getText().length(); i++) {
            if (Character.isLetter(transactionAmount.getText().charAt(i))) {
                return false;
            }}
        for (int i = 0; i < transactionName.getText().length(); i++) {
            if (Character.isDigit(transactionName.getText().charAt(i))) {
                return false ;
            }
        }
        return true;
    }

    private boolean checkInformationAddBudgetPost(){

            if (addBudgetPostNameField.getText().isEmpty()){
                return false;}

            if (addBudgetPostMaxField.getText().isEmpty()){
                return false;}

            if (addBudgetPostDescriptionArea.getText().isEmpty()){
                return false;}

            for (int i = 0; i < addBudgetPostMaxField.getText().length(); i++) {
                if (Character.isLetter(addBudgetPostMaxField.getText().charAt(i))) {
                    return false;
                }}

            for (int i = 0; i < addBudgetPostNameField.getText().length(); i++) {
                if (Character.isDigit(addBudgetPostNameField.getText().charAt(i))) {
                    return false;
                }
            }
            return true;
        }



    private void wrongAddTransactionInformation(){
        errorLabel.setTextFill(Paint.valueOf("FF0000"));
        errorLabel.setText("The information is incorrectly filled out!");

    }

    private void wrongAddBudgetPostInformation(){
        budgetPostErrorLabel.setTextFill(Paint.valueOf("FF0000"));
        budgetPostErrorLabel.setText("The information is incorrectly filled out!");
    }
    private void feedBackAddingBudgetPost(){
        budgetPostErrorLabel.setText("The budget post have been added!");
        budgetPostErrorLabel.setTextFill(Paint.valueOf( "1E77BD" ));
    }

    private void clearInputInfo(){
        budgetPostErrorLabel.setText("");
        errorLabel.setText("");
        transactionName.setText("");
        transactionDescription.setText("");
        transactionAmount.setText("");
        addBudgetPostNameField.setText("");
        addBudgetPostMaxField.setText("");
        addBudgetPostDescriptionArea.setText("");
        datePicker.getEditor().clear();
    }
}



