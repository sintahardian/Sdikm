package application.model;

import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataKegiatan {
	private IntegerProperty kegiatanID;
    private StringProperty kegiatanNamaGuru;
    private StringProperty kegiatan;
    private StringProperty keterangan;
    private ObjectProperty<Date> tanggalKegiatan;
    
    
    public DataKegiatan(int kegiatanID, String kegiatanNamaGuru,String kegiatan, String keterangan,Date tanggalKegiatan) {
    	this.kegiatanID = new SimpleIntegerProperty(kegiatanID);
    	this.kegiatanNamaGuru = new SimpleStringProperty(kegiatanNamaGuru);
    	this.kegiatan = new SimpleStringProperty(kegiatan);
    	this.keterangan = new SimpleStringProperty(keterangan);
    	this.tanggalKegiatan = new SimpleObjectProperty<>(tanggalKegiatan);
    }
    
    public DataKegiatan(int kegiatanID, String kegiatanNamaGuru,String kegiatan,Date tanggalKegiatan) {
    	this.kegiatanID = new SimpleIntegerProperty(kegiatanID);
    	this.kegiatanNamaGuru = new SimpleStringProperty(kegiatanNamaGuru);
    	this.kegiatan = new SimpleStringProperty(kegiatan);
    	this.tanggalKegiatan = new SimpleObjectProperty<>(tanggalKegiatan);
    }
    
    public IntegerProperty getKegiatanID() {
    	return kegiatanID;
    }
    public StringProperty getKegiatanNamaGuru() {
    	return kegiatanNamaGuru;
    }
    public StringProperty getKegiatan() {
    	return kegiatan;
    }
    public StringProperty getKeterangan() {
    	return keterangan;
    }

    public ObjectProperty<Date> getTanggalKegiatan() {
        return tanggalKegiatan;
    }
}
