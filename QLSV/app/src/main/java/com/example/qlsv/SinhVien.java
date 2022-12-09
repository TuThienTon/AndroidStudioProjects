package com.example.qlsv;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int masv, gioitinh;
    private String hoten, lop, diachi, sdt;

    public SinhVien(int masv,  String hoten, String lop, String diachi, String sdt,int gioitinh) {
        this.masv = masv;
        this.gioitinh = gioitinh;
        this.hoten = hoten;
        this.lop = lop;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public SinhVien( String hoten, String lop, String diachi, String sdt,int gioitinh) {
        this.gioitinh = gioitinh;
        this.hoten = hoten;
        this.lop = lop;
        this.diachi = diachi;
        this.sdt = sdt;
    }
    public SinhVien(){

    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "masv=" + masv +
                ", gioitinh=" + gioitinh +
                ", hoten='" + hoten + '\'' +
                ", lop='" + lop + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
}
