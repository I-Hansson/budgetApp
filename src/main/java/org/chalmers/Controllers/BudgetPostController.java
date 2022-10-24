package org.chalmers.Controllers;

import org.chalmers.model.ModelFacade;

/**
 * Controller class for the view class BudgetPostView.
 * Depends on: ModelFacade.
 * @author Jonathan
 */

public class BudgetPostController {

    private final ModelFacade facade = ModelFacade.getInstance();

    public BudgetPostController(){

    }

    /**
     * Creation of budget post.
     * @param name The budget post name.
     * @param maxAmount The budgetcap for the budget post.
     * @param description The description for the budget post.
     * @param color The selected color for the budget post.
     */

    public void createBudgetPost(String name, String maxAmount, String description,String color){
        System.out.println(color);
        int r = Integer.valueOf(color.substring(2, 4), 16);
        int g = Integer.valueOf(color.substring(4, 6), 16);
        int b=  Integer.valueOf(color.substring(6, 8), 16);
        String rgb = r + "," + g + "," + b;

        facade.addBudgetPost(name, Double.parseDouble(maxAmount), rgb);
    }

}
