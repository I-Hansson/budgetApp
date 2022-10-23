package org.chalmers.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class represents a transaction.
 *
 * Depends on BudgetPostID
 *
 * @author Isac Hansson
 */
public class Transaction implements ITransaction {
    private Calendar dateOfTransaction;
    private double amount;
    private BudgetPostID budgetPostID;
    private String description;
    private String name;

    public Transaction(String name, double amount, String description, Calendar dateOfTransaction){
        this.name = name;
        this.amount = amount;
        this.budgetPostID = Config.uncategorizedBudgetPostID;
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

    public void setBpID(BudgetPostID budgetPostID){
        this.budgetPostID = budgetPostID;
    }

    // Methods

    
}
