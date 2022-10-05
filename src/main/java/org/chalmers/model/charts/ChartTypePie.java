package org.chalmers.model.charts;

import org.chalmers.model.IBudgetPostsObserver;
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
            if( transaction.getAmount() != 0){
                String budgetPostName = transaction.getBudgetPostName();
                if (data.containsKey(budgetPostName)) {
                    int temp = data.get(budgetPostName) + (int) transaction.getAmount();
                    data.put(budgetPostName, temp);
                } else {
                    data.put(budgetPostName, (int) transaction.getAmount());
                }
            }
        }
    }
}
