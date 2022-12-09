package com.example.qlnv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity_Add extends AppCompatActivity {

    private EditText edtManv, edtHoten, edtPhongban, edtChucvu, edtDienthoai;
    private Button btnThem, btnThoat;
    private RadioGroup rg_gioitinh;
    private int gioitinh = 1;
    private NhanVienDao nvDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        anhxa();
        nvDao = new NhanVienDao(Activity_Add.this);
        rg_gioitinh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbNam) {
                    gioitinh = 1;
                } else {
                    gioitinh = 0;
                }
            }
        });

        // bắt sự kiện cho btnThem
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtManv.getText().toString().equals("") || edtHoten.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Mã SV hoặc Họ tên không chính xác!!!", Toast.LENGTH_SHORT).show();
                } else {
                    int manv = Integer.parseInt(edtManv.getText().toString());
                    String hoten = edtHoten.getText().toString();
                    String phongban = edtPhongban.getText().toString();
                    String chucvu = edtChucvu.getText().toString();
                    String dienthoai = edtDienthoai.getText().toString();
                    NhanVien sv = new NhanVien(manv, hoten, gioitinh, phongban, chucvu, dienthoai);
                    nvDao.Them(sv);
                    edtManv.setText("");
                    edtHoten.setText("");
                    edtPhongban.setText("");
                    edtChucvu.setText("");
                    edtDienthoai.setText("");
                    Toast.makeText(getApplicationContext(), "Thêm Thành công.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhxa() {
        edtManv = findViewById(R.id.edtManv);
        edtHoten = findViewById(R.id.edtHoten);
        edtPhongban = findViewById(R.id.edtPhongban);
        edtChucvu = findViewById(R.id.edtChucvu);
        edtDienthoai = findViewById(R.id.edtDienthoai);
        btnThem = findViewById(R.id.btnThem);
        btnThoat = findViewById(R.id.btnThoat);
        rg_gioitinh = findViewById(R.id.rg_gioitinh);
    }
}