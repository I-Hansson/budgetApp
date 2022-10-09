package org.chalmers.model;

import java.util.Collection;

public interface ITransactionAddedObserver {
    void update(Collection<Transaction> transactions);
}
