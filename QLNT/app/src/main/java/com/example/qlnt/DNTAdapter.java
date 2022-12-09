package com.example.qlnt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DNTAdapter extends BaseAdapter {
    private Context context;
    private List<DoNoiThat> DNTList;
    public DNTAdapter(Context context,List<DoNoiThat> DNTList){
        this.context=context;
        this.DNTList=DNTList;
    }
    @Override
    public int getCount() {
        return DNTList.size();
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
        ViewHoder viewHoder;
        if (convertView==null){
            viewHoder=new ViewHoder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.iem_listnt,null);

            viewHoder.tvmant=convertView.findViewById(R.id.tv_mant);
            viewHoder.tvtennt=convertView.findViewById(R.id.tv_tennt);
            viewHoder.tvmota=convertView.findViewById(R.id.tv_mota);
            viewHoder.tvdongia=convertView.findViewById(R.id.tv_dongia);
            viewHoder.imvLoaint=convertView.findViewById(R.id.iv_loaint);

            convertView.setTag(viewHoder);

        }else{
            viewHoder=(ViewHoder) convertView.getTag();
        }
            // THiet lap gia tri
        DoNoiThat dnt=DNTList.get(position);
        viewHoder.tvmant.setText("Mã nội thất :"+dnt.getMant());
        viewHoder.tvtennt.setText("Tên nội thất :"+dnt.getTennt());
        viewHoder.tvmota.setText("Mô tả :"+dnt.getMota());
        viewHoder.tvdongia.setText("Đơn giá :"+dnt.getDongia());
        if(dnt.getLoaint()==0){
            viewHoder.imvLoaint.setImageResource(R.drawable.bango);
        }else if(dnt.getLoaint()==1){
            viewHoder.imvLoaint.setImageResource(R.drawable.ghengoi);
        }else {
            viewHoder.imvLoaint.setImageResource(R.drawable.tu);
        }

        return convertView;
    }
    class ViewHoder{
        ImageView imvLoaint;
        TextView tvmant, tvtennt, tvmota, tvdongia;
    }
}
