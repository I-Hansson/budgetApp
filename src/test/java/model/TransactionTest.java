package model;

import org.chalmers.model.BudgetPostID;
import org.chalmers.model.Transaction;

import org.junit.Before;
import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
 class TransactionTest {

    Calendar today = new GregorianCalendar();
    Transaction testTransaction = new Transaction(
                "Test",
                        100,
                        " ",
                today
                );
    BudgetPostID bpId = new BudgetPostID("test2", "0, 0, 0");

    @Before
    public void init() {

    }

    @Test
    @Order(1)
    void getBudgetPostNameReturnsCorrectString(){
        assertEquals("Uncategorized", testTransaction.getBudgetPostName());
    }

    @Test
    @Order(2)
    void getBudgetPostColorReturnsCorrectString() {
        assertEquals("0,0,0", testTransaction.getBudgetPostColor());
    }

    @Test
    @Order(3)
    void getNameReturnsCorrectString() {
        assertEquals("Test", testTransaction.getName());
    }

    @Test
    @Order(4)
    void getDateReturnsCorrectInstance() {
        assertEquals(today, testTransaction.getDate());
    }

    @Test
    @Order(5)
    void getAmountReturnsCorrectDouble() {
        assertEquals(100, testTransaction.getAmount());
    }

    @Test
    @Order(6)
    void getDescriptionReturnsCorrectString() {
        assertEquals(" ", testTransaction.getDescription());
    }

    @Test
    @Order(7)
    void budgetPostIdIsMutable() {
        testTransaction.setBpID(bpId);
        assertEquals("test2", testTransaction.getBudgetPostName());
    }
}
