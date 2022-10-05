package org.chalmers.model.charts;

import org.chalmers.model.Transaction;
import org.chalmers.model.charts.lineChartExtents.ILineChartExtent;

import java.util.*;

public class ChartTypeLine implements IChart<Integer, Integer> {

    private final ILineChartExtent extent;
    private final Map<Integer, Integer> data;

    ChartTypeLine(ILineChartExtent extent) {
        this.extent = extent;
        this.data = extent.createEmptyDateMap();
    }

    @Override
    public void update(Collection<Transaction> transactions) {
        for(Transaction transaction : transactions){
            if( transaction.getAmount() != 0){
                int date = extent.getDateAsInt(transaction);
                int temp = data.get(date) + (int) transaction.getAmount();
                data.put(date, temp);
            }
        }
    }

    @Override
    public Map<Integer, Integer> getDataMap() {
        return data;
    }
}
