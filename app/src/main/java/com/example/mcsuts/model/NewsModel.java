package com.example.mcsuts.model;

public class NewsModel {

    String Judul, tanggal, detail, source;

    int img;

    public NewsModel(String judul, String tanggal, String detail, String source, int img) {
        Judul = judul;
        this.tanggal = tanggal;
        this.detail = detail;
        this.source = source;
        this.img = img;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
