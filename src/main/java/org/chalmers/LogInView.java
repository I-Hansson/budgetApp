package org.chalmers;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.chalmers.Controllers.LogInController;
import org.chalmers.model.ModelFacade;

import java.io.IOException;

public class LogInView {

    private LogInController controller = new LogInController();


    @FXML
    TextField nameCreateUserTextField;
    @FXML
    TextField idCreateUserTextField;
    @FXML
    TextField passwordCreateUserTextField;

    @FXML
    Button signInButton;
    @FXML
    Text signUpText;

    @FXML
    AnchorPane createUserPane;
    @FXML
    AnchorPane joinAnchorPane;


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void createAccount(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        createUserPane.toBack();
        controller.createUser(nameCreateUserTextField.getText(), idCreateUserTextField.getText(), passwordCreateUserTextField.getText());
    }

    @FXML
    public void goToCreateAccount(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        createUserPane.toFront();
    }


    @FXML
    public void SwitchToOverviewPage(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        ModelFacade facade = ModelFacade.getInstance(); //todo fix
        facade.connectDB();
        root = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void signInButtonOnHover() {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(100));
        scaleTransition.setCycleCount(1);
        scaleTransition.setFromY(1);
        scaleTransition.setFromX(1);
        scaleTransition.setToY(1.1);
        scaleTransition.setToX(1.1);
        scaleTransition.setNode(signInButton);
        scaleTransition.play();
    }

    @FXML
    public void signInButtonStopHover() {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(100));
        scaleTransition.setCycleCount(1);
        scaleTransition.setFromY(1.1);
        scaleTransition.setFromX(1.1);
        scaleTransition.setToY(1);
        scaleTransition.setToX(1);
        scaleTransition.setNode(signInButton);
        scaleTransition.play();
    }
}
