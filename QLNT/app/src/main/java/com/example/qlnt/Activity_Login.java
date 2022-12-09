package com.example.qlnt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Login extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    //    1. Khai bao cac thanh phan
    private EditText edtUser, edtPass;
    private Button btnDN, btnThoat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnDN = findViewById(R.id.btnLogin);
        btnThoat = findViewById(R.id.btnExit);
        // 3. Bat su kien cho cac button
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // xu li logic
                if (edtPass.getText().toString().equals("") || (edtPass.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(), "ban chua nhap Username hoac Password", Toast.LENGTH_LONG).show();
                } else if (edtUser.getText().toString().equals("admin") && edtPass.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Dang nhap thanh cong", Toast.LENGTH_LONG).show();
                    //      chuyen sang activity2
                    //     3.a TAO doi tuong Intent
                    Intent it1 = new Intent(Activity_Login.this, MainActivity.class);
                    startActivity(it1);
                    Log.d("AAA","VAO");
                } else {
                    Toast.makeText(getApplicationContext(), "Dang nhap that bai", Toast.LENGTH_LONG).show();
                }
            }
        });
        //4. bat su kien cho button Thoat
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}