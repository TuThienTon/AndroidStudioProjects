package com.example.qlnt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity_Edit extends AppCompatActivity {
    private EditText edtMaNT,edtTenNT,edtMota,edtDongia;
    private Button btnSave,btnExit;
    private RadioGroup rg_loaint;
    private RadioButton rbBan,rbGhe,rbTu;
    private int loaint;
    private DoNoiThatDao dntDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        anhxa();
        dntDao=new DoNoiThatDao(Activity_Edit.this);
        Intent intent=getIntent();
        final DoNoiThat dnt=(DoNoiThat) intent.getSerializableExtra("dataDNT");
        // Lay du lieu
        edtTenNT.setText(dnt.getTennt());
        edtMota.setText(dnt.getMota());
        edtDongia.setText(dnt.getDongia());
        if(dnt.getLoaint()==1){
            rbGhe.setChecked(true);
            loaint=1;
        }else if(dnt.getLoaint()==0) {
            rbBan.setChecked(true);
            loaint=0;
        }else {
            rbTu.setChecked(true);
            loaint=2;
        }

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rg_loaint.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rbGhe){
                    loaint=1;
                }else if(checkedId==R.id.rbBan) {
                    loaint=0;
                }else {
                    loaint=2;
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dnt.setTennt(edtTenNT.getText().toString());
                dnt.setMota(edtMota.getText().toString());
                dnt.setDongia(edtDongia.getText().toString());
                dnt.setLoaint(loaint);
                dntDao.SuaDNT(dnt);
                Intent intent1=new Intent(Activity_Edit.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
    private  void anhxa(){
        edtMaNT=findViewById(R.id.edtMant);
        edtTenNT=findViewById(R.id.edtTennt);
        edtMota=findViewById(R.id.edtMota);
        edtDongia=findViewById(R.id.edtDongia);
        btnSave=findViewById(R.id.btnSave);
        btnExit=findViewById(R.id.btnExit);
        rg_loaint=findViewById(R.id.rg_loaint);
        rbBan=findViewById(R.id.rbBan);
        rbGhe=findViewById(R.id.rbGhe);
        rbTu=findViewById(R.id.rbTu);

    }
}