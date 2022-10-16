import javafx.collections.ObservableList;

import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import org.chalmers.model.Budget;
import org.chalmers.model.BudgetPost;
import org.chalmers.model.BudgetPostFactory;
import org.chalmers.model.BudgetPostID;
import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.model.charts.ChartTypeLine;
import org.chalmers.model.charts.ChartTypePie;
import org.chalmers.model.charts.IChart;
import org.chalmers.modelAdapters.chartAdapters.LineChartFX;
import org.chalmers.modelAdapters.chartAdapters.PieChartFX;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChartAdapterTest {
    /*
    BudgetPostID bp = new BudgetPostID("TEST","COLOR","ID");
    private final Transaction[] testTransactionsLine = {
            new Transaction("Test0" ,100, bp, "test"),
            new Transaction("Test1" ,200, bp, "test"),
            new Transaction("Test2" ,300, bp, "test"),
            new Transaction("Test3" ,400, bp, "test"),
            new Transaction("Test4" ,500, bp, "test"),
            new Transaction("Test5" ,600, bp, "test"),
            new Transaction("Test6" ,700, bp, "test"),
    };


    BudgetPost test = BudgetPostFactory.createBudgetPost("test");
    BudgetPost test1 = BudgetPostFactory.createBudgetPost("test1");
    BudgetPost test2 = BudgetPostFactory.createBudgetPost("test2");

    private final Transaction[] testTransactionsPie = {
            new Transaction("test",100, test.getId(), ""),
            new Transaction("test",200, test1.getId(), ""),
            new Transaction("test",300, test2.getId(), ""),
            new Transaction("test",400, test.getId(), ""),
            new Transaction("test",500, test1.getId(), ""),
            new Transaction("test",600, test2.getId(), ""),
            new Transaction("test",700, test.getId(), ""),
    };


    @Test
    public void LineChartFXReturnsCorrectSeries() {
        ChartTypeLine lineChart = ChartFactory.createMonthLineChart();
        LineChartFX FXChart = new LineChartFX(lineChart);

        lineChart.update(List.of(testTransactionsLine));
        XYChart.Series<Number, Number> result = FXChart.getXYSeries();
        Calendar calendar = new GregorianCalendar();

        assertEquals(2800, result.getData().get(calendar.get(Calendar.DAY_OF_MONTH)-1).getYValue());
    }

    @Test
    public void PieChartFXReturnsCorrectList() {
        ChartTypePie pieChart = ChartFactory.createPieChart();
        PieChartFX FXChart = new PieChartFX(pieChart);

        pieChart.update(List.of(testTransactionsPie));
        ObservableList<PieChart.Data> result = FXChart.getObservableList();

        assertEquals(1200, result.get(1).getPieValue());

    }

     */
}
