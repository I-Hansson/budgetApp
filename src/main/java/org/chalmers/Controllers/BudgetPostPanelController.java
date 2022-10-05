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
    Budget budget = new Budget();
    public BudgetPostPanelController (){

        /*BudgetPost budget1 = new BudgetPost("Matvaror",3000, "5, 51, 92");
        BudgetPost budget2 = new BudgetPost("Kläder",500, "15, 87, 79");
        BudgetPost budget3 = new BudgetPost("Transport",1500, "31, 120, 189");
        BudgetPost budget4 = new BudgetPost("Fika",300, "166, 212, 227");
        BudgetPost budget5 = new BudgetPost("Resturang", 800, "166, 212, 227");




        budgets.add(budget1);
        budgets.add(budget2);
        budgets.add(budget3);
        budgets.add(budget4);
        budgets.add(budget5);*/
        budget.getBudgetPosts().get(0).setCurrentBalance(1000);
        budget.getBudgetPosts().get(1).setCurrentBalance(99);
        budget.getBudgetPosts().get(2).setCurrentBalance(100);
        budget.getBudgetPosts().get(3).setCurrentBalance(110);


        createBudgetPostCards();
    }
    public List<BudgetPost> getBudgetPosts(){
        return this.budgets;
    }
    public List<OverviewBudgetPost> getBudgetPostCards(){
        return this.budgetPostCards;
    }
    public  void createBudgetPostCards(){
        for (BudgetPost i : budget.getBudgetPosts()){
            double moneyLeft = 0;
            if (i.getBudgetCap()-i.getCurrentBalance() > 0){
                moneyLeft = i.getBudgetCap()-i.getCurrentBalance();
            }
            budgetPostCards.add(new OverviewBudgetPost(i.getName(),String.valueOf(moneyLeft), i.getCurrentBalance()/i.getBudgetCap(),i.getColor(),getComplementColor(i.getColor())));
        }

    }
    public String getComplementColor(String rgb) {
            Color color = Color.web("rgb(" + rgb + ")");
            Color newColor = color.brighter();
        return ""+newColor.getRed()*255+"," + newColor.getGreen()*255 +","+ newColor.getBlue()*255;
    }

}
