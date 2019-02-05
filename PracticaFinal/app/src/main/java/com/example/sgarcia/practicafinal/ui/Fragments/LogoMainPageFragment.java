package com.example.sgarcia.practicafinal.ui.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sgarcia.practicafinal.Adapters.ViewPagerGameAdapter;
import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;

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
        final int level2;

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

        level2 = level;

        for (int i = 0; i< gameViewModel.getLevel().get(level).getLevelLogos().size(); i++){
            adapter.addCardItem(gameViewModel.getLevel().get(level).getLevelLogos().get(i));
        }

        vp.setAdapter(adapter);

        final Observer<Integer> posObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                gameViewModel.setLogoPosition(integer);
            }
        };

        gameViewModel.getLogoPosition().observe(this, posObserver);

        vp.setCurrentItem(gameViewModel.getLogoPosition().getValue());

        final Observer<Logo> logoObserver = new Observer<Logo>() {
            @Override
            public void onChanged(@Nullable Logo logo) {

                vp.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                    @Override
                    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                        gameViewModel.setSelectedLogo(logo);
                    }
                });
            }
        };

        gameViewModel.getSelectedLogo().observe(this, logoObserver);

    }

}
