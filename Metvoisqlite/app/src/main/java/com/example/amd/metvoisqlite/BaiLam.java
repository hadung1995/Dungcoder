package com.example.amd.metvoisqlite;

/**
 * Created by AMD on 10/18/2017.
 */

public class BaiLam {
    private int idCV;
    private String TenCV;

    public BaiLam(int idCV, String tenCV) {
        this.idCV = idCV;
        TenCV = tenCV;
    }

    public int getIdCV() {
        return idCV;
    }

    public void setIdCV(int idCV) {
        this.idCV = idCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String tenCV) {
        TenCV = tenCV;
    }
}
