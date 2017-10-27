package com.example.amd.androidvssqlitepickturepick;

/**
 * Created by AMD on 10/23/2017.
 */

public class CongViec {
    private int id;
    private String ten;

    public CongViec(int id, String ten) {
        this.id = id;
        this.ten = ten;
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
}
