package org.chalmers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.chalmers.Controllers.LogInController;

import java.io.IOException;

public class LogInView {

    private LogInController controller = new LogInController();


    @FXML TextField nameCreateUserTextField;
    @FXML TextField idCreateUserTextField;
    @FXML TextField passwordCreateUserTextField;

    @FXML AnchorPane signAnchorPane;
    @FXML Text signUpText;

    @FXML AnchorPane createUserPane;
    @FXML AnchorPane joinAnchorPane;


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void createAccount(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        createUserPane.toBack();
        signAnchorPane.toFront();
        controller.createUser(nameCreateUserTextField.getText(),idCreateUserTextField.getText(), passwordCreateUserTextField.getText());
        signAnchorPane.setDisable(false);


    }

    @FXML
    public void goToCreateAccount(javafx.scene.input.MouseEvent mouseEvent) throws IOException{

        createUserPane.toFront();
        signAnchorPane.toBack();
        signAnchorPane.setDisable(true);

    }



    @FXML
    public void SwitchToOverviewPage(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

}}
