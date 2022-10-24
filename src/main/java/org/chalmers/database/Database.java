package org.chalmers.database;

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
     * @param email the email of the new user
     */
    public static void createUserDoc(String name, String email, String pwd){
        try{
            FileWriter incomingFile = new FileWriter("./src/main/database/users/incoming.json");
            JSONObject jsonObject = new JSONObject();
            JSONObject bp = new JSONObject();
            bp.put("name", "Matvaror");
            bp.put("cap", 1500);
            bp.put("color", "100,50,50");
            bp.put("name", "Matvaror");
            bp.put("dateOfCreation", "2210");
            JSONArray list = new JSONArray();
            list.add(bp);
            try{
                jsonObject.put("name", name);
                jsonObject.put("email", email);
                jsonObject.put("password", pwd);
                jsonObject.put("id", nextID);
                jsonObject.put("budgetPosts", list);
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
     * @param email the email of the new signed in.
     * @param pwd the password
     */
    public static Integer signIntoDB(String email, String pwd){
        for(int i = 1; i < nextID; i++){
            File f = new File("./src/main/database/users/" + i + ".json");
            if(f.exists()){
                UsersDB udb = new UsersDB(i);
                if(udb.getEmail().equals(email)){
                    if(udb.matchesPassword(pwd))
                        return i;
                    else{

                        return 404;
                    }
                }
            }
        }

        return 403;
    }
}
