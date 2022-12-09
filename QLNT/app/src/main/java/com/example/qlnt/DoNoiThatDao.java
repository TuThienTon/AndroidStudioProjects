package com.example.qlnt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DoNoiThatDao {
    private DBHelper csdl;

    public DoNoiThatDao(Context context) {

        csdl = new DBHelper(context);
    }

    // Them Do Noi That
    public void ThemDNT(DoNoiThat dnt) {
        SQLiteDatabase db = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaNT", dnt.getMant());
        values.put("TenNT", dnt.getTennt());
        values.put("LoaiNT", dnt.getLoaint());
        values.put("MoTa", dnt.getMota());
        values.put("DonGia", dnt.getDongia());

        db.insert("DoNoiThat1", null, values);
        db.close();
    }

    //Sửa thông tin đồ nội thất
    public void SuaDNT(DoNoiThat dnt) {
        SQLiteDatabase db = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("TenNT", dnt.getTennt());
        values.put("LoaiNT", dnt.getLoaint());
        values.put("MoTa", dnt.getMota());
        values.put("DonGia", dnt.getDongia());
        db.update("DoNoiThat1", values, "MaNT=?", new String[]{String.valueOf(dnt.getMant())});
    }

    // Xoa noi that
    public int XoaDNT(int id) {
        SQLiteDatabase db = csdl.getWritableDatabase();
        int kq = db.delete("DoNoiThat1", "MaNT=?", new String[]{String.valueOf(id)});
        db.close();
        return kq;
    }

    //Hien thi thong tin
    public List<DoNoiThat> ThongTinDNT() {
        List<DoNoiThat> DNTList=new ArrayList<>();
        String sql="SELECT * FROM DoNoiThat1";
        SQLiteDatabase db=csdl.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        cursor.moveToFirst();
        while ((!cursor.isAfterLast())){
            int mant=cursor.getInt(0);
            String tennt=cursor.getString(1);
            int loaint=cursor.getInt(2);
            String mota=cursor.getString(3);
            String dongia=cursor.getString(4);
            DoNoiThat dnt=new DoNoiThat(mant,tennt,mota,dongia,loaint);
            DNTList.add(dnt);
            cursor.moveToNext();
        }
        return DNTList;
    }
    // Tim kiem
    public List<DoNoiThat> TimKiemDNT(String s){
        List<DoNoiThat> DNTList= new ArrayList<>();
        SQLiteDatabase db=csdl.getReadableDatabase();
        String sql="SELECT * FROM DoNoiThat1 WHERE MaNT LIKE '%"+s+"%'OR TenNT LIKE '%"+s+"%' ";
        Cursor cursor=db.rawQuery(sql,null);
        cursor.moveToFirst();
        while ((!cursor.isAfterLast())){
            int mant=cursor.getInt(0);
            String tennt=cursor.getString(1);
            int loaint=cursor.getInt(2);
            String mota=cursor.getString(3);
            String dongia=cursor.getString(4);
            DoNoiThat dnt=new DoNoiThat(mant,tennt,mota,dongia,loaint);
            DNTList.add(dnt);
            cursor.moveToNext();
        }
        return DNTList;
    }

}
