package org.chalmers.modelAdapters.chartAdapters;

import javafx.scene.chart.XYChart;

import java.util.Map;

public class LineChartFX {

    public static XYChart.Series<Integer, Integer> getDataAsXYSeries(Map<Integer, Integer> dataMap) {
        XYChart.Series<Integer, Integer> series = createSeries(dataMap.size());

        for (Integer date : dataMap.keySet()) {
            if(dataMap.get(date) != 0) {
                int amount = dataMap.get(date);
                var temp = series.getData().get(date - 1);
                int temp2 = temp.getYValue();
                series.getData().set(date - 1, new XYChart.Data<>(date, amount + temp2));
            }
        }

        return series;
    }

    private static XYChart.Series<Integer, Integer> createSeries(int len) {
        XYChart.Series<Integer, Integer> series = new XYChart.Series<>();

        for(int i = 1; i <= len; i++) {
            series.getData().add(new XYChart.Data<>(i, 0));
        }

        return series;
    }
}
