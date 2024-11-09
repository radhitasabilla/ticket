package pojo;
// Generated Oct 11, 2022 1:46:30 PM by Hibernate Tools 4.3.1

import DAO.DAOTiket;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;




/**
 * Tiket generated by hbm2java
 */
@ManagedBean
public class Tiket  implements java.io.Serializable {


     private Integer idTiket;
     private String judul;
     private String tempat;
     private String tanggal;
     private String harga;
     private String deskripsi;
     private String thumbnail;
     
     public List<Tiket> getAllRecords()
     {
         DAOTiket usr = new DAOTiket();
         List<Tiket> lUsr = usr.retrieveTiket();
         return lUsr;
         
     }
 
 
 public String save_user(){
         DAOTiket add = new DAOTiket();
         add.addTiket(this);
         return "AdminMainMenu";
     }
     
     public String getById(){
         String id_tiket = idTiket.toString();
         DAOTiket usr = new DAOTiket();
         List<Tiket> lUsr = usr.getbyID(id_tiket);
         judul = lUsr.get(0).judul;
         tempat = lUsr.get(0).tempat;
         tanggal = lUsr.get(0).tanggal;
         harga = lUsr.get(0).harga;
         deskripsi = lUsr.get(0).deskripsi;
         thumbnail = lUsr.get(0).thumbnail;
         return "AdminEdit";
     }
     
          public String edit()
     {
         DAOTiket usr = new DAOTiket();
         usr.editTiket(this);
         judul = "";
         tempat = "";
         tanggal = "";
         harga = "";
         deskripsi = "";
         thumbnail = "";

         FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Berhasil Update Data",null);
         return "AdminEdit";
     }
     
     public String delete()
     {
         //String id_user = idUser.toString();
         DAOTiket usr = new DAOTiket();
         usr.deleteTiket(idTiket);
         judul = "";
         tempat = "";
         tanggal = "";
         harga = "";
         deskripsi = "";
         thumbnail = "";

         return "AdminEdit";
     }

    public Tiket() {
    }

    public Tiket(String judul, String tempat, String tanggal, String harga, String deskripsi, String thumbnail) {
       this.judul = judul;
       this.tempat = tempat;
       this.tanggal = tanggal;
       this.harga = harga;
       this.deskripsi = deskripsi;
       this.thumbnail = thumbnail;
    }
   
    public Integer getIdTiket() {
        return this.idTiket;
    }
    
    public void setIdTiket(Integer idTiket) {
        this.idTiket = idTiket;
    }
    public String getJudul() {
        return this.judul;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getTempat() {
        return this.tempat;
    }
    
    public void setTempat(String tempat) {
        this.tempat = tempat;
    }
    public String getTanggal() {
        return this.tanggal;
    }
    
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String getHarga() {
        return this.harga;
    }
    
    public void setHarga(String harga) {
        this.harga = harga;
    }
    public String getDeskripsi() {
        return this.deskripsi;
    }
    
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }




}

