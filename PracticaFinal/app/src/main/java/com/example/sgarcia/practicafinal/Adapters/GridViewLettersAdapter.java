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
import android.widget.Toast;

import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.Others.Alphabet;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;
import com.example.sgarcia.practicafinal.ui.Fragments.LogoMainPageFragment;

import java.util.List;


public class GridViewLettersAdapter extends BaseAdapter {

    private GameViewModel gameViewModel;
    private Context context;
    private List<Character> alphabet;
    GridViewLogoNameAdapter logoNameAdapter;
    ViewPagerGameAdapter viewPagerGameAdapter;

    public GridViewLettersAdapter (GameViewModel viewModel, List<Character> alphabet, ViewPagerGameAdapter viewPagerGameAdapter, GridViewLogoNameAdapter logoNameAdapter) {
        this.gameViewModel = viewModel;
        this.alphabet = alphabet;
        this.viewPagerGameAdapter = viewPagerGameAdapter;
        this.logoNameAdapter = logoNameAdapter;
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
        final char [] newLetter = new char[gameViewModel.getSelectedLogo().getValue().getName().toCharArray().length];
        final String[] letter = {""};

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

                    gameViewModel.setLogoPosition(0);
                    gameViewModel.setLetterPosition(position);
                    gameViewModel.setLetterPressed(alphabet.get(position).toString());

                    view.setVisibility(View.INVISIBLE);
                    view.setClickable(false);

                    /*final Observer<String> letterObserver = new Observer<String>() {
                        @Override
                        public void onChanged(@Nullable String s) {
                            if(!s.equals("")){
                                letter[0] =(gameViewModel.getLetterPressed().getValue());
                            }
                        }
                    };

                    gameViewModel.getLetterPressed().observe((LifecycleOwner) context, letterObserver);

                    int posLetter = -1;
                    while (posLetter == -1){
                        for (int i=0;i<newLetter.length;i++){
                            if (newLetter[i] != ' '){
                                newLetter[i] = letter[0].charAt(0);
                                posLetter = i;
                                break;
                            }else{
                                posLetter = i;
                            }
                        }
                    }

                    logoNameAdapter = new GridViewLogoNameAdapter(gameViewModel, answerList(newLetter));
                    viewPagerGameAdapter.addAdapter(logoNameAdapter);*/

                    /*final Observer<String> letterObserver = new Observer<String>() {
                        @Override
                        public void onChanged(@Nullable String s) {
                            if(!s.equals("")){
                                int posLetter = -1;
                                while (posLetter == -1){
                                    for (int i=0;i<newLetter.length;i++){
                                        if (newLetter[i] != ' '){
                                            newLetter[i] = gameViewModel.getLetterPressed().getValue().charAt(0);
                                            posLetter = i;
                                            break;
                                        }else{
                                            posLetter = i;
                                        }
                                    }
                                }

                                logoNameAdapter = new GridViewLogoNameAdapter(gameViewModel, answerList(newLetter));
                            }
                        }
                    };

                    gameViewModel.getLetterPressed().observe((LifecycleOwner) context, letterObserver);*/

                    /*if (gameViewModel.getSelectedLogo().getValue().getName().contains(alphabet.get(position).toString())) {

                        char compare = alphabet.get(position);

                        for (int i = 0; i < gameViewModel.getSelectedLogo().getValue().getName().toCharArray().length; i++){

                        }

                    }*/
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
