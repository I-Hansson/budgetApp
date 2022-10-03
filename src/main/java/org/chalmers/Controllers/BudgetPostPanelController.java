package org.chalmers.Controllers;


import javafx.scene.paint.Color;
import org.chalmers.OverviewBudgetPost;
import org.chalmers.model.Budget;
import org.chalmers.model.BudgetPost;

import java.util.ArrayList;
import java.util.List;

public class BudgetPostPanelController {
    private List<BudgetPost> budgets = new ArrayList<BudgetPost>( );
    private List<OverviewBudgetPost> budgetPostCards = new ArrayList<OverviewBudgetPost>();

    public BudgetPostPanelController (){

        BudgetPost budget1 = new BudgetPost("Matvaror",3000);
        BudgetPost budget2 = new BudgetPost("Kläder",500);
        BudgetPost budget3 = new BudgetPost("Transport",1500);
        BudgetPost budget4 = new BudgetPost("Fika",300);
        BudgetPost budget5 = new BudgetPost("Resturang", 800);


        budgets.add(budget1);
        budgets.add(budget2);
        budgets.add(budget3);
        budgets.add(budget4);
        budgets.add(budget5);
        budget1.setCurrentBalance(1000);
        budget2.setCurrentBalance(99);
        budget3.setCurrentBalance(1000);
        budget4.setCurrentBalance(110);

        budget1.setColor(Color.color(0.02,0.20,0.36));
        budget1.setComplementColorColor(Color.color(0.2,0.30,0.53));

        budget2.setColor(Color.color(0.06,0.34,0.31));
        budget2.setComplementColorColor(Color.color(0.09,0.44,0.40));


        budget3.setColor(Color.color(0.12,0.47,0.74));
        budget3.setComplementColorColor(Color.color(0.14,0.53,0.83));

        budget4.setColor(Color.color(0.65,0.83,0.89));
        budget4.setComplementColorColor(Color.color( 0.8,0.9,0.97));
        budget5.setColor(Color.color(0.65,0.83,0.89));
        budget5.setComplementColorColor(Color.color( 0.8,0.9,0.97));
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
