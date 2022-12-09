package com.example.qlnt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtSearch;
    private Button btnSearch;
    private ListView lvdnt;
    private List<DoNoiThat> DNTList;
    private DNTAdapter adapter;
    private DBHelper db;
    private DoNoiThatDao dntdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        edtSearch = findViewById(R.id.edtSearch);
        btnSearch = findViewById(R.id.btnSearch);
        lvdnt = findViewById(R.id.lvdnt);
        // Do DL
        DNTList = new ArrayList<DoNoiThat>();
        dntdao = new DoNoiThatDao(MainActivity.this);

        DNTList = dntdao.ThongTinDNT();
        adapter=new DNTAdapter(getApplicationContext(),DNTList);

        lvdnt.setAdapter(adapter);
        onResume();
        // khao bao context menu
        registerForContextMenu(lvdnt);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DNTList = (List<DoNoiThat>) dntdao.TimKiemDNT(edtSearch.getText().toString());
                adapter = new DNTAdapter(getApplicationContext(), DNTList);
                lvdnt.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuThem: {
                Intent intent = new Intent(MainActivity.this, Activity_Add.class);
                startActivity(intent);
                break;
            }
            case R.id.mnuThoat: {
                AlertDialog.Builder bd1= new AlertDialog.Builder(MainActivity.this);
                bd1= bd1.setTitle("Xac nhan thoat chuong trinh");
                bd1.setMessage("ban co muon thoat chuong trinh hong?");
                bd1.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                bd1.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                // hien thi giao dien
                AlertDialog dialog=bd1.create();
                dialog.show();
            }
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int vitri = info.position;
        DoNoiThat dnt = DNTList.get(vitri);
        switch (item.getItemId()) {
            case R.id.mnuSua: {
                Intent intent = new Intent(MainActivity.this, Activity_Edit.class);
                intent.putExtra("dataDNT", dnt);
                startActivity(intent);
                break;
            }
            case R.id.mnuXoa: {
                dntdao.XoaDNT(dnt.getMant());
                adapter.notifyDataSetChanged();
                onResume();
                break;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DNTList.clear();
        DNTList.addAll(dntdao.ThongTinDNT());
        adapter.notifyDataSetChanged();
    }
}