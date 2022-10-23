package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.chalmers.Controllers.BudgetPostdetailedViewController;
import org.chalmers.model.ITransaction;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.modelAdapters.chartAdapters.LineChartFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Jonathan
 */

public class BudgetPostdetailedView implements Initializable {

    BudgetPostdetailedViewController controller = new BudgetPostdetailedViewController();
    SceneController sceneController = new SceneController();


    @FXML FlowPane paneColorAmount;
    @FXML FlowPane paneLastTransacions;
    @FXML FlowPane paneGraphHigh;
    @FXML FlowPane paneGraphLow;

    LineChartFX modelChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeMonthLineChart();
        update();
    }

    public void update(){
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

    @FXML
    public void SwitchToPastTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.pastTransaction(mouseEvent);
    }

    @FXML
    public void SwitchToBudgetPosts(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.budgetPostView(mouseEvent);
    }

    @FXML
    public void SwitchToAddTransaction(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.addTransaction(mouseEvent);
    }
    @FXML
    public void SwitchToOverview (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        sceneController.overviewView(mouseEvent);
    }
}
