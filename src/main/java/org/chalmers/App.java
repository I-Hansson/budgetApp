package org.chalmers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.chalmers.model.ModelFacade;

/**
 * @author Isac Hansson
 * Starts the application
 * Depends on: ModelFacade.
 *
 */
public class App extends Application{
    ModelFacade facade = ModelFacade.getInstance();

    /**
     * Setts the necessary information for the start of the application.
     */

    @Override
    public void start (Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load((getClass().getResource("LogInView.fxml")));
        primaryStage.setTitle("SAFE BOAT");
        Image icon = new Image("file:src/main/resources/org/chalmers/images/logo.jpg");
        primaryStage.getIcons().add(icon);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                try {
                    facade.saveUser();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Platform.exit();
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }

}