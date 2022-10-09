package org.chalmers.model;

import java.util.*;

/**
 * @author Isac Hansson ,
 * Budget depends on BudgetPost, Transaction, ITransactionAddedObserver, BudgetPostFactory, ITransactionAddedObserver
 */




public class Budget {

    private double startBalance;
    private double currentBalance;
    private int id;

    private List<BudgetPost> budgetPosts = new ArrayList<>();
    private List<Transaction> recentTransactions = new ArrayList<>();

    private int year;
    private int month;
    private Calendar calender;

    private final Collection<ITransactionAddedObserver> observers = new ArrayList<>();

    /**
     * Contructor of  the budget,
     * Instantiate four default budgetPosts through a BudgetPostFactory
     * Instantiate the date for the budget, i.e what month is this budget active.
     * @param year What year is this active.
     * @param month What month is this active.
     */
    public Budget(int year, int month){
        this.calender = new GregorianCalendar(year,month,1);
        this.year = calender.get(Calendar.YEAR);
        this.month = calender.get(Calendar.MONTH);

        this.budgetPosts.add(BudgetPostFactory.createBudgetPost("Matvaror",5000,"5, 51, 92"));
        this.budgetPosts.add(BudgetPostFactory.createBudgetPost("Transport",1000,"15, 87, 79"));
        this.budgetPosts.add(BudgetPostFactory.createBudgetPost("Resturang",800,"166, 212, 227"));
        this.budgetPosts.add(BudgetPostFactory.createBudgetPost("Kläder",800,"31, 120, 189"));

    }

    /**
     * Called to get a String representation of the month this buget is active in.
     * @return The string that is a month based on the number (0-11) that represents that month. 
     */
    public String getMonth(){
            String[] month =
                    {"Decemeber","January", "February", "Mars", "April", "May", "june", "July", "august", "September", "October", "November"};
            return  month[this.month];

    }
    public List<BudgetPost> getBudgetPosts() {
        return this.budgetPosts;
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
    public List<Transaction> getRecentTransactions(){
        return this.recentTransactions;
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

    public void addTransaction(Transaction transaction){
        this.recentTransactions.add(transaction);
        notifyObservers();
    }

    public void addObserver(ITransactionAddedObserver observer) {
        observers.add(observer);
    }

    /**
     * Add a NEW budget-post to the users budget planner.
     * @param name the name of the new post.
     * @param cap the maximum amount intended for this post.
     */
    /*public void addBudgetPost(String name, double cap){
        if(!budgetPosts.containsKey(name)){
            budgetPosts.put("test", new BudgetPost(name,cap));
        } else{
            //TODO Alert user that post already exists
            System.out.println("Post " + name + " already exists");
        }
    }*/

    private void notifyObservers(){
        for (ITransactionAddedObserver o : observers) {
            o.update(getRecentTransactions());
        }
    }
}
