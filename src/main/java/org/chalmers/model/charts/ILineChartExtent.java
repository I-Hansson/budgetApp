package org.chalmers.model.charts;

import org.chalmers.model.ITransaction;
import java.util.Map;

/**
 * An interface for classes that represent the algorithm for an extent of a line chart.
 *
 * @author williamfrisk
 */
interface ILineChartExtent {
    /**
     * Returns the date of the transaction as an integer.
     *
     * @param transaction The ITransaction.
     * @return The date as an Integer.
     */
    int getDateAsInt(ITransaction transaction);

    /**
     * Creates a Map with the correct size.
     * @return The map.
     */
    Map<Integer, Integer> createEmptyDateMap();
}
