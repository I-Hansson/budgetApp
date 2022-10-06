package org.chalmers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.chalmers.model.User;
import org.chalmers.model.database.BudgetPostsDB;
import org.chalmers.model.database.UsersDB;

import java.io.IOException;
import java.util.Objects;

/**
 * JavaFX App
 */
public class App extends Application{

    public void start (Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load((getClass().getResource("LogInPage.fxml")));
        primaryStage.setTitle("SAFE BOAT");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
        UsersDB db = new UsersDB(0);
        db.addBudgetPost("mat");
    }

}