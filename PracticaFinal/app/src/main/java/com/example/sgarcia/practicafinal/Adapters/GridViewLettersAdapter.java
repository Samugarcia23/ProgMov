package com.example.sgarcia.practicafinal.Adapters;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;

import java.util.ArrayList;
import java.util.List;


public class GridViewLettersAdapter extends BaseAdapter {

    private GameViewModel gameViewModel;
    private Context context;
    private List<Character> alphabet;
    private ArrayList<ArrayList<View>> viewArrayList = new ArrayList<>();


    public GridViewLettersAdapter (GameViewModel viewModel, List<Character> alphabet) {
        this.gameViewModel = viewModel;
        this.alphabet = alphabet;
        for (int i = 0; i < 20; i++)
            viewArrayList.add(new ArrayList<>());
    }

    @Override
    public int getCount() {
        return alphabet.size();
    }

    @Override
    public Object getItem(int i) {
        return alphabet.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Button btnLetter;
        context = parent.getContext();
        LevelSelection levelSelection = gameViewModel.getSelectedLevel().getValue();

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

        Logo logo = gameViewModel.getLevel().get(level2).getLevelLogos().get(gameViewModel.getViewPagerPosition().getValue());

        if (view == null){

            btnLetter = new Button(context);
            btnLetter.setLayoutParams(new GridLayout.LayoutParams());
            btnLetter.setPadding(8,8,8,8);
            btnLetter.setBackgroundColor(Color.parseColor("#EEEEEE"));
            btnLetter.setTextColor(Color.parseColor("#424242"));
            btnLetter.setText(alphabet.get(position).toString());
            btnLetter.setTag("btn" + logo.getName());
            btnLetter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Logo logo = gameViewModel.getLevel().get(level2).getLevelLogos().get(gameViewModel.getViewPagerPosition().getValue());

                    if (gameViewModel.getArraylistLength()[gameViewModel.getViewPagerPosition().getValue()] == logo.getName().toCharArray().length){
                        view.setClickable(false);
                    }else{
                        view.setVisibility(View.INVISIBLE);
                        view.setEnabled(false);
                        viewArrayList.get(gameViewModel.getViewPagerPosition().getValue()).add(view);
                        gameViewModel.setLetterPressed(alphabet.get(position).toString());
                    }
                }

            });

            final Observer<Boolean> deleteClickedObserver = new Observer<Boolean>() {
                @Override
                public void onChanged(@Nullable Boolean aBoolean) {
                    Logo logo = gameViewModel.getLevel().get(level2).getLevelLogos().get(gameViewModel.getViewPagerPosition().getValue());
                    if (!logo.isGuessed()){
                        if (aBoolean){
                            for (int i = 0; i < viewArrayList.get(gameViewModel.getViewPagerPosition().getValue()).size(); i++){
                                if (viewArrayList.get(gameViewModel.getViewPagerPosition().getValue()) != null){
                                    viewArrayList.get(gameViewModel.getViewPagerPosition().getValue()).get(i).setVisibility(View.VISIBLE);
                                    viewArrayList.get(gameViewModel.getViewPagerPosition().getValue()).get(i).setEnabled(true);
                                } else
                                    break;
                            }
                        }
                    }
                }
            };

            gameViewModel.get_deleteClicked().observe((LifecycleOwner) context, deleteClickedObserver);

            final Observer<Boolean> logoGuessedObserver = new Observer<Boolean>() {
                @Override
                public void onChanged(@Nullable Boolean aBoolean) {

                    if (aBoolean){
                        for (int i = 0; i < viewArrayList.get(gameViewModel.getViewPagerPosition().getValue()).size(); i++){
                            if (viewArrayList.get(gameViewModel.getViewPagerPosition().getValue()) != null){
                                viewArrayList.get(gameViewModel.getViewPagerPosition().getValue()).get(i).setEnabled(false);
                            } else
                                break;
                        }
                    }
                }
            };

            gameViewModel.getLogoGuessed().observe((LifecycleOwner) context, logoGuessedObserver);

        }else {
            btnLetter = (Button) view;
        }

        return btnLetter;

    }

}
