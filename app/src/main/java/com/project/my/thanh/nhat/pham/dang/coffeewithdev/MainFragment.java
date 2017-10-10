package com.project.my.thanh.nhat.pham.dang.coffeewithdev;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by nhth1 on 10-Oct-17.
 */

public class MainFragment extends Fragment {

    GridView gridViewSanPham;
    ArrayList<SanPham> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);

        gridViewSanPham = (GridView) view.findViewById(R.id.GridView_SanPham_MainFragment);

        list.add(new SanPham(R.drawable.coffee_1, "coffee type 1" ));
        list.add(new SanPham(R.drawable.coffee_2, "coffee type 2" ));
        list.add(new SanPham(R.drawable.coffee_3, "coffee type 3" ));
        list.add(new SanPham(R.drawable.coffee_4, "coffee type 4" ));
        list.add(new SanPham(R.drawable.coffee_5, "coffee type 5" ));
        list.add(new SanPham(R.drawable.coffee_6, "coffee type 6" ));
        list.add(new SanPham(R.drawable.coffee_7, "coffee type 7" ));
        list.add(new SanPham(R.drawable.coffee_8, "coffee type 8" ));
        list.add(new SanPham(R.drawable.coffee_7, "coffee type 9" ));
        list.add(new SanPham(R.drawable.coffee_8, "coffee type 10" ));
        list.add(new SanPham(R.drawable.coffee_7, "coffee type 11" ));
        list.add(new SanPham(R.drawable.coffee_8, "coffee type 12" ));

        SanPhamAdapter adapter = new SanPhamAdapter(getContext(), list);
        gridViewSanPham.setAdapter(adapter);

        gridViewSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentBuyIt fragmentBuyIt = new FragmentBuyIt();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putString("nameSP", list.get(i).name);
                fragmentBuyIt.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.LinerMain, fragmentBuyIt).commit();
            }
        });

        return view;
    }
}
