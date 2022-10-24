package org.chalmers.database;

import org.chalmers.model.*;

import java.util.Calendar;

/**
* @author Isac Hansson
* Save User, transactions and budgetposts to the database (json files)
*/


public class DatabaseSaver {

    private static User user;
    private static UsersDB userDB ;

    /**
     * Save the user to the database
     * @param tempUser The User to be saved.
     * @throws InterruptedException
     */
    public static void saveUserToDatabase(User tempUser) throws InterruptedException {
        if (tempUser != null){
            user = tempUser;

            userDB = new UsersDB(user.getUserID());

            saveTransactions();

            saveBudgetPost();
        }else{
            //TODO
            System.out.println("no user");
        }
    }

    private static void saveTransactions() {
        for(SaveableBudget b : user.getSaveableBudgets())
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

            }
    }
    private static void saveBudgetPost() {
        userDB.openSetters();
        for(SaveableBudget b :  user.getSaveableBudgets()) {

            for (IBudgetPost bp: b.getNewBudgetPosts()){

                userDB.addBudgetPost(bp.getName(),String.valueOf(user.getCurrentBudget().getDate().get(Calendar.YEAR)) + String.valueOf(user.getCurrentBudget().getDate().get(Calendar.MONTH)),bp.getColor(),bp.getBudgetCap());
            }
        }
        userDB.closeSetter();

    }

}
