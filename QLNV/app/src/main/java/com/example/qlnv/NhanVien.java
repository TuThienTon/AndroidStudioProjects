package com.example.qlnv;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private int manv;
    private String hoten;
    private int gioitinh;
    private String phongban, chucvu, dienthoai;

    public NhanVien() {
    }

    public NhanVien(int manv, String hoten, int gioitinh, String phongban, String chucvu, String dienthoai) {
        this.manv = manv;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.phongban = phongban;
        this.chucvu = chucvu;
        this.dienthoai = dienthoai;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "manv=" + manv +
                ", hoten='" + hoten + '\'' +
                ", gioitinh=" + gioitinh +
                ", phongban='" + phongban + '\'' +
                ", chucvu='" + chucvu + '\'' +
                ", dienthoai='" + dienthoai + '\'' +
                '}';
    }
}
