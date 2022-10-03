package org.chalmers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.chalmers.model.database.BudgetPostsDB;
import org.chalmers.model.database.UsersDB;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        UsersDB udb = new UsersDB(22230000);
        BudgetPostsDB bdb = new BudgetPostsDB("000001");

        udb.openSetters();
        udb.setUserName("Kalle");
        udb.setNewStandardBalance(420);
        udb.setBalance(69);
        udb.addBudgetPost("Kläder");
        udb.closeSetter();

        launch();
    }

}