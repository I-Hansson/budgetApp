import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.model.charts.IChart;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChartTest {

    private final Transaction[] testTransactionsLine = {
            new Transaction(100, "test", ""),
            new Transaction(200, "test1", ""),
            new Transaction(300, "test2", ""),
            new Transaction(400, "test3", ""),
            new Transaction(500, "test4", ""),
            new Transaction(600, "test5", ""),
            new Transaction(700, "test6", ""),
    };

    private final Transaction[] testTransactionsPie = {
            new Transaction(100, "test", ""),
            new Transaction(200, "test1", ""),
            new Transaction(300, "test2", ""),
            new Transaction(400, "test", ""),
            new Transaction(500, "test1", ""),
            new Transaction(600, "test2", ""),
            new Transaction(700, "test", ""),
    };

    @Test
    public void chartTypePieReturnsCorrectData() {
        IChart<String, Integer> pieChart = ChartFactory.createPieChart();
        pieChart.update(List.of(testTransactionsPie));

        Map<String, Integer> correctMap = new HashMap<>();
        correctMap.put("test", 1200);
        correctMap.put("test1", 700);
        correctMap.put("test2", 900);

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
