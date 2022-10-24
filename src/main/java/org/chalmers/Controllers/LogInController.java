package org.chalmers.Controllers;

import org.chalmers.model.ModelFacade;
import org.chalmers.database.Database;
import org.chalmers.database.DatabaseLoader;

/**
 * Controller class for the view class LogInView.
 *
 * @author Jonathan
 */

public class LogInController {


    public LogInController(){}
    ModelFacade facade = ModelFacade.getInstance(); //todo fix


    public void createUser(String name, String id,String password){

        facade.createNewUser( name, id, password);

    }
    public void signInUser(String username, String password){

         int  id = Database.signIntoDB(username,password);
         if (id == 404){
             //TODO
             System.out.println("wrong password");
         }else if( id == 403){
             System.out.println("User not found");
         }else{

             facade.setUser(DatabaseLoader.getUserFromDatabase(id));
         }
    }
}



