package org.chalmers.model;

public interface ITransaction extends IHasDate{

    int getAmount();
    String getName();
    String getDescription();
}
