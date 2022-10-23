package model;

import org.chalmers.model.*;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveableBudgetTest {

    private SaveableBudget testBudget = new Budget(0, 0);

    @Test
    public void newTransactionsCollectionIsMutable() {
        ITransaction tempTransaction = new Transaction(
                "",
                10,
                "",
                new GregorianCalendar());
        testBudget.addNewTransaction(tempTransaction);

        assertTrue(testBudget.getNewTransactions().contains(tempTransaction));
    }

    @Test
    public void newBudgetPostsCollectionIsMutable() {
        IBudgetPost tempBudgetPost = new BudgetPost("test");
        testBudget.addNewBudgetPost(tempBudgetPost);

        assertTrue(testBudget.getNewBudgetPosts().contains(tempBudgetPost));
    }
}
