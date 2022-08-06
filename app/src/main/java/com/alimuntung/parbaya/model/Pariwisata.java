package com.alimuntung.parbaya.model;

import java.io.Serializable;

public class Pariwisata implements Serializable
{
    private Double lat;
    private Double lng;
    private String judul;
    private String deskripsi;

    public Pariwisata(){

    }

    public Pariwisata(Double lat, Double lng,String judul,String deskripsi){
        this.lat = lat;
        this.lng = lng;
        this.judul = judul;
        this.deskripsi = deskripsi;
    }


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

    @Override
    public String toString() {

        return "Pariwisata{" +

                "judul=" + judul +

                ", desc=" + deskripsi +

                ", lat=" + lat +
                ", lng =" + lng +
                "}";

    }
}
