import javafx.scene.chart.XYChart;
import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.model.charts.IChart;
import org.chalmers.modelAdapters.chartAdapters.LineChartFX;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChartAdapterTest {

    private final Transaction[] testTransactionsLine = {
            new Transaction(100, "test", ""),
            new Transaction(200, "test1", ""),
            new Transaction(300, "test2", ""),
            new Transaction(400, "test3", ""),
            new Transaction(500, "test4", ""),
            new Transaction(600, "test5", ""),
            new Transaction(700, "test6", ""),
    };

    @Test
    public void LineChartFXReturnsCorrectSeries() {
        IChart<Integer, Integer> lineChart = ChartFactory.createMonthLineChart();
        lineChart.update(List.of(testTransactionsLine));

        XYChart.Series<Integer, Integer> result = LineChartFX.getDataAsXYSeries(lineChart.getDataMap());
        Calendar calendar = new GregorianCalendar();

        assertEquals(2800, result.getData().get(calendar.get(Calendar.DAY_OF_MONTH)-1).getYValue());
    }
}
