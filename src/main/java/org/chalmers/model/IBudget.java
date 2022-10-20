package org.chalmers.model;

import java.util.List;

/**
 * An interface for classes that represent the concept of a budget
 *
 * @author williamfrisk
 */
public interface IBudget extends IHasTransactions, IHasDate, IHasBalance, IHasBudgetCap, IHasBudgetPosts{
    //TODO Dessa metoder är ytterst jävla tillfälliga
    List<ITransaction> getNewTransactions();

    List<IBudgetPost> getNewBudgetPosts();
}
