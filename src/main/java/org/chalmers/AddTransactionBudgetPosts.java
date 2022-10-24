package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

/**
 * Acts as the view class of Add Transaction Budget Posts.
 *
 * @author Jonathan
 */

public class AddTransactionBudgetPosts extends AnchorPane {

    private static Toggle selectedButton;

    @FXML RadioButton budgetPost;

    static ToggleGroup toggleGroup = new ToggleGroup();


    /**
     *
     * Creates the dynamic view.
     * @param name The specific budget post name.
     */

    public AddTransactionBudgetPosts(String name) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddTransactionBudgetPosts.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        budgetPost.setText(name);
        budgetPost.setToggleGroup(toggleGroup);

    }


    /**
     * Returns the selected budget post for the new transaction.
     * @return the value of the selected budget post as a String.
     */

    public static String getGroupValue(){
        RadioButton selectedButton = (RadioButton) toggleGroup.getSelectedToggle();
        return selectedButton.getText();
    }


}
