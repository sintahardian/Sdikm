package application.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {


    @FXML
    private Button btn;

    @FXML
    void evtButton(ActionEvent event) {
    	System.out.println("ok");
    }
}
