package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity_Edit extends AppCompatActivity {
    private EditText edtMaSV, edtHoten, edtLop, edtDiachi, edtsdt;
    private Button btnSave, btnExit;
    private RadioGroup rg_gioitinh;
    private RadioButton rbNam, rbNu;
    private int gioitinh;
    private SinhVienDao svDao;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        anhxa();
        svDao=new SinhVienDao(Activity_Edit.this);
        Intent intent=getIntent();
        final SinhVien sv=(SinhVien) intent.getSerializableExtra("DuLieu");
        // Lấy DL
        edtHoten.setText(sv.getHoten());
        edtLop.setText(sv.getLop());
        edtDiachi.setText(sv.getDiachi());
        edtsdt.setText(sv.getSdt());
        if(sv.getGioitinh()==1){
            rbNam.setChecked(true);
            gioitinh=1;
        }else {
            rbNu.setChecked(true);
            gioitinh=0;
        }
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rg_gioitinh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rbNam){
                    gioitinh=1;
                }else {
                    gioitinh=0;
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Edit.this);
                builder.setTitle("Save data?");
//                builder.setMessage("");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sv.setHoten(edtHoten.getText().toString());
                        sv.setLop(edtLop.getText().toString());
                        sv.setDiachi(edtDiachi.getText().toString());
                        sv.setSdt(edtsdt.getText().toString());
                        sv.setGioitinh(gioitinh);
                        svDao.SuaSV(sv);
                        Toast.makeText(getApplicationContext(), "Sửa thành công.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create().show();
            }
        });
    }

    private void anhxa() {
        edtMaSV=findViewById(R.id.edtMasv);
        edtHoten=findViewById(R.id.edtHoten);
        edtLop=findViewById(R.id.edtLop);
        edtDiachi=findViewById(R.id.edtDiachi);
        edtsdt=findViewById(R.id.edtSDT);
        btnSave=findViewById(R.id.btnSave);
        btnExit=findViewById(R.id.btnExit);
        rg_gioitinh=findViewById(R.id.rg_gioitinh);
        rbNam=findViewById(R.id.rbNam);
        rbNu=findViewById(R.id.rbNu);
    }
}