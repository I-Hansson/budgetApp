package org.chalmers.model;

import java.util.*;

/**
 * @author Isac Hansson ,
 * Depends on BudgetPost, Transaction, ITransactionAddedObserver, BudgetPostFactory, ITransactionAddedObserver
 */
public class Budget {

    private double startBalance;
    private double currentBalance;
    private double cap;
    private int id;

    private List<IBudgetPost> budgetPosts = new ArrayList<>();
    private List<IBudgetPost> newBudgetPosts = new ArrayList<>();
    private List<ITransaction> transactions = new ArrayList<>();
    private List<ITransaction> newTransactions = new ArrayList<>();
    private int year;
    private int month;
    private Calendar calender;


    private final Collection<ITransactionAddedObserver> observers = new ArrayList<>();

    public void setTransactions(List<ITransaction> transactions) {
        this.transactions = transactions;
    }

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
        this.cap = calculateCap();
    }
    private double calculateCap(){
        double temp = 0;
        for(IBudgetPost bp : this.budgetPosts){
            temp += bp.getBudgetCap();

        }
        return temp;

    }

    public String getYear() {
        return String.valueOf(this.year);
    }

    /**
     * Called to get a String representation of the month this buget is active in.
     * @return The string that is a month based on the number (0-11) that represents that month. 
     */
    public String getMonthNumber(){
        if(this.month ==0){
            return "12";
        }
        if (this.month< 10){
            return "0"+String.valueOf(this.month);
        }
        return String.valueOf(this.month);

    }

    /**
     * Returns a list of all transactions in this budget.
     * @return The list of transactions
     */
    public List<ITransaction> getNewTransactions() {
        return newTransactions;
    }

    public List<IBudgetPost> getNewBudgetPosts(){
        return newBudgetPosts;
    }

    public String getMonth(){
            String[] month =
                    {"January", "February", "Mars", "April", "May", "june", "July", "August", "September",
                            "October", "November", "December"};
            return month[this.month];

    }
    public List<IBudgetPost> getBudgetPosts() {
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
    public List<ITransaction> getTransactions(){
        return this.transactions;
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

    public void addTransaction(ITransaction transaction){
        this.transactions.add(transaction);
    }
    public void addBudgetPost(IBudgetPost bp){
        this.budgetPosts.add(bp);
    }


    public void addObserver(ITransactionAddedObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(){
        for (ITransactionAddedObserver o : observers) {
            o.update(getTransactions());
        }
    }
}
