package org.chalmers.model.database;

import org.chalmers.model.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;

/**
 * Written by Oscar Cronvall
 * Intended to make a pathway between our java abstractions and the database.
 * Used by: TODO where?
 * Uses: Transaction, TransactionDB & DatabaseConnector, simple.JSONObject, simple.JSONArray
 */
public class UsersDB {
    private DatabaseConnector connector;
    private FileWriter file;
    private JSONObject oldDB;
    private TransactionsDB transactionsDB;
    private static int nextID = Objects.requireNonNull(new File("./src/main/database/users").list()).length - 2;

    public UsersDB(int uid){
        connector = new DatabaseConnector("src/main/database/users/" + uid +".json");
        file = null;
        oldDB = getUser();
        transactionsDB = new TransactionsDB(uid);
    }

    /**
     * Only intended to be used in the UsersDB class, reads and returns the read document in full.
     * @return returns the read file in full of the type JSONObjcet
     */
    private JSONObject getUser(){
        return connector.getDbObj();
    }

    /**
     * @return Returns the name of the user in this document
     */
    public String getUserName(){
        String userName = getUser().get("name").toString();
        return userName;
    }

    /**
     * @param writtenPassword given password by client input
     * @return if password matches with the one in the database
     */
    public Boolean matchesPassword(String writtenPassword){
        String pwd = getUser().get("password").toString();
        return writtenPassword.equals(pwd);
    }

    /**
     * @return Returns the current balance of the user in this document
     */
    public Double getBalance(){
        Double userBalance = Double.parseDouble(getUser().get("currentBalance").toString());
        return userBalance;
    }

    /**
     * @return Returns the standard balance (the start balance for each month) of the user in this document
     */
    public Double getStandardBalance(){
        Double userStartBalance = Double.parseDouble(getUser().get("startBalance").toString());
        return userStartBalance;
    }

    /**
     * @return returns the ID of the user (same as used for json document, reference: uid.json)
     */
    public String getUid(){
        String id = getUser().get("id").toString();
        return id;
    }

    /**
     * Updates the name of the user in the database
     * @param newName the new name wanted for the user
     */
    public void setUserName(String newName){
        oldDB.put("name", newName);
    }

    /**
     * Updates the current balance of the user in the database
     * @param newBalance the new balance for the user
     */
    public void setBalance(double newBalance){
        oldDB.put("currentBalance", newBalance);
    }

    /**
     * Updates the standard balance that is used in the beggining of each month.
     * @param newStandardBalance the new standard balance
     */
    public void setNewStandardBalance(double newStandardBalance){
        oldDB.put("startBalance", newStandardBalance);
    }

    public void addTransaction(String name, String description, Double amount, String date, String budgetPostName){
        transactionsDB.addTransaction(name,description,amount,date,budgetPostName);
    }
    public List<Transaction> getTransactionsDate(int year, int month){
        return transactionsDB.getTransactionsListMonth(year,month);
    }
    public List<Transaction> getAllTransactions(){
        return transactionsDB.getAllTransactions();
    }

    /**
     * @return A HashMap containing name<String>, cap<Double>, color<String>
     */
    public List<Map<String, Object>> getBudgetPosts(){
        List<Map<String, Object>> result = new ArrayList<>();
        JSONArray postsDB = (JSONArray) oldDB.get("budgetPosts");

        for(Object obj: postsDB){
            JSONObject jsonObject = (JSONObject) obj;
            Map<String, Object> bp = new HashMap();
            bp.put("date",jsonObject.get("date").toString());
            bp.put("name", jsonObject.get("name").toString());
            bp.put("cap", Double.parseDouble(jsonObject.get("cap").toString()));
            bp.put("color", jsonObject.get("color").toString());
            result.add(bp);
        }
        return result;
    }

    /**
     * Add a budget post to this user
     * @param name The name of the budget post
     * @param cap The transaction cap of this budget post
     * @param color The color for the budget post
     * @param date The date in the format year+month E.g. "2210" == October 2022
     */
    public void addBudgetPost(String name, Double cap, String color, String date){
        JSONArray postsDB = (JSONArray) oldDB.get("budgetPosts");
        JSONObject newBudgetPost = new JSONObject();
        openSetters();
        newBudgetPost.put("date", date);
        newBudgetPost.put("name",name);
        newBudgetPost.put("cap",cap);
        newBudgetPost.put("color", color);
        postsDB.add(newBudgetPost);
        closeSetter();
    }

    /**
     * Removes a certain budgetPost from the JSONArray of budgetPosts
     * @param name the name of the budget post to be removed
     * @param date the date of the budget post to remove
     */
    public void removeBudgetPost(String name, String date){
        openSetters();
        JSONArray postsDB = (JSONArray) oldDB.get("budgetPosts");
        for(Object postObj: postsDB){
            JSONObject post = (JSONObject) postObj;
            boolean namesMatch = post.get("name").toString().equals(name);
            boolean dateMatch = post.get("date").toString().equals(date);
            if(namesMatch && dateMatch){
                postsDB.remove(postObj);
                closeSetter();
            }
        }
    }

    /**
     * Call this method so that you can edit the database.
     */
    public void openSetters(){
        try{
            file = new FileWriter(connector.getDbPath());
            oldDB = getUser();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Call this method to write and close new edits to the database.
     * To edit again call on the openSetters() method
     */
    public void closeSetter(){
        try{
            file.write(oldDB.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}