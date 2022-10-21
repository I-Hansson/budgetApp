package org.chalmers.Controllers;

import org.chalmers.model.ModelFacade;


/**
 * Controller class for the view class BudgetPostView.
 *
 * @author Jonathan
 */

public class BudgetPostController {

    private ModelFacade facade = ModelFacade.getInstance();


    public BudgetPostController(){

    }


    public void createBudgetPost(String name, String maxAmount, String description,String color){
        System.out.println(color);
        int r = Integer.valueOf(color.substring(2, 4), 16);
        int g = Integer.valueOf(color.substring(4, 6), 16);
        int b=  Integer.valueOf(color.substring(6, 8), 16);
        StringBuilder rgb = new StringBuilder();
        rgb.append(r + "," + g + "," + b);

        facade.addBudgetPost(name, Double.parseDouble(maxAmount), rgb.toString());
    }

}
