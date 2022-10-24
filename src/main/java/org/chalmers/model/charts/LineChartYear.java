package org.chalmers.model.charts;

import org.chalmers.model.ITransaction;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * A class that provides implementation to a line chart that needs to span a year.
 */
class LineChartYear implements ILineChartExtent {

    public LineChartYear() {}

    /**
     * {@inheritDoc}
     * @param transaction {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public int getDateAsInt(ITransaction transaction) {
        return transaction.getDate().get(Calendar.DAY_OF_YEAR);
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Map<Integer, Integer> createEmptyDateMap() {
        Map<Integer, Integer> emptyDateMap = new HashMap<>();
        for (int i = 1; i <= 365; i++){
            emptyDateMap.put(i, 0);
        }
        return emptyDateMap;
    }
}
