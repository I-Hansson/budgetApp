package org.chalmers.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classes that extend this class keep track of any new transactions
 * or budget post that were added during the last session
 * and is able to return them.
 *
 * @author williamfrisk
 */
public abstract class SaveableBudget implements IBudget{

    private Collection<IBudgetPost> newBudgetPosts = new ArrayList<>();
    private Collection<ITransaction> newTransactions = new ArrayList<>();

    /**
     * Returns all new budget post added by the user during the last session.
     * @return The new budget posts.
     */
    public Collection<IBudgetPost> getNewBudgetPosts(){
        return newBudgetPosts;
    }

    /**
     * Returns all new transactions added by the user during the last session.
     * @return
     */
    public Collection<ITransaction> getNewTransactions(){
        return newTransactions;
    }

    /**
     * Adds a ITransaction to the collection of new transactions.
     * @param transaction The transaction to be added.
     */
    protected void addNewTransaction(ITransaction transaction) {
        newTransactions.add(transaction);
    }

    /**
     * Adds a IBudgetPost to the collection of new budget posts.
     * @param budgetPost The budget post to be added.
     */
    protected void addNewBudgetPost(IBudgetPost budgetPost) {
        newBudgetPosts.add(budgetPost);
    }
}
