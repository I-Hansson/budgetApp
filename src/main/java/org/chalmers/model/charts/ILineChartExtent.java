package org.chalmers.model.charts;

import org.chalmers.model.Transaction;

import java.util.Map;

interface ILineChartExtent {
    int getDateAsInt(Transaction transaction);
    Map<Integer, Integer> createEmptyDateMap();
}
