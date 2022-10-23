package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.chalmers.Controllers.BudgetPostController;


import org.chalmers.Controllers.BudgetPostItemController;
import org.chalmers.Controllers.OverviewController;
import org.chalmers.model.ModelFacade;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * @author Jonathan
 */

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

    @FXML ImageView rightArrow;

    private BudgetPostController budgetcontroller = new BudgetPostController();
    private OverviewController overviewController = new OverviewController();
    private ModelFacade facade = ModelFacade.getInstance();
    private BudgetPostItemController itemController = new BudgetPostItemController();

    Image arrowRightGrey;
    Image arrowRightBlack;

    SceneController sceneController = new SceneController();

    /**
     * Initalizes the information by calling update
     */
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        try {
            arrowRightGrey = new Image(new FileInputStream("src/main/resources/org/chalmers/images/right_grey.png"));
            arrowRightBlack = new Image(new FileInputStream("src/main/resources/org/chalmers/images/right.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        update();
    }

    /**
     * Updates the content that is dependent on user input
     *  - if the slider arrows shall be grayed
     *  - the budgetpost information that is specific for this month
     */
    public void update(){

        if(facade.getCurrentBudget() == facade.getUser().getBudgets().get(facade.getUser().getBudgets().size() -1))
        {
            setRightArrowGrey();
        }else{
            setRightArrowBlack();
        }

        currentBudgetMonth.setText(
                DateStringFormatter.getMonthAsString(facade.getCurrentBudgetCalendar()) + " " +
                        facade.getCurrentBudgetCalendar().get(Calendar.YEAR));
        budgetPostsViewGridPane.getChildren().clear();
        itemController.createBudgetItems();
        for(int i = 0; i<itemController.getItem().size(); i++) {
            budgetPostsViewGridPane.add(itemController.getItem().get(i), i, 0);
        }

    }
    private void setRightArrowGrey()  {
        rightArrow.setImage(arrowRightGrey);
    }

    private void setRightArrowBlack(){
        rightArrow.setImage(arrowRightBlack);
    }

    /**
     * "Scrolls" the user to the next months budget
     */
    @FXML
    public void nextMonth(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        overviewController.clickedNextMonth();
        update();
    }

    /**
     * "Scrolls" the user to the previous months budget
     */
    @FXML
    public void prevMonth(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        System.out.println("next");
        overviewController.clickedPrevMonth();
        update();

    }

    /**
     * Sends the budgetPostPane to the front
     */
    @FXML
    public void goToAddBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        addBudgetPostGreyBackground.toFront();
        newBudgetPostPane.toFront();
        clearInputInfo();
    }

    /**
     * Submits the given information to the budget controller
     */
    @FXML
    public void addBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        if (checkInformation()){
            budgetcontroller.createBudgetPost(
                    budgetPostName.getText(),
                    budgetMax.getText(),
                    budgetPostDescription.getText(),
                    String.valueOf(budgetPostColor.getValue())
            );
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
    public void SwitchToPastTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.pastTransaction(mouseEvent);
    }
    @FXML
    public void SwitchToAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.addTransaction(mouseEvent);
    }
    @FXML
    public void SwitchToOverview (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.overviewView(mouseEvent);
    }





    private boolean checkInformation() {

        if (budgetPostColor.getValue() == null){
            return false;}

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



