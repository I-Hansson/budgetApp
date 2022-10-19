package org.chalmers.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a budget post.
 * Depends on Transaction, BudgetPostID, IBudgetPostsObserver
 *
 * @author Isac Hansson
 */
public class BudgetPost implements IBudgetPost{
    //TODO give Icon attribute

    private double budgetCap; //The most you want to spend in a surtain budget-post.
    private double currentBalance;

    private BudgetPostID id;
    private final List<IBudgetPostsObserver> observers = new ArrayList<IBudgetPostsObserver>();
    private final List<ITransaction> transactions = new ArrayList<>();

    public BudgetPost(double budgetCap, String name, String color){
        this.id = new BudgetPostID(name, color);
        this.budgetCap = budgetCap;
        this.currentBalance = budgetCap;
        //TODO Implement icon logic here aswell.
    }

    public BudgetPost(String name) {
        this.id = new BudgetPostID(name, "5, 51, 92");
        this.budgetCap = 0;
        this.currentBalance = budgetCap;
    }

    BudgetPost(double budgetCap, String name) {
        this.id = new BudgetPostID(name, "5, 51, 92");
        this.budgetCap = budgetCap;
        this.currentBalance = budgetCap;
    }


    //Setters
    /**
     * {@inheritDoc}
     */
    @Override
    public void setBudgetCap(double newCap){
        this.budgetCap = newCap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrentBalance(double x){
        this.currentBalance = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTransaction(ITransaction transaction) {
        transactions.add(transaction);
        updateCurrentBalance();
    }

    /**
     * Adds a new IBudgetPostsObserver to the list of observers.
     * @param observer The observer to be added.
     */
    public void addObserver(IBudgetPostsObserver observer) {
        this.observers.add(observer);
    }

    //Getters
    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public BudgetPostID getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public String getName() {
        return id.getName();
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public String getColor() {
        return id.getColor();
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public double getBudgetCap() {
        return budgetCap;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public double getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Returns a copy of the list of transactions in the BudgetPost
     * @return {@inheritDoc}
     */
    @Override
    public Collection<ITransaction> getTransactions() {
        List<ITransaction> transactionsCopy = new ArrayList<>(transactions.size()+1);
        transactionsCopy.addAll(transactions);

        return transactionsCopy;
    }

    private void notifyObservers(){
        ArrayList<ITransaction> transactionsCopy = new ArrayList<>();
        Collections.copy(transactionsCopy, transactions); // Defensive copying

        for(IBudgetPostsObserver observer: observers){
            observer.update(transactionsCopy);
        }
    }

    private void updateCurrentBalance(){
        double temp = 0;
        for (ITransaction t : this.transactions){
            temp += t.getAmount();
        }
        this.currentBalance = temp;
    }
}
