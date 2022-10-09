package org.chalmers.model.database;

import org.chalmers.model.Transaction;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * Written by Oscar Cronvall
 * Intended to make a pathway between our java abstractions and the database.
 * TODO skriv utförligare
 */
public class UsersDB {
    private DatabaseConnector connector;
    private FileWriter file;
    private JSONObject oldDB;
    private TransactionsDB transactionsDB;
    private static int nextID = 3;

    public UsersDB(int uid){
        connector = new DatabaseConnector("src/main/database/users/" + uid +".json");
        file = null;
        oldDB = null;
        transactionsDB = new TransactionsDB(uid);
    }

    public static void createUserDoc(String name, String pwd, Double balance, Double standardBalance){
        try{
            FileWriter incomingFile = new FileWriter("./src/main/database/users/incoming.json");
            JSONObject jsonObject = new JSONObject();
            try{
                jsonObject.put("name", name);
                jsonObject.put("password", pwd);
                jsonObject.put("currentBalance", balance);
                jsonObject.put("startBalance", standardBalance);
                jsonObject.put("id", nextID);
            } finally {
                incomingFile.write(jsonObject.toJSONString());
                incomingFile.flush();
                incomingFile.close();
            }
            File srcFile = new File("./src/main/database/users/incoming.json");
            File destFile = new File("./src/main/database/users/" + nextID + ".json");
            FileChannel src = new FileInputStream(srcFile).getChannel();
            FileChannel dest = new FileOutputStream(destFile).getChannel();
            dest.transferFrom(src, 0, src.size());
        } catch (IOException e){
            e.printStackTrace();
        }
        nextID++;
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