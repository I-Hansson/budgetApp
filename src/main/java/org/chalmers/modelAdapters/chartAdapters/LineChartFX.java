package org.chalmers.modelAdapters.chartAdapters;

import javafx.scene.chart.XYChart;
import org.chalmers.model.charts.ChartTypeLine;

/**
 * An adapter class that makes ChartTypeLine useable with JavaFX.
 * Depends on ChartTypeLine and JavaFX.
 *
 * @author williamfrisk
 */
public class LineChartFX {

    private final ChartTypeLine modelChart;
    private final XYChart.Series<Integer, Integer> series;

    public LineChartFX(ChartTypeLine chart) {
        this.modelChart = chart;
        this.series = createSeries(modelChart.getDataMap().size());
    }
    
    public XYChart.Series<Integer, Integer> getXYSeries() {
        for (Integer date : modelChart.getDataMap().keySet()) {
            if(modelChart.getDataMap().get(date) != 0) {
                int amount = modelChart.getDataMap().get(date);
                var temp = series.getData().get(date - 1);
                int temp2 = temp.getYValue();
                series.getData().set(date - 1, new XYChart.Data<>(date, amount + temp2));
            }
        }

        return series;
    }

    private XYChart.Series<Integer, Integer> createSeries(int len) {
        XYChart.Series<Integer, Integer> series = new XYChart.Series<>();

        for(int i = 1; i <= len; i++) {
            series.getData().add(new XYChart.Data<>(i, 0));
        }

        return series;
    }
}
