package org.chalmers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.chalmers.model.ModelFacade;
import org.chalmers.model.database.Database;

/**
 * JavaFX App
 */
public class App extends Application{
    ModelFacade facade =ModelFacade.getInstance();
    public void start (Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load((getClass().getResource("LogInView.fxml")));
        primaryStage.setTitle("SAFE BOAT");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                try {
                    facade.saveTransactions();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.exit();
                System.exit(0);
            }
        });

    }


    public static void main(String[] args) {
        System.out.println(Database.signIntoDB("oscar.cronvall@outlook.com", "Krokodil123").getEmail());
        System.out.println(Database.signIntoDB("oscar.cronvall@outlook.com", "Krokodil123").matchesPassword("Krokodil123"));

        System.out.println(Database.signIntoDB("svante@cool.com", "swag").getEmail());
        System.out.println(Database.signIntoDB("svante@cool.com", "swag").matchesPassword("swag"));

        System.out.println(Database.signIntoDB("casi@chalmers.it", "litenkuk123"));
        launch(args);
    }

}