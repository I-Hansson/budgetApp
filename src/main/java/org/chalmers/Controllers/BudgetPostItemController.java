package org.chalmers.Controllers;


import org.chalmers.BudgetPostsItem;
import org.chalmers.model.IBudgetPost;
import org.chalmers.model.ModelFacade;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for the view class BudgetPostItem.
 *
 * @author Jonathan
 */

public class BudgetPostItemController {
    List<BudgetPostsItem> item = new ArrayList<>();
    ModelFacade facade = ModelFacade.getInstance();
    public BudgetPostItemController(){
        createBudgetItems();
    }

    public List<BudgetPostsItem> getItem() {
        return item;
    }
    public void createBudgetItems(){
        item.clear();
        for (IBudgetPost bp: facade.getBudgetPosts()){
            item.add(new BudgetPostsItem(
                    bp.getName(),
                    "descrition",
                    bp.getBudgetCap(),
                    bp.getTransactions().size(),
                    bp.getColor()
            ));
        }
    }
}
