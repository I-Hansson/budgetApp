package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

/**
 * @author Jonathan
 */

public class AddTransactionBudgetPosts extends AnchorPane {

    private static Toggle selectedButton;

    @FXML RadioButton budgetPost;

    static ToggleGroup toggleGroup = new ToggleGroup();


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

    ///TODO May not be static.

    public static String getGroupValue(){
        RadioButton selectedButton = (RadioButton) toggleGroup.getSelectedToggle();
        return selectedButton.getText();
    }


}
