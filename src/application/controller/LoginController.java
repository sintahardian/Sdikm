package application.controller;
import static javafx.fxml.FXMLLoader.load;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.database.DBConnection;
import application.database.Dao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField fieldUsername;

    @FXML
    private JFXPasswordField fieldPassword;

    @FXML
    private JFXButton btnLogin;
    private Dao dao;
    DBConnection connection;
    @FXML
    void goToDashboard(ActionEvent event) {
    	dao = new Dao();
        String username = fieldUsername.getText();
        String password = fieldPassword.getText();
        boolean flag=dao.validate(username,password);
        if (!flag){
        	fieldPassword.setText("");
            fieldUsername.setText("");
            alertTransactionFailed();
        }else {
            try {
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                Parent root = load(getClass().getResource("../layout/Dashboard.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void initialize(URL location, ResourceBundle resources) {
        dao = new Dao();
    }


    private void alertTransactionFailed() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Failed");
        alert.setHeaderText("Failed");
        alert.setContentText("Ooops, Incorrect name or password");

        alert.showAndWait();
    }
}
