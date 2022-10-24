package charts;

import org.chalmers.model.ITransaction;
import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.modelAdapters.chartAdapters.LineChartFX;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LineChartFXTest {

    @Test
    void lineChartFXUpdatesDataMapCorrectly() {
        LineChartFX testChart = new LineChartFX(ChartFactory.createWeekLineChart());
        List<ITransaction> dataPoints = new ArrayList<>();
        ITransaction dataPoint = new Transaction("test", 100, " ", new GregorianCalendar());
        dataPoints.add(dataPoint);

        testChart.update(dataPoints);
        assertEquals(100, testChart.getXYSeries().getData().get(dataPoint.getDate().get(Calendar.DAY_OF_WEEK) - 1).getYValue());
    }
}
