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

import java.util.ArrayList;
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

                    final ArrayList[] characters = {new ArrayList()};

                    /*final Observer<Logo> logoChangedObserver = new Observer<Logo>() {
                        @Override
                        public void onChanged(@Nullable Logo logo) {
                            if (logo != null){

                            }
                        }
                    };

                    gameViewModel.getSelectedLogo().observe((LifecycleOwner) context, logoChangedObserver);*/

                    if (gameViewModel.getArraylistLength() == gameViewModel.getSelectedLogo().getValue().getName().toCharArray().length){
                        view.setClickable(false);
                    }else{
                        view.setVisibility(View.INVISIBLE);
                        view.setEnabled(false);
                        gameViewModel.setLetterPressed(alphabet.get(position).toString());
                        //Arraylist de views??
                    }

                    final Observer<String> letterObserver = new Observer<String>() {
                        @Override
                        public void onChanged(@Nullable String s) {
                            if (!s.equals("") && gameViewModel.getArraylistLength() < gameViewModel.getSelectedLogo().getValue().getName().toCharArray().length){

                                if (gameViewModel.getArraylistLength() == 0){
                                    for (int i = 0; i<gameViewModel.getSelectedLogo().getValue().getName().toCharArray().length; i ++){
                                        gameViewModel.getCharArray().getValue().add(gameViewModel.getSelectedLogo().getValue().getName().toCharArray()[i]);
                                    }

                                    for (int i=0; i<gameViewModel.getCharArray().getValue().size();i++)
                                        characters[0].add(i, '_');
                                }

                                int posLetter = -1;
                                while (posLetter == -1){
                                    for (int i=0;i<characters[0].size();i++){
                                        if (characters[0].get(i).toString().equals("_")){
                                            characters[0].set(i, gameViewModel.getLetterPressed().getValue().charAt(0));
                                            posLetter = i;
                                            break;
                                        }
                                    }
                                }

                                gameViewModel.setArraylistLength(gameViewModel.getArraylistLength() + 1);

                            }else{
                                view.setClickable(false);
                            }
                        }
                    };

                    gameViewModel.getLetterPressed().observe((LifecycleOwner) context, letterObserver);
                    logoNameAdapter = new GridViewLogoNameAdapter(gameViewModel, characters[0]);
                    logoNameGridView.setAdapter(logoNameAdapter);
                    logoNameAdapter.notifyDataSetChanged();
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
