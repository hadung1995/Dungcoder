package com.example.amd.androidvssqliteremake;

/**
 * Created by AMD on 10/23/2017.
 */

public class CongViec {
    private int id;
    private String ten;
    private String link;

    public CongViec(int id, String ten, String link) {
        this.id = id;
        this.ten = ten;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
