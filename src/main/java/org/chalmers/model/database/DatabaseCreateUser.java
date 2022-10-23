package org.chalmers.model.database;



public class DatabaseCreateUser {


    public static void createDB(String name, String id,String password){
        Database.createUserDoc(name,id,password);

    }


}
