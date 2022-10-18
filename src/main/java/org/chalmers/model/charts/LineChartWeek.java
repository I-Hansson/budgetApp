package org.chalmers.model.charts;

import org.chalmers.model.Transaction;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

class LineChartWeek implements ILineChartExtent {
    public LineChartWeek() {}

    @Override
    public int getDateAsInt(Transaction transaction) {
        return transaction.getDateOfTransaction().get(Calendar.DAY_OF_WEEK);

    }

    @Override
    public Map<Integer, Integer> createEmptyDateMap() {
        Map<Integer, Integer> emptyDateMap = new HashMap<>();
        for (int i = 1; i <= 7; i++){
            emptyDateMap.put(i, 0);
        }
        return emptyDateMap;
    }


}
