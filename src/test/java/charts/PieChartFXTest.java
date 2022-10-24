package charts;

import org.chalmers.model.ITransaction;
import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartFactory;

import org.chalmers.modelAdapters.chartAdapters.PieChartFX;


import java.util.ArrayList;

import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PieChartFXTest {

    @Test
        void pieChartFXUpdatesDataMapCorrectly() {
        PieChartFX testChart = new PieChartFX(ChartFactory.createPieChart());
        List<ITransaction> dataPoints = new ArrayList<>();
        ITransaction dataPoint = new Transaction("test", 100, " ", new GregorianCalendar());
        dataPoints.add(dataPoint);

        testChart.update(dataPoints);
        assertEquals(100, testChart.getObservableList().get(0).getPieValue());
    }
}
