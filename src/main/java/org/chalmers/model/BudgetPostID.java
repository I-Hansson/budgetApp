package org.chalmers.model;

/**
 * This class represents an ID for a budget post.
 * Its purpose is to loosen dependencies between Transaction and BudgetPost
 * <p>
 * Used by: Transaction, BudgetPost
 *
 * @author Isac Hansson
 */
public class BudgetPostID {

    private String name;
    private final String color;


    public BudgetPostID(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setName (String newName){
        this.name = newName;
    }

}
