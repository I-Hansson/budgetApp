package org.chalmers.modelAdapters.chartAdapters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import org.chalmers.model.ITransaction;
import org.chalmers.model.charts.ChartTypePie;

import java.util.Collection;

/**
 * An adapter class that makes ChartTypePie useable with JavaFX.
 * <p>
 * Uses: ChartTypePie
 * Used by: View module
 *
 * @author williamfrisk
 */
public class PieChartFX {

    private final ChartTypePie modelChart;

    /**
     * Constructs the PieChartFX with a given chart instance from the model.
     *
     * @param chart The ChartTypePie instance to be used.
     */
    public PieChartFX(ChartTypePie chart) {
        modelChart = chart;
    }

    /**
     * Returns an ObservableList containing PieChart.Data which is needed by
     * JavaFX to create a pie chart.
     *
     * @return The ObservableList.
     */
    public ObservableList<PieChart.Data> getObservableList() {
        ObservableList<PieChart.Data> dataObservableList = FXCollections.observableArrayList();

        int i = 0;
        for (String name : modelChart.getDataMap().keySet()) {
            dataObservableList.add(i, new PieChart.Data(name, modelChart.getDataMap().get(name)));
            i++;
        }

        return dataObservableList;
    }

    /**
     * Updates the LineChartFX with new transactions.
     *
     * @param transactions The transactions to be used.
     */
    public void update(Collection<ITransaction> transactions) {
        this.modelChart.update(transactions);
    }
}
