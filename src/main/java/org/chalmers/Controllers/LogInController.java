package org.chalmers.Controllers;

import org.chalmers.model.ModelFacade;
import org.chalmers.database.Database;
import org.chalmers.database.DatabaseLoader;

/**
 * Controller class for the view class LogInView.
 * Depends on: ModelFacade.
 * @author Jonathan
 */

public class LogInController {


    public LogInController(){}
    ModelFacade facade = ModelFacade.getInstance();

    /**
     * Creation of the user.
     * @param name The user name.
     * @param id The user id.
     * @param password The user password
     */

    public void createUser(String name, String id,String password){
        facade.createNewUser( name, id, password);
    }

    /**
     * Signs in the user.
     * @param username The username of the user.
     * @param password The password of the user.
     */

    public void signInUser(String username, String password){

         int  id = Database.signIntoDB(username,password);
         if (id == 404){
             System.out.println("wrong password");
         }else if( id == 403){
             System.out.println("User not found");
         }else{
             System.out.println("User: " + id);
             facade.setUser(DatabaseLoader.getUserFromDatabase(id));
         }
    }
}



