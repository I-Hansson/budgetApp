package org.chalmers.model.charts;

import org.chalmers.model.ITransaction;
import org.chalmers.model.Transaction;

import java.util.Map;

interface ILineChartExtent {
    int getDateAsInt(ITransaction transaction);
    Map<Integer, Integer> createEmptyDateMap();
}
