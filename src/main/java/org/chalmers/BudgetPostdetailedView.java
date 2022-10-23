package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import javafx.scene.paint.Paint;
import org.chalmers.Controllers.BudgetPostdetailedViewController;
import org.chalmers.model.ITransaction;
import org.chalmers.model.ModelFacade;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.modelAdapters.chartAdapters.LineChartFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Jonathan
 */

public class BudgetPostdetailedView implements Initializable {

    ModelFacade facade = ModelFacade.getInstance();
    BudgetPostdetailedViewController controller = new BudgetPostdetailedViewController();
    SceneController sceneController = new SceneController();


    @FXML TextField budgetPostName;
    @FXML TextField budgetMax;
    @FXML Label errorLabel;

    @FXML AnchorPane changeBudgetPostPane;
    @FXML AnchorPane changeBudgetPostPaneGreyBackground;

    @FXML FlowPane paneColorAmount;
    @FXML FlowPane paneLastTransacions;
    @FXML FlowPane paneGraphHigh;
    @FXML FlowPane paneGraphLow;

    LineChartFX modelChart;

    /**
     * Initalizes the page
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeMonthLineChart();
        update();
    }


    /**
     * Reads and renders the information given by the controllers for all the
     * listed view objects such as the chart and table.
     */
    private void update(){

        this.paneColorAmount.getChildren().clear();
        this.paneColorAmount.getChildren().add(new BudgetPostsDetailedBalance());
        this.paneLastTransacions.getChildren().clear();

        for(ITransaction transaction : controller.getCurrentBudgetPost().getTransactions()){
            this.paneLastTransacions.getChildren().add(
                    new BudgetPostsDetailedLastTransactions(
                            transaction.getName(), transaction.getDate(), transaction.getAmount()
                    )
            );
        }

        this.paneGraphLow.getChildren().clear();
        this.paneGraphLow.getChildren().add(new BudgetPostDetailedOverLook());
    }

    //TODO Ska detta vara en egen klass och isåfall hur?
    private void initializeMonthLineChart() {
        modelChart = new LineChartFX(ChartFactory.createMonthLineChart());
        modelChart.update(controller.getCurrentBudgetPost().getTransactions());
        final NumberAxis xAxis = new NumberAxis(1, 31, 1);
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");

        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Amount spent / day");
        lineChart.getData().setAll(modelChart.getXYSeries());
        lineChart.setCreateSymbols(false);
        lineChart.setLegendVisible(true);
        lineChart.setPrefWidth(878);
        lineChart.setPrefHeight(254);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Spending limit");
        for(int i = 1; i <= 31; i++) {
            series.getData().add(new XYChart.Data<>(i,
                    (controller.getCurrentBudgetPost().getBudgetCap() -
                            controller.getCurrentBudgetPost().getCurrentBalance()) / 31));
        }


        lineChart.getData().add(series);
        lineChart.getData().get(1).getNode().setStyle("-fx-stroke-dash-array: 3 6; -fx-stroke-width: 2px");

        paneGraphHigh.getChildren().add(lineChart);
    }

    /**
     * Switches to the past transaction view
     */
    @FXML
    private void SwitchToPastTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.pastTransaction(mouseEvent);
    }

    /**
     * Switches to the add budget posts view
     */
    @FXML
    private void SwitchToBudgetPosts(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.budgetPostView(mouseEvent);
    }

    /**
     * Switches to the add transaction view
     */
    @FXML
    private void SwitchToAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.addTransaction(mouseEvent);
    }

    /**
     * Switches to the overview view
     */
    @FXML
    private void SwitchToOverview (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.overviewView(mouseEvent);
    }

    @FXML
    private void goToChangeBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        changeBudgetPostPaneGreyBackground.toFront();
        changeBudgetPostPane.toFront();
    }

    @FXML
    private void changeBudgetPost(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        if (checkInformation()) {
            if (!budgetMax.getText().isEmpty()) {
                facade.getSelectedBudgetPost().setBudgetCap(Double.parseDouble(budgetMax.getText()));
            }
            if (!budgetPostName.getText().isEmpty()) {
                facade.getSelectedBudgetPost().setName(budgetPostName.getText());
            }
            rightInputFeedback();
            update();
        }else {
            wrongInformation();
        }
    }

    @FXML
    private void closeWindow(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        changeBudgetPostPane.toBack();
        changeBudgetPostPaneGreyBackground.toBack();
        clearInputInfo();
    }


    private boolean checkInformation() {

        if ((budgetPostName.getText().isEmpty()) && (budgetMax.getText().isEmpty())){
            return false;}

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
        errorLabel.setText("The budget post has been added!");
        errorLabel.setTextFill(Paint.valueOf( "1E77BD" ));
    }

    private void clearInputInfo(){
        errorLabel.setText("");
        budgetPostName.setText("");
        budgetMax.setText("");
    }




}
