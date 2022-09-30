import org.chalmers.model.Transaction;
import org.chalmers.model.charts.LineChart;
import org.chalmers.model.charts.MonthLineChart;
import org.chalmers.model.charts.WeekLineChart;
import org.junit.Test;

import java.util.ArrayList;

public class ChartsTest {

    @Test
    public void CalenderTest() throws InterruptedException {
        Transaction transaction = new Transaction(200.0,"Mat","Kottbullar");
        Transaction transaction2 = new Transaction(300.0,"Mat","hej");
        LineChart hej = new WeekLineChart();
        ArrayList<Transaction> temp = new ArrayList<>();
        temp.add(transaction);
        temp.add(transaction2);
        hej.update(temp);
        System.out.println(hej.getData().getData());
    }
}
