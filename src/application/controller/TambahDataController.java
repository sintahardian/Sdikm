package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class TambahDataController implements Initializable{
	
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private JFXButton btnKeluarTambahData;

	    @FXML
	    private JFXTextField fieldNama;

	    @FXML
	    private HBox fieldNik;

	    @FXML
	    private JFXTextField fieldTelepon;

	    @FXML
	    private JFXComboBox<?> dropdownJabatan;

	    @FXML
	    private JFXTextArea fieldAlamat;

	    @FXML
	    private JFXDatePicker dateGabung;

	    @FXML
	    private JFXButton btnSaveDataGuru;

	    @FXML
	    private JFXButton btnEditDataGuru;

	    @FXML
	    private JFXButton btnDeleteDataGuru;

	    @FXML
	    private JFXButton btnResetDataGuru;

	    @FXML
	    private TableView<?> tableDataGuru;

	    @FXML
	    private TableColumn<?, ?> columnIdDataGuru;

	    @FXML
	    private TableColumn<?, ?> columnNamaDataGuru;

	    @FXML
	    private TableColumn<?, ?> columnNikDataGuru;

	    @FXML
	    private TableColumn<?, ?> columnTeleponDataGuru;

	    @FXML
	    private TableColumn<?, ?> columnJabatanDataGuru;

	    @FXML
	    private TableColumn<?, ?> columnAlamatDataGuru;

	    @FXML
	    private TableColumn<?, ?> columnTanggalDataGuru;

	    @FXML
	    private JFXTextField fieldNamaDataKegiatan;

	    @FXML
	    private JFXTextField fieldKegiatanDataKegiatan;

	    @FXML
	    private JFXTextArea fieldKeteranganDataKegiatan;

	    @FXML
	    private JFXDatePicker dateDataKegiatan;

	    @FXML
	    private JFXButton btnSaveDataKegiatan;

	    @FXML
	    private JFXButton btnEditDataKegiatan;

	    @FXML
	    private JFXButton btnDeleteDataKegiatan;

	    @FXML
	    private JFXButton btnResetDataKegiatan;

	    @FXML
	    private TableView<?> tableDataGuruKegiatan;

	    @FXML
	    private TableColumn<?, ?> columnIdDataGuruKegiatan;

	    @FXML
	    private TableColumn<?, ?> columnNamaDataGuruKegiatan;

	    @FXML
	    private TableColumn<?, ?> columnJabatanDataGuruKegiatan;

	    @FXML
	    private JFXTextField fieldCariKegiatan;

	    @FXML
	    private JFXButton btnCariKegiatan;

	    @FXML
	    private JFXButton btnTambahKegiatan;

	    @FXML
	    private TableView<?> tableKegiatan;

	    @FXML
	    private TableColumn<?, ?> columnIdDataKegiatan;

	    @FXML
	    private TableColumn<?, ?> columnNamaDataKegiatan;

	    @FXML
	    private TableColumn<?, ?> columnKegiatanDataKegiatan;

	    @FXML
	    private TableColumn<?, ?> columnTanggalDataKegiatan;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
