package org.chalmers.model.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsersDB {
    private DatabaseConnector connector;
    private FileWriter file;
    private JSONObject oldDB;
    private JSONArray budgetPosts;

    public UsersDB(int uid){
        connector = new DatabaseConnector("src/main/database/users/" + uid +".json");
        file = null;
        oldDB = null;
        budgetPosts = null;
    }

    /**
     * Only intended to be used in the UsersDB class, reads and returns the read document in full.
     * @return returns the read file in full of the type JSONObjcet
     */
    private JSONObject getUser(){
        return connector.getDbObj();
    }

    /**
     *
     * @return Returns the name of the user in this document
     */
    public String getUserName(){
        //TODO get username
        String userName = getUser().get("name").toString();
        return userName;
    }
    /**
     * @return Returns the current balance of the user in this document
     */
    public Double getBalance(){
        //TODO get balance
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
     * @return Returns all budget posts in form of Map<name, budgetPostDocID>
     */
    public Map<String, String> getBudgetPosts(){
        Map<String, String> result = new HashMap<>();

        JSONArray posts = (JSONArray) getUser().get("budgetPosts");
        for(int i = 0; i < posts.size(); i++){
            JSONObject curr = (JSONObject) posts.get(i);
            result.put(
                    curr.get("name").toString(),
                    curr.get("id").toString()
            );
        }
        return result;
    }

    /**
     * @param postName the name of the budgetPost wanted
     * @return the document ID of the budget post with the name given in param
     */
    public String getBudgetPostID(String postName){
        Map<String, String> budgetPosts = getBudgetPosts();
        if(budgetPosts.containsKey(postName)){
            return budgetPosts.get(postName);
        }
        return null;
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

    /**
     * Adds a new budgetPost to the db
     * @param name the name of the new budget post
     * TODO add safety so that two budgetPosts can't have the same name
     */
    public void addBudgetPost(String name){
        budgetPosts = (JSONArray) oldDB.get("budgetPosts");

        if(!budgetPostExists(name)){
            JSONObject newPost = new JSONObject();
            newPost.put("name", name);
            int counter = budgetPosts.size() + 1;
            newPost.put("id", "000" + getUid() + counter);
            budgetPosts.add(newPost);
            oldDB.put("budgetPosts", budgetPosts);
        }else{
            System.out.println("ALERT: a budget post with that name already exists (" + name + ")");
        }
    }

    /**
     * Call this method so that you can edit the database.
     */
    public void openSetters(){
        try{
            file = new FileWriter(connector.getDbPath());
            oldDB = getUser();
            budgetPosts = (JSONArray) oldDB.get("budgetPosts");
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


    private boolean budgetPostExists(String postName){
        for(Object obj: budgetPosts){
            JSONObject object = (JSONObject) obj;
            if(object.get("name").equals(postName))
                return true;
        }
        return false;
    }
}