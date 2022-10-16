package org.chalmers.model.charts;

import org.chalmers.model.Transaction;

import java.util.HashMap;
import java.util.Map;

public class LineChartMonth implements ILineChartExtent {
    public LineChartMonth() {}

    @Override
    public int getDateAsInt(Transaction transaction) {
        return transaction.getDayOfMonth();
    }

    @Override
    public Map<Integer, Integer> createEmptyDateMap() {
        Map<Integer, Integer> emptyDateMap = new HashMap<>();
        for (int i = 1; i <= 31; i++){ // TODO alla månader har inte 31 dagar...
            emptyDateMap.put(i, 0);
        }
        return emptyDateMap;
    }
}
