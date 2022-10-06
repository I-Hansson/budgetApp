package org.chalmers.Controllers;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import org.chalmers.model.*;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.modelAdapters.chartAdapters.PieChartFX;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OverviewPieChartController {

    ModelFacade model = ModelFacade.getInstance();
    PieChartFX modelChart;
    Collection<Transaction> transactions = new ArrayList<>();


    //TODO här ska vi koppla till backenden
    Budget budget = new Budget();

    public OverviewPieChartController(){
        modelChart = new PieChartFX(ChartFactory.createPieChart());
        for (BudgetPost bp : budget.getBudgetPosts()) {
            for (int i = 0; i < 10; i++) {
                transactions.add(new Transaction("test", i * 100, bp.getId(), ""));
            }
        }
        modelChart.update(transactions);
    }

    public ObservableList<PieChart.Data> getData(){
        return modelChart.getObservableList();
    }

    public List<BudgetPost> getBudgetPosts() {
        return budget.getBudgetPosts();
    }
}
