package org.chalmers.model;

import java.util.ArrayList;

public interface IBudgetPostsObserver {
    void update(ArrayList<Transaction> transactions);
}
