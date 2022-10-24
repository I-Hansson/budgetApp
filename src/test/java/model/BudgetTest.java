package model;

import org.chalmers.model.Budget;
import org.chalmers.model.BudgetPost;
import org.chalmers.model.Transaction;


import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class BudgetTest {

    Budget testBudget;
    BudgetPost testBp;
    Transaction testTransaction;



    @Test
    @Order(1)
    void getDateReturnsCorrectInstance() {
        testBudget = new Budget(2022, 10);
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
        Calendar now = new GregorianCalendar();
        assertTrue(testBudget.getDate().after(now));
    }


    @Test
    @Order(2)
    void transactionsListIsMutable() {
        testBudget = new Budget(2022, 10);
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
        testBudget.addTransaction(testTransaction);
        assertTrue(testBudget.getTransactions().contains(testTransaction));
    }

    @Test
    @Order(4)
    void getBudgetCapReturnsCorrectDouble() {
        testBudget = new Budget(2022, 10);
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
             testBudget.addBudgetPost(testBp);
            assertEquals(100, testBudget.getBudgetCap());
    }
    @Test
    @Order(3)
    void budgetPostListIsMutable() {
        testBudget = new Budget(2022, 10);
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
        testBudget.addBudgetPost(testBp);
        assertTrue(testBudget.getBudgetPosts().contains(testBp));
    }
    @Test
    @Order(5)
    void getCurrentBalanceReturnsCurrentBalance() {
        testBudget = new Budget(2022, 10);
        testBp = new BudgetPost(100, "test", "0, 0, 0");
        testTransaction = new Transaction("test", 10, "", new GregorianCalendar());
        testBudget.addTransaction(testTransaction);
        assertEquals(10,testBudget.getCurrentBalance());

    }


}
