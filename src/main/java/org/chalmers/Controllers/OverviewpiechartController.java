package org.chalmers.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class OverviewpiechartController {
    private ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
            new PieChart.Data("Food",40),
            new PieChart.Data("Snus",70),
            new PieChart.Data("Candy",55),
            new PieChart.Data("Books",50),
            new PieChart.Data("Soda",20)
    );
    public OverviewpiechartController(){



    }
    public ObservableList<PieChart.Data> getData(){
        return this.data;
    }
}
