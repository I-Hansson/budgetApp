package org.chalmers.model.charts.lineChartExtents;

import org.chalmers.model.Transaction;

public class LineChartMonth implements ILineChartExtent {
    @Override
    public int getDateAsInt(Transaction transaction) {
        return transaction.getDayOfMonth();
    }
}
