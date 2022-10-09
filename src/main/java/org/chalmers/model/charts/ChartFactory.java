package org.chalmers.model.charts;

import org.chalmers.model.charts.lineChartExtents.ILineChartExtent;
import org.chalmers.model.charts.lineChartExtents.LineChartMonth;
import org.chalmers.model.charts.lineChartExtents.LineChartWeek;
import org.chalmers.model.charts.lineChartExtents.LineChartYear;

/**
 * This class is used to create instances of chart classes
 *
 * @author williamfrisk
 */
public class ChartFactory {

    public static ChartTypePie createPieChart() {
        return new ChartTypePie();
    }
/*
    public static ChartTypeLine createWeekLineChart() {
        ILineChartExtent temp = new LineChartWeek();
        return new ChartTypeLine(temp);
    }

    public static ChartTypeLine createMonthLineChart() {
         return new ChartTypeLine(new LineChartMonth());
    }

    public static ChartTypeLine createYearLineChart() {
        return new ChartTypeLine(new LineChartYear());
    }

 */
}
