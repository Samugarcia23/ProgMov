package com.example.sgarcia.ejemplofragments;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    Button btnRed, btnBlue;
    public ViewModel miViewmodel;
    String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRed = findViewById(R.id.btnRed);
        btnBlue = findViewById(R.id.btnBlue);
        miViewmodel = ViewModelProviders.of(this).get(MainViewModel.class);

        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        FragmentColor fragment;
        switch (v.getId()){

            case R.id.btnRed:
                fragment = new FragmentColor();
                color = "#f74a4a";
                ((MainViewModel) miViewmodel).setColor(color);
                replaceFragment(fragment);
                break;

            case R.id.btnBlue:
                fragment = new FragmentColor();
                color = "#4a7df7";
                ((MainViewModel) miViewmodel).setColor(color);
                replaceFragment(fragment);
                break;
        }
    }

    public void replaceFragment(FragmentColor someFragment) {
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.your_placeholder, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
