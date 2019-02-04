package com.example.sgarcia.practicafinal.ui.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.sgarcia.practicafinal.Adapters.GridViewLettersAdapter;
import com.example.sgarcia.practicafinal.Adapters.GridViewLogoNameAdapter;
import com.example.sgarcia.practicafinal.Adapters.ViewPagerGameAdapter;
import com.example.sgarcia.practicafinal.Entities.Level;
import com.example.sgarcia.practicafinal.Others.Alphabet;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL1;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL2;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL3;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL4;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL5;

/*
 *
 *   Clase LogoMainPageFragment (extiende de Fragment)
 *
 */

public class LogoMainPageFragment extends Fragment {

    GameViewModel gameViewModel;
    ViewPagerGameAdapter adapter;
    ViewPager vp;
    LevelSelection levelSelection;


    //Metodo que devuelve un nuevo LogoMainPageFragment

    public static LogoMainPageFragment newInstance() {
        return new LogoMainPageFragment();
    }

    //Metodo que infla el layout del fragment

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.logomainpage_activity, container, false);
    }

    //Metodo que se ejecuta al crearse la actividad. Asigna el adaptador (ViewPagerGameAdapter) al viewpager

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gameViewModel = ViewModelProviders.of(getActivity()).get(GameViewModel.class);
        vp = getActivity().findViewById(R.id.logoViewPager);
        adapter = new ViewPagerGameAdapter(gameViewModel);
        levelSelection = gameViewModel.getSelectedLevel().getValue();

        int level = 0;

        switch (levelSelection){

            case LEVEL1:
                level = 0;
                break;

            case LEVEL2:
                level = 1;
                break;

            case LEVEL3:
                level = 2;
                break;

            case LEVEL4:
                level = 3;
                break;

            case LEVEL5:
                level = 4;
                break;
        }

        for (int i = 0; i< gameViewModel.getLevel().get(level).getLevelLogos().size(); i++){
            adapter.addCardItem(gameViewModel.getLevel().get(level).getLevelLogos().get(i));
        }

        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(20);
        vp.setCurrentItem(gameViewModel.getLogoPosition());
    }
}
