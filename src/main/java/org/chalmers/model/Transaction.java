package org.chalmers.model;

import java.util.Date;

public class Transaction {
    private Date dateOfTransaction;
    private double amount;
    private String budgetPostName;
    private String description;


    public Transaction(double amount, String budgetPostName, String description){
        this.dateOfTransaction = new Date(System.currentTimeMillis());
        this.amount = amount;
        this.budgetPostName = budgetPostName;
        this.description = description;
        //TODO if budgetPostName doesn't exist create it or throw error?
        //TODO if amount surpasses budget-post's cap alert user and add it to post.
    }

    //Getters
    public Date getDateOfTransaction() {
        return new Date(dateOfTransaction.getTime());
    }
    public double getAmount(){
        return amount;
    }
    public String getBudgetPostName(){
        return budgetPostName;
    }
    public String getDescription(){
        return description;
    }

    // Methods

    
}
