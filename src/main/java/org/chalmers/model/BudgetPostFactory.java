package org.chalmers.model;

/**
 * This class instantiates new BudgetPost instances and allows for
 * a simpler interface than the BudgetPost constructor.
 */
public class BudgetPostFactory {

    public static BudgetPost createBudgetPost(String name) {
        BudgetPost bp = new BudgetPost(0,name,  "5, 51, 92" );
        return bp;
    }

    public static BudgetPost createBudgetPost(String name, double budgetCap) {
        BudgetPost bp = new BudgetPost(budgetCap,name,  "5, 51, 92");
        return bp;
    }

    public static BudgetPost createBudgetPost(String name, double budgetCap, String color) {
        BudgetPost bp = new BudgetPost(budgetCap, name,  color);
        return bp;
    }
}
