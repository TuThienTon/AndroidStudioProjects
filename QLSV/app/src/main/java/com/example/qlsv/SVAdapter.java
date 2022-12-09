package com.example.qlsv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SVAdapter extends BaseAdapter {
    private Context context;
    private List<SinhVien> SVList;

    public SVAdapter(Context context, List<SinhVien> SVList) {
        this.context = context;
        this.SVList = SVList;
    }

    @Override
    public int getCount() {
        return SVList.size();
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
        if(convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.item_listsv,null);
            // ánh xạ
            viewHolder.tvmasv=convertView.findViewById(R.id.tv_masv);
            viewHolder.tvhoten=convertView.findViewById(R.id.tv_hoten);
            viewHolder.tvlop=convertView.findViewById(R.id.tv_lop);
            viewHolder.tvdiachi=convertView.findViewById(R.id.tv_diachi);
            viewHolder.tvsdt=convertView.findViewById(R.id.tv_sdt);
            viewHolder.imvGioitinh=convertView.findViewById(R.id.iv_gioitinh);
            convertView.setTag(viewHolder);

        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }

        // Thiết lập giá trị
        SinhVien sv=SVList.get(position);
        viewHolder.tvmasv.setText("Mã SV: "+sv.getMasv());
        viewHolder.tvhoten.setText("Họ tên: "+sv.getHoten());
        viewHolder.tvlop.setText("Lớp: "+ sv.getLop());
        viewHolder.tvdiachi.setText("Địa chỉ: "+sv.getDiachi());
        viewHolder.tvsdt.setText("SDT: "+sv.getSdt());
        if(sv.getGioitinh()==0){
            viewHolder.imvGioitinh.setImageResource(R.drawable.nu);
        }else {
            viewHolder.imvGioitinh.setImageResource(R.drawable.nam);
        }
        return convertView;
    }

    class ViewHolder{
        ImageView imvGioitinh;
        TextView tvmasv, tvhoten, tvlop, tvdiachi, tvsdt;
    }
}
