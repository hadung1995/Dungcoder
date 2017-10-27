package com.example.amd.gridviewnangcao;

/**
 * Created by AMD on 10/9/2017.
 */

public class HinhAnh {
    private int HinhAnh;
    private String name;

    public HinhAnh(int hinhAnh, String name) {
        HinhAnh = hinhAnh;
        this.name = name;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
