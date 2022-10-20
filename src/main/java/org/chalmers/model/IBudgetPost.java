package org.chalmers.model;

/**
 * An interface for classes that represent the concept of a budget post
 *
 * @author williamfrisk
 */
public interface IBudgetPost extends IHasTransactions, IHasBalance, IHasBudgetCap{
    /**
     * Returns a string with format "R, G, B" used for displaying color.
     * @return The string containing RGB values.
     */
    String getColor();

    /**
     * Returns the name of the budget post.
     * @return The name.
     */
    String getName();

    /**
     * Returns an object that represents the id of the budget post which contains name and color.
     * @return The object containing name and color.
     */
    BudgetPostID getId();
}
