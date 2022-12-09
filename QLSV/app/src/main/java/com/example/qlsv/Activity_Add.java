package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity_Add extends AppCompatActivity {

    private EditText edtMaSV, edtHoten, edtLop, edtDiachi, edtsdt;
    private Button btnThem, btnThoat;
    private RadioGroup rg_gioitinh;
    private int gioitinh = 1;
    private SinhVienDao svDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        anhxa();
        svDao = new SinhVienDao(Activity_Add.this);
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
                if (edtMaSV.getText().toString().equals("") || edtHoten.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Mã SV hoặc Họ tên không chính xác!!!", Toast.LENGTH_SHORT).show();
                } else {
                    int masv = Integer.parseInt(edtMaSV.getText().toString());
                    String hoten = edtHoten.getText().toString();
                    String lop = edtLop.getText().toString();
                    String diachi = edtDiachi.getText().toString();
                    String sdt = edtsdt.getText().toString();
                    SinhVien sv = new SinhVien(masv, hoten, lop, diachi, sdt, gioitinh);
                    svDao.ThemSV(sv);
                    edtMaSV.setText("");
                    edtHoten.setText("");
                    edtLop.setText("");
                    edtDiachi.setText("");
                    edtsdt.setText("");
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
        edtMaSV = findViewById(R.id.edtMasv);
        edtHoten = findViewById(R.id.edtHoten);
        edtLop = findViewById(R.id.edtLop);
        edtDiachi = findViewById(R.id.edtDiachi);
        edtsdt = findViewById(R.id.edtSDT);
        btnThem = findViewById(R.id.btnThem);
        btnThoat = findViewById(R.id.btnThoat);
        rg_gioitinh = findViewById(R.id.rg_gioitinh);
    }
}