package org.chalmers.model;

import java.util.Collection;

public interface IHasBudgetPosts {
    void addBudgetPost(IBudgetPost bp);
    Collection<IBudgetPost> getBudgetPosts();
}
