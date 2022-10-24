package org.chalmers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Managing all the functionality regarding switching view.
 * @author Jonathan.
 * Should be in controller package but the class is not able to find fxml files when it's
 * placed in the controller package.
 */


public class SceneController { // Should be in controller package but cant find fxml file then...

    public SceneController(){}

    private void getStage(MouseEvent event, String view){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(view));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException e){
            System.out.println(e);
    }
}

    /**
     * Loads the view for the Budget Post View.
     * @param event The event from the user interaction.
     */
    public void budgetPostView(MouseEvent event){getStage(event,"BudgetPostsView.fxml");}

    /**
     * Loads the view for the Overview View.
     * @param event The event from the user interaction.
     */

    public void overviewView(MouseEvent event){
        getStage(event,"Overview.fxml");
    }

    /**
     * Loads the view for the Budget Post Detailed View.
     * @param event The event from the user interaction.
     */

    public void budgetPostDetailed(MouseEvent event){
        getStage(event,"BudgetPostDetailedView.fxml");
    }

    /**
     * Loads the view for the Past Transaction View.
     * @param event The event from the user interaction.
     */

    public void pastTransaction(MouseEvent event){
        getStage(event,"PastTransactionView.fxml");
    }

    /**
     * Loads the view for the Add Transaction View.
     * @param event The event from the user interaction.
     */
    public void addTransaction(MouseEvent event){
        getStage(event,"AddTransaction.fxml");
    }



}
