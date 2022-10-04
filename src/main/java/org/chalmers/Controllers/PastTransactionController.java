package org.chalmers.Controllers;

import org.chalmers.OverviewBudgetPost;
import org.chalmers.PastTransactionItem;
import org.chalmers.PastTransactionView;
import org.chalmers.model.Budget;
import org.chalmers.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PastTransactionController {

    Budget budget = new Budget();
    private List<PastTransactionItem>  pastTransactionItemList = new ArrayList<PastTransactionItem>();
    public PastTransactionController(){

        budget.addTransaction("Uber",100,budget.getBudgetPosts().get(1),"JKPG to GBG");
        budget.addTransaction("ICA",100,budget.getBudgetPosts().get(0),"milk, sugar");
        budget.addTransaction("H&M",100,budget.getBudgetPosts().get(2),"T-shirt");
        for(Transaction t : budget.getRecentTransactions()){
            pastTransactionItemList.add(new PastTransactionItem(t));
        }

    }

    public List<PastTransactionItem> getPastTransactionItemList() {
        return this.pastTransactionItemList;
    }
}
