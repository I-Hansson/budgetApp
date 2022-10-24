package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import org.chalmers.Controllers.OverviewController;
import org.chalmers.model.ITransaction;
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
 * Acts as a view class for PastTransactionView.
 * Depends on: OverviewController, ModelFacade, PastTransactionItem and SceneController.
 * @author Jonathan
 *
 */

public class PastTransactionView implements Initializable {

    @FXML FlowPane addTransactionFlowPane;
    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;
    @FXML Button newTransactionButton;
    @FXML FlowPane pastTransactionFlowPane;

    @FXML Text currentBudgetMonth;
    @FXML
    ImageView rightArrow;

    Image arrowRightGrey;
    Image arrowRightBlack;



    ModelFacade facade = ModelFacade.getInstance();
    private final List<PastTransactionItem>  pastTransactionItemList = new ArrayList<>();

    SceneController sceneController = new SceneController();


    private final OverviewController overviewController = new OverviewController();

    /**
     * Initalizes the update method
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            arrowRightGrey = new Image(new FileInputStream("src/main/resources/org/chalmers/images/right_grey.png"));
            arrowRightBlack = new Image(new FileInputStream("src/main/resources/org/chalmers/images/right.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    update();
    }

    /**
     * Updates the dynamic information
     * by reading and rendering the information.
     */
    private void update(){

        pastTransactionFlowPane.getChildren().clear();

        this.pastTransactionFlowPane.getChildren().clear();
        if(facade.getCurrentBudget() == facade.getUser().getBudgets().get(facade.getUser().getBudgets().size() -1))
        {
            setRightArrowGrey();
        }else{
            setRightArrowBlack();
        }

        currentBudgetMonth.setText(DateStringFormatter.getMonthAsString(facade.getCurrentBudgetCalendar())+ " "
                + facade.getCurrentBudgetCalendar().get(Calendar.YEAR));

        updateItem();
        for(PastTransactionItem i : pastTransactionItemList){
            this.pastTransactionFlowPane.getChildren().add(i);
        }
    }

    private void setRightArrowGrey()  {
        rightArrow.setImage(arrowRightGrey);
    }
    private void setRightArrowBlack(){
        rightArrow.setImage(arrowRightBlack);
    }


    @FXML
    private void nextMonth() {
        overviewController.clickedNextMonth();
        update();
    }

    @FXML
    private void prevMonth(){
        overviewController.clickedPrevMonth();
        update();

    }


    @FXML
    private void SwitchToOverview (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.overviewView(mouseEvent);
    }


    @FXML
    private void SwitchToBudgetPosts(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.budgetPostView(mouseEvent);
    }


    @FXML
    private void SwitchToAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.addTransaction(mouseEvent);
    }

    public void updateItem(){
        pastTransactionItemList.clear();
        for(ITransaction t : facade.getCurrentBudgetTransactions()) {
            pastTransactionItemList.add(new PastTransactionItem(t));
        }
    }
    public List<PastTransactionItem> getPastTransactionItemList() {
        return this.pastTransactionItemList;
    }
}