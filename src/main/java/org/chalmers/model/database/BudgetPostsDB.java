package org.chalmers.model.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BudgetPostsDB {

    private DatabaseConnector connector;

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

    public List getTransactions(){
        ArrayList<JSONObject> result = new ArrayList<>();
        JSONArray transactions = (JSONArray) getBudgetPost().get("transactions");
        for(int i = 0; i < transactions.size(); i++){
            JSONObject curr = (JSONObject) transactions.get(i);
            result.add(curr);
        }
        return result;
    }


    
}
