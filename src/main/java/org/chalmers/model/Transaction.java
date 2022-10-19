package org.chalmers.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class represents a transaction.
 *
 * Depends on BudgetPostID
 *
 * @author Isac Hansson
 */
class Transaction implements ITransaction {
    private Calendar dateOfTransaction;
    private double amount;
    private BudgetPostID budgetPostID;
    private String description;
    private String name;

    public Transaction(String name, double amount, String description, Calendar dateOfTransaction){
        this.name = name;
        this.amount = amount;
        this.budgetPostID = Config.uncategorizedBudgetPostID;
        this.dateOfTransaction = dateOfTransaction;
        this.description = description;
    }


    public void setBpID(BudgetPostID budgetPostID){
        System.out.println(this.getDate());
        this.budgetPostID = budgetPostID;
    }

    //Getters
    public String getBudgetPostName(){
            return this.budgetPostID.getName();
    }
    public String getBudgetPostColor(){
        return this.budgetPostID.getColor();
    }


    public String getName() {
        return name;
    }

    public String getDayOfWeekAsString(){
        String[] days =
                {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",};
        int day = this.getDate().get(Calendar.DAY_OF_WEEK);
        System.out.println(day);
        return days[day-1];
    }

    @Override
    public Calendar getDate() {
        return this.dateOfTransaction;
    }
    @Override
    public double getAmount(){
        return amount;
    }

    @Override
    public String getDescription(){
        return description;
    }


    // Methods

    
}
