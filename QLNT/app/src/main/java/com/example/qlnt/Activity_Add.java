package com.example.qlnt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Activity_Add extends AppCompatActivity {
    private EditText edtMaNT,edtTenNT,edtMota,edtDongia;
    private Button btnThem,btnThoat;
    private RadioGroup rg_loaint;
    private int loaint=1;
    private DoNoiThatDao dntDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        anhxa();
        dntDao=new DoNoiThatDao(Activity_Add.this);
        rg_loaint.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rbGhe){
                    loaint=1;
                }
                else if (checkedId==R.id.rbBan){
                    loaint=0;
                }
                else {
                    loaint=2;
                }
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mant=Integer.parseInt(edtMaNT.getText().toString());
                String tennt=edtTenNT.getText().toString();
                String mota=edtMota.getText().toString();
                String dongia=edtDongia.getText().toString();
                DoNoiThat dnt=new DoNoiThat(mant,tennt,mota,dongia,loaint);
                dntDao.ThemDNT(dnt);
                Intent intent1=new Intent(Activity_Add.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
    private  void anhxa(){
        edtMaNT=findViewById(R.id.edtMant);
        edtTenNT=findViewById(R.id.edtTennt);
        edtMota=findViewById(R.id.edtMota);
        edtDongia=findViewById(R.id.edtDongia);
        btnThem=findViewById(R.id.btnThem);
        btnThoat=findViewById(R.id.btnThoat);
        rg_loaint=findViewById(R.id.rg_loaint);
    }
}