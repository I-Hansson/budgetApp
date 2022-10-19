package org.chalmers.model;

import java.util.Collection;

public interface IHasTransactions {
    void addTransaction(ITransaction transaction);
    Collection<ITransaction> getTransactions();
}
