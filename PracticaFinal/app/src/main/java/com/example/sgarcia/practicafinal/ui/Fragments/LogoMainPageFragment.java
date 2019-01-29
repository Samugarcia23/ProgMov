package com.example.sgarcia.practicafinal.ui.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;

public class LogoMainPageFragment extends Fragment {

    GameViewModel gameViewModel;

    public static LogoMainPageFragment newInstance() {
        return new LogoMainPageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.logomainpage_activity, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gameViewModel = ViewModelProviders.of(getActivity()).get(GameViewModel.class);

    }
}
