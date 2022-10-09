package org.chalmers.model;

import org.chalmers.model.database.BudgetPostsDB;
import org.chalmers.model.database.UsersDB;

import java.util.*;

public class ModelFacade {

    private UsersDB db = new UsersDB(1);
    private static ModelFacade instance = new ModelFacade();


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

    public List<BudgetPost> getBudgetPosts() {
        Map<String, String> response = db.getBudgetPosts();
        List<BudgetPost> result = new ArrayList<>();
        List<BudgetPostsDB> BpDb = new ArrayList<>();

        for (String id : response.keySet()) {
            BpDb.add(new BudgetPostsDB(id));
        }

        for (BudgetPostsDB bp: BpDb) {
            result.add(BudgetPostFactory.createBudgetPost(bp.getName(), bp.getCap()));
        }

        return result;
    }

    //VARNING!! Fungerar inte!!
    public BudgetPost getBudgetPost(String name) { //TODO
        for (BudgetPost bp : getBudgetPosts()) {
            if (bp.getId().getName().equals(name)) {
                return bp;
            }
        }
        return BudgetPostFactory.createBudgetPost("nej");
    }

    public void addBudgetPost(String name) {
        // not workings rn
        db.openSetters();
        db.addBudgetPost(name);
        db.closeSetter();
    }

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


}
