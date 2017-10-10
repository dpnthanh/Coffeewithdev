package com.project.my.thanh.nhat.pham.dang.coffeewithdev;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nhth1 on 10-Oct-17.
 */

public class SanPhamAdapter extends BaseAdapter {

    Context context;
    ArrayList<SanPham> listSanPham;

    public SanPhamAdapter(Context context, ArrayList<SanPham> listSanPham) {
        this.context = context;
        this.listSanPham = listSanPham;
    }

    @Override
    public int getCount() {
        return listSanPham.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        view = layoutInflater.inflate(R.layout.view_sanpham, null);

        ImageView iv = (ImageView) view.findViewById(R.id.ImageView_avatar_Header);
        TextView tv = (TextView) view.findViewById(R.id.TextView_NameCoffee_ViewSanPham);

//        iv.setImageResource(R.drawable.coffee_1);
        tv.setText(listSanPham.get(i).name);
        return view;
    }
}
