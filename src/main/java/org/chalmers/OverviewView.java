package org.chalmers;


import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.util.Duration;
import javafx.stage.Stage;
import org.chalmers.Controllers.OverviewController;

import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ITransaction;
import org.chalmers.model.ModelFacade;

/**
 * @author Jonathan
 */


public class OverviewView implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML FlowPane AddTransactionFlowPane;
    @FXML Text overviewTitelPanel;
    @FXML Text budgetPostsTitelPanel;
    @FXML Text pastTransactionsTitelPanel;
    @FXML Text currentBudgetMonth;


    @FXML FlowPane overlookPane;


    @FXML FlowPane PiechartFlowPane;


    @FXML GridPane budgetPostsGridPane;
    @FXML Button newTransactionButton;

    @FXML
    ListView<Label> latestTransactionsListView;

    @FXML ImageView rightArrow;
    @FXML ImageView leftArrow;

    Image arrowRightGrey;
    Image arrowRightBlack;
    List<OverviewBudgetPost> currentFourPanels;
    List<List<OverviewBudgetPost>> bpList = new ArrayList<>();

    // controllers
    SceneController sceneController = new SceneController();
    OverviewController controller = new OverviewController();
    ModelFacade facade = ModelFacade.getInstance();

    /**
     * Initalizes the overview view
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            arrowRightGrey = new Image(new FileInputStream("src/main/resources/org/chalmers/images/right_grey.png"));
             arrowRightBlack = new Image(new FileInputStream("src/main/resources/org/chalmers/images/right.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

            update();


        Text[] textsWithVHints = {overviewTitelPanel, budgetPostsTitelPanel, pastTransactionsTitelPanel};
        for (Text text : textsWithVHints) {
            labelHinting(text);
        }

        addArrowHinting();
    }
    private void setRightArrowGrey()  {
        rightArrow.setImage(arrowRightGrey);
    }
    private void setRightArrowBlack(){
        rightArrow.setImage(arrowRightBlack);
    }

    private void addArrowHinting() {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(100));
        scaleTransition.setCycleCount(1);
        rightArrow.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scaleTransition.setFromY(1);
                scaleTransition.setFromX(1);
                scaleTransition.setToY(1.2);
                scaleTransition.setToX(1.2);
                scaleTransition.setNode(rightArrow);
                scaleTransition.play();
            }
        });

        leftArrow.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scaleTransition.setFromY(1);
                scaleTransition.setFromX(1);
                scaleTransition.setToY(1.2);
                scaleTransition.setToX(1.2);
                scaleTransition.setNode(leftArrow);
                scaleTransition.play();
            }
        });
        rightArrow.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scaleTransition.setFromY(1.2);
                scaleTransition.setFromX(1.2);
                scaleTransition.setToY(1);
                scaleTransition.setToX(1);
                scaleTransition.setNode(rightArrow);
                scaleTransition.play();
            }
        });
        leftArrow.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scaleTransition.setFromY(1.2);
                scaleTransition.setFromX(1.2);
                scaleTransition.setToY(1);
                scaleTransition.setToX(1);
                scaleTransition.setNode(leftArrow);
                scaleTransition.play();
            }
        });

    }

    /**
     * The adds a hinting text on hover
     * @param text the text that shall be displayed
     */
    @FXML
    public void labelHinting(Text text) {
        text.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            }
        });
    }

    /**
     * switches to the past transactions view
     */
    @FXML
    public void SwitchToPastTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.pastTransaction(mouseEvent);
    }

    /**
     * switches to the budget posts view
     */
    @FXML
    public void SwitchToBudgetPosts(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.budgetPostView(mouseEvent);
    }

    /**
     * switches to the add transactions view
     */
    @FXML
    public void SwitchToAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.addTransaction(mouseEvent);
    }

    /**
     *  switches to next in the carousel
     */
    @FXML
    public void nextMonth(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        controller.clickedNextMonth();
        update();
    }
    /**
     *  switches to previous in the carousel
     */
    @FXML
    public void prevMonth(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        controller.clickedPrevMonth();
        update();
    }

    /**
     * Read and renders the information given by the controller
     */
    public void update() {


        this.overlookPane.getChildren().clear();
        this.overlookPane.getChildren().add(new OverviewOverlookView());

        if(facade.getCurrentBudget() == facade.getUser().getBudgets().get(facade.getUser().getBudgets().size() -1))
        {
            setRightArrowGrey();
        }else{
            setRightArrowBlack();
        }
        currentBudgetMonth.setText(DateStringFormatter.getMonthAsString(facade.getCurrentBudgetCalendar()) + " "
                + facade.getCurrentBudgetCalendar().get(Calendar.YEAR));
        this.PiechartFlowPane.getChildren().clear();
        this.budgetPostsGridPane.getChildren().clear();
        this.PiechartFlowPane.getChildren().add(new OverviewPieChart());
        //controller.getBudgetPostCards().clear();
        createBudgetPostCards();
        sortPanels();
        paintPanels();
        latestTransactionsListView.getItems().clear();
        for (ITransaction transaction : controller.getLatestTransactions()) {
            Label tempLabel = new Label("-" + transaction.getAmount() + "kr " + transaction.getName());
            latestTransactionsListView.getItems().add(tempLabel);
        }
    }

    /**
     * Generates a budget post cards
     */
    public void sortPanels(){
        bpList.clear();
        List<OverviewBudgetPost> tempBp = new ArrayList<>();
        for(int i = 0; i <= controller.getBudgetPostCards().size()-1; i++ ){
            if(i == 4){
                bpList.add(tempBp);
                tempBp = new ArrayList<>();

            }
            tempBp.add(controller.getBudgetPostCards().get(i));
        }
        bpList.add(tempBp);
        System.out.println(bpList);
        currentFourPanels  =  bpList.get(0);
    }

    public void paintPanels(){
        budgetPostsGridPane.getChildren().clear();
        for (int i = 0; i < currentFourPanels.size(); i++){
            budgetPostsGridPane.add(currentFourPanels.get(i), i,0);
        }
    }

    @FXML
    public void rightArrowPanel(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        int index = bpList.indexOf(currentFourPanels);
        if(index + 1 >= bpList.size()){
            index = -1;
        }
            currentFourPanels = bpList.get(index+1);
            paintPanels();

    }
    @FXML
    public void leftArrowPanel(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        int index = bpList.indexOf(currentFourPanels);
        if(index <= 0){
                index = bpList.size();
        }
            currentFourPanels = bpList.get(index-1);
       paintPanels();
    }



    public void createBudgetPostCards(){
        controller.getBudgetPostCards().clear();
        for (IBudgetPost i : controller.getBudgetPostsfromUser()){
            controller.getBudgetPostCards().add(new OverviewBudgetPost(
                            i.getName(),
                            i.getCurrentBalance(),
                            i.getCurrentBalance()/i.getBudgetCap(),
                            i.getColor(),getComplementColor(i.getColor())
                    ));

        }

    }

    /**
     * @param rgb R,G,B in the range of 0-255
     * @return the complement color
     */
    public String getComplementColor(String rgb) {
        Color color = Color.web("rgb(" + rgb + ")");
        Color newColor = color.brighter();
        return ""+newColor.getRed()*255+"," + newColor.getGreen()*255 +","+ newColor.getBlue()*255;
    }


}







