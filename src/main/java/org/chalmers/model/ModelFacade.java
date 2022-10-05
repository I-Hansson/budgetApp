package org.chalmers.model;

import javafx.scene.paint.Color;
import org.chalmers.model.database.BudgetPostsDB;
import org.chalmers.model.database.UsersDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelFacade {

    UsersDB db = new UsersDB(1);

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
