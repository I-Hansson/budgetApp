package org.chalmers.model;

import java.util.Collection;

/**
 * An interface for classes which contain a collection of budget posts
 *
 * @author williamfrisk
 */
public interface IHasBudgetPosts {
    /**
     * Adds an IBudgetPost to the collection of IBudgetPost.
     * @param bp The IBudgetPost to be added.
     */
    void addBudgetPost(IBudgetPost bp);

    /**
     * Returns a collection of IBudgetPost.
     * @return The collection of IBudgetPost.
     */
    Collection<IBudgetPost> getBudgetPosts();
}
