package com.example.sgarcia.ejemplofragments;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    Button btnRed, btnBlue;
    public ViewModel miViewmodel;
    String color;
    FragmentColor fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRed = findViewById(R.id.btnRed);
        btnBlue = findViewById(R.id.btnBlue);
        fragment = new FragmentColor();
        miViewmodel = ViewModelProviders.of(this).get(MainViewModel.class);

        replaceFragment(fragment);

        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnRed:
                color = "#f74a4a";
                ((MainViewModel) miViewmodel).setColor(color);
                break;

            case R.id.btnBlue:
                color = "#4a7df7";
                ((MainViewModel) miViewmodel).setColor(color);
                break;
        }
    }

    public void replaceFragment(FragmentColor someFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.your_placeholder, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
