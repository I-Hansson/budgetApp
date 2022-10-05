package org.chalmers.model.charts;

import org.chalmers.model.charts.lineChartExtents.LineChartMonth;
import org.chalmers.model.charts.lineChartExtents.LineChartWeek;
import org.chalmers.model.charts.lineChartExtents.LineChartYear;

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
