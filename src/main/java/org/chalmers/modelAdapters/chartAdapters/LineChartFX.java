package org.chalmers.modelAdapters.chartAdapters;

import javafx.scene.chart.XYChart;
import org.chalmers.model.ITransaction;
import org.chalmers.model.charts.ChartTypeLine;

import java.util.Collection;

/**
 * An adapter class that makes ChartTypeLine useable with JavaFX.
 * <p>
 * Uses: ChartTypeLine
 * Used by: View module
 *
 * @author williamfrisk
 */
public class LineChartFX {

    private final ChartTypeLine modelChart;
    private final XYChart.Series<Number, Number> series;

    /**
     * Constructs the LineChartFX with a given chart instance from the model.
     *
     * @param chart The ChartTypeLine instance to be used.
     */
    public LineChartFX(ChartTypeLine chart) {
        this.modelChart = chart;
        this.series = createSeries(modelChart.getDataMap().size());
    }

    /**
     * Returns an XYChart.Series which is the datatype required to create a
     * line chart using JavaFX
     *
     * @return The XYChart.Series
     */
    public XYChart.Series<Number, Number> getXYSeries() {
        for (Integer date : modelChart.getDataMap().keySet()) {
            if(modelChart.getDataMap().get(date) != 0) {
                int amount = modelChart.getDataMap().get(date);
                var temp = series.getData().get(date - 1);
                int temp2 = (int) temp.getYValue();
                series.getData().set(date - 1, new XYChart.Data<>(date, amount + temp2));
            }
        }

        return series;
    }

    /**
     * Updates the LineChartFX with new transactions.
     *
     * @param transactions The transactions to be used.
     */
    public void update(Collection<ITransaction> transactions) {
        modelChart.update(transactions);
    }

    private XYChart.Series<Number, Number> createSeries(int len) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();

        for(int i = 1; i <= len; i++) {
            series.getData().add(new XYChart.Data<>(i, 0));
        }
        series.setName("Transactions");

        return series;
    }
}
