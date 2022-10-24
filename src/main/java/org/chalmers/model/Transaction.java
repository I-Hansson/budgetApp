package org.chalmers.model;

import java.util.Calendar;

/**
 * This class represents a transaction.
 * <p>
 * Uses: BudgetPostID
 * Used by: ModelFacade
 *
 * @author Isac Hansson
 */
public class Transaction implements ITransaction {
    private final Calendar dateOfTransaction;
    private final double amount;
    private BudgetPostID budgetPostID;
    private final String description;
    private final String name;

    public Transaction(String name, double amount, String description, Calendar dateOfTransaction){
        this.name = name;
        this.amount = amount;
        this.budgetPostID = Config.UNCATEGORIZED_BUDGET_POST_ID;
        this.dateOfTransaction = dateOfTransaction;
        this.description = description;
    }

    //Getters
    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public String getBudgetPostName(){
            return this.budgetPostID.getName();
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public String getBudgetPostColor(){
        return this.budgetPostID.getColor();
    }


    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Calendar getDate() {
        return this.dateOfTransaction;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public double getAmount(){
        return amount;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public String getDescription(){
        return description;
    }

    //Setters

    /**
     * Sets the BudgetPostID of the transaction.
     * @param budgetPostID The BudgetPostID
     */
    public void setBpID(BudgetPostID budgetPostID){
        this.budgetPostID = budgetPostID;
    }

    // Methods

    
}
