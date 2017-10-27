package com.example.amd.android_27_10_2017_tuan1;

/**
 * Created by AMD on 10/27/2017.
 */

public class Player {
    private int id;
    private String ten;

    public Player(int id, String ten) {
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
