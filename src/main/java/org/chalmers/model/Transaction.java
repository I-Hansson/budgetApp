package org.chalmers.model;

import javafx.scene.paint.Color;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Transaction {
    private Calendar dateOfTransaction;
    private double amount;
    private String budgetPostName;
    private String description;


    public Transaction(double amount, String budgetPostName, String description){
        this.dateOfTransaction = new GregorianCalendar();
        this.amount = amount;
        this.budgetPostName = budgetPostName;
        this.description = description;
        //TODO if budgetPostName doesn't exist create it or throw error?
        //TODO if amount surpasses budget-post's cap alert user and add it to post.
    }

    //Getters
    public Calendar getDateOfTransaction() {
        return this.dateOfTransaction;
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
