package org.chalmers.model.database;

import org.chalmers.model.IBudget;
import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ITransaction;
import org.chalmers.model.User;

import java.util.Calendar;

public class DatabaseSaver {


    private static User user;
    private static UsersDB userDB = new UsersDB(1);
    public static void saveUserToDatabase(User tmp) throws InterruptedException {
        user = tmp;
        userDB = new UsersDB(1);
        saveTransactions();
        saveBudgetPost();
    }


    private static void saveTransactions() throws InterruptedException {
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
    private static void saveBudgetPost(){
        userDB.openSetters();
        for(IBudget b : user.getBudgets()) {
            for (IBudgetPost bp: b.getNewBudgetPosts() ){
                userDB.addBudgetPost(bp.getName(),String.valueOf(user.getCurrentBudget().getDate().get(Calendar.YEAR)) + String.valueOf(user.getCurrentBudget().getDate().get(Calendar.MONTH)),bp.getColor(),bp.getBudgetCap());
            }
        }
        userDB.closeSetter();

    }

}
