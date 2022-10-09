package org.chalmers.modelAdapters.chartAdapters;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.collections.transformation.SortedList;
import javafx.scene.chart.PieChart;
import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartTypePie;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author williamfrisk
 */
public class PieChartFX {

    private final ChartTypePie modelChart;

    public PieChartFX(ChartTypePie chart) {
        modelChart = chart;
    }

    public ObservableList<PieChart.Data> getObservableList() {
        ObservableList<PieChart.Data> dataObservableList = FXCollections.observableArrayList();

        int i = 0;
        for (String name : modelChart.getDataMap().keySet()) {
            dataObservableList.add(i, new PieChart.Data(name, modelChart.getDataMap().get(name)));
            i++;
        }

        return dataObservableList;
    }

    public void update(Collection<Transaction> transactions) {
        this.modelChart.update(transactions);
    }
}
