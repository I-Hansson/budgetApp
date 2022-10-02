package org.chalmers.model.charts.lineChartExtents;

import org.chalmers.model.Transaction;

import java.util.Map;

public interface ILineChartExtent {
    int getDateAsInt(Transaction transaction);
    Map<Integer, Integer> createEmptyDateMap();
}
