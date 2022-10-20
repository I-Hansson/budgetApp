package org.chalmers.model;

import java.util.*;

/**
 * @author Isac Hansson ,
 * Depends on BudgetPost, Transaction, ITransactionAddedObserver, BudgetPostFactory, ITransactionAddedObserver
 */
public class Budget implements IBudget{

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
        calculateCap();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBudgetCap(double newCap) {
        budgetCap = newCap;
    }

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
     * Returns a list of all ITransactions in this budget which were added during the last session.
     * @return The list of ITransactions.
     */
    @Override
    public List<ITransaction> getNewTransactions() {
        return newTransactions;
    }

    /**
     * Returns a list of all IBudgetPost in this budget which were added during the last session.
     * @return The list of IBudgetPost.
     */
    @Override
    public List<IBudgetPost> getNewBudgetPosts(){
        return newBudgetPosts;
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
     * @param newBalance {@inheritDoc}
     */
    @Override
    public void setCurrentBalance(double newBalance) {
        currentBalance = newBalance;
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
    public void addTransaction(ITransaction transaction){
        this.transactions.add(transaction);
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
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

    private void calculateCap(){
        double temp = 0;
        for(IBudgetPost bp : this.budgetPosts){
            temp += bp.getBudgetCap();

        }
        this.setBudgetCap(temp);

    }

    public void updateCurrentBalance(){
        double temp = 0;
        for(ITransaction t : this.transactions){
            temp += t.getAmount();
        }
        this.currentBalance = temp;


    }
}
