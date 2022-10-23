package org.chalmers;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.chalmers.Controllers.LogInController;

import java.io.IOException;

/**
 * @author Jonathan
 */

public class LogInView {

    private LogInController controller = new LogInController();

    @FXML
    TextField userName;
    @FXML
    TextField userPassword;
    @FXML
    TextField nameCreateUserTextField;
    @FXML
    TextField idCreateUserTextField;
    @FXML
    TextField passwordCreateUserTextField;
    @FXML
    Label errorLabelLogInView;

    @FXML
    Button signInButton;
    @FXML
    Text signUpText;

    @FXML
    AnchorPane createUserPane;
    @FXML
    AnchorPane joinAnchorPane;

    SceneController sceneController = new SceneController();

    @FXML
    public void createAccount(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        if (checkInformation()) {
            createUserPane.toBack();
            controller.createUser(
                    nameCreateUserTextField.getText(),
                    idCreateUserTextField.getText(),
                    passwordCreateUserTextField.getText()
            );
            clearInputInfo();
        }
        wrongInformation();
    }

    @FXML
    private void goToCreateAccount(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        createUserPane.toFront();
    }





    @FXML
    private void SwitchToOverviewPage(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        controller.signInUser(userName.getText(), userPassword.getText());

        if (controller.userIsSignedIn()){
            sceneController.overviewView(mouseEvent);
        }
    }

    @FXML
    private void signInButtonOnHover() {
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
    private void signInButtonStopHover() {
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




    private boolean checkInformation() {
        
        if (nameCreateUserTextField.getText().isEmpty()){
            return false;
        }

        if (idCreateUserTextField.getText().isEmpty()){
            return false;
        }
        if (passwordCreateUserTextField.getText().isEmpty()){
            return false;
        }

        for (int i = 0; i < nameCreateUserTextField.getText().length(); i++) {
            if (Character.isDigit(nameCreateUserTextField.getText().charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void wrongInformation(){
        errorLabelLogInView.setTextFill(Paint.valueOf("FF0000"));
        errorLabelLogInView.setText("The information is incorrectly filled out!");
    }

    private void clearInputInfo(){
        errorLabelLogInView.setText("");
        idCreateUserTextField.setText("");
        passwordCreateUserTextField.setText("");
        nameCreateUserTextField.setText("");
    }
}
