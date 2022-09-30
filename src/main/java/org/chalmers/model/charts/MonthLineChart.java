package org.chalmers.model.charts;


import javafx.scene.chart.XYChart;
import org.chalmers.model.Transaction;

import java.util.Calendar;

public class MonthLineChart extends LineChart {

    @Override
    int getDateAsInt(Transaction transaction) {
        return transaction.getDateOfTransaction().get(Calendar.DAY_OF_MONTH);
    }

    XYChart.Series<Integer, Integer> fillSeries(){
        data = new XYChart.Series<Integer, Integer>();
        for(int i = 1; i<=31;i++){
            data.getData().add(new XYChart.Data<>(i, 0));
        }
        return data;
    }
}
