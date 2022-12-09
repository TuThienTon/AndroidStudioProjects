package com.example.qlnv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "qlnv.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NHANVIEN = "nhanvien";
    private static final String COLUMN_NHANVIEN_MANV = "manv";
    private static final String COLUMN_NHANVIEN_HOTEN = "hoten";
    private static final String COLUMN_NHANVIEN_GIOITINH = "gioitinh";
    private static final String COLUMN_NHANVIEN_PHONGBAN = "phongban";
    private static final String COLUMN_NHANVIEN_CHUCVU = "chucvu";
    private static final String COLUMN_NHANVIEN_DIENTHOAI = "dienthoai";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql =
                "CREATE TABLE " + TABLE_NHANVIEN +
                        " (" + COLUMN_NHANVIEN_MANV + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NHANVIEN_HOTEN + " TEXT, " +
                        COLUMN_NHANVIEN_GIOITINH + " INTEGER, " +
                        COLUMN_NHANVIEN_PHONGBAN + " TEXT, " +
                        COLUMN_NHANVIEN_CHUCVU + " TEXT, " +
                        COLUMN_NHANVIEN_DIENTHOAI + " TEXT );";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NHANVIEN);
        onCreate(sqLiteDatabase);
    }
}
