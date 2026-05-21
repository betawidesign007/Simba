package model;

public class Mustahik {

    private int id_mustahik;
    private String nik;
    private String nama;
    private String alamat;

    public int getId_mustahik() {
        return id_mustahik;
    }

    public void setId_mustahik(int id_mustahik) {
        this.id_mustahik = id_mustahik;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}