package org.chalmers.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class BudgetPost {


    //TODO give Icon attribute

    private double budgetCap; //The most you want to spend in a surtain budget-post.
    private double currentBalance;

    private BudgetPostID id;
    private List<IBudgetPostsObserver> observers = new ArrayList<IBudgetPostsObserver>();
    private List<Transaction> transactions = new ArrayList<>();

    BudgetPost(double budgetCap, String name, String color){
        this.id = new BudgetPostID(name, color, "0000001");
        //TODO TEMP
        this.budgetCap = budgetCap;
        this.currentBalance = 0;
        //TODO Implement icon logic here aswell.
    }
    /**
     * Update the name of this budget post.
     * @param newName the new name.
     */


    /**
     * Edits the budget cap for this post.
     * Make sure that this change doesn't surpass the users total balance.
     * @param newCap The new cap for this post.
     */
    public void setBudgetCap(double newCap){
        this.budgetCap = newCap;
    }

    public BudgetPostID getId() {
        return id;
    }

    /**
     * Add a transaction to the list of past transactions.
     * @param transaction Transaction to be added.
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        updateCurrentBalance();
    }
    private void updateCurrentBalance(){
        double temp = 0;
        for (Transaction t : this.transactions){
            temp += t.getAmount();
        }
        this.currentBalance = temp;
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

    public double getBudgetCap() {
        return budgetCap;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }



    public Collection<Transaction> getTransactions() {
        List<Transaction> transactionsCopy = new ArrayList<>();

       // Collections.copy(transactionsCopy, transactions);
        return transactions;
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
