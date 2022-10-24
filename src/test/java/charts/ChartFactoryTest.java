package charts;

import org.chalmers.model.charts.ChartFactory;
import org.chalmers.model.charts.ChartTypeLine;
import org.chalmers.model.charts.ChartTypePie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

 class ChartFactoryTest {

    @Test
    void createPieChartReturnsCorrectInstance() {
        assertTrue(ChartFactory.createPieChart() instanceof ChartTypePie);
    }

    @Test
    void createWeekLineChartReturnsCorrectInstance() {
        ChartTypeLine testChart = ChartFactory.createWeekLineChart();
        assertEquals(7, testChart.getDataMap().size());
    }

    @Test
    void createMonthLineChartReturnsCorrectInstance() {
        ChartTypeLine testChart = ChartFactory.createMonthLineChart();
        assertEquals(31, testChart.getDataMap().size());
    }

    @Test
    void createYearLineChartReturnsCorrectInstance() {
        ChartTypeLine testChart = ChartFactory.createYearLineChart();
        assertEquals(365, testChart.getDataMap().size());
    }
}
