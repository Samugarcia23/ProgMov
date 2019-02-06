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
import android.widget.GridView;

import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;

import java.util.List;


public class GridViewLettersAdapter extends BaseAdapter {

    private GameViewModel gameViewModel;
    private Context context;
    private List<Character> alphabet;
    GridViewLogoNameAdapter logoNameAdapter;
    ViewPagerGameAdapter viewPagerGameAdapter;
    GridView logoNameGridView;

    public GridViewLettersAdapter (GameViewModel viewModel, List<Character> alphabet, ViewPagerGameAdapter viewPagerGameAdapter, GridViewLogoNameAdapter logoNameAdapter, GridView logoNameGridView) {
        this.gameViewModel = viewModel;
        this.alphabet = alphabet;
        this.viewPagerGameAdapter = viewPagerGameAdapter;
        this.logoNameAdapter = logoNameAdapter;
        this.logoNameGridView = logoNameGridView;
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
        final char[] newLetter = new char[gameViewModel.getSelectedLogo().getValue().getName().toCharArray().length];
        final char[] newLetter2 = answerList(newLetter);
        final char[][] vmChar = new char[1][1];

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

                    gameViewModel.setLetterPosition(position);
                    gameViewModel.setLetterPressed(alphabet.get(position).toString());
                    final int adapterPos = viewPagerGameAdapter.getItemPosition(gameViewModel.getSelectedLogo().getValue());
                    final Logo[] selectedLogo = new Logo[1];

                    view.setVisibility(View.INVISIBLE);
                    view.setClickable(false);

                    final Observer<Logo> logoObserver = new Observer<Logo>() {
                        @Override
                        public void onChanged(@Nullable Logo logo) {
                            selectedLogo[0] = gameViewModel.getSelectedLogo().getValue();
                        }
                    };

                    gameViewModel.getSelectedLogo().observe((LifecycleOwner) context, logoObserver);

                    final Observer<String> letterObserver = new Observer<String>() {
                        @Override
                        public void onChanged(@Nullable String s) {
                            if (!s.equals("") && viewPagerGameAdapter.getItemPosition(selectedLogo[0]) == adapterPos){

                                if (gameViewModel.getCharArray().getValue() == null){
                                    gameViewModel.initCharArray(selectedLogo[0].getName().toCharArray().length);
                                    gameViewModel.setCharArray(answerList(gameViewModel.getCharArray().getValue()));
                                    int posLetter = -1;
                                    while (posLetter == -1){
                                        for (int j = 0; j<gameViewModel.getCharArray().getValue().length; j++){
                                            if (answerList(gameViewModel.getCharArray().getValue())[j] == ' '){
                                                gameViewModel.addChar(gameViewModel.getLetterPressed().getValue().charAt(0), j);
                                                posLetter = j;
                                                vmChar[0] = gameViewModel.getCharArray().getValue();
                                                break;
                                            }
                                        }
                                    }

                                }else{
                                    gameViewModel.setCharArray(vmChar[0]);
                                    int posLetter = -1;
                                    while (posLetter == -1){
                                        for (int j = 0; j<gameViewModel.getCharArray().getValue().length; j++){
                                            if (answerList(gameViewModel.getCharArray().getValue())[j] == ' '){
                                                gameViewModel.addChar(gameViewModel.getLetterPressed().getValue().charAt(0), j);
                                                posLetter = j;
                                                vmChar[0] = gameViewModel.getCharArray().getValue();
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    };

                    gameViewModel.getLetterPressed().observe((LifecycleOwner) context, letterObserver);

                    final Observer<char[]> charObserver = new Observer<char[]>() {
                        @Override
                        public void onChanged(@Nullable char[] chars) {
                            if (chars != null && !gameViewModel.getLetterPressed().getValue().equals("") && viewPagerGameAdapter.getItemPosition(gameViewModel.getSelectedLogo().getValue()) == adapterPos){

                                int posLetter = -1;
                                while (posLetter == -1){
                                    for (int i=0;i<newLetter2.length;i++){
                                        if (newLetter2[i] == ' '){
                                            newLetter2[i] = gameViewModel.getCharArray().getValue()[i];
                                            posLetter = i;
                                            break;
                                        }
                                    }
                                }

                                logoNameAdapter = new GridViewLogoNameAdapter(gameViewModel, newLetter2);
                                logoNameGridView.setAdapter(logoNameAdapter);
                                logoNameAdapter.notifyDataSetChanged();
                            }
                        }
                    };

                    gameViewModel.getCharArray().observe((LifecycleOwner) context, charObserver);

                }
            });


        }else {
            btnLetter = (Button) view;
        }

        return btnLetter;

    }

    private char[] answerList(char[] answer){
        char result[] = new char[answer.length];
        for (int i=0; i<answer.length;i++)
            result[i] = ' ';

        return result;
    }
}
