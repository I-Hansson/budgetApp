package org.chalmers.model.charts;

import org.chalmers.model.charts.lineChartExtents.LineChartMonth;
import org.chalmers.model.charts.lineChartExtents.LineChartWeek;
import org.chalmers.model.charts.lineChartExtents.LineChartYear;

public class ChartFactory {

    public static IChart<String, Integer> createPieChart() {
        return new ChartTypePie();
    }

    public static IChart<Integer, Integer> createWeekLineChart() {
        return new ChartTypeLine(new LineChartWeek());
    }

    public static IChart<Integer, Integer> createMonthLineChart() {
         return new ChartTypeLine(new LineChartMonth());
    }

    public static IChart<Integer, Integer> createYearLineChart() {
        return new ChartTypeLine(new LineChartYear());
    }
}
