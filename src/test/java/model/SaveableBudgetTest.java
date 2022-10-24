package model;

import org.chalmers.model.*;

import java.util.GregorianCalendar;
import org.chalmers.model.Transaction;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SaveableBudgetTest {

    private SaveableBudget testBudget = new Budget(0, 0);

    @Test
    void newTransactionsCollectionIsMutable() {
        ITransaction tempTransaction = new Transaction(
                "",
                10,
                "",
                new GregorianCalendar());
        testBudget.addNewTransaction(tempTransaction);

        assertTrue(testBudget.getNewTransactions().contains(tempTransaction));
    }

    @Test
    void newBudgetPostsCollectionIsMutable() {
        IBudgetPost tempBudgetPost = new BudgetPost("test");
        testBudget.addNewBudgetPost(tempBudgetPost);

        assertTrue(testBudget.getNewBudgetPosts().contains(tempBudgetPost));
    }
}
