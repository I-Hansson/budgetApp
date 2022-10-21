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

    protected Collection<IBudgetPost> newBudgetPosts = new ArrayList<>();
    protected Collection<ITransaction> newTransactions = new ArrayList<>();

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
}
