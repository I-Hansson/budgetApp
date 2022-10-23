package org.chalmers.model;

import java.util.*;

/**
 * @author Isac Hansson ,
 * Depends on BudgetPost, Transaction, ITransactionAddedObserver, BudgetPostFactory, ITransactionAddedObserver
 */
public class Budget extends SaveableBudget implements IBudget{

    private double startBalance;
    private double currentBalance;
    private double budgetCap;

    private List<IBudgetPost> budgetPosts = new ArrayList<>();
    private List<ITransaction> transactions = new ArrayList<>();
    private final Calendar calendar;

    public void setTransactions(List<ITransaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Contructor of  the budget,
     * Instantiate four default budgetPosts through a BudgetPostFactory
     * Instantiate the date for the budget, i.e. what month is this budget active.
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

    /**
     * {@inheritDoc}
     * @param newBalance {@inheritDoc}
     */
    @Override
    public void setCurrentBalance(double newBalance) {
        currentBalance = newBalance;
    }

    /**
     * Sets the new start balance for each month.
     * @param newStartBalance the new starting value for each month.
     */
    public void setStartBalance(double newStartBalance){
        startBalance = newStartBalance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBudgetCap(double newCap) {
        budgetCap = newCap;
    }

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
        double temp = 0;
        for(IBudgetPost bp : this.budgetPosts){
            temp += bp.getBudgetCap();

        }
        this.setBudgetCap(temp);

    }
}
