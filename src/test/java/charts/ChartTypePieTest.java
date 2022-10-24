package charts;

import org.chalmers.model.ITransaction;
import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.model.charts.ChartTypePie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

class ChartTypePieTest {

    @Test
    void monthLineChartUpdatesDataMapCorrectly() {
        ChartTypePie testChart = ChartFactory.createPieChart();
        List<ITransaction> dataPoints = new ArrayList<>();
        ITransaction dataPoint = new Transaction("test", 100, " ", new GregorianCalendar());
        dataPoints.add(dataPoint);

        testChart.update(dataPoints);
        assertTrue(testChart.getDataMap().containsKey("Uncategorized"));
    }
}
