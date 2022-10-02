package org.chalmers.model.charts;

import org.chalmers.model.Transaction;

public class LineChartYear implements ILineChartExtent {
    @Override
    public int getDateAsInt(Transaction transaction) {
        return transaction.getDayOfYear();
    }
}
