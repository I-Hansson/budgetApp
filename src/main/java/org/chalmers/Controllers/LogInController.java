package org.chalmers.Controllers;

import org.chalmers.model.ModelFacade;
import org.chalmers.model.database.Database;
import org.chalmers.model.database.DatabaseLoader;

/**
 * Controller class for the view class LogInView.
 *
 * @author Jonathan
 */

public class LogInController {


    public LogInController(){}
    ModelFacade facade = ModelFacade.getInstance(); //todo fix


    public void createUser(String name, String id,String password){

    }
    public Boolean signInUser(String username, String password){

         int  id = Database.signIntoDB(username,password);
         if (id == 404){
             System.out.println("wrong password");
         }else if( id == 403){
             System.out.println("User not found");
         }else{
             System.out.println("User: " + id);
             facade.setUser(DatabaseLoader.getUserFromDatabase(id));
             return true;
         }
            return false;
    }

}



