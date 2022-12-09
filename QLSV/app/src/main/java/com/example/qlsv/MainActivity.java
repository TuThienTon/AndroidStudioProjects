package com.example.qlsv;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // khai báo các thành phần
    private EditText edtSearch;
    private Button btnSeach;
    private ListView lvsv;

    private List<SinhVien> SVList;
    private SVAdapter adapter;
    private DBHelper db;
    private SinhVienDao svdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        edtSearch=findViewById(R.id.edtSearch);
        btnSeach=findViewById(R.id.btnSearch);
        lvsv=findViewById(R.id.lvsv);

        // Đổ DL
        SVList=new ArrayList<SinhVien>();
        svdao=new SinhVienDao(MainActivity.this);
        SVList=svdao.ThongTinSV();
        adapter=new SVAdapter(getApplicationContext(),SVList);
        lvsv.setAdapter(adapter);
        onResume();
        registerForContextMenu(lvsv);
        btnSeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SVList=(List<SinhVien>)svdao.TimKiemSV(edtSearch.getText().toString());
                adapter=new SVAdapter(getApplicationContext(),SVList);
                lvsv.setAdapter(adapter);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuThem:{
                Intent intent=new Intent(MainActivity.this, Activity_Add.class);
                startActivity(intent);

                break;

            }
            case R.id.mnuThoat:{
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("Xác nhận thoát khỏi chương trình");
                builder1.setMessage("Bạn có muốn thoát khỏi chương trình không ?");
                builder1.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder1.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                Dialog dialog=builder1.create();
                dialog.show();
            }
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int vitri=info.position;
        SinhVien sv=SVList.get(vitri);
        switch (item.getItemId()){
            case R.id.mnuSua:{
                Intent intent=new Intent(MainActivity.this, Activity_Edit.class);
                intent.putExtra("DuLieu", sv);
                startActivity(intent);
                break;
            }
            case R.id.mnuXoa:{
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("Delete?");
                builder1.setMessage("Bạn có chắc chắn xóa?");
                builder1.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        svdao.XoaSV(sv.getMasv());
                        adapter.notifyDataSetChanged();
                        onResume();

                    }

                });

                builder1.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                Dialog dialog=builder1.create();
                dialog.show();
                break;

            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SVList.clear();
        SVList.addAll(svdao.ThongTinSV());
        adapter.notifyDataSetChanged();
    }
}