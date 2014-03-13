package id.co.hans.sample.shared.model;

import java.io.Serializable;

public class User implements Serializable {
    private String id_user;
    private String nama_user;
    private String alamat_user;
    private String email;
    private String kdpp;
    private String unit;
    private int disable_user;
    private String leveluser;
    private String jenispp;
    private String nip;

    public User(){

    }

    public User(String id_user, String nama_user, String alamat_user, String email, String kdpp, String unit, int disable_user, String leveluser, String jenispp, String nip) {
        this.id_user = id_user;
        this.nama_user = nama_user;
        this.alamat_user = alamat_user;
        this.email = email;
        this.kdpp = kdpp;
        this.unit = unit;
        this.disable_user = disable_user;
        this.leveluser = leveluser;
        this.jenispp = jenispp;
        this.nip = nip;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getAlamat_user() {
        return alamat_user;
    }

    public void setAlamat_user(String alamat_user) {
        this.alamat_user = alamat_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKdpp() {
        return kdpp;
    }

    public void setKdpp(String kdpp) {
        this.kdpp = kdpp;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getDisable_user() {
        return disable_user;
    }

    public void setDisable_user(int disable_user) {
        this.disable_user = disable_user;
    }

    public String getLeveluser() {
        return leveluser;
    }

    public void setLeveluser(String leveluser) {
        this.leveluser = leveluser;
    }

    public String getJenispp() {
        return jenispp;
    }

    public void setJenispp(String jenispp) {
        this.jenispp = jenispp;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
