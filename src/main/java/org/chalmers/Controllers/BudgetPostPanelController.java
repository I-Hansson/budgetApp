package org.chalmers.Controllers;


import javafx.scene.paint.Color;
import org.chalmers.OverviewBudgetPost;
import org.chalmers.model.BudgetPost;

import java.util.ArrayList;
import java.util.List;

public class BudgetPostPanelController {
    private List<BudgetPost> budgets = new ArrayList<BudgetPost>( );
    private List<OverviewBudgetPost> budgetPostCards = new ArrayList<OverviewBudgetPost>();

    public BudgetPostPanelController (){

        BudgetPost budget1 = new BudgetPost("Matvaror",3000, Color.color(0.02, 0.20, 0.36));
        BudgetPost budget2 = new BudgetPost("Kläder",500, Color.color(0.06,0.34,0.31));
        BudgetPost budget3 = new BudgetPost("Transport",1500,  Color.color(0.12,0.47,0.74));
        BudgetPost budget4 = new BudgetPost("Fika",300, Color.color(0.02, 0.20, 0.36));
        BudgetPost budget5 = new BudgetPost("Resturang", 800, Color.color(0.65,0.83,0.89));
        
        budgets.add(budget1);
        budgets.add(budget2);
        budgets.add(budget3);
        budgets.add(budget4);
        budgets.add(budget5);
        budget1.setCurrentBalance(1000);
        budget2.setCurrentBalance(99);
        budget3.setCurrentBalance(1000);
        budget4.setCurrentBalance(110);


        createBudgetPostCards();
    }
    public List<BudgetPost> getBudgetPosts(){
        return this.budgets;
    }
    public List<OverviewBudgetPost> getBudgetPostCards(){
        return this.budgetPostCards;
    }
    public  void createBudgetPostCards(){
        for (BudgetPost i : budgets){
            double moneyLeft = 0;
            if (i.getBudgetCap()-i.getCurrentBalance() > 0){
                moneyLeft = i.getBudgetCap()-i.getCurrentBalance();
            }
            budgetPostCards.add(new OverviewBudgetPost(i.getName(),String.valueOf(moneyLeft), i.getCurrentBalance()/i.getBudgetCap(), i.getColor(),i.getComplementColor()));
        }

    }
}
