package org.chalmers.model;

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

    public IBudget getCurrentBudget() {
        return user.getCurrentBudget();
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




    public void connectDB() {
        fillBudget();


         for(IBudget budget:   user.getBudgets()){
             int budgetDate = budget.getDate().get(Calendar.YEAR) * 100 + budget.getDate().get(Calendar.MONTH);
             for(Map<String,Object> bp : userDB.getBudgetPosts()){
                 int bpDate = Integer.parseInt((String) bp.get("dateOfCreation"));
                 if (bpDate<= budgetDate){
                     IBudgetPost budgetPost = new BudgetPost(
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

        for (IBudget budget: user.getBudgets()){
             for(ITransaction t : budget.getTransactions()){
                 for(IBudgetPost bp: budget.getBudgetPosts()){
                     DBTransaction temp = (DBTransaction) t;
                     System.out.println(t.getBudgetPostName());
                     if(temp.getBpName().equals(bp.getName())){
                         temp.setBpID(bp.getId());
                         bp.addTransaction(t);
                     }
                 }
             }
         }
        }
    private void fillBudget(){
        HashMap<Integer, List<Transaction>> map = loadIntTransactions();
        System.out.println(map);
        TransactionsDB transactionDB = new TransactionsDB(1);
        Transaction transaction = transactionDB.getAllTransactions().get(0);
        int fmonth = transaction.getDate().get(Calendar.MONTH);
        int fyear = transaction.getDate().get(Calendar.YEAR);
        System.out.println((fyear*100 + fmonth));

        Calendar today = new GregorianCalendar();
        int lYear = today.get(Calendar.YEAR);
        int lMonth = today.get(Calendar.MONTH);
        Calendar newCalender = new GregorianCalendar(
                transaction.getDate().get(Calendar.YEAR),
                transaction.getDate().get(Calendar.MONTH),
                transaction.getDate().get(Calendar.DAY_OF_MONTH)
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

    public HashMap<Integer, List<Transaction>> loadIntTransactions() {

        HashMap<Integer, List<Transaction>> map = new HashMap<>();
        TransactionsDB uDB = new TransactionsDB(1);
        for(Transaction transaction: uDB.getAllTransactions()){
            int year = transaction.getDate().get(Calendar.YEAR);
            int month = transaction.getDate().get(Calendar.MONTH);
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

    public void saveTransactions() throws InterruptedException {
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

    }

    private void setDate(String date){
        int year = Integer.parseInt(date.substring(0, 2));
        int  month = Integer.parseInt(date.substring(2,4));
        int day = Integer.parseInt(date.substring(4,6));

    }


}

