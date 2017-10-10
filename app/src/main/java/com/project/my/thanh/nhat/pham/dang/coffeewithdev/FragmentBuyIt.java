package com.project.my.thanh.nhat.pham.dang.coffeewithdev;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.PropertyPermission;

/**
 * Created by nhth1 on 10-Oct-17.
 */

public class FragmentBuyIt extends Fragment implements View.OnClickListener{

    TextView txtName;
    Button btnBuy, btnBack;
    RadioButton radioButtonS, radioButtonM, radioButtonL;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_it, null);

        txtName = (TextView) view.findViewById(R.id.TextView_NameBuy_FragmentBuyIt);
        btnBuy = (Button) view.findViewById(R.id.Button_Buy_FragmentBuyIt);
        btnBack = (Button) view.findViewById(R.id.Button_Back_FragmentBuyIt);


        radioButtonS = (RadioButton) view.findViewById(R.id.RadioSizeS_FragmentBuyIt);
        radioButtonM = (RadioButton) view.findViewById(R.id.RadioSizeM_FragmentBuyIt);
        radioButtonL = (RadioButton) view.findViewById(R.id.RadioSizeL_FragmentBuyIt);

        radioButtonM.setChecked(true);


        if(getArguments() != null) {
            txtName.setText(getArguments().getString("nameSP"));
        }

        btnBuy.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        switch (view.getId()){
            case R.id.Button_Buy_FragmentBuyIt:


                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_other);

                TextView txtName_Dialog = (TextView) dialog.findViewById(R.id.TextView_NameOther_DialogOther);
                TextView txtsize_Dialog = (TextView) dialog.findViewById(R.id.TextView_Size_DialogOther);
                Button btnCancal_Dialog = (Button) dialog.findViewById(R.id.Button_Cancel_DialogOther);
                Button btnOK_Dialog = (Button) dialog.findViewById(R.id.Button_OK_DialogOther);

                txtName_Dialog.setText("Tên: " + getArguments().getString("nameSP"));
//                txtsize_Dialog.setText("Size: M");

                if (radioButtonS.isChecked()) {
                    txtsize_Dialog.setText("Size: S");
                } else  if (radioButtonM.isChecked()) {
                    txtsize_Dialog.setText("Size: M");
                } else if (radioButtonL.isChecked()) {
                    txtsize_Dialog.setText("Size: L");
                }

                btnCancal_Dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });

                btnOK_Dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "Đã đặt hàng", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                dialog.show();
                break;
            case R.id.Button_Back_FragmentBuyIt:
                MainFragment mainFragment = new MainFragment();
                fragmentManager.beginTransaction().replace(R.id.LinerMain, mainFragment).commit();
                break;
        }
    }
}
