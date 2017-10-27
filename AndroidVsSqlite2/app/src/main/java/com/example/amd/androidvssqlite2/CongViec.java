package com.example.amd.androidvssqlite2;

/**
 * Created by AMD on 10/18/2017.
 */

public class CongViec {
    private int idcongviec;
    private String tencongviec;

    public CongViec(int idcongviec, String tencongviec) {
        this.idcongviec = idcongviec;
        this.tencongviec = tencongviec;
    }

    public String getTencongviec() {
        return tencongviec;
    }

    public void setTencongviec(String tencongviec) {
        this.tencongviec = tencongviec;
    }

    public int getIdcongviec() {
        return idcongviec;
    }

    public void setIdcongviec(int idcongviec) {
        this.idcongviec = idcongviec;
    }
}
