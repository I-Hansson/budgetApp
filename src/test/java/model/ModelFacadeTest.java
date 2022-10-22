package model;

import org.chalmers.model.ModelFacade;
import org.chalmers.model.User;
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

    //TODO Funkar inte som det ska
    @Test
    public void getCurrentBudgetCalendarReturnsCorrectInstance() {
        Calendar today = new GregorianCalendar();
        assertEquals(
                today.get(Calendar.MONTH) + 1,
                testFacade.getCurrentBudgetCalendar().get(Calendar.MONTH)
        );
    }

    @Test
    @Order(2)
    public void transactionsCollectionIsMutable() {
        testFacade.addTransaction(
                "",
                1,
                "Uncategorized",
                "",
                new GregorianCalendar());

        assertEquals(0, testFacade.getCurrentBudgetTransactions().size());
    }


    //TODO funkar inte som det ska
    @Test
    @Order(1)
    public void budgetPostsCollectionIsMutable() {
        testFacade.addBudgetPost(
                "Uncategorized",
                1,
                "");

        assertEquals(1, testFacade.getBudgetPosts().size());
    }

    //TODO Funkar inte som det ska
    @Test
    public void getCurrentBudgetBalanceReturnsCorrectDouble() {
        testFacade.addTransaction(
                "",
                1,
                "",
                "",
                new GregorianCalendar());

        assertEquals(0, testFacade.getCurrentBudgetBalance());
    }
}
