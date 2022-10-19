package org.chalmers.model.charts;

import org.chalmers.model.Transaction;


import java.util.*;

/**
 * This class gives functionality for displaying line charts.
 * Depends on ILineChartExtent & Transaction
 *
 * @author williamfrisk
 */
public class ChartTypeLine implements IChart<Integer, Integer> {

    private final ILineChartExtent extent;
    private final Map<Integer, Integer> data;

    ChartTypeLine(ILineChartExtent extent) {
        this.extent = extent;
        this.data = extent.createEmptyDateMap();
    }

    /**
     * Updates the data in the line chart with a given collection of transactions.
     * @param transactions The collection of transaction which are used for the update.
     */
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

    /**
     * Returns a Map containing the data points and appurtunent date number.
     * @return The Map with data points and dates
     */
    @Override
    public Map<Integer, Integer> getDataMap() {
        return data;
    }
}
