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
    private String dateString;
    private  String BudgetPostName;

    public Transaction(String name, double amount, BudgetPostID budgetPostID, String description){
        this.dateOfTransaction = new GregorianCalendar();
        this.name = name;
        this.amount = amount;
        this.budgetPostID = budgetPostID;
        this.description = description;
    }

    public Transaction(String name, double amount, String description, String date,String budgetPostName){
        this.dateOfTransaction = new GregorianCalendar();
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.dateString = date;
        this.BudgetPostName = budgetPostName;
    }
    public void setBpID(BudgetPostID budgetPostID){
        this.budgetPostID = budgetPostID;
    }
    //Getters

    public String getBudgetPostName(){
        try{
            return this.budgetPostID.getName();
        }catch(NullPointerException e){
            return this.BudgetPostName;
        }
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
                {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",};
        int day = this.getDateOfTransaction().get(Calendar.DAY_OF_WEEK);
        System.out.println(day);
        return  days[day-1];
    }
    public String getDateString(){
        return dateString;
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
