package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.chalmers.Controllers.OverviewController;
import org.chalmers.Controllers.PastTransactionController;
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

public class PastTransactionView implements Initializable {

    @FXML FlowPane AddTransactionFlowPane;

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

    SceneController sceneController = new SceneController();


    private final OverviewController overviewController = new OverviewController();
    private final PastTransactionController pastTransactionController = new PastTransactionController();
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

        pastTransactionController.updateItem();
        for(PastTransactionItem i : pastTransactionController.getPastTransactionItemList()){
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
}