package application.model;
import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataGuru {
	private IntegerProperty guruID;
    private StringProperty namaGuru;
    private StringProperty telepon;
    private StringProperty jabatan;
    private StringProperty alamat;
    private ObjectProperty<Date> date;


    public DataGuru(int guruID, String namaGuru, String telepon, String jabatan, String alamat, Date date) {
    	this.guruID = new SimpleIntegerProperty(guruID);
    	this.namaGuru = new SimpleStringProperty(namaGuru);
    	this.telepon = new SimpleStringProperty(telepon);
    	this.jabatan = new SimpleStringProperty(jabatan);
    	this.alamat = new SimpleStringProperty(alamat);
    	this.date = new SimpleObjectProperty<>(date);
    }
    
    public IntegerProperty getGuruID() {
    	return guruID;
    }
    public StringProperty getNamaGuru() {
    	return namaGuru;
    }
    public StringProperty getTelepon() {
    	return telepon;
    }
    public StringProperty getjabatan() {
    	return jabatan;
    }
    public StringProperty getAlamat() {
    	return alamat;
    }
    public ObjectProperty<Date> getDate() {
        return date;
    }

}
