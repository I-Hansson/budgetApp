package org.chalmers.model.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Objects;

/**
 * Written by Oscar Cronvall
 * Used by: TODO where?
 * Uses: none of our own classes buy uses the simple.JSONObject & simple.JSONArray
 */
public class Database {

    private static int nextID = Objects.requireNonNull(new File("./src/main/database/users").list()).length - 2;

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

    public int hashString(String str){
        int hash = 67;
        for(int i = 0; i < str.length(); i++){
            hash = hash*31+str.charAt(i);
        }
        return hash;
    }
}
