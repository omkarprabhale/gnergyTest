package com.omkar.gnrgytest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class BlankFragment2 extends Fragment {


    @BindView(R.id.tvWays)
    TextView tvWays;

    @BindView(R.id.tvColorcode)
    TextView tvColorcode;

    @BindView(R.id.tvEditvalue)
    TextView tvEditValue;
    @BindView(R.id.btnBack)
    Button btnBack;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            View view = inflater.inflate(R.layout.fragment_blank, container, false);

            ButterKnife.bind(view);


            tvColorcode = view.findViewById(R.id.tvColorcode);
            tvEditValue = view.findViewById(R.id.tvEditvalue);
            tvWays = view.findViewById(R.id.tvWays);
            String colrcode = getArguments().getString("colrcode");
            tvColorcode.setText("colour code of box :"+colrcode);

            String editvalue = getArguments().getString("editValue");
            tvEditValue.setText("enterd value :"+editvalue);
            String ways = getArguments().getString("ways");
            tvWays.setText("selected way :"+ways);

            btnBack =view.findViewById(R.id.btnBack);
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BlankFragment frag =new BlankFragment();
                    getFragmentManager().beginTransaction().replace(R.id.fragview,frag).commit();                }
            });
            return view;
        } catch (Exception e) {
            Log.e("Exception in 2nd frag", e.getMessage());
            return null;
        }

    }





}
