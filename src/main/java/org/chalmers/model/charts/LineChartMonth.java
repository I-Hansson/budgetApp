package org.chalmers.model.charts;

import org.chalmers.model.ITransaction;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

class LineChartMonth implements ILineChartExtent {
    public LineChartMonth() {}

    @Override
    public int getDateAsInt(ITransaction transaction) {
        return transaction.getDate().get(Calendar.DAY_OF_MONTH);
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
