package com.example.qlsv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDao {
    private  DBHelper csdl;
    public SinhVienDao(Context context){
        csdl=new DBHelper(context);
    }

    // Thêm SV
    public void ThemSV(SinhVien sv){
        SQLiteDatabase db=csdl.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("MaSV", sv.getMasv());
        values.put("HoTen", sv.getHoten());
        values.put("GioiTinh", sv.getGioitinh());
        values.put("Lop", sv.getLop());
        values.put("DiaChi", sv.getDiachi());
        values.put("DienThoai", sv.getSdt());
        db.insert("SinhVien1",null, values);
        db.close();

    }
    // Sửa thông tin SV
    public void SuaSV(SinhVien sv){
        SQLiteDatabase db=csdl.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("HoTen", sv.getHoten());
        values.put("GioiTinh", sv.getGioitinh());
        values.put("Lop", sv.getLop());
        values.put("DiaChi", sv.getDiachi());
        values.put("DienThoai", sv.getSdt());
//        String masv=String.valueOf(sv.getMasv());
        db.update("SinhVien1", values, "MaSV=?", new String[]{String.valueOf(sv.getMasv())});
    }
    // Xóa SV;
    public int XoaSV(int id){
        SQLiteDatabase db=csdl.getWritableDatabase();
        int kq=db.delete("SinhVien1","MaSV=?",new String[]{String.valueOf(id)});
        db.close();
        return kq;
    }
    // Hiển thị thông tin
    public List<SinhVien> ThongTinSV(){
        List<SinhVien> SVList=new ArrayList<SinhVien>();
        String sql="SELECT * FROM SinhVien1";
        SQLiteDatabase db=csdl.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int masv=cursor.getInt(0);
            String hoten=cursor.getString(1);
            int gioitinh=cursor.getInt(2);
            String lop=cursor.getString(3);
            String diachi=cursor.getString(4);
            String sdt=cursor.getString(5);
            SinhVien sv = new SinhVien(masv,hoten,lop,diachi,sdt,gioitinh);
            SVList.add(sv);
            cursor.moveToNext();
        }
        return  SVList;
    }
    // Tìm kiếm
    public List<SinhVien> TimKiemSV(String s){
        List<SinhVien> SVList=new ArrayList<SinhVien>();
        SQLiteDatabase db=csdl.getReadableDatabase();
        String sql="SELECT * FROM SinhVien1 WHERE MaSV LIKE '%"+s+"%'OR HoTen LIKE '%"+s+"%' OR Lop LIKE '%"+s+"%' ";
        Cursor cursor=db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int masv=cursor.getInt(0);
            String hoten=cursor.getString(1);
            int gioitinh=cursor.getInt(2);
            String lop=cursor.getString(3);
            String diachi=cursor.getString(4);
            String sdt=cursor.getString(5);
            SinhVien sv=new SinhVien(masv,hoten,lop,diachi,sdt,gioitinh);
            SVList.add(sv);
            cursor.moveToNext();
        }
        return SVList;
    }

}
