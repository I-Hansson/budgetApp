package org.chalmers.model;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Transaction {
    private Calendar dateOfTransaction;
    private double amount;
    private BudgetPostID budgetPostID;
    private String description;
    private String name;

    public Transaction(String name, double amount, BudgetPostID budgetPostID, String description){
        this.dateOfTransaction = new GregorianCalendar();
        this.name = name;
        this.amount = amount;
        this.budgetPostID = budgetPostID;
        this.description = description;
    }

    //Getters
    public String getBudgetPostName(){
        return this.budgetPostID.getName();
    }
    public String getBudgetPostColor(){
        return this.budgetPostID.getColor();
    }
    public String getBudgetPostID(){
        return this.budgetPostID.getId();
    }

    public String getName() {
        return name;
    }
    public String getTransactionDate(){

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(this.dateOfTransaction.getTime());
    }
    public String getDayOfWeeks(){
        String[] days =
                {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int day = this.getDateOfTransaction().get(Calendar.DAY_OF_WEEK);
        System.out.println(day);
        return  days[day];
    }

    public Calendar getDateOfTransaction() {
        return this.dateOfTransaction;
    }
    public double getAmount(){
        return amount;
    }

    public String getDescription(){
        return description;
    }

    public int getDayOfWeek() {
        return dateOfTransaction.get(Calendar.DAY_OF_WEEK);
    }
    public int getDayOfMonth() {
        return dateOfTransaction.get(Calendar.DAY_OF_MONTH);
    }
    public int getDayOfYear() {
        return dateOfTransaction.get(Calendar.DAY_OF_YEAR);
    }

    // Methods

    
}
