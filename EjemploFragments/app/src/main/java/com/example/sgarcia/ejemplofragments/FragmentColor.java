package com.example.sgarcia.ejemplofragments;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentColor extends Fragment {


    Button btnRed, btnBlue;
    public ViewModel miViewmodel;
    String color;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.color_layout, container, false);
        miViewmodel = ViewModelProviders.of(this).get(MainViewModel.class);
        final Observer<String> observer = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                rootView.setBackgroundColor(Color.parseColor(s));
            }
        };


        ((MainViewModel) miViewmodel).getColor().observe( this, observer);

        return rootView;
    }
}
