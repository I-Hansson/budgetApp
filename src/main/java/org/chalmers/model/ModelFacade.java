package org.chalmers.model;

import org.chalmers.model.database.TransactionsDB;
import org.chalmers.model.database.UsersDB;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This class is a facade for the entire model.
 * Its purpose is providing an interface for the client code and allow interaction with the model.
 *
 * Depends on everything :))))
 *
 * @author williamfrisk
 * @author Isac Hansson
 */
public class ModelFacade {

    // TODO Får jag göra så här ?
    private static SelectedBudgetPost selectedBudgetPost = new SelectedBudgetPost(null);
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
        return user.getCurrentBudget().getTransactions();
    }
    public List<BudgetPost> budgetPostsfromUser(){
        return user.getCurrentBudget().getBudgetPosts();
    }
    public User getUser(){
        return user;
    }
    public void addTransaction(String name, double amount, String budgetPostID, String description,Calendar date){

        for(BudgetPost bp : user.getCurrentBudget().getBudgetPosts()){
            if (bp.getName() == budgetPostID){
                Transaction t =new Transaction(name,amount,description,date);
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




    public void connectDB() {
        fillBudget();


         for(Budget budget:   user.getBudgets()){
             int budgetDate = Integer.parseInt(budget.getYear() +budget.getMonthNumber());
             for(Map<String,Object> bp : userDB.getBudgetPosts()){
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
             for(Transaction t : budget.getTransactions()){
                 for(BudgetPost bp: budget.getBudgetPosts()){
                     System.out.println(t.getBudgetPostName());
                     if(t.getBudgetPostName().equals(bp.getName())){
                         t.setBpID(bp.getId());
                         bp.addTransaction(t);
                     }
                 }
             }
         }


        System.out.println(user.getCurrentBudget().getBudgetPosts().get(0).getName());

      /*  for (Budget b : user.getBudgets()) {
            System.out.println("Månad: " + b.getMonth());
            System.out.println("år: " + b.getYear());
            System.out.println("Budgetposts" + b.getBudgetPosts());
            System.out.println("___________________");
        }*/


        }
        private void fillBudget(){
            HashMap<Integer, List<Transaction>> map = loadIntTransactions();
            System.out.println(map);
            TransactionsDB transactionDB = new TransactionsDB(1);
            Transaction transaction = transactionDB.getAllTransactions().get(0);
            int fmonth = transaction.getDateOfTransaction().get(Calendar.MONTH);
            int fyear = transaction.getDateOfTransaction().get(Calendar.YEAR);
            System.out.println((fyear*100 + fmonth));

            Calendar today = new GregorianCalendar();
            int lYear = today.get(Calendar.YEAR);
            int lMonth = today.get(Calendar.MONTH);
            Calendar newCalender = new GregorianCalendar(
                    transaction.getDateOfTransaction().get(Calendar.YEAR),
                    transaction.getDateOfTransaction().get(Calendar.MONTH),
                    transaction.getDateOfTransaction().get(Calendar.DAY_OF_MONTH)
            );
            do {
                Budget budget = new Budget(fyear,fmonth);

                if ( map.containsKey(fyear*100 + fmonth)){
                    budget.getTransactions().addAll(map.get(fyear*100 + fmonth));
                }
                user.getBudgets().add(budget);


                newCalender.add(Calendar.MONTH,1);
                fmonth = newCalender.get(Calendar.MONTH);
                fyear = newCalender.get(Calendar.YEAR);
            } while (fyear*100 + fmonth <= (lYear*100 + lMonth));

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


    public HashMap<Integer, List<Transaction>> loadIntTransactions() {

        HashMap<Integer, List<Transaction>> map = new HashMap<>();
        TransactionsDB uDB = new TransactionsDB(1);
        for(Transaction transaction: uDB.getAllTransactions()){
            int year = transaction.getDateOfTransaction().get(Calendar.YEAR);
            int month = transaction.getDateOfTransaction().get(Calendar.MONTH);
            Integer transactionKey = year *100 + month;
            System.out.println("TKEY: " + transactionKey);
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

    /*public void saveTransactions() throws InterruptedException {
        userDB.openSetterTransaction();
        for(Budget b : user.getBudgets())
        for (Transaction t: b.getNewTransactions() ){
           userDB.addTransaction(t.getName(),t.getDescription(),t.getAmount(),t.getDateString(),t.getBudgetPostName());
            System.out.println(t.getBudgetPostName());
        }
        userDB.closeSetterTransaction();
    }*/
    public void saveBudgetPost(){
        userDB.openSetters();
        for(Budget b : user.getBudgets()) {
            for (BudgetPost bp: b.getNewBudgetPosts() ){
                userDB.addBudgetPost(bp.getName(),user.getCurrentBudget().getYear() + user.getCurrentBudget().getMonthNumber(),bp.getColor(),bp.getBudgetCap());
            }
        }
        userDB.closeSetter();

    }

    private void setDate(String date){
        int year = Integer.parseInt(date.substring(0, 2));
        int  month = Integer.parseInt(date.substring(2,4));
        int day = Integer.parseInt(date.substring(4,6));

    }


}

