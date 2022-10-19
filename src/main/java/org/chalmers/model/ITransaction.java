package org.chalmers.model;

public interface ITransaction extends IHasDate{

    double getAmount();
    String getName();
    String getDescription();
    String getBudgetPostName();
    String getBudgetPostColor();
}
