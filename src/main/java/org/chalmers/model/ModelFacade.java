package org.chalmers.model;



import javafx.collections.ObservableList;
import org.chalmers.BudgetPostsDetailedLastTransactions;
import org.chalmers.model.database.Database;
import org.chalmers.model.database.TransactionsDB;
import org.chalmers.model.database.UsersDB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        HashMap<String, List<Transaction>> map = loadIntTransactions();
        TransactionsDB uDB = new TransactionsDB(1);
        Transaction f = uDB.getAllTransactions().get(0);
        int fmonth = Integer.parseInt(f.getDateString().substring(2, 4));
        int fyear = Integer.parseInt((f.getDateString().substring(0, 2)));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        int lYear = Integer.parseInt(dateFormat.format(date).substring(2,4));
        int lMonth = Integer.parseInt(dateFormat.format(date).substring(5,7));

        while (true) {
            Budget b = new Budget(fyear, fmonth);
            if (lYear == fyear && fmonth > lMonth ) {
                break;
            }
            if (map.containsKey(String.valueOf(fyear) + String.valueOf(fmonth))){
                    b.getRecentTransactions().addAll(map.get(String.valueOf(fyear) + String.valueOf(fmonth)));
            }
            user.getBudgets().add(b);
            fmonth++;
            if (fmonth > 12) {
                fmonth = 1;
                fyear++;
            }


        }

        user.setCurrentBudget(user.getBudgets().get((user.getBudgets().size()-1)));
        for (Budget b : user.getBudgets()){
            System.out.println("Månad: "+ b.getMonth());
            System.out.println("år: " + b.getYear());
            System.out.println("___________________");

        }


        }


    public HashMap<String, List<Transaction>> loadIntTransactions() {
        List<Transaction> monthTrans = new ArrayList<>();
        HashMap<String, List<Transaction>> map = new HashMap<>();
        TransactionsDB uDB = new TransactionsDB(1);
        Transaction f = uDB.getAllTransactions().get(0);
        Transaction l = uDB.getAllTransactions().get(Math.max(uDB.getAllTransactions().size() - 1, 0));
        int fmonth = Integer.parseInt(f.getDateString().substring(2, 4));
        int fyear = Integer.parseInt((f.getDateString().substring(0, 2)));
        int lYear = Integer.parseInt((l.getDateString().substring(0, 2)));

        while (true) {
            monthTrans.clear();
            for (Transaction tr : uDB.getTransactionsListMonth(fyear, fmonth)) {
                if (fmonth == Integer.parseInt(tr.getDateString().substring(2, 4))) {
                    monthTrans.add(tr);
                }

                map.put(String.valueOf(fyear) + String.valueOf(fmonth), new ArrayList<>(monthTrans));


            }
            fmonth++;
            if (fmonth > 12) {
                fmonth = 1;
                fyear++;
            }
            if (lYear < fyear) {
                break;
            }
        }
        return map;
    }
}

