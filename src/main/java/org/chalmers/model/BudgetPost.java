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
public class BudgetPost {
    //TODO give Icon attribute

    private double budgetCap; //The most you want to spend in a surtain budget-post.
    private double currentBalance;

    private BudgetPostID id;
    private final List<IBudgetPostsObserver> observers = new ArrayList<IBudgetPostsObserver>();
    private final List<Transaction> transactions = new ArrayList<>();

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
     * Edits the budget cap for this post.
     * Make sure that this change doesn't surpass the users total balance.
     * @param newCap The new cap for this post.
     */
    public void setBudgetCap(double newCap){
        this.budgetCap = newCap;
    }

    public void setCurrentBalance(double x){
        this.currentBalance = x;
    }

    /**
     * Add a transaction to the list of past transactions.
     * @param transaction Transaction to be added.
     */
    public void addTransaction(Transaction transaction) {
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
    public BudgetPostID getId() {
        return id;
    }

    public String getName() {
        return id.getName();
    }

    public String getColor() {
        return id.getColor();
    }

    public double getBudgetCap() {
        return budgetCap;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Returns a copy of the list of transactions in the BudgetPost
     * @return The list of transactions
     */
    public Collection<Transaction> getTransactions() {
        List<Transaction> transactionsCopy = new ArrayList<>(transactions.size()+1);
        transactionsCopy.addAll(transactions);

        return transactionsCopy;
    }

    private void notifyObservers(){
        ArrayList<Transaction> transactionsCopy = new ArrayList<>();
        Collections.copy(transactionsCopy, transactions); // Defensive copying

        for(IBudgetPostsObserver observer: observers){
            observer.update(transactionsCopy);
        }
    }

    private void updateCurrentBalance(){
        double temp = 0;
        for (Transaction t : this.transactions){
            temp += t.getAmount();
        }
        this.currentBalance = temp;
    }
}
