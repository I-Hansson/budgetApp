package org.chalmers.model;

/**
 * An interface for classes representing the concept of a transaction
 *
 * @author williamfrisk
 */
public interface ITransaction extends IHasDate{

    /**
     * Returns the double amount of the ITransaction. Negative means income.
     * @return The amount.
     */
    double getAmount();

    /**
     * Returns the name of the ITransaction.
     * @return The name.
     */
    String getName();

    /**
     * Returns the description of the ITransaction.
     * @return The description.
     */
    String getDescription();

    /**
     * Returns the name of the budget post to which the ITransaction belongs to.
     * @return The name of the budget post.
     */
    String getBudgetPostName();

    /**
     * Returns the color of the budget post to which the ITransaction belongs to.
     * @return The name of the budget post.
     */
    String getBudgetPostColor();
}
