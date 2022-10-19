package org.chalmers.model;

import java.util.List;

public interface IBudget extends IHasTransactions, IHasDate, IHasBalance, IHasBudgetCap, IHasBudgetPosts{
    //TODO Dessa metoder är ytterst jävla tillfälliga
    List<ITransaction> getNewTransactions();

    List<IBudgetPost> getNewBudgetPosts();
}
