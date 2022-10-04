package org.chalmers.model.charts;

import org.chalmers.model.BudgetPost;
import org.chalmers.model.Transaction;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class ChartTypePie implements IChart<String, Integer> {

    private final Map<String, Integer> data;

    ChartTypePie() {
        this.data = new HashMap<>();
    }

    @Override
    public Map<String, Integer> getDataMap() {
        return data;
    }

    @Override
    public void update(Collection<Transaction> transactions) {
        for(Transaction transaction : transactions){
            if( transaction.getAmount() != 0){
                BudgetPost budgetPostName = transaction.getBudgetPost();
                if (data.containsKey(budgetPostName.getName())) {
                    int temp = data.get(budgetPostName) + (int) transaction.getAmount();
                    data.put(budgetPostName.getName(), temp);
                } else {
                    data.put(budgetPostName.getName(), (int) transaction.getAmount());
                }
            }
        }
    }
}
