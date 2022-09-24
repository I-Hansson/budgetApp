package org.chalmers.model.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsersDB {
    private DatabaseConnector connector;

    public UsersDB(int uid){
        connector = new DatabaseConnector("src/main/database/users/" + uid +".json");
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

    public void setUserName(Integer id, String newName){
        //TODO set new username
    }

    public void setBalance(double newBalance){
        //TODO set new balance value
    }

    public void setNewStandardBalance(double newStandardBalance){
        //TODO set new standard balance
    }
}
