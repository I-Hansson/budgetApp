package org.chalmers.model;

import java.util.*;

/**
 * @author Isac Hansson ,
 * Depends on BudgetPost, Transaction, ITransactionAddedObserver, BudgetPostFactory, ITransactionAddedObserver
 */
class Budget implements IBudget{

    private double startBalance;
    private double currentBalance;
    private double budgetCap;

    private List<IBudgetPost> budgetPosts = new ArrayList<>();
    private List<IBudgetPost> newBudgetPosts = new ArrayList<>();
    private List<ITransaction> transactions = new ArrayList<>();
    private List<ITransaction> newTransactions = new ArrayList<>();
    private final Calendar calendar;


    private final Collection<ITransactionAddedObserver> observers = new ArrayList<>();

    public void setTransactions(List<ITransaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Contructor of  the budget,
     * Instantiate four default budgetPosts through a BudgetPostFactory
     * Instantiate the date for the budget, i.e what month is this budget active.
     * @param year What year is this active.
     * @param month What month is this active.
     */
    public Budget(int year, int month) {
        this.calendar = new GregorianCalendar(year, month, 1);
        this.budgetCap = calculateCap();
    }

    @Override
    public void setBudgetCap(double newCap) {
        budgetCap = newCap;
    }

    @Override
    public double getBudgetCap() {
        return budgetCap;
    }

    @Override
    public Calendar getDate() {
        return calendar;
    }

    /**
     * Returns a list of all transactions in this budget.
     * @return The list of transactions
     */
    public List<ITransaction> getNewTransactions() {
        return newTransactions;
    }

    public List<IBudgetPost> getNewBudgetPosts(){
        return newBudgetPosts;
    }
    public Collection<IBudgetPost> getBudgetPosts() {
        return this.budgetPosts;
    }

    /**
     * Update the current balance.
     * @param newBalance the new balance.
     */
    @Override
    public void setCurrentBalance(double newBalance) {
        currentBalance = newBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
    public Collection<ITransaction> getTransactions(){
        return this.transactions;
    }

    /**
     * Sets the new start balance for each month.
     * @param newStartBalance the new starting value for each month.
     */
    public void setStartBalance(double newStartBalance){
        startBalance = newStartBalance;
    }

    /**
     * Update the current balance.
     * @param change the amount that changes, if expense use negative values.
     */

    public void addTransaction(ITransaction transaction){
        this.transactions.add(transaction);
    }
    public void addBudgetPost(IBudgetPost bp){
        this.budgetPosts.add(bp);
    }


    public void addObserver(ITransactionAddedObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(){
        for (ITransactionAddedObserver o : observers) {
            o.update(getTransactions());
        }
    }

    private double calculateCap(){
        double temp = 0;
        for(IBudgetPost bp : this.budgetPosts){
            temp += bp.getBudgetCap();

        }
        return temp;

    }
}
