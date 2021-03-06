package com.example.sgarcia.practicafinal.ui.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sgarcia.practicafinal.Adapters.RecyclerViewAdapter;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;

/*
 *
 *   Clase LogolistFragment (extiende de Fragment)
 *
 */

public class LogoListFragment extends Fragment {

    GameViewModel gameViewModel;
    RecyclerViewAdapter adapter;
    RecyclerView rvlogo;

    //Metodo que devuelve un nuevo LogoListFragment

    public static LogoListFragment newInstance() {
        return new LogoListFragment();
    }

    //Metodo que infla el layout del fragment

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.logolistfragment_activity, container, false);
    }

    //Metodo que se ejecuta al crearse la actividad. Asigna el adaptador (RecyclerViewAdapter) al recyclerview

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gameViewModel = ViewModelProviders.of(getActivity()).get(GameViewModel.class);

        adapter = new RecyclerViewAdapter(gameViewModel);
        rvlogo = getActivity().findViewById(R.id.rvlogo);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
        rvlogo.setLayoutManager(mLayoutManager);
        rvlogo.setAdapter(adapter);

    }

}
