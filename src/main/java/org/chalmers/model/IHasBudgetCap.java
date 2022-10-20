package org.chalmers.model;

/**
 * An interface for classes that feature a budget cap that can be updated
 *
 * @author williamfrisk
 */
public interface IHasBudgetCap {
    /**
     * Sets the budget cap to the given budget cap.
     * @param newCap The new cap.
     */
    void setBudgetCap(double newCap);

    /**
     * @return The budget cap
     */
    double getBudgetCap();
}
