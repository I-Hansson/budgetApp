package org.chalmers.model;

import org.chalmers.database.Database;
import org.chalmers.database.DatabaseSaver;

import java.util.*;

/**
 * This class is a facade for the entire model.
 * Its purpose is providing an interface for the client code and allow interaction with the model.
 * <p>
 * Uses: IBudgetPost, ITransaction, Transaction, BudgetPost, IBudget
 * Used by: View and Controller modules
 *
 * @author williamfrisk
 * @author Isac Hansson
 * @author Jonathan
 */
public final class ModelFacade {

    // TODO Får jag göra så här ?
    private static IBudgetPost selectedBudgetPost;
    private static final ModelFacade instance = new ModelFacade();
    private User user;
    private ModelFacade() {}

    //Getters

    /**
     * Returns the instance of the ModelFacade, implements a singleton pattern.
     * @return The instance of the ModelFacade.
     */
    public static ModelFacade getInstance() {
        return instance;
    }

    /**
     * Skitmetod som inte bör användas.
     * @return
     */
    public IBudgetPost getSelectedBudgetPost(){
        return selectedBudgetPost;
    }

    /**
     * Returns the currently, by the GUI, selected budget in the current user.
     * @return The current IBudget.
     */
    public IBudget getCurrentBudget() {
        return user.getCurrentBudget();
    }

    /**
     * Returns the currently selected budgets calendar object.
     * @return The calendar object.
     */
    public Calendar getCurrentBudgetCalendar() {
        return user.getCurrentBudget().getDate();
    }

    /**
     * Returns the collection of ITransaction belonging to the currently selected budget.
     * @return The collection of ITransaction.
     */
    public Collection<ITransaction> getCurrentBudgetTransactions(){
        return user.getCurrentBudget().getTransactions();
    }

    /**
     * Returns the collection of IBudgetPost belonging to the currently selected budget.
     * @return The collection of IBudgetPost.
     */
    public Collection<IBudgetPost> getBudgetPosts(){
        return user.getCurrentBudget().getBudgetPosts();
    }

    /**
     * Returns the user that is currently logged in and active.
     * @return The user.
     */
    public User getUser(){
        return user;
    }

    /**
     * Returns the balance of the currently selected budget.
     * @return The balance.
     */
    public double getCurrentBudgetBalance(){
        return user.getCurrentBudget().getCurrentBalance();
    }

    /**
     * Returns the budget cap (i.e. the max available money available for budgeting)
     * for the current user.
     * @return The budget cap.
     */
    public double getBudgetCap(){
        return user.getCurrentBudget().getBudgetCap();
    }

    //Setters

    /**
     * Sets the current user. Call when logging in.
     * @param user The User that is logged in.
     */
    public void setUser(User user){
        this.user = user;
    }

    /**
     * Skitmetod som inte bör användas.
     * @return
     */
    public void setSelectedBudgetPost(IBudgetPost budgetPost){
        selectedBudgetPost = budgetPost;
    }

    //Methods

    /**
     * Adds a Transaction to a budget post to the currently selected budget in the active user.
     *
     * @param name The name of the transaction.
     * @param amount The amount of the transaction.
     * @param budgetPostID The string of the budget post name/id.
     * @param description The description of the transaction.
     * @param date The date of the transaction.
     */
    public void addTransaction(String name, double amount, String budgetPostID, String description, Calendar date) throws IllegalArgumentException{

        for(IBudgetPost bp : user.getCurrentBudget().getBudgetPosts()){
            if (Objects.equals(bp.getName(), budgetPostID)){
                Transaction transaction = new Transaction(name,amount,description,date);
                transaction.setBpID(bp.getId());


                IBudget specificBudget = user.getSpecificbudget(
                        transaction.getDate().get(Calendar.YEAR),
                        transaction.getDate().get(Calendar.MONTH)
                );

                if(bp.getCurrentBalance() < transaction.getAmount())
                    throw new IllegalArgumentException();
                specificBudget.addTransaction(transaction);
                bp.addTransaction(transaction);
            }
        }
    }

    /**
     * Adds a BudgetPost to the currently selected budget in the active user.
     *
     * @param name The name of the budget post.
     * @param budgetCap The budget cap of the budget post.
     * @param color The color of the budget post (format: "R, G, B").
     */
    public void addBudgetPost(String name, double budgetCap, String color){
        user.getCurrentBudget().addBudgetPost(new BudgetPost(budgetCap, name, color));
    }

    /**
     * Save the user in the database.
     * @throws InterruptedException Throws if program is interrupted during save.
     */
    public void saveUser() throws InterruptedException {
        DatabaseSaver.saveUserToDatabase(user);
    }

    /**
     * Creates a new user in the database.
     *
     * @param name The name of the user.
     * @param id The ID of the user.
     * @param password The password of the user.
     */
    public void createNewUser(String name, String id,String password){
        Database.createUserDoc(name, id, password);
    }

}

