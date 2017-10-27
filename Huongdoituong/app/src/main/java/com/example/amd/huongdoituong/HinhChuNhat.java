package com.example.amd.huongdoituong;

/**
 * Created by AMD on 9/27/2017.
 */

public class HinhChuNhat {
    private int cd;
    private int cr;
    HinhChuNhat()
    {
        cd=1;
        cr=1;
    }
    HinhChuNhat(int dai,int rong)
    {
        this.cd=dai;
        this.cr=rong;
    }
//starting set and get
    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public int getCr() {
        return cr;
    }

    public void setCr(int cr) {
        this.cr = cr;
    }
//ending set and get
    public int chuvi()
    {
        return (cd+cr)*2;
    }
    public int dientich()
    {
        return cd*cr;
    }
    public String getInfo()
    {
        return "dientich: " + this.dientich()+" Chu vi: "+this.chuvi();
    }
}
