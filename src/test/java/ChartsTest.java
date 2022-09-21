import org.chalmers.model.BudgetPost;
import org.chalmers.model.BudgetPostMonthLineDiagram;
import org.chalmers.model.Color;
import org.chalmers.model.Transaction;
import org.junit.Test;

import java.util.ArrayList;

public class ChartsTest {

    @Test
    public void CalenderTest() throws InterruptedException {
        Transaction transaction = new Transaction(200.0,"Mat","Kottbullar");
        Transaction transaction2 = new Transaction(300.0,"Mat","hej");
        BudgetPostMonthLineDiagram hej = new BudgetPostMonthLineDiagram();
        ArrayList<Transaction> temp = new ArrayList<>();
        temp.add(transaction);
        temp.add(transaction2);
        hej.update(temp);
    }
}
