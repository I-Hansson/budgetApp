import org.chalmers.model.BudgetPost;
import org.chalmers.model.BudgetPostFactory;
import org.chalmers.model.BudgetPostID;
import org.chalmers.model.Transaction;
import org.chalmers.model.charts.ChartFactory;
import org.chalmers.model.charts.ChartTypePie;
import org.chalmers.model.charts.IChart;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChartTest {
    /*
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


    BudgetPost test = BudgetPostFactory.createBudgetPost("test");
    BudgetPost test1 = BudgetPostFactory.createBudgetPost("test1");
    BudgetPost test2 = BudgetPostFactory.createBudgetPost("test2");
    private final Transaction[] testTransactionsPie = {
            new Transaction("Test" ,100, test.getId(), "bana"),
            new Transaction("Test1" ,200, test1.getId(), "sxds"),
            new Transaction("Test2" ,300, test2.getId(), "tess"),
            new Transaction("Test" ,400, test.getId(), "ts"),
            new Transaction("Test1" ,500, test1.getId(), "terfsst"),
            new Transaction("Test2" ,600, test2.getId(), "tessst"),
            new Transaction("Test" ,700, test.getId(), "tesst"),
    };


    //Sämsta testet någonsin william
    @Test
    public void chartTypePieReturnsCorrectData() {
        ChartTypePie pieChart = ChartFactory.createPieChart();
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
*/

}
