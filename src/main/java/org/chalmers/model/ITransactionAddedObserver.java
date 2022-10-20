package org.chalmers.model;

import java.util.Collection;

/**
 * Interchangeable with IBudgetPostsObserver
 */
public interface ITransactionAddedObserver {
    void update(Collection<ITransaction> transactions);
}
