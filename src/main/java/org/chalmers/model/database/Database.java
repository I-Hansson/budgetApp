package org.chalmers.model.database;

import org.chalmers.model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Objects;

/**
 * Written by Oscar Cronvall
 */
public class Database {

    private static int nextID = Objects.requireNonNull(new File("./src/main/database/users").list()).length - 2;


    /**
     * Creates a document for a NEW user in the database. Should only be called upon when CREATING
     * a new user.
     * @param name the name of the new user
     * @param pwd the password for the new user
     * @param balance the start balance for the new user
     */
    public static void createUserDoc(String name, String pwd, Double balance){
        try{
            FileWriter incomingFile = new FileWriter("./src/main/database/users/incoming.json");
            JSONObject jsonObject = new JSONObject();
            try{
                jsonObject.put("name", name);
                jsonObject.put("password", pwd);
                jsonObject.put("currentBalance", balance);
                jsonObject.put("startBalance", balance);
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
            createUserTransactionDoc();
        } catch (IOException e){
            e.printStackTrace();
        }
        nextID++;
    }

    private static void createUserTransactionDoc(){
        try{
            File newFile = new File("./src/main/database/transactions/" + nextID + ".json");
            if(newFile.createNewFile())
                System.out.println("Transaction document created");
            else
                System.out.println("Document of that id already exists");

            JSONObject jsonObject = new JSONObject();
            JSONArray transactions = new JSONArray();
            jsonObject.put("transactions", transactions);

            FileWriter writer = new FileWriter("./src/main/database/transactions/" + nextID + ".json");
            writer.write(jsonObject.toJSONString());
            writer.flush();
            writer.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Integer lastUserCreatedID(){
        return Math.max(nextID-1,1);
    }

    /**
     * @return the UsersDB for the signed in user.
     * @param uid the userID of the new signed in.
     */
    public UsersDB signIntoDB(String uid, String pwd){
        Integer uidInt = Integer.parseInt(uid);
        File f = new File("./src/main/database/users/" + uid + ".json");
        if(f.exists()){
            UsersDB udb = new UsersDB(uidInt);
            if(udb.matchesPassword(pwd))
                return udb;
            System.out.println("Password is incorrect");
        }
        return null;
    }
}
