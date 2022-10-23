package model;

import org.chalmers.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModelFacadeTest {

    ModelFacade testFacade = ModelFacade.getInstance();
    User testUser = new User(1);
    IBudget testBudget = new Budget(2022, 9);
    IBudgetPost testBp = new BudgetPost("test");

    @Before
    public void init() {
        testFacade.setUser(testUser);
    }

    @Test
    public void getCurrentBudgetReturnsCorrectInstance() {
        assertEquals(
                testFacade.getUser().getCurrentBudget(),
                testFacade.getCurrentBudget()
                );
    }

    @Test
    public void getCurrentBudgetCalendarReturnsCorrectInstance() {
        Calendar today = new GregorianCalendar();
        assertEquals(
                today.get(Calendar.MONTH),
                testFacade.getCurrentBudgetCalendar().get(Calendar.MONTH)
        );
    }

    @Test
    @Order(2)
    public void transactionsCollectionIsMutable() {
        testFacade.getUser().getBudgets().add(testBudget);
        testFacade.getUser().setCurrentBudget(testBudget);
        testFacade.addBudgetPost(
                "Uncategorized",
                1,
                "");
        testFacade.addTransaction(
                "",
                1,
                "Uncategorized",
                "",
                new GregorianCalendar());

        assertEquals(1, testFacade.getCurrentBudgetTransactions().size());
    }

    @Test
    @Order(1)
    public void budgetPostsCollectionIsMutable() {

        testFacade.addBudgetPost(
                "Uncategorized",
                1,
                "");

        assertEquals(1, testFacade.getBudgetPosts().size());
    }

    @Test
    public void getCurrentBudgetBalanceReturnsCorrectDouble() {
        testFacade.getUser().getBudgets().add(testBudget);
        testFacade.getUser().setCurrentBudget(testBudget);
        testFacade.addBudgetPost(
                "Uncategorized",
                1,
                "");
        testFacade.addTransaction(
                "",
                1,
                "Uncategorized",
                "",
                new GregorianCalendar());

        assertEquals(1, testFacade.getCurrentBudgetBalance());
    }

    @Test
    public void selectedBudgetPostIsMutable() {
        testFacade.setSelectedBudgetPost(testBp);
        assertEquals(testBp, testFacade.getSelectedBudgetPost());
    }

    @Test
    public void getBudgetCapReturnsCorrectDouble() {
        testFacade.addBudgetPost("", 100, "");
        assertEquals(100, testFacade.getBudgetCap());
    }
}
