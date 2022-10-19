package org.chalmers.model;

import org.chalmers.model.database.DatabaseLoader;
import org.chalmers.model.database.DatabaseSaver;
import org.chalmers.model.database.TransactionsDB;
import org.chalmers.model.database.UsersDB;

import java.util.*;

/**
 * This class is a facade for the entire model.
 * Its purpose is providing an interface for the client code and allow interaction with the model.
 *
 * Depends on everything :))))
 *
 * @author williamfrisk
 * @author Isac Hansson
 * @author Jonathan
 */
public class ModelFacade {

    // TODO Får jag göra så här ?
    private static SelectedBudgetPost selectedBudgetPost = new SelectedBudgetPost(null);

    private static ModelFacade instance = new ModelFacade();

    private User user;
    private ModelFacade() {}

    public static ModelFacade getInstance() {
        return instance;
    }
    public SelectedBudgetPost getSelectedBudget(){return selectedBudgetPost;}


    public IBudget getCurrentBudget() {
        return user.getCurrentBudget();
    }

    public Collection<ITransaction> getCurrentBudgetTransactions(){
        return user.getCurrentBudget().getTransactions();
    }
    public Collection<IBudgetPost> budgetPostsfromUser(){
        return user.getCurrentBudget().getBudgetPosts();
    }
    public User getUser(){
        return user;
    }
    public void addTransaction(String name, double amount, String budgetPostID, String description,Calendar date){

        for(IBudgetPost bp : user.getCurrentBudget().getBudgetPosts()){
            if (bp.getName() == budgetPostID){
                Transaction t = new Transaction(name,amount,description,date);
                t.setBpID(bp.getId());

                user.getCurrentBudget().addTransaction(t);

                user.getCurrentBudget().getNewTransactions().add(t);

                bp.addTransaction(t);



            }
        }


    }
    public void addBudgetPost(String name, String maxAmount,  String description,String color){
        user.getCurrentBudget().addBudgetPost(new BudgetPost(Double.parseDouble(maxAmount),name,color));

        user.getCurrentBudget().getNewBudgetPosts().add(new BudgetPost(Double.parseDouble(maxAmount),name,color));


    }

    public void setUser(User user){
        this.user = user;
    }



    public double getCurrentBalance(){
        return user.getCurrentBudget().getCurrentBalance();
    }
    public double getBudgetCap(){
        return user.getCurrentBudget().getBudgetCap();
    }
public void saveUser() throws InterruptedException {
    DatabaseSaver.saveUserToDatabase(user);
}


}

