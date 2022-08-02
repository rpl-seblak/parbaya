package com.alimuntung.parbaya.model;

public class Pariwisata
{
    private Double lat;
    private Double lng;
    private String judul;
    private String deskripsi;
    public Pariwisata(Double lat, Double lng,String judul,String deskripsi){
        this.lat = lat;
        this.lng = lng;
        this.judul = judul;
        this.deskripsi = deskripsi;

    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi(){
        return deskripsi;
    }
}
