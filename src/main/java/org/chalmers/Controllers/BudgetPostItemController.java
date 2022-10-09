package org.chalmers.Controllers;


import org.chalmers.BudgetPostsItem;
import org.chalmers.model.BudgetPost;
import org.chalmers.model.ModelFacade;

import java.util.ArrayList;
import java.util.List;

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
        for (BudgetPost bp: facade.budgetPostsfromUser()){
            item.add(new BudgetPostsItem(bp.getId().getName(),"descrition", bp.getBudgetCap(),bp.getTransactions().size(),bp.getId().getColor()));
        }
    }
}
