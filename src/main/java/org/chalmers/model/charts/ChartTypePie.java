package org.chalmers.model.charts;

import org.chalmers.model.ITransaction;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This class gives functionality for displaying pie charts.
 * Depends on Transaction.
 *
 * @author williamfrisk
 */
public class ChartTypePie {

    private final Map<String, Integer> data;

    ChartTypePie() {
        this.data = new HashMap<>();
    }

    /**
     * Returns a Map containing the BudgetPost names and appurtunent amount spent.
     * @return The Map with BudgetPost names and amounts.
     */
    public Map<String, Integer> getDataMap() {
        return data;
    }

    /**
     * Updates the data in the line chart with a given collection of transactions.
     * @param transactions The collection of transaction which are used for the update.
     */
    public void update(Collection<ITransaction> transactions) {
        data.clear();
        for(ITransaction transaction : transactions){

            if(transaction.getAmount() != 0){
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
