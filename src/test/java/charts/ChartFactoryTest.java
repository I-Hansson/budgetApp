package charts;

import org.chalmers.model.charts.ChartFactory;
import org.chalmers.model.charts.ChartTypeLine;
import org.chalmers.model.charts.ChartTypePie;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChartFactoryTest {

    @Test
    public void createPieChartReturnsCorrectInstance() {
        assertTrue(ChartFactory.createPieChart() instanceof ChartTypePie);
    }

    @Test
    public void createWeekLineChartReturnsCorrectInstance() {
        ChartTypeLine testChart = ChartFactory.createWeekLineChart();
        assertEquals(7, testChart.getDataMap().size());
    }

    @Test
    public void createMonthLineChartReturnsCorrectInstance() {
        ChartTypeLine testChart = ChartFactory.createMonthLineChart();
        assertEquals(31, testChart.getDataMap().size());
    }

    @Test
    public void createYearLineChartReturnsCorrectInstance() {
        ChartTypeLine testChart = ChartFactory.createYearLineChart();
        assertEquals(365, testChart.getDataMap().size());
    }
}
