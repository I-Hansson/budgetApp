package org.chalmers.model;

import java.util.*;

/**
 * This class represents the concept of a budget and stores all transactions
 * and budget posts in the budget. A budget spans a month.
 * <p>
 * Uses: IBudgetPost, ITransaction
 * Used by: User
 *
 * @author Isac Hansson
 */
public class Budget extends SaveableBudget implements IBudget{

    private double currentBalance;
    private double budgetCap;

    private final List<IBudgetPost> budgetPosts = new ArrayList<>();
    private final List<ITransaction> transactions = new ArrayList<>();
    private final Calendar calendar;


    /**
     * Instantiates the Budget class.
     *
     * @param year What year is this active.
     * @param month What month is this active.
     */
    public Budget(int year, int month) {
        this.calendar = new GregorianCalendar(year, month, 1);
        calculateCap();
    }

    //Getters

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public double getBudgetCap() {
        calculateCap();
        return budgetCap;
    }


    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Calendar getDate() {
        return calendar;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Collection<IBudgetPost> getBudgetPosts() {
        return this.budgetPosts;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public double getCurrentBalance() {
        updateCurrentBalance();
        return currentBalance;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Collection<ITransaction> getTransactions(){
        return this.transactions;
    }

    //Setters



    //Methods

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTransaction(ITransaction transaction){
        if (transactions.contains(transaction))
            addNewTransaction(transaction);
        addNewTransaction(transaction);
        this.transactions.add(transaction);
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public void addBudgetPost(IBudgetPost bp){
        if (budgetPosts.contains(bp))
            addNewBudgetPost(bp);
        addNewBudgetPost(bp);
        this.budgetPosts.add(bp);
    }

    private void updateCurrentBalance(){
        double temp = 0;
        for(ITransaction t : this.transactions){
            temp += t.getAmount();
        }
        this.currentBalance = temp;
    }

    private void calculateCap(){
        budgetCap = 0;
        for(IBudgetPost bp : this.budgetPosts){
            budgetCap += bp.getBudgetCap();
        }
    }
}
