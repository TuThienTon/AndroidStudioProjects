package com.example.qlnv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDao {
    private DBHelper csdl;

    public NhanVienDao(Context context) {
        csdl = new DBHelper(context);
    }

    // Thêm
    public void Them(NhanVien nv) {
        SQLiteDatabase db = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("manv", nv.getManv());
        values.put("hoten", nv.getHoten());
        values.put("gioitinh", nv.getGioitinh());
        values.put("phongban", nv.getPhongban());
        values.put("chucvu", nv.getChucvu());
        values.put("dienthoai", nv.getDienthoai());
        db.insert("nhanvien", null, values);
        db.close();

    }

    // Sửa thông tin
    public void Sua(NhanVien nv) {
        SQLiteDatabase db = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hoten", nv.getHoten());
        values.put("gioitinh", nv.getGioitinh());
        values.put("phongban", nv.getPhongban());
        values.put("chucvu", nv.getChucvu());
        values.put("dienthoai", nv.getDienthoai());
        db.update("nhanvien", values, "manv=?", new String[]{String.valueOf(nv.getManv())});
    }

    // Xóa SV;
    public int Xoa(int id) {
        SQLiteDatabase db = csdl.getWritableDatabase();
        int kq = db.delete("nhanvien", "manv=?", new String[]{String.valueOf(id)});
        db.close();
        return kq;
    }

    // Hiển thị thông tin
    public List<NhanVien> ThongTin() {
        List<NhanVien> NVList = new ArrayList<NhanVien>();
        String sql = "SELECT * FROM nhanvien";
        SQLiteDatabase db = csdl.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int masv = cursor.getInt(0);
            String hoten = cursor.getString(1);
            int gioitinh = cursor.getInt(2);
            String phongban = cursor.getString(3);
            String chucvu = cursor.getString(4);
            String dienthoai = cursor.getString(5);
            NhanVien nv = new NhanVien(masv, hoten, gioitinh, phongban, chucvu, dienthoai);
            NVList.add(nv);
            cursor.moveToNext();
        }
        return NVList;
    }

    // Tìm kiếm
    public List<NhanVien> TimKiemNV(String s) {
        List<NhanVien> NVList = new ArrayList<NhanVien>();
        SQLiteDatabase db = csdl.getReadableDatabase();
        String sql = "SELECT * FROM nhanvien WHERE manv LIKE '%" + s + "%'OR hoten LIKE '%" + s + "%' OR phongban LIKE '%" + s + "%' ";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int manv = cursor.getInt(0);
            String hoten = cursor.getString(1);
            int gioitinh = cursor.getInt(2);
            String phongban = cursor.getString(3);
            String chucvu = cursor.getString(4);
            String dienthoai = cursor.getString(5);
            NhanVien nv = new NhanVien(manv, hoten, gioitinh, phongban, chucvu, dienthoai);
            NVList.add(nv);
            cursor.moveToNext();
        }
        return NVList;
    }
}
