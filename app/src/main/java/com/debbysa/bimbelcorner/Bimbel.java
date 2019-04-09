package com.debbysa.bimbelcorner;

public class Bimbel {
    private String nama;
    private String alamat;
    private String deskripsi;

    public Bimbel(String nama, String alamat, String deskripsi) {
        this.nama = nama;
        this.alamat = alamat;
        this.deskripsi = deskripsi;
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

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
