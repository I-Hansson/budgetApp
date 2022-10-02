package org.chalmers.model.charts;

import org.chalmers.model.IBudgetPostsObserver;
import org.chalmers.model.Transaction;

import java.util.*;

public class ChartTypeLine implements IChart<Integer, Integer> {

    private final ILineChartExtent extent;
    private final Map<Integer, Integer> data;

    ChartTypeLine(ILineChartExtent extent) {
        this.extent = extent;
        this.data = new HashMap<>(7);
    }

    @Override
    public void update(Collection<Transaction> transactions) {
        for(Transaction transaction : transactions){
            if( transaction.getAmount() != 0){
                int date = extent.getDateAsInt(transaction);
                int amount = (int) transaction.getAmount();
                data.put(date, amount);
            }
        }
    }

    @Override
    public Map<Integer, Integer> getDataMap() {
        return data;
    }
}
