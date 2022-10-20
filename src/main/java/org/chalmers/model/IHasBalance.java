package org.chalmers.model;

/**
 * An interface for classes that feature a balance which can be updated
 *
 * @author williamfrisk
 */
public interface IHasBalance {
    /**
     * Sets the balance to the given balance.
     * @param newBalance The new balance.
     */
    void setCurrentBalance(double newBalance);

    /**
     * @return The balance.
     */
    double getCurrentBalance();
}
