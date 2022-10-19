package org.chalmers.model;

public interface IBudgetPost extends IHasTransactions, IHasBalance, IHasBudgetCap{
    String getColor();
    String getName();
    BudgetPostID getId();
}
