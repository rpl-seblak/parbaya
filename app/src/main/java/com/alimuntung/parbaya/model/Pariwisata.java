package com.alimuntung.parbaya.model;

import java.io.Serializable;

public class Pariwisata implements Serializable
{
    private Double lat;
    private Double lng;
    private String judul;
    private String deskripsi;
    private String alamat;
    private String url;

    public Pariwisata(){

    }

    public Pariwisata(Double lat, Double lng,String judul,String deskripsi, String alamat, String url){
        this.lat = lat;
        this.lng = lng;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.alamat = alamat;
        this.url = url;
    }
    // Ikbar Laudza Alviansyah
// IF-7
// 10119260
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Pariwisata{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", judul='" + judul +
                ", deskripsi='" + deskripsi  +
                ", alamat='" + alamat  +
                ", url='" + url  +
                '}';
    }
}
