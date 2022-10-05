package org.chalmers.model;

import javafx.scene.paint.Color;
/**
 * @author williamfrisk
 * This class instantiates new BudgetPost instances and allows for
 * a simpler interface than the BudgetPost constructor.
 */
public class BudgetPostFactory {

    public static BudgetPost createBudgetPost(String name) {
        BudgetPost bp = new BudgetPost(name, 0, "5, 51, 92");
        return bp;
    }

    public static BudgetPost createBudgetPost(String name, double budgetCap) {
        BudgetPost bp = new BudgetPost(name, budgetCap, "5, 51, 92");
        return bp;
    }

    public static BudgetPost createBudgetPost(String name, double budgetCap, String color) {
        BudgetPost bp = new BudgetPost(name, budgetCap, color);
        return bp;
    }
}
