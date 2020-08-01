package application.model;

import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataSurat {
	private IntegerProperty suratID;
    private StringProperty nomerSurat;
    private StringProperty jenisSurat;
    private StringProperty keteranganSurat;
    private ObjectProperty<Date> tanggalSurat;


    public DataSurat(int suratID, String nomerSurat,String jenisSurat, String keteranganSurat, Date tanggalSurat) {
    	this.suratID = new SimpleIntegerProperty(suratID);
    	this.nomerSurat = new SimpleStringProperty(nomerSurat);
    	this.jenisSurat = new SimpleStringProperty(jenisSurat);
    	this.keteranganSurat = new SimpleStringProperty(keteranganSurat);
    	this.tanggalSurat = new SimpleObjectProperty<>(tanggalSurat);
    }
    
    
    public IntegerProperty getSuratID() {
    	return suratID;
    }
    public StringProperty getNomerSurat() {
    	return nomerSurat;
    }
    public StringProperty getJenisSurat() {
    	return jenisSurat;
    }
    public StringProperty getKeteranganSurat() {
    	return keteranganSurat;
    }
    public ObjectProperty<Date> getTanggalSurat() {
        return tanggalSurat;
    }
}
