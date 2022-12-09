package com.example.qlnv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NVAdapter extends BaseAdapter {
    private Context context;
    private List<NhanVien> NVList;

    public NVAdapter(Context context, List<NhanVien> NVList) {
        this.context = context;
        this.NVList = NVList;
    }

    @Override
    public int getCount() {
        return NVList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list, null);
            // ánh xạ
            viewHolder.tvmanv = convertView.findViewById(R.id.tv_manv);
            viewHolder.tvhoten = convertView.findViewById(R.id.tv_hoten);
            viewHolder.tvphongban = convertView.findViewById(R.id.tv_phongban);
            viewHolder.tvchucvu = convertView.findViewById(R.id.tv_chucvu);
            viewHolder.tvdienthoai = convertView.findViewById(R.id.tv_dienthoai);
            viewHolder.imvGioitinh = convertView.findViewById(R.id.iv_gioitinh);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Thiết lập giá trị
        NhanVien nv = NVList.get(position);
        viewHolder.tvmanv.setText("Mã NV: " + nv.getManv());
        viewHolder.tvhoten.setText("Họ tên: " + nv.getHoten());
        viewHolder.tvphongban.setText("Phòng ban: " + nv.getPhongban());
        viewHolder.tvchucvu.setText("Chức vụ: " + nv.getChucvu());
        viewHolder.tvdienthoai.setText("Điện thoại: " + nv.getDienthoai());
        if (nv.getGioitinh() == 0) {
            viewHolder.imvGioitinh.setImageResource(R.drawable.nu);
        } else {
            viewHolder.imvGioitinh.setImageResource(R.drawable.nam);
        }
        return convertView;
    }

    class ViewHolder {
        ImageView imvGioitinh;
        TextView tvmanv, tvhoten, tvphongban, tvchucvu, tvdienthoai;
    }
}
