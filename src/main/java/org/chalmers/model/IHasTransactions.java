package org.chalmers.model;

import java.util.Collection;

/**
 * An interface for classes which contain a collection of transactions
 *
 * @author williamfrisk
 */
public interface IHasTransactions {
    /**
     * Adds an ITransaction to the collection of ITransaction.
     * @param transaction The ITransaction to be added.
     */
    void addTransaction(ITransaction transaction);

    /**
     * Returns a collection containing the instances of ITransaction.
     * @return The collection of ITransaction.
     */
    Collection<ITransaction> getTransactions();
}
