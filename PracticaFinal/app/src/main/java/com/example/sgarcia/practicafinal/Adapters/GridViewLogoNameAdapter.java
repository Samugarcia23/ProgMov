package com.example.sgarcia.practicafinal.Adapters;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;
import com.example.sgarcia.practicafinal.ui.Fragments.LogoMainPageFragment;

import java.util.ArrayList;

public class GridViewLogoNameAdapter extends BaseAdapter {

    private GameViewModel gameViewModel;
    private ArrayList<Character> answerLetter;
    private Context context;
    private ArrayList<ArrayList<View>> viewArrayList = new ArrayList<>();
    private LevelSelection levelSelection;
    Logo logo;

    public GridViewLogoNameAdapter (GameViewModel viewModel, ArrayList<Character> letter) {
        this.gameViewModel = viewModel;
        this.answerLetter = letter;
        for (int i = 0; i < 20; i++)
            viewArrayList.add(new ArrayList<>());
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

        logo = gameViewModel.getLevel().get(level2).getLevelLogos().get(gameViewModel.getViewPagerPosition().getValue());
    }

    @Override
    public int getCount() {
        return answerLetter.size();
    }

    @Override
    public Object getItem(int i) {
        return answerLetter.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final Button[] btnLetter = new Button[1];
        context = parent.getContext();


        if (view == null){

            btnLetter[0] = new Button(context);
            btnLetter[0].setLayoutParams(new GridLayout.LayoutParams());
            btnLetter[0].setPadding(8,8,8,8);
            btnLetter[0].setBackgroundColor(Color.parseColor("#424242"));
            btnLetter[0].setTextColor(Color.parseColor("#FAFAFA"));
            btnLetter[0].setText(String.valueOf(answerLetter.get(position)));
            viewArrayList.get(gameViewModel.getViewPagerPosition().getValue()).add(btnLetter[0]);

        } else {
            btnLetter[0] =(Button)view;
        }

        return btnLetter[0];
    }
}
