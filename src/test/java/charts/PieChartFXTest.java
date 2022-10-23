package charts;

import org.chalmers.model.ITransaction;
import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.modelAdapters.chartAdapters.LineChartFX;
import org.chalmers.modelAdapters.chartAdapters.PieChartFX;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieChartFXTest {

    @Test
    public void pieChartFXUpdatesDataMapCorrectly() {
        PieChartFX testChart = new PieChartFX(ChartFactory.createPieChart());
        List<ITransaction> dataPoints = new ArrayList<>();
        ITransaction dataPoint = new Transaction("test", 100, " ", new GregorianCalendar());
        dataPoints.add(dataPoint);

        testChart.update(dataPoints);
        assertEquals(100, testChart.getObservableList().get(0).getPieValue());
    }
}
