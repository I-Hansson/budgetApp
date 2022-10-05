package org.chalmers.model.charts;

import org.chalmers.model.BudgetPost;
import org.chalmers.model.Transaction;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ChartTypePie implements IChart<String, Integer> {

    private final Map<String, Integer> data;

    public ChartTypePie() {
        this.data = new HashMap<>();
    }

    @Override
    public Map<String, Integer> getDataMap() {
        return data;
    }

    @Override
    public void update(Collection<Transaction> transactions) {
        for(Transaction transaction : transactions){
            if(transaction.getAmount() != 0){
                BudgetPost budgetPost = transaction.getBudgetPost();
                if (data.containsKey(budgetPost.getName())) {
                    int temp = data.get(budgetPost.getName()) + (int) transaction.getAmount();
                    data.put(budgetPost.getName(), temp);
                } else {
                    data.put(budgetPost.getName(), (int) transaction.getAmount());
                }
            }
        }
    }
}
