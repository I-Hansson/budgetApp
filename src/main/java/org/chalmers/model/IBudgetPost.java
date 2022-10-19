package org.chalmers.model;

public interface IBudgetPost extends IHasTransactions{

    void setBudgetCap(double newCap);
    double getBudgetCap();
    void setCurrentBalance(double newBalance);
    double getCurrentBalance();
    String getColor();
    String getName();
    BudgetPostID getId();
}
