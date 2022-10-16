package org.chalmers.model.charts;


/**
 * This class is used to create instances of chart classes.
 * Depends on ChartTypePie and ChartTypeLine.
 *
 * @author williamfrisk
 */
public class ChartFactory {

    public static ChartTypePie createPieChart() {
        return new ChartTypePie();
    }


    public static ChartTypeLine createWeekLineChart() {
        return new ChartTypeLine(new LineChartWeek());
    }

    public static ChartTypeLine createMonthLineChart() {
         return new ChartTypeLine(new LineChartMonth());
    }

    public static ChartTypeLine createYearLineChart() {
        return new ChartTypeLine(new LineChartYear());
    }


}
