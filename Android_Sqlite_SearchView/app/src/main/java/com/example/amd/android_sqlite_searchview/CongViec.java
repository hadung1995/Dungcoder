package com.example.amd.android_sqlite_searchview;

/**
 * Created by AMD on 10/19/2017.
 */

public class CongViec {
    private int idcongviec;
    private String tencongviec;

    public CongViec(int idcongviec, String tencongviec) {
        this.idcongviec = idcongviec;
        this.tencongviec = tencongviec;
    }

    public int getIdcongviec() {
        return idcongviec;
    }

    public void setIdcongviec(int idcongviec) {
        this.idcongviec = idcongviec;
    }

    public String getTencongviec() {
        return tencongviec;
    }

    public void setTencongviec(String tencongviec) {
        this.tencongviec = tencongviec;
    }
}
