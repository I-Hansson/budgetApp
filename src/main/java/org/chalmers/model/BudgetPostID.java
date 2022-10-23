package org.chalmers.model;

/**
 * This class represents an ID for a budget post.
 * Its purpose is to loosen dependencies between Transaction and BudgetPost
 *
 * @author Isac Hansson, Jonathan Svantesson
 */
public class BudgetPostID {

    private String name;
    private String color;


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
