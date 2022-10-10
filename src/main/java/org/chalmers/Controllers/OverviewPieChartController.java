package org.chalmers.Controllers;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import org.chalmers.model.*;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.model.charts.ChartTypePie;
import org.chalmers.modelAdapters.chartAdapters.PieChartFX;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Controller class for the pie chart on the overview page
 *
 * @author williamfrisk
 */
public class OverviewPieChartController {

    ModelFacade facade = ModelFacade.getInstance();
    PieChartFX modelChart;
    Collection<Transaction> transactions = new ArrayList<>();

    Random random = new Random();


    //TODO här ska vi koppla till backenden
    Budget budget = new Budget(22,10);

    public OverviewPieChartController(){
        modelChart = new PieChartFX(ChartFactory.createPieChart());

        modelChart.update(facade.getCurrentBudgetTransactions());
    }

    public ObservableList<PieChart.Data> getData(){
        return modelChart.getObservableList();
    }

    public List<BudgetPost> getBudgetPosts() {
        return facade.budgetPostsfromUser();
    }
}
