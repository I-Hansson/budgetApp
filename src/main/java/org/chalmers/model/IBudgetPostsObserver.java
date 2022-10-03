package org.chalmers.model;

import java.util.ArrayList;
import java.util.Collection;

public interface IBudgetPostsObserver {
    void update(Collection<Transaction> transactions);
}
