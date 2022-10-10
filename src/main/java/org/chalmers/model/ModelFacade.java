package org.chalmers.model;



import javafx.collections.ObservableList;
import org.chalmers.BudgetPostsDetailedLastTransactions;
import org.chalmers.model.database.Database;
import org.chalmers.model.database.TransactionsDB;
import org.chalmers.model.database.UsersDB;

import java.util.*;

public class ModelFacade {

    private UsersDB db = new UsersDB(1);
    private static ModelFacade instance = new ModelFacade();

    private User user = new User();
    private ModelFacade() {}

    public static ModelFacade getInstance() {
        return instance;
    }

    public String getCurrentUserName() {
        return db.getUserName();
    }

    public Double getCurrentBalance() {
        return db.getBalance();
    }

    public Double getStandardBalance() {
        return db.getStandardBalance();
    }


    /*public List<BudgetPost> getBudgetPosts() {
        Map<String, String> response = db.getBudgetPosts();
        List<BudgetPost> result = new ArrayList<>();
        List<BudgetPostsDB> BpDb = new ArrayList<>();


            for (String id : response.keySet()) {
                BpDb.add(new BudgetPostsDB(id));
            }

            for (BudgetPostsDB bp : BpDb) {
                result.add(BudgetPostFactory.createBudgetPost(bp.getName(), bp.getCap()));
            }

            return result;
        }
        return result;
    }*/


    /*
    //VARNING!! Fungerar inte!!
    public BudgetPost getBudgetPost(String name) { //TODO
        for (BudgetPost bp : getBudgetPosts()) {
            if (bp.getId().getName().equals(name)) {
                return bp;
            }
        }
        return BudgetPostFactory.createBudgetPost("nej");
    }

    public void addBudgetPost(String name) { //TODO
        // not workings rn
        db.openSetters();
        db.addBudgetPost(name);
        db.closeSetter();
    }*/

    public void setUserName(String name) {
        db.openSetters();
        db.setUserName(name);
        db.closeSetter();
    }

    public void setBalance(double balance) {
        db.openSetters();
        db.setBalance(balance);
        db.closeSetter();
    }

    public void setStandardBalance(double balance) {
        db.openSetters();
        db.setNewStandardBalance(balance);
        db.closeSetter();
    }

    public List<Transaction> getCurrentBudgetTransactions(){
        return user.getCurrentBudget().getRecentTransactions();
    }
    public List<BudgetPost> budgetPostsfromUser(){
        return user.getCurrentBudget().getBudgetPosts();
    }
    public User getUser(){
        return user;
    }
    public void addTransaction(String name, double amount, String budgetPostID, String description){

        for(BudgetPost bp : user.getCurrentBudget().getBudgetPosts()){
            if (bp.getId().getName() == budgetPostID){
                Transaction t = new Transaction(name,amount,bp.getId(),description);

                user.getCurrentBudget().addTransaction(t);
                bp.addTransaction(t);
                bp.updatecurrentBalance();

            }
        }


    }
    public void connectDB() {
        Database.createUserDoc("Isac", "qwertyfuck", 1000.0, 10.0);
        List<Transaction> monthTrans = new ArrayList<>();
        HashMap<String, List<Transaction>> map = new HashMap<>();
        TransactionsDB uDB = new TransactionsDB(1);
        Transaction t = uDB.getAllTransactions().get(0);
        int fmonth = Integer.parseInt(t.getDateString().substring(2, 4));
        while (true) {
            monthTrans.clear();
            for (Transaction tr : uDB.getTransactionsListMonth(22, fmonth)) {
                if (fmonth == Integer.parseInt(tr.getDateString().substring(2, 4))) {
                    monthTrans.add(tr);
                    System.out.println(monthTrans);
                    System.out.println(tr.getName());
                }

                map.put(String.valueOf(fmonth),new ArrayList<>(monthTrans));

            }

            fmonth++;
            if (fmonth > 12) {
                break;
            }
        }
        System.out.println(map);
        System.out.println(map.get("9"));
    }
}
