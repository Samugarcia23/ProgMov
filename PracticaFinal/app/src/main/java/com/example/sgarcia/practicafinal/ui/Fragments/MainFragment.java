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

import com.example.sgarcia.practicafinal.Adapters.ViewPagerAdapter;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;

/*
 *
 *   Clase MainFragment (extiende de Fragment)
 *
 */

public class MainFragment extends Fragment {

    MainViewModel mViewModel;
    ViewPager viewPager;
    ViewPagerAdapter adapter;

    //Metodo que devuelve un nuevo MainFragment

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    //Metodo que infla el layout del fragment

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main2_fragment, container, false);
    }

    //Metodo que se ejecuta al crearse la actividad. Asigna el adaptador (ViewPagerAdapter) al viewpager

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        viewPager = getActivity().findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapter(mViewModel);

        adapter.addCardItem(mViewModel.getLevel().get(0));
        adapter.addCardItem(mViewModel.getLevel().get(1));
        adapter.addCardItem(mViewModel.getLevel().get(2));
        adapter.addCardItem(mViewModel.getLevel().get(3));
        adapter.addCardItem(mViewModel.getLevel().get(4));

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(mViewModel.getLevel().size() - 1);

        final Observer<Integer> levelShowedObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                viewPager.setCurrentItem(integer);
            }
        };

        mViewModel.getLevelBack().observe(this, levelShowedObserver);

        viewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                mViewModel.setPosition(viewPager.getCurrentItem());
            }
        });

    }

}
