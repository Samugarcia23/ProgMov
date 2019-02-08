package com.example.sgarcia.practicafinal.Adapters;

import android.content.Context;
import android.graphics.Color;
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

    public GridViewLettersAdapter (GameViewModel viewModel, List<Character> alphabet) {
        this.gameViewModel = viewModel;
        this.alphabet = alphabet;
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

        if (view == null){

            btnLetter = new Button(context);
            btnLetter.setLayoutParams(new GridLayout.LayoutParams());
            btnLetter.setPadding(8,8,8,8);
            btnLetter.setBackgroundColor(Color.parseColor("#EEEEEE"));
            btnLetter.setTextColor(Color.parseColor("#424242"));
            btnLetter.setText(alphabet.get(position).toString());
            btnLetter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

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

                    if (gameViewModel.getArraylistLength()[gameViewModel.getViewPagerPosition().getValue()] == logo.getName().toCharArray().length){
                        view.setClickable(false);
                    }else{
                        view.setVisibility(View.INVISIBLE);
                        view.setEnabled(false);
                        gameViewModel.setLetterPressed(alphabet.get(position).toString());
                        //Arraylist de views??
                    }
                }

            });

        }else {
            btnLetter = (Button) view;
        }

        return btnLetter;

    }

    private ArrayList<Character> answerList(ArrayList<Character> answer){
        ArrayList<Character> result = new ArrayList<>();
        for (int i=0; i<answer.size();i++)
            result.set(i, ' ');

        return result;
    }
}
