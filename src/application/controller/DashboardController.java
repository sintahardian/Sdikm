package application.controller;

import java.net.URL;
import static javafx.fxml.FXMLLoader.load;

import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardController implements Initializable{
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton btnPenilaian;

    @FXML
    private JFXButton btnSurat;

    @FXML
    private JFXButton btnTambahData;

    @FXML
    private JFXButton btnLaporan;

    @FXML
    private JFXButton btnKeluar;

    @FXML
    void gotoLaporan(ActionEvent event) {

    }

    @FXML
    void gotoPenilaian(ActionEvent event) {

    }

    @FXML
    void gotoSurat(ActionEvent event) {
    	System.out.println("ok");
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();

            Parent root = load(getClass().getResource("../layout/surat.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void gotoTambahData(ActionEvent event) {
    	System.out.println("ok");
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage = new Stage();

            Parent root = load(getClass().getResource("../layout/tambahdata.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
   

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
