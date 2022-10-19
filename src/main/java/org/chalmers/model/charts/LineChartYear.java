package org.chalmers.model.charts;

import org.chalmers.model.ITransaction;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

class LineChartYear implements ILineChartExtent {

    public LineChartYear() {}
    @Override
    public int getDateAsInt(ITransaction transaction) {
        return transaction.getDate().get(Calendar.DAY_OF_YEAR);
    }

    @Override
    public Map<Integer, Integer> createEmptyDateMap() {
        Map<Integer, Integer> emptyDateMap = new HashMap<>();
        for (int i = 1; i <= 365; i++){
            emptyDateMap.put(i, 0);
        }
        return emptyDateMap;
    }
}
