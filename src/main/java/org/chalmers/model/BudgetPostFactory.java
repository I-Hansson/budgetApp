package org.chalmers.model;

/**
 * @author williamfrisk
 * This class instantiates new BudgetPost instances and allows for
 * a simpler interface than the BudgetPost constructor.
 */
public class BudgetPostFactory {

    private static Color currentColor = Color.RED;

    public static BudgetPost createBudgetPost(String name) {
        BudgetPost bp = new BudgetPost(name, 0);
        currentColor = currentColor.next();
        return bp;
    }

    public static BudgetPost createBudgetPost(String name, double budgetCap) {
        BudgetPost bp = new BudgetPost(name, budgetCap);
        currentColor = currentColor.next();
        return bp;
    }

    public static BudgetPost createBudgetPost(String name, double budgetCap, Color color) {
        BudgetPost bp = new BudgetPost(name, budgetCap);
        bp.setColor(color);
        return bp;
    }
}
