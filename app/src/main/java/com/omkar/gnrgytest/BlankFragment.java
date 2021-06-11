package com.omkar.gnrgytest;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.omkar.gnrgytest.adapter.WaysAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class BlankFragment extends Fragment implements View.OnClickListener {


  @BindView(R.id.edtValue)
    EditText editText;

  @BindView(R.id.viewBox)
    View viewBox;

  @BindView(R.id.rvWays)
  RecyclerView rvWays;

  private ColorDrawable clrCode;
  private  String edtValue;
  private List<String> listofways =new ArrayList<String>();
    private WaysAdapter adapter;
    private int colorID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.frag1layout, container, false);
        ButterKnife.bind(view);


        viewBox = view.findViewById(R.id.viewBox);
        clrCode = (ColorDrawable) viewBox.getBackground();
        editText =view.findViewById(R.id.edtValue);

         colorID = clrCode.getColor();
        if(!editText.getText().toString().isEmpty()){
           edtValue = editText.getText().toString();
        }else{
            edtValue = "value not present";
        }

        listofways.add("1");
        listofways.add("2");
        listofways.add("3");

        adapter = new WaysAdapter(listofways,this);
        rvWays =view.findViewById(R.id.rvWays);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvWays.setLayoutManager(layoutManager);
        rvWays.setAdapter(adapter);
        rvWays.addItemDecoration(new DividerItemDecoration(getContext(),layoutManager.getOrientation()));



        return view;
    }


    @Override
    public void onClick(View v) {
    Bundle bundle =new Bundle();
    bundle.putString("colrcode", String.valueOf(colorID));
    bundle.putString("editValue",edtValue);
    bundle.putString("ways", String.valueOf(v.getTag()));

    BlankFragment2 frag2 =new BlankFragment2();
    frag2.setArguments(bundle);

    getFragmentManager().beginTransaction().replace(R.id.fragview,frag2).commit();





    }

    @Override
    public void onResume() {
        super.onResume();

        /*Handler handler =new Handler();
        Timer timer  = new Timer();
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                if(System.currentTimeMillis() %2 ==0)
                {
                    viewBox.setBackgroundColor(0x00FF00);
                }else{
                    viewBox.setBackgroundColor(0xFF0000);
                }
            }
        };

        timer.schedule(task,0,6000);

    }*/
    }
}
