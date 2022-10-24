package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import org.chalmers.Controllers.BudgetPostController;


import org.chalmers.Controllers.OverviewController;
import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ModelFacade;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Acts as the view class of Budget Post View.
 * Depends on: BudgetPostController, OverviewController, ModelFacade and SceneController
 * @author Jonathan
 * @author Isac Hansson
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


    List<BudgetPostsItem> currentFourPanels;
    List<List<BudgetPostsItem>> bpList = new ArrayList<>();

    List<BudgetPostsItem> items = new ArrayList<>();

    private final BudgetPostController budgetcontroller = new BudgetPostController();
    private final OverviewController overviewController = new OverviewController();
    private final ModelFacade facade = ModelFacade.getInstance();
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

    private void update(){
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
        items = createBudgetItems();
      sortPanels();
      paintPanel();

    }
    private void sortPanels(){
        bpList.clear();
        List<BudgetPostsItem> tempBp = new ArrayList<>();
        for(int i = 0; i <= items.size()-1; i++ ){
            if(i == 4){
                bpList.add(tempBp);
                tempBp = new ArrayList<>();
            }
            tempBp.add(items.get(i));
        }
        bpList.add(tempBp);
        currentFourPanels  =  bpList.get(0);
    }

    private void paintPanel(){
        budgetPostsViewGridPane.getChildren().clear();
        for(int i = 0; i<currentFourPanels.size(); i++) {
            budgetPostsViewGridPane.add(currentFourPanels.get(i), i, 0);
        }
    }
    @FXML
    private void rightArrowPanel(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        int index = bpList.indexOf(currentFourPanels);
        if(index + 1 >= bpList.size()){
            index = -1;
        }
        currentFourPanels = bpList.get(index+1);
        paintPanel();
    }

    @FXML
    private void leftArrowPanel(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        int index = bpList.indexOf(currentFourPanels);
        if(index <= 0){
            index = bpList.size();
        }
        currentFourPanels = bpList.get(index-1);
        paintPanel();
    }


    private void setRightArrowGrey()  {
        rightArrow.setImage(arrowRightGrey);
    }

    private void setRightArrowBlack(){
        rightArrow.setImage(arrowRightBlack);
    }

    @FXML
    private void nextMonth(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        overviewController.clickedNextMonth();
        update();
    }


    @FXML
    private void prevMonth(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        overviewController.clickedPrevMonth();
        update();

    }

    @FXML
    private void goToAddBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        addBudgetPostGreyBackground.toFront();
        newBudgetPostPane.toFront();
        clearInputInfo();
    }

    @FXML
    private void addBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        if (checkInformation()){
            budgetcontroller.createBudgetPost(
                    budgetPostName.getText(),
                    budgetMax.getText(),
                    budgetPostDescription.getText(),
                    String.valueOf(budgetPostColor.getValue())
            );
            rightInputFeedback();
            addBudgetPostGreyBackground.toBack();
            newBudgetPostPane.toBack();
            update();
        }else{
            wrongInformation();
        }


    }

    @FXML
    private void closeWindow(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        addBudgetPostGreyBackground.toBack();
        newBudgetPostPane.toBack();
        clearInputInfo();
    }



    @FXML
    private void SwitchToPastTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.pastTransaction(mouseEvent);
    }
    @FXML
    private void SwitchToAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.addTransaction(mouseEvent);
    }
    @FXML
    private void SwitchToOverview (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
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

    private List<BudgetPostsItem> createBudgetItems(){
        List<BudgetPostsItem> result = new ArrayList<>();
        for (IBudgetPost bp: facade.getBudgetPosts()){
            result.add(new BudgetPostsItem(
                    bp.getName(),
                    "",
                    bp.getBudgetCap(),
                    bp.getTransactions().size(),
                    bp.getColor(),
                    bp.getCurrentBalance()
            ));
        }
        return result;
    }
}



