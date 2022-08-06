package com.alimuntung.parbaya.helper;

public class ProfileItem {
    private String nim;
    private String nama;

    public ProfileItem(String nim, String nama, int pp) {
        this.nim = nim;
        this.nama = nama;
        this.pp = pp;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public int getPp() {
        return pp;
    }

    private int pp;
}
