package org.chalmers.model;

import org.chalmers.model.database.DatabaseLoader;
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

    private User user = new User();
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

    /*public void saveTransactions() throws InterruptedException {
        userDB.openSetterTransaction();
        for(IBudget b : user.getBudgets())
        for (ITransaction t: b.getNewTransactions() ){


            String year = String.valueOf(t.getDate().get(Calendar.YEAR));
            String month = String.valueOf(t.getDate().get(Calendar.MONTH));
            String day = String.valueOf(t.getDate().get(Calendar.DAY_OF_MONTH));
            String temp;
            if (Integer.parseInt(day) < 10) {
                day = "0" + day;
            }
            if (Integer.parseInt(month) < 10){
               month = "0" + month;
            }
                temp = year+ month+ day;
           userDB.addTransaction(t.getName(),t.getDescription(),t.getAmount(),temp,t.getBudgetPostName());
            System.out.println(t.getBudgetPostName());
        }
        userDB.closeSetterTransaction();
    }
    public void saveBudgetPost(){
        userDB.openSetters();
        for(IBudget b : user.getBudgets()) {
            for (IBudgetPost bp: b.getNewBudgetPosts() ){
                userDB.addBudgetPost(bp.getName(),String.valueOf(user.getCurrentBudget().getDate().get(Calendar.YEAR)) + String.valueOf(user.getCurrentBudget().getDate().get(Calendar.MONTH)),bp.getColor(),bp.getBudgetCap());
            }
        }
        userDB.closeSetter();

    }*/

}

