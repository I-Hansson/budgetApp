import org.chalmers.model.BudgetPost;
import javafx.scene.paint.Color;
import org.chalmers.model.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BudgetPostTest {

    BudgetPost testBp;
    Transaction testTransaction;

    @Before
    public void init(){
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, testBp.getId(), "", "");
    }

    @Test
    @Order(1)
    public void getColorRGBReturnsCorrectValues() {
        assertEquals("0, 0, 0", testBp.getColor());
    }

    @Test
    @Order(2)
    public void getNameReturnsCorrectString() {
        assertEquals("test", testBp.getName());
    }

    @Test
    @Order(3)
    public void budgetCapIsMutable() {
        testBp.setBudgetCap(150.0);
        assertEquals(150.0, testBp.getBudgetCap());
    }

    @Test
    @Order(4)
    public void currentBalanceIsMutable() {
        testBp.setCurrentBalance(90);
        assertEquals(90, testBp.getCurrentBalance());
    }

    @Test
    @Order(5)
    public void getTransactionsReturnsCorrectInstance() {
        testBp.addTransaction(testTransaction);
        assertTrue(testBp.getTransactions().contains(testTransaction));
    }
}
