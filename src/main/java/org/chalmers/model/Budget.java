package org.chalmers.model;

import java.time.Year;
import java.util.*;

public class Budget {

    private double startBalance;
    private double currentBalance;
    private int id;
    private Map<String, BudgetPost> budgetPosts = new HashMap<>();
    private ArrayList<Transaction> recentTransactions = new ArrayList<>();
    private int year;
    private int month;
    private Calendar calender = new GregorianCalendar();
    public Budget(){
        this.year = calender.get(Calendar.YEAR);
        this.month = calender.get(Calendar.MONTH);

    }

    public double getCurrentBalance() {
        return currentBalance;
    }
    public double getStartBalance(){
        return currentBalance;
    }
    public int getId(){
        return id;
    }
    public ArrayList getRecentTransactions(){
        return recentTransactions;
    }

    /**
     * Sets the new start balance for each month.
     * @param newStartBalance the new starting value for each month.
     */
    public void setStartBalance(double newStartBalance){
        startBalance = newStartBalance;
    }

    /**
     * Update the current balance.
     * @param change the amount that changes, if expense use negative values.
     */
    public void updateBalance(double change){
        currentBalance += change;
    }

    /**
     * Add a NEW budget-post to the users budget planner.
     * @param name the name of the new post.
     * @param cap the maximum amount intended for this post.
     */
    public void addBudgetPost(String name, double cap){
        if(!budgetPosts.containsKey(name)){
            budgetPosts.put("test", new BudgetPost(name,cap));
        } else{
            //TODO Alert user that post already exists
            System.out.println("Post " + name + " already exists");
        }
    }
}
