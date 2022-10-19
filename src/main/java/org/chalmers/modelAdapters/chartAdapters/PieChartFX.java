package org.chalmers.modelAdapters.chartAdapters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import org.chalmers.model.ITransaction;
import org.chalmers.model.charts.ChartTypePie;

import java.util.Collection;

/**
 * An adapter class that makes ChartTypePie useable with JavaFX.
 * Depends on ChartTypePie and JavaFX.
 *
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

    public void update(Collection<ITransaction> transactions) {
        this.modelChart.update(transactions);
    }
}
