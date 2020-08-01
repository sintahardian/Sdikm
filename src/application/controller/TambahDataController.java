package application.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.collections.MappingChange.Map;

import application.database.Const;
import application.database.Dao;
import application.model.DataGuru;
import application.model.DataKegiatan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	    private JFXTextField fieldNik;

	    @FXML
	    private JFXTextField fieldTelepon;

	    @FXML
	    private JFXComboBox<String> dropdownJabatan;

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
	    private TableView<DataGuru> tableDataGuru;

	    @FXML
	    private TableColumn<DataGuru, Integer> columnIdDataGuru;

	    @FXML
	    private TableColumn<DataGuru, String> columnNamaDataGuru;

	    @FXML
	    private TableColumn<DataGuru, String> columnNikDataGuru;

	    @FXML
	    private TableColumn<DataGuru, String> columnTeleponDataGuru;

	    @FXML
	    private TableColumn<DataGuru, String> columnJabatanDataGuru;

	    @FXML
	    private TableColumn<DataGuru, String> columnAlamatDataGuru;

	    @FXML
	    private TableColumn<DataGuru, Date> columnTanggalDataGuru;

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
	    private TableView<DataGuru> tableDataGuruKegiatan;

	    @FXML
	    private TableColumn<DataGuru, Integer> columnIdDataGuruKegiatan;

	    @FXML
	    private TableColumn<DataGuru, String> columnNamaDataGuruKegiatan;

	    @FXML
	    private TableColumn<DataGuru, String> columnJabatanDataGuruKegiatan;

	    @FXML
	    private JFXTextField fieldCariKegiatan;

	    @FXML
	    private JFXButton btnCariKegiatan;

	    @FXML
	    private JFXButton btnTambahKegiatan;

	    @FXML
	    private TableView<DataKegiatan> tableKegiatan;

	    @FXML
	    private TableColumn<DataKegiatan, Integer> columnIdDataKegiatan;

	    @FXML
	    private TableColumn<DataKegiatan, String> columnNamaDataKegiatan;

	    @FXML
	    private TableColumn<DataKegiatan, String> columnKegiatanDataKegiatan;

	    @FXML
	    private TableColumn<DataKegiatan, Date> columnTanggalDataKegiatan;

	    private String[] aJabatan = {"Guru", "Kepala Sekolah", "Wakil Kepala Sekolah"};
	    
	    private FXMLLoader loader;
	    private String query;
	    private int dataGuruID, iddatakegiatan;
	    Dao dao;
	    private Map<String, Object> map;
	    private boolean EDIT = false, ADD = true;
	    
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	     
		dao = new Dao();
		initJabatan();
		refreshTable();
		initDataGuru();
		refreshTableDataGuruKegiatan();
		refreshTableKegiatan();
		
		dropdownJabatan.getSelectionModel().clearAndSelect(0);
		
		btnEditDataGuru.setOnAction(event -> {
            ADD = false;
            EDIT = true;
            editDataGuru();
        });
		btnTambahKegiatan.setOnAction(event -> {
			addGuruDataKegiatan();
		});
		btnSaveDataGuru.setOnAction(event -> saveDataGuru());
		btnSaveDataKegiatan.setOnAction(event -> saveDataKegiatan());
	}
	 private void initJabatan() {
	        List<String> list = new ArrayList<String>();
	        for (String content : aJabatan) {
	            list.add(content);
	        }
	        @SuppressWarnings("rawtypes")
			ObservableList observableList = FXCollections.observableArrayList(list);
	        dropdownJabatan.setItems(observableList);
	    }
	 private void refreshTable() {
		 initDataGuru();
//	        String text = tf_findcustomer.getText();
//	        if (text.equals("")) {
	            query = "SELECT * FROM " + Const.DATAGURU_TABLE + "";
//	        } else {
//	            query = "SELECT " + Const.CUSTOMER_ID + ", " + Const.CUSTOMER_NAME + "," + Const.CUSTOMER_EMAIL + "," + Const.CUSTOMER_PHONENUMBER + "," + Const.CUSTOMER_GENDER + "," + Const.CUSTOMER_ADDRESS + " FROM " + Const.CUSTOMER_TABLE + " WHERE " + Const.CUSTOMER_NAME + " LIKE '%" + text + "%'";
//	        }
	            tableDataGuru.setItems(dao.getDataGuru(query));
	    }
	 private void initDataGuru() {
		 columnIdDataGuru.setCellValueFactory(cell -> cell.getValue().getGuruID().asObject());
		 columnNamaDataGuru.setCellValueFactory(cell -> cell.getValue().getNamaGuru());
		 columnNikDataGuru.setCellValueFactory(cell -> cell.getValue().getNikGuru());
		 columnTeleponDataGuru.setCellValueFactory(cell -> cell.getValue().getTelepon());
		 columnJabatanDataGuru.setCellValueFactory(cell -> cell.getValue().getjabatan());
		 columnAlamatDataGuru.setCellValueFactory(cell -> cell.getValue().getAlamat());
		 columnTanggalDataGuru.setCellValueFactory(cell -> cell.getValue().getDate());

	    }
	 public void saveDataGuru() {
		 String dataGuruNama = fieldNama.getText();
	        String dataGuruNik= fieldNik.getText();
	        String dataGuruTelepon = fieldTelepon.getText();
	        String dataGuruJabatan = dropdownJabatan.getSelectionModel().getSelectedItem();
	        String dataGuruAlamat = fieldAlamat.getText();
	        java.sql.Date dataGuruJoin = java.sql.Date.valueOf(dateGabung.getValue());
	        
	        if (EDIT) {//if editng btn is press
	            query = "UPDATE " + Const.DATAGURU_TABLE + " SET " + Const.DATAGURU_NAMA + "='" + dataGuruNama + "', " + Const.DATAGURU_NIK + "='" +
	            		dataGuruNik + "', " + Const.DATAGURU_TELEPON + "='" + dataGuruTelepon + "', " + Const.DATAGURU_JABATAN + "='" + dataGuruJabatan + "', " + Const.DATAGURU_ALAMAT + "='" + dataGuruAlamat + Const.DATAGURU_JOIN + "='" + dataGuruJoin +"' WHERE " + Const.DATAGURU_ID + "=" + dataGuruID + "";
	            System.out.println("edit");
	        } else if (ADD) {//ii add btn is press
	            query = "INSERT INTO " + Const.DATAGURU_TABLE + " VALUES(null, '" +
	            		dataGuruNama + "', '" + dataGuruNik + "', '" + dataGuruTelepon + "','" + dataGuruJabatan + "','" + dataGuruAlamat + "','"+dataGuruJoin+"');";
	            System.out.println("save");
	        }
	        dao.saveData(query);
	        refreshTable();
	}
	 private void editDataGuru() {
        DataGuru selected = tableDataGuru.getSelectionModel().getSelectedItem();
        dataGuruID = selected.getGuruID().get();
        fieldNama.setText(selected.getNamaGuru().get());
        fieldNik.setText(selected.getNikGuru().get());
        fieldTelepon.setText(selected.getTelepon().get());
        dropdownJabatan.getSelectionModel().select(selected.getjabatan().get());
        fieldAlamat.setText(selected.getAlamat().get());
        
    }

	 //==========================kegiatan================
	 private void initDataGuruKegiatan() {
		 columnIdDataGuruKegiatan.setCellValueFactory(cell -> cell.getValue().getGuruID().asObject());
		 columnNamaDataGuruKegiatan.setCellValueFactory(cell -> cell.getValue().getNamaGuru());
		 columnJabatanDataGuruKegiatan.setCellValueFactory(cell -> cell.getValue().getjabatan());
	    }
	 
	 private void initDataKegiatan() {
		 columnIdDataKegiatan.setCellValueFactory(cell -> cell.getValue().getKegiatanID().asObject());
		 columnNamaDataKegiatan.setCellValueFactory(cell -> cell.getValue().getKegiatanNamaGuru());
		 columnKegiatanDataKegiatan.setCellValueFactory(cell -> cell.getValue().getKegiatan());
		 columnTanggalDataKegiatan.setCellValueFactory(cell -> cell.getValue().getTanggalKegiatan());
	    }
	 
	 private void refreshTableDataGuruKegiatan() {
		 initDataGuruKegiatan();
	     query = "SELECT " + Const.DATAGURU_ID + ", " + Const.DATAGURU_NAMA + ", " + Const.DATAGURU_JABATAN +" FROM "+ Const.DATAGURU_TABLE + "";
	     tableDataGuruKegiatan.setItems(dao.getDataGuruKegiatan(query));
	 }
	 
	 private void refreshTableKegiatan() {
		 initDataKegiatan();
	     query = "SELECT " + Const.DATAKEGIATAN_ID + ", " + Const.DATAKEGIATAN_NAMAGURU + ", " + Const.DATAKEGIATAN_KEGIATAN + ", "+Const.DATAKEGIATAN_TANGGALKEGIATAN+ " FROM "+ Const.DATAKEGIATAN_TABLE + "";
	     tableKegiatan.setItems(dao.getDataKegiatan(query));
	 }
	 
	 
	 private void addGuruDataKegiatan() {
	        DataGuru selected = tableDataGuruKegiatan.getSelectionModel().getSelectedItem();
	        fieldNamaDataKegiatan.setText(String.valueOf(selected.getNamaGuru().get()));
	    }

	 public void saveDataKegiatan() {
		 String dataNamaGuruKegiatan = fieldNamaDataKegiatan.getText();
	        String dataKegiatanGuruKegiatan= fieldKegiatanDataKegiatan.getText();
	        String dataKeteranganGuruKegiatan = fieldKeteranganDataKegiatan.getText();
	        java.sql.Date dataTanggalGuruKegiatan = java.sql.Date.valueOf(dateDataKegiatan.getValue());
	        
	        if (EDIT) {//if editng btn is press
	            query = "UPDATE " + Const.DATAKEGIATAN_TABLE + " SET " + Const.DATAKEGIATAN_NAMAGURU + "='" + dataNamaGuruKegiatan + "', " + Const.DATAKEGIATAN_KEGIATAN + "='" +
	            		dataKegiatanGuruKegiatan + "', " + Const.DATAKEGIATAN_KETERANGAN + "='" + dataKeteranganGuruKegiatan + "', " + Const.DATAKEGIATAN_TANGGALKEGIATAN + "='" + dataTanggalGuruKegiatan + "', " +"' WHERE " + Const.DATAKEGIATAN_ID + "=" + iddatakegiatan + "";
	            System.out.println("edit");
	        } else if (ADD) {//ii add btn is press
	            query = "INSERT INTO " + Const.DATAKEGIATAN_TABLE + " VALUES(null, '" +
	            		dataNamaGuruKegiatan + "', '" + dataKegiatanGuruKegiatan + "', '" + dataKeteranganGuruKegiatan + "','" + dataTanggalGuruKegiatan + "');";
	            System.out.println("save");
	        }
	        dao.saveData(query);
	        refreshTable();
	}

}
