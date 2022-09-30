package org.chalmers.model.charts;

import javafx.scene.chart.XYChart;
import org.chalmers.model.IBudgetPostsObserver;
import org.chalmers.model.Transaction;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class LineChart implements IBudgetPostsObserver {
    XYChart.Series<Integer, Integer> data;

    public LineChart() {
        data = fillSeries();
    }

    public XYChart.Series<Integer, Integer> getData() {
        return data;
    }

    public void update(ArrayList<Transaction> transactions) {
        for(Transaction transaction : transactions){
            if( transaction.getAmount() != 0){
                int date = getDateAsInt(transaction); //transaction.getDateOfTransaction().get(Calendar.DAY_OF_WEEK);
                int amount = (int) transaction.getAmount();
                var temp = this.data.getData().get(date-1);
                int temp2 = temp.getYValue();
                this.data.getData().set(date-1,new XYChart.Data<>(date,amount + temp2));
            }
        }
    }

    abstract int getDateAsInt(Transaction transaction);
    abstract XYChart.Series<Integer, Integer> fillSeries();
}
