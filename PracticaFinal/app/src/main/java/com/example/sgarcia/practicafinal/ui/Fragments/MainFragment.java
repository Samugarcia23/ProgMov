package com.example.sgarcia.practicafinal.ui.Fragments;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sgarcia.practicafinal.Adapters.RecyclerViewAdapter;
import com.example.sgarcia.practicafinal.Adapters.ViewPagerAdapter;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;

import java.util.Objects;

public class MainFragment extends Fragment {

    MainViewModel mViewModel;
    ViewPager viewPager;
    ViewPagerAdapter adapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main2_fragment, container, false);
    }

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

        viewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                mViewModel.setPosition(viewPager.getCurrentItem());
            }
        });

    }

}
