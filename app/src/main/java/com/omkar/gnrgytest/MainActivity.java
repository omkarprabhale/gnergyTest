package com.omkar.gnrgytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.omkar.gnrgytest.adapter.WaysAdapter;

public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.fragview)
    FrameLayout fragView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        BlankFragment frag1 = new BlankFragment();
        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragview,frag1,"firstFrag").commit();




    }

}
