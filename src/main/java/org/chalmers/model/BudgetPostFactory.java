package org.chalmers.model;

import javafx.scene.paint.Color;
/**
 * @author williamfrisk
 * This class instantiates new BudgetPost instances and allows for
 * a simpler interface than the BudgetPost constructor.
 */
public class BudgetPostFactory {

    private static final Color[] colors = {
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.PURPLE,
            Color.GRAY,
            Color.PINK,
            Color.BLACK,
            Color.TURQUOISE,
            Color.CHOCOLATE
    };

    private static int currentColorIndex = 0;

    public static BudgetPost createBudgetPost(String name) {
        BudgetPost bp = new BudgetPost(name, 0);
        bp.setColor(colors[currentColorIndex]);
        currentColorIndex++;
        return bp;
    }

    public static BudgetPost createBudgetPost(String name, double budgetCap) {
        BudgetPost bp = new BudgetPost(name, budgetCap);
        bp.setColor(colors[currentColorIndex]);
        currentColorIndex++;
        return bp;
    }

    public static BudgetPost createBudgetPost(String name, double budgetCap, Color color) {
        BudgetPost bp = new BudgetPost(name, budgetCap);
        bp.setColor(color);
        return bp;
    }
}
