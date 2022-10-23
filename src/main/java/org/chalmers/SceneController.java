package org.chalmers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class SceneController { // Should be in controller package but cant find fxml file then...

    public SceneController(){}

    public void getStage(MouseEvent event, String view){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(view));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (Exception e){
            System.out.println(e);
    }
}

    public void budgetPostView(MouseEvent event){getStage(event,"BudgetPostsView.fxml");}
    public void overviewView(MouseEvent event){
        getStage(event,"Overview.fxml");
    }
    public void budgetPostDetailed(MouseEvent event){
        getStage(event,"BudgetPostDetailed.fxml");
    }
    public void pastTransaction(MouseEvent event){
        getStage(event,"PastTransactionView.fxml");
    }
    public void addTransaction(MouseEvent event){
        getStage(event,"AddTransaction.fxml");
    }



}
