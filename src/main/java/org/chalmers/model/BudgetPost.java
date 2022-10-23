package org.chalmers.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a budget post.
 * Depends on Transaction, BudgetPostID, IBudgetPostsObserver
 *
 * @author Isac Hansson, Jonathan Svantesson
 */
public class BudgetPost implements IBudgetPost{
    //TODO give Icon attribute

    private double budgetCap; //The most you want to spend in a surtain budget-post.
    private double currentBalance;
    private BudgetPostID id;
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

    public BudgetPost(double budgetCap, String name) {
        this.id = new BudgetPostID(name, "5, 51, 92");
        this.budgetCap = budgetCap;
        this.currentBalance = budgetCap;
    }


    //Setters
    /**
     * {@inheritDoc}
     */
<<<<<<< HEAD
=======
    @Override
>>>>>>> a7010380edd3ffdfba28cda82d7d8aceffc7a72e
    public void setBudgetCap(double newCap){
        this.budgetCap = newCap;
    }

    /**
     * {@inheritDoc}
     */

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
        return getId().getName();
    }

    /**
     * @param newName The new name for the budget post.
     */
    @Override
    public void setName (String newName ) {getId().setName(newName);}



    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public String getColor() {
        return getId().getColor();
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

    private void updateCurrentBalance(){
        for (ITransaction t : this.transactions){
            this.currentBalance -= t.getAmount();
        }
    }
}
