package org.chalmers.model.charts;


/**
 * This class is used to create instances of chart classes.
 * Its purpose is obscuring implementation from client code.
 *
 * Depends on ChartTypePie and ChartTypeLine.
 *
 * @author williamfrisk
 */
public class ChartFactory {

    /**
     * Instantiates an object of ChartTypePie.
     * @return the instantiated object.
     */
    public static ChartTypePie createPieChart() {
        return new ChartTypePie();
    }

    /**
     * Instantiates on object of ChartTypeLine with a LineChartWeek extent.
     * @return the instantiated object
     */
    public static ChartTypeLine createWeekLineChart() {
        return new ChartTypeLine(new LineChartWeek());
    }

    /**
     * Instantiates on object of ChartTypeLine with a LineChartMonth extent.
     * @return the instantiated object
     */
    public static ChartTypeLine createMonthLineChart() {
         return new ChartTypeLine(new LineChartMonth());
    }

    /**
     * Instantiates on object of ChartTypeLine with a LineChartYear extent.
     * @return the instantiated object
     */
    public static ChartTypeLine createYearLineChart() {
        return new ChartTypeLine(new LineChartYear());
    }


}
