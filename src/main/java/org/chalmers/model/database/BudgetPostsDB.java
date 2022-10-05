package org.chalmers.model.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BudgetPostsDB {

    private DatabaseConnector connector;
    private FileWriter file;
    private JSONObject oldDB;

    public BudgetPostsDB(String postID){
        connector = new DatabaseConnector("src/main/database/budgetPosts/" + postID +".json");
    }

    public JSONObject getBudgetPost(){
        return connector.getDbObj();
    }

    public String getName(){
        String name = getBudgetPost().get("name").toString();
        return name;
    }

    public Double getCap(){
        Double cap = Double.parseDouble(getBudgetPost().get("cap").toString());
        return cap;
    }

    public List<JSONObject> getTransactions(){
        ArrayList<JSONObject> result = new ArrayList<>();
        JSONArray transactions = (JSONArray) getBudgetPost().get("transactions");
        for(int i = 0; i < transactions.size(); i++){
            JSONObject curr = (JSONObject) transactions.get(i);
            result.add(curr);
        }
        return result;
    }
    
    public void setName(String newName){
        oldDB.put("name", newName);
    }

    public void setCap(Double newCap){oldDB.put("cap", newCap);}

    public void addTransaction(String description, Double total, String date){
        JSONArray transactions = (JSONArray) oldDB.get("transactions");
        JSONObject newTransactions = new JSONObject();
        newTransactions.put("description", description);
        newTransactions.put("total", total);
        newTransactions.put("date", date);
        transactions.add(newTransactions);
        oldDB.put("transactions", transactions);
    }


    /**
     * Call this method so that you can edit the database.
     */
    public void openSetters(){
        try{
            file = new FileWriter(connector.getDbPath());
            oldDB = getBudgetPost();
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
