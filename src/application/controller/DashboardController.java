package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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

    }

    @FXML
    void gotoTambahData(ActionEvent event) {

    }
   

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		assert btnPenilaian != null : "fx:id=\"btnPenilaian\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert btnSurat != null : "fx:id=\"btnSurat\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert btnTambahData != null : "fx:id=\"btnTambahData\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert btnLaporan != null : "fx:id=\"btnLaporan\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert btnKeluar != null : "fx:id=\"btnKeluar\" was not injected: check your FXML file 'Dashboard.fxml'.";
		
	}
}
