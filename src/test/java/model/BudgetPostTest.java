package model;

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
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BudgetPostTest {

    BudgetPost testBp;
    Transaction testTransaction;

    @Before
    public void init(){
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
    }

    @Test
    @Order(1)
    public void getColorRGBReturnsCorrectValues() {
        assertEquals("0, 0, 0", testBp.getColor());
    }

    @Test
    @Order(2)
    public void nameIsMutable() {
        testBp.setName("hej");
        assertEquals("hej", testBp.getName());
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

    @Test
    @Order(6)
    public void constructorOverloadingWorks() {
        testBp = new BudgetPost("test1");
        assertEquals("test1", testBp.getName());

        testBp = new BudgetPost(13, "test2");
        assertEquals(13, testBp.getBudgetCap());
        assertEquals("test2", testBp.getName());
    }
}
