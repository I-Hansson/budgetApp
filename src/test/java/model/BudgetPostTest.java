package model;

import org.chalmers.model.BudgetPost;

import org.chalmers.model.Transaction;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.GregorianCalendar;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class BudgetPostTest {

    BudgetPost testBp;
    Transaction testTransaction;


    @Test
    @Order(1)
    void getColorRGBReturnsCorrectValues() {
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
        assertEquals("0, 0, 0", testBp.getColor());
    }

    @Test
    @Order(2)
    void nameIsMutable() {
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
        testBp.setName("hej");
        assertEquals("hej", testBp.getName());
    }

    @Test
    @Order(3)
    void budgetCapIsMutable() {
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
        testBp.setBudgetCap(150.0);
        assertEquals(150.0, testBp.getBudgetCap());
    }

    @Test
    @Order(4)
    void currentBalanceIsMutable() {
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
        testBp.setCurrentBalance(90);
        assertEquals(90, testBp.getCurrentBalance());
    }

    @Test
    @Order(5)
    void getTransactionsReturnsCorrectInstance() {
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
        testBp.addTransaction(testTransaction);
        assertTrue(testBp.getTransactions().contains(testTransaction));
    }

    @Test
    @Order(6)
    void constructorOverloadingWorks() {
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
        testBp = new BudgetPost("test1");
        assertEquals("test1", testBp.getName());

        testBp = new BudgetPost(13, "test2");
        assertEquals(13, testBp.getBudgetCap());
        assertEquals("test2", testBp.getName());
    }
}
