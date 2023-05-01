package com.example.mcsuts.model;

public class TransactionModel {

    String judul;
    String textLeft;
    String textRight;
    String tanggal;
    String tempat;

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    String capacity;
    int  imgLeft, imgRight, imgTempat;

    public int getImgTempat() {
        return imgTempat;
    }

    public void setImgTempat(int imgTempat) {
        this.imgTempat = imgTempat;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTextLeft() {
        return textLeft;
    }

    public void setTextLeft(String textLeft) {
        this.textLeft = textLeft;
    }

    public String getTextRight() {
        return textRight;
    }

    public void setTextRight(String textRight) {
        this.textRight = textRight;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getImgLeft() {
        return imgLeft;
    }

    public void setImgLeft(int imgLeft) {
        this.imgLeft = imgLeft;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public int getImgRight() {
        return imgRight;
    }

    public void setImgRight(int imgRight) {
        this.imgRight = imgRight;
    }

    public TransactionModel(String judul, String textLeft, String textRight, String tanggal, int imgLeft, int imgRight, String tempat, int imgTempat, String capacity) {
        this.judul = judul;
        this.textLeft = textLeft;
        this.textRight = textRight;
        this.tanggal = tanggal;
        this.imgLeft = imgLeft;
        this.imgRight = imgRight;
        this.tempat = tempat;
        this.imgTempat = imgTempat;
        this.capacity = capacity;
    }
}
