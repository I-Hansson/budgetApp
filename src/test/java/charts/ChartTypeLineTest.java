package charts;

import org.chalmers.model.ITransaction;
import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.model.charts.ChartTypeLine;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChartTypeLineTest {

    @Test
    void weekLineChartUpdatesDataMapCorrectly() {
        ChartTypeLine testChart = ChartFactory.createWeekLineChart();
        List<ITransaction> dataPoints = new ArrayList<>();
        ITransaction dataPoint = new Transaction("test", 100, " ", new GregorianCalendar());
        dataPoints.add(dataPoint);

        testChart.update(dataPoints);
        assertTrue(testChart.getDataMap().containsValue((int) dataPoint.getAmount()));
    }

    @Test
   void monthLineChartUpdatesDataMapCorrectly() {
        ChartTypeLine testChart = ChartFactory.createMonthLineChart();
        List<ITransaction> dataPoints = new ArrayList<>();
        ITransaction dataPoint = new Transaction("test", 100, " ", new GregorianCalendar());
        dataPoints.add(dataPoint);

        testChart.update(dataPoints);
        assertTrue(testChart.getDataMap().containsValue((int) dataPoint.getAmount()));
    }

    @Test
    void yearLineChartUpdatesDataMapCorrectly() {
        ChartTypeLine testChart = ChartFactory.createYearLineChart();
        List<ITransaction> dataPoints = new ArrayList<>();
        ITransaction dataPoint = new Transaction("test", 100, " ", new GregorianCalendar());
        dataPoints.add(dataPoint);

        testChart.update(dataPoints);
        assertTrue(testChart.getDataMap().containsValue((int) dataPoint.getAmount()));
    }
}
