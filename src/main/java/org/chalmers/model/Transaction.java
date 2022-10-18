package org.chalmers.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This class represents a transaction.
 *
 * Depends on BudgetPostID
 *
 * @author Isac Hansson
 */
public class Transaction {
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
        System.out.println(this.getDateOfTransaction());
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
