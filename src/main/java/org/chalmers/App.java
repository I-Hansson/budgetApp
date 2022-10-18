package org.chalmers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.chalmers.model.ModelFacade;

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
        System.out.println(Color.MAGENTA.darker());
        System.out.println(Color.MAGENTA);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                try {
                    facade.saveTransactions();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                facade.saveBudgetPost();
                Platform.exit();
                System.exit(0);
            }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }

}