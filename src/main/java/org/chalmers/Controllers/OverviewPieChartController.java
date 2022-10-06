package org.chalmers.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import org.chalmers.model.BudgetPost;
import org.chalmers.model.BudgetPostFactory;
import org.chalmers.model.ModelFacade;
import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.model.charts.ChartTypePie;
import org.chalmers.modelAdapters.chartAdapters.PieChartFX;

import java.util.ArrayList;
import java.util.Collection;

public class OverviewPieChartController {

    ModelFacade model = ModelFacade.getInstance();
    PieChartFX modelChart;
    Collection<Transaction> transactions = new ArrayList<>();

    BudgetPost tempData1 = BudgetPostFactory.createBudgetPost("temp1");
    BudgetPost tempData2 = BudgetPostFactory.createBudgetPost("temp2");
    BudgetPost tempData3 = BudgetPostFactory.createBudgetPost("temp3");
    BudgetPost[] tempBpArr = {tempData1, tempData2, tempData3};

    public OverviewPieChartController(){
        modelChart = new PieChartFX(ChartFactory.createPieChart());
        for (int i = 0; i < 10; i++) {
            BudgetPost bp = tempBpArr[i % 3];
            transactions.add(new Transaction("test", i*100, bp.getId(), ""));
        }
        modelChart.update(transactions);
    }

    public ObservableList<PieChart.Data> getData(){
        return modelChart.getObservableList();
    }

    public BudgetPost[] getBudgetPosts() {
        return tempBpArr;
    }
}
