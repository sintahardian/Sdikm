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
import application.model.DataSurat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class SuratController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton btnKeluar;

    @FXML
    private JFXTextField nomersurat;

    @FXML
    private JFXComboBox<String> jenissurat;

    @FXML
    private JFXTextArea keterangan;

    @FXML
    private JFXDatePicker tanggalsurat;
    @FXML
    private JFXButton btnSaveSurat;

    @FXML
    private TableView<DataSurat> tablesurat;

    @FXML
    private TableColumn<DataSurat, Integer> columnidsurat;

    @FXML
    private TableColumn<DataSurat, String> columnnomersurat;

    @FXML
    private TableColumn<DataSurat, String> columnjenissurat;

    @FXML
    private TableColumn<DataSurat, String> columnketerangansurat;
    
    @FXML
    private TableColumn<DataSurat, Date> columntanggalsurat;
    
    
    private String[] aJenisSurat = {"Surat Masuk", "Surat Keluar"};
    private FXMLLoader loader;
    private String query;
    private int idDataSurat;
    Dao dao;
    private Map<String, Object> map;
    private boolean EDIT = false, ADD = true;
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	dao = new Dao();
    	initSurat();
    	refreshTableSurat();
    	
    	jenissurat.getSelectionModel().clearAndSelect(0);
    	btnSaveSurat.setOnAction(event -> saveDataSurat());
		
	}
    
    
    private void initSurat() {
        List<String> list = new ArrayList<String>();
        for (String content : aJenisSurat) {
            list.add(content);
        }
        @SuppressWarnings("rawtypes")
		ObservableList observableList = FXCollections.observableArrayList(list);
        jenissurat.setItems(observableList);
    }
    
 
    public void saveDataSurat() {
		 	String nomerSurat = nomersurat.getText();
	        String jenisSurat = jenissurat.getSelectionModel().getSelectedItem();
	        String keteranganSurat = keterangan.getText();
	        java.sql.Date tanggalSurat = java.sql.Date.valueOf(tanggalsurat.getValue());
	        
	        if (EDIT) {//if editng btn is press
	            query = "UPDATE " + Const.DATASURAT_TABLE + " SET " + Const.DATASURAT_NOMERSURAT + "='" + nomerSurat + "', " + Const.DATASURAT_JENISSURAT + "='" +
	            		jenisSurat + "', " + Const.DATASURAT_KETERANGAN + "='" + keteranganSurat + "', " + Const.DATASURAT_TANGGAL + "='" + tanggalSurat + "', " +"' WHERE " + Const.DATASURAT_ID + "=" + idDataSurat + "";
	            System.out.println("edit");
	        } else if (ADD) {//ii add btn is press
	            query = "INSERT INTO " + Const.DATASURAT_TABLE + " VALUES(null, '" +
	            		nomerSurat + "', '" + jenisSurat + "', '" + keteranganSurat + "','" + tanggalSurat +"');";
	            System.out.println("save");
	        }
	        dao.saveData(query);
	        refreshTableSurat();
	}
    
    private void initDataSurat() {
    	columnidsurat.setCellValueFactory(cell -> cell.getValue().getSuratID().asObject());
    	columnnomersurat.setCellValueFactory(cell -> cell.getValue().getNomerSurat());
    	columnjenissurat.setCellValueFactory(cell -> cell.getValue().getJenisSurat());
    	columnketerangansurat.setCellValueFactory(cell -> cell.getValue().getKeteranganSurat());
    	columntanggalsurat.setCellValueFactory(cell -> cell.getValue().getTanggalSurat());

	    }
    
    private void refreshTableSurat() {
    	initDataSurat();
	     query = "SELECT " + Const.DATASURAT_ID + ", " + Const.DATASURAT_NOMERSURAT + ", " + Const.DATASURAT_JENISSURAT + ", "+Const.DATASURAT_KETERANGAN+ ", "+Const.DATASURAT_TANGGAL+ " FROM "+ Const.DATASURAT_TABLE + "";
	     tablesurat.setItems(dao.getDataSurat(query));
	 }
}
