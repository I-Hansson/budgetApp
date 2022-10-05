import org.chalmers.model.BudgetPost;
import org.chalmers.model.BudgetPostFactory;
import org.chalmers.model.BudgetPostID;
import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.model.charts.IChart;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChartTest {
    BudgetPostID bp = new BudgetPostID("TEST","COLOR","ID");
    private final Transaction[] testTransactionsLine = {
            new Transaction("Test" ,100, bp, "test"),
            new Transaction("Test1" ,200, bp, "test"),
            new Transaction("Test2" ,300, bp, "test"),
            new Transaction("Test3" ,400, bp, "test"),
            new Transaction("Test4" ,500, bp, "test"),
            new Transaction("Test5" ,600, bp, "test"),
            new Transaction("Test6" ,700, bp, "test"),

    };

    private final Transaction[] testTransactionsPie = {
            new Transaction("Test" ,100, bp, "bana"),
            new Transaction("Test1" ,200, bp, "sxds"),
            new Transaction("Test2" ,300, bp, "tess"),
            new Transaction("Test" ,400, bp, "ts"),
            new Transaction("Test1" ,500, bp, "terfsst"),
            new Transaction("Test2" ,600, bp, "tessst"),
            new Transaction("Test" ,700, bp, "tesst"),
    };
    //Sämsta testet någonsin william
    @Test
    public void chartTypePieReturnsCorrectData() {
        IChart<String, Integer> pieChart = ChartFactory.createPieChart();
        System.out.println(pieChart.getDataMap());
        pieChart.update(List.of(testTransactionsPie));


        Map<String, Integer> correctMap = new HashMap<>();
        correctMap.put("Test", 1200);
        correctMap.put("Test1", 700);
        correctMap.put("Test2", 900);

        assertEquals(correctMap, pieChart.getDataMap());
    }

    @Test
    public void chartTypeLineReturnsCorrectData() {
        IChart<Integer, Integer> lineChart = ChartFactory.createWeekLineChart();
        lineChart.update(List.of(testTransactionsLine));

        Map<Integer, Integer> correctMap = new HashMap<>();
        for (int i = 1; i <= 7; i++) {
            correctMap.put(i, 0);
        }
        for (Transaction transaction : testTransactionsLine) {
            correctMap.put(transaction.getDayOfWeek(), (int) transaction.getAmount() + correctMap.get(transaction.getDayOfWeek()));
        }

        assertEquals(correctMap, lineChart.getDataMap());
    }
}
