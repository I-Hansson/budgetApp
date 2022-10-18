package org.chalmers.model;



import javafx.collections.ObservableList;
import org.chalmers.BudgetPostsDetailedLastTransactions;
import org.chalmers.BudgetPostsView;
import org.chalmers.model.database.Database;
import org.chalmers.model.database.TransactionsDB;
import org.chalmers.model.database.UsersDB;

import java.security.spec.RSAOtherPrimeInfo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ModelFacade {

    // TODO Får jag göra så här ?
    private SelectedBudgetPost selectedBudgetPost = new SelectedBudgetPost(null);
    UsersDB userDB = new UsersDB(1);
    private UsersDB db = new UsersDB(1);
    private static ModelFacade instance = new ModelFacade();

    private User user = new User();
    private ModelFacade() {}

    public static ModelFacade getInstance() {
        return instance;
    }

    // TODO Får jag göra så här ?
    public SelectedBudgetPost getSelectedBudget(){return selectedBudgetPost;}

    public String getCurrentUserName() {
        return db.getUserName();
    }

    public Double getCurrentBalance() {
        return db.getBalance();
    }

    public Double getStandardBalance() {
        return db.getStandardBalance();
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

    public List<Transaction> getCurrentBudgetTransactions(){
        return user.getCurrentBudget().getRecentTransactions();
    }
    public List<BudgetPost> budgetPostsfromUser(){
        return user.getCurrentBudget().getBudgetPosts();
    }
    public User getUser(){
        return user;
    }
    public void addTransaction(String name, double amount, String budgetPostID, String description,String date){

        for(BudgetPost bp : user.getCurrentBudget().getBudgetPosts()){
            if (bp.getId().getName() == budgetPostID){
                Transaction t = new Transaction(name,amount,bp.getId(),description,date);
                user.getCurrentBudget().addTransaction(t);
                user.getCurrentBudget().getNewTransactions().add(t);
                bp.addTransaction(t);


            }
        }


    }
    public void addBudgetPost(String name, String maxAmount,  String description,String color){
        user.getCurrentBudget().addBudgetPost(new BudgetPost(Double.parseDouble(maxAmount),name,color));

    }




    public void connectDB() {
        fillBudget();


         for(Budget budget:   user.getBudgets()){
             int budgetDate = Integer.parseInt(budget.getYear() +budget.getMonthNumber());
             for(Map<String,Object> bp : userDB.budgetPosts()){
                 int bpDate = Integer.parseInt((String) bp.get("dateOfCreation"));
                 if (bpDate<= budgetDate){
                     BudgetPost budgetPost = new BudgetPost(
                             Double.parseDouble(bp.get("cap").toString()),
                       bp.get("name").toString(),
                       bp.get("color").toString());
                     budget.getBudgetPosts().add(budgetPost);
                 }
             }
             }
        /**
         *
         */

        for (Budget budget: user.getBudgets()){
             for(Transaction t : budget.getRecentTransactions()){
                 for(BudgetPost bp: budget.getBudgetPosts()){
                     System.out.println(t.getBudgetPostName());
                     if(t.getBudgetPostName().equals(bp.getId().getName())){
                         t.setBpID(bp.getId());
                         bp.addTransaction(t);
                     }
                 }
             }
         }


        System.out.println(user.getCurrentBudget().getBudgetPosts().get(0).getId().getName());

        for (Budget b : user.getBudgets()) {
            System.out.println("Månad: " + b.getMonth());
            System.out.println("år: " + b.getYear());
            System.out.println("Budgetposts" + b.getBudgetPosts());
            System.out.println("___________________");
        }


        }
        private void fillBudget(){
            HashMap<String, List<Transaction>> map = loadIntTransactions();
            TransactionsDB transactionDB = new TransactionsDB(1);
            Transaction f = transactionDB.getAllTransactions().get(0);
            String fmonth = f.getDateString().substring(2, 4);
            String fyear =(f.getDateString().substring(0, 2));

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String lYear =dateFormat.format(date).substring(2,4);
            String lMonth = dateFormat.format(date).substring(5,7);

            do {
                Budget budget;
                if(fmonth.equals("12")){ // för att oracle är dumma
                    budget = new Budget(Integer.parseInt(fyear),0);
                }else{
                    budget = new Budget(Integer.parseInt(fyear),Integer.parseInt(fmonth));
                }

                if ( map.containsKey(fyear + fmonth)){
                    budget.getRecentTransactions().addAll(map.get(fyear + fmonth));
                }
                user.getBudgets().add(budget);
                String nextMonth = nextMonth(fyear + fmonth);
                fyear = nextMonth.substring(0,2);
                fmonth = nextMonth.substring(2,4);
            } while (Integer.parseInt(fyear + fmonth)< Integer.parseInt(lYear + lMonth)+1);

            user.setCurrentBudget(user.getBudgets().get((user.getBudgets().size()-1)));


        }
        private String nextMonth(String date){
            int year = Integer.parseInt(date.substring(0,2));
            int month=  Integer.parseInt(date.substring(2,4));
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
            if(month < 10){
                return String.valueOf(year) + "0"+String.valueOf(month);
            }
            return String.valueOf(year) + String.valueOf(month);

        }


    public HashMap<String, List<Transaction>> loadIntTransactions() {

        HashMap<String, List<Transaction>> map = new HashMap<>();
        TransactionsDB uDB = new TransactionsDB(1);
        for(Transaction transaction: uDB.getAllTransactions()){
            String transactionKey = transaction.getDateString().substring(0,4);
            if(map.containsKey(transactionKey)){
                map.get(transactionKey).add(transaction);
            }else{
                List<Transaction> temp = new ArrayList<>();
                temp.add(transaction);
                map.put(transactionKey,temp);
            }
        }
        return map;
    }

    public void saveTransactions() throws InterruptedException {
        userDB.openSetterTransaction();
        for(Budget b : user.getBudgets())
        for (Transaction t: b.getNewTransactions() ){
           userDB.addTransaction(t.getName(),t.getDescription(),t.getAmount(),t.getDateString(),t.getBudgetPostName());
            System.out.println(t.getBudgetPostName());
        }
        userDB.closeSetterTransaction();
    }
    public void saveBudgetPost(){
        userDB.openSetterTransaction();
        for(Budget b : user.getBudgets()) {
            for (BudgetPost bp: b.getBudgetPosts() ){
            }
        }
        userDB.closeSetterTransaction();

    }

}

