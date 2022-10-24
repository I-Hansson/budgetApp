package model;
import org.chalmers.model.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ModelFacadeTest {
    //saveUser() and createNewUser() are untestable with our skills in testing.

    ModelFacade testFacade = ModelFacade.getInstance();
    User testUser = new User(1);
    IBudget testBudget = new Budget(2022, 9);
    IBudgetPost testBp = new BudgetPost("test");



    @Test
    void getCurrentBudgetReturnsCorrectInstance() {
        testFacade.setUser(testUser);
        assertEquals(
                testFacade.getUser().getCurrentBudget(),
                testFacade.getCurrentBudget()
                );
    }

    @Test
    void getCurrentBudgetCalendarReturnsCorrectInstance() {
        testFacade.setUser(testUser);
        Calendar today = new GregorianCalendar();
        assertEquals(
                today.get(Calendar.MONTH),
                testFacade.getCurrentBudgetCalendar().get(Calendar.MONTH)
        );
    }

    @Test
    @Order(2)
    void transactionsCollectionIsMutable() {
        testFacade.setUser(testUser);
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
    void budgetPostsCollectionIsMutable() {
        testFacade.setUser(testUser);

        testFacade.addBudgetPost(
                "Uncategorized",
                1,
                "");

        assertEquals(1, testFacade.getBudgetPosts().size());
    }

    @Test
    void getCurrentBudgetBalanceReturnsCorrectDouble() {
        testFacade.setUser(testUser);
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
    void selectedBudgetPostIsMutable() {
        testFacade.setUser(testUser);
        testFacade.setSelectedBudgetPost(testBp);
        assertEquals(testBp, testFacade.getSelectedBudgetPost());
    }

    @Test
    void getBudgetCapReturnsCorrectDouble() {
        testFacade.setUser(testUser);
        testFacade.addBudgetPost("", 100, "");
        assertEquals(100, testFacade.getBudgetCap());
    }
}
