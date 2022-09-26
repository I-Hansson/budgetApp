package org.chalmers.model.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsersDB {
    private DatabaseConnector connector;
    private JSONParser parser;
    private FileWriter file;
    private JSONObject oldDB;

    public UsersDB(int uid){
        connector = new DatabaseConnector("src/main/database/users/" + uid +".json");
        parser = new JSONParser();
        file = null;
        oldDB = null;
    }

    public JSONObject getUser(){
        return connector.getDbObj();
    }

    public String getUserName(){
        //TODO get username
        String userName = getUser().get("name").toString();
        return userName;
    }

    public Double getBalance(){
        //TODO get balance
        Double userBalance = Double.parseDouble(getUser().get("currentBalance").toString());
        return userBalance;
    }

    public Double getStandardBalance(){
        //TODO get standard balance
        Double userStartBalance = Double.parseDouble(getUser().get("startBalance").toString());
        return userStartBalance;
    }

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

    public String getBudgetPostID(String postName){
        Map<String, String> budgetPosts = getBudgetPosts();
        if(budgetPosts.containsKey(postName)){
            return budgetPosts.get(postName);
        }
        return null;
    }

    public String getUid(){
        String id = getUser().get("id").toString();
        return id;
    }

    public void setUserName(String newName){
        oldDB.put("name", newName);
    }

    public void setBalance(double newBalance){
        oldDB.put("currentBalance", newBalance);
    }

    public void setNewStandardBalance(double newStandardBalance){
        oldDB.put("startBalance", newStandardBalance);
    }

    public void addBudgetPost(String name){
        JSONArray posts = (JSONArray) oldDB.get("budgetPosts");
        JSONObject newPost = new JSONObject();
        newPost.put("name", name);
        int counter = posts.size() + 1;
        newPost.put("id", "000" + getUid() + counter);
        posts.add(newPost);
        oldDB.put("transactions", posts);
    }

    public void openSetters(){
        try{
            file = new FileWriter(connector.getDbPath());
            oldDB = getUser();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void closeSetter(){
        try{
            file.write(oldDB.toJSONString());
            file.flush();
            file.close();
            oldDB = null;
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
