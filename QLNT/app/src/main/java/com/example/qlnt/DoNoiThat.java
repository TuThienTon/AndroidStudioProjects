package com.example.qlnt;

import java.io.Serializable;

public class DoNoiThat implements Serializable {
    private int mant,loaint;
    private String tennt,mota,dongia;

    public DoNoiThat(int mant, String tennt, String mota, String dongia, int loaint) {
        this.mant = mant;
        this.loaint = loaint;
        this.tennt = tennt;
        this.mota = mota;
        this.dongia = dongia;
    }

    public DoNoiThat( String tennt, String mota, String dongia,int loaint) {
        this.loaint = loaint;
        this.tennt = tennt;
        this.mota = mota;
        this.dongia = dongia;
    }

    public DoNoiThat() {
    }

    public int getMant() {
        return mant;
    }

    public void setMant(int mant) {
        this.mant = mant;
    }

    public int getLoaint() {
        return loaint;
    }

    public void setLoaint(int loaint) {
        this.loaint = loaint;
    }

    public String getTennt() {
        return tennt;
    }

    public void setTennt(String tennt) {
        this.tennt = tennt;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    @Override
    public String toString() {
        return "DoNoiThat{" +
                "mant=" + mant +
                ", loaint=" + loaint +
                ", tennt='" + tennt + '\'' +
                ", mota='" + mota + '\'' +
                ", dongia='" + dongia + '\'' +
                '}';
    }
}
