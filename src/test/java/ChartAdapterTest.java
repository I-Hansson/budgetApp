import javafx.scene.chart.XYChart;
import org.chalmers.model.BudgetPost;
import org.chalmers.model.BudgetPostFactory;
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
    BudgetPost bp = BudgetPostFactory.createBudgetPost("test");
    private final Transaction[] testTransactionsLine = {
            new Transaction("Test0" ,100, bp, "test"),
            new Transaction("Test1" ,200, bp, "test"),
            new Transaction("Test2" ,300, bp, "test"),
            new Transaction("Test3" ,400, bp, "test"),
            new Transaction("Test4" ,500, bp, "test"),
            new Transaction("Test5" ,600, bp, "test"),
            new Transaction("Test6" ,700, bp, "test"),



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
