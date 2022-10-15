package org.chalmers.Controllers;

import javafx.collections.FXCollections;
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


    public OverviewPieChartController(){ //TODO här finns för mycket funktionalitet. Bara delegera user input
        modelChart = new PieChartFX(ChartFactory.createPieChart());

        modelChart.update(facade.getCurrentBudgetTransactions());
    }

    public ObservableList<PieChart.Data> getData(){
        ObservableList<PieChart.Data> result = modelChart.getObservableList();
        if (result.size() == 0) {
            result = FXCollections.observableArrayList();
            result.add(new PieChart.Data("1", 1));
        }
        return result;
    }

    public List<BudgetPost> getBudgetPosts() {
        return facade.budgetPostsfromUser();
    }
}
