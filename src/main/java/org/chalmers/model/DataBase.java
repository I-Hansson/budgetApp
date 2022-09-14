package org.chalmers.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataBase {

    JSONParser parser = new JSONParser();
    String usersDBUri = "src/main/database/users.json";
    String budgetPostsDBUri = "src/main/database/budgetPosts.json";

    private JSONObject usersDB;
    private JSONObject budgetPostsDB;

    public DataBase(){
        try{
            usersDB = (JSONObject) parser.parse(new FileReader(usersDBUri));
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try{
            budgetPostsDB = (JSONObject) parser.parse(new FileReader(budgetPostsDBUri));
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getAllUsers(){
        System.out.println("-------- GET ALL USERS --------");
        System.out.println(new JSONObject(usersDB));
        return new JSONObject(usersDB);
    }

    public Object getUsersBudgetPosts(Integer uid){
        System.out.println("-------- GET USER BUDGETPOSTS --------");
        Object result = new JSONObject(budgetPostsDB).get(uid.toString());

        if(result != null){
            System.out.println("returned user budgetPosts: " + result);
        }else{
            System.out.println("Can't find user with id " + uid);
        }
        return result;
    }


    public Object getTransactions(String postName,JSONObject budgetPost){
        System.out.println("-------- GET TRANSACTION --------");
        JSONObject post = (JSONObject) budgetPost.get(postName);
        System.out.println(post.get("transactions"));
        return budgetPost.keySet();
    }

    //TODO Add new user
    //TODO Add new budget post
    //TODO Add transaction to budgetpost

    //TODO Remove budget post
    //TODO Remove user

    //TODO Edit username

    //TODO come up with all other methods.....
}
