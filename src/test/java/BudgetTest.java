import org.chalmers.model.Budget;
import org.chalmers.model.BudgetPost;
import org.chalmers.model.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BudgetTest {

    Budget testBudget;
    BudgetPost testBp;
    Transaction testTransaction;

    @Before
    public void init(){
        testBudget = new Budget(2022, 10);
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, testBp.getId(), "", "")
    }

    @Test
    @Order(1)
    public void getYearReturnsCorrectString() {
        assertEquals("2022", testBudget.getYear());
    }

    @Test
    @Order(2)
    public void getMonthReturnsCorrectString() {
        assertEquals("10", testBudget.getMonthNumber())
        assertEquals("October", testBudget.getMonth());
    }

    @Test
    @Order(3)
    public void transactionsListIsMutable() {
        testBudget.addTransaction(testTransaction);
        assertTrue(testBudget.getTransactions().contains(testTransaction));
    }
}
