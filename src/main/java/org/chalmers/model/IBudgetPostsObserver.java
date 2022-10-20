package org.chalmers.model;

import java.util.Collection;

/**
 * An interface for classes observing BudgetPost
 *
 * @author williamfrisk
 */
public interface IBudgetPostsObserver {
    /**
     * Updates the observer with a collection of transactions.
     * @param transactions The collection of transactions.
     */
    void update(Collection<ITransaction> transactions);
}
