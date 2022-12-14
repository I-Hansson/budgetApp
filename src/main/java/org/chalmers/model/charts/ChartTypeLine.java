package org.chalmers.model.charts;

import org.chalmers.model.ITransaction;


import java.util.*;

/**
 * This class gives functionality for displaying line charts.
 * Depends on ILineChartExtent & Transaction
 * <p>
 * Uses: ILineChartExtent
 * Used by: ChartFactory, LineChartFX
 *
 * @author williamfrisk
 */
public class ChartTypeLine{

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
    public void update(Collection<ITransaction> transactions) {
        for(ITransaction transaction : transactions){
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
    public Map<Integer, Integer> getDataMap() {
        return data;
    }
}
