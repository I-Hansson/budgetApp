package org.chalmers.model;

import java.util.ArrayList;
import java.util.Collections;

public class BudgetPost {

    private String name;
    //TODO give Icon attribute
    private String color;
    private double budgetCap; //The most you want to spend in a surtain budget-post.
    private double currentBalance;
    private ArrayList<IBudgetPostsObserver> observers = new ArrayList<IBudgetPostsObserver>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public BudgetPost(String name, double budgetCap,String  color){
        this.name = name;
        this.budgetCap = budgetCap;
        this.currentBalance = 0;
        this.color = color;
        //TODO Implement icon logic here aswell.
    }
    /**
     * Update the name of this budget post.
     * @param newName the new name.
     */
    public void setName(String newName){
        this.name = newName;
    }

    /**
     * Edits the budget cap for this post.
     * Make sure that this change doesn't surpass the users total balance.
     * @param newCap The new cap for this post.
     */
    public void setBudgetCap(double newCap){
        this.budgetCap = newCap;
    }

    /**
     * Edits the color for this post.
     * @param color The new color.
     */
    public void setColor(String color) {
         this.color = color;
    }

    /**
     * Add a transaction to the list of past transactions.
     * @param transaction Transaction to be added.
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * Adds a new IBudgetPostsObserver to the list of observers.
     * @param observer The observer to be added.
     */
    public void addObserver(IBudgetPostsObserver observer) {
        this.observers.add(observer);
    }

    /**
     * Returns RGB values for this budget post's color.
     * @return int[]{R, G, B}
     */

    public String getColor() {
        return this.color;
    }

    public double getBudgetCap() {
        return budgetCap;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Transaction> getTransactions() {
        ArrayList<Transaction> transactionsCopy = new ArrayList<>();
        Collections.copy(transactionsCopy, transactions);

        return transactionsCopy;
    }

    /**
     * Notify all observers to this budgetpost.
     * Also sends the list of transactions
     */
    private void notifyObservers(){
        ArrayList<Transaction> transactionsCopy = new ArrayList<>();
        Collections.copy(transactionsCopy, transactions); // Defensive copying

        for(IBudgetPostsObserver observer: observers){
            observer.update(transactionsCopy);
        }
    }


    public void setCurrentBalance(int x){
        this.currentBalance = x;
    }

}
