package com.alimuntung.parbaya.model;

public class Pariwisata
{
    private Double lnt;
    private Double lng;
    private String judul;
    public Pariwisata(Double lnt, Double lng,String judul){
        this.lnt = lnt;
        this.lng = lng;
        this.judul = judul;
    }

    public Double getLnt() {
        return lnt;
    }

    public Double getLng() {
        return lng;
    }

    public String getJudul() {
        return judul;
    }
}
