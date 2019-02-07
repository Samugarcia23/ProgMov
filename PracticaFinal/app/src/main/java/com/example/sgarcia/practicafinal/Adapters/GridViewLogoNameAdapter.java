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

import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;
import com.example.sgarcia.practicafinal.ui.Fragments.LogoMainPageFragment;

import java.util.ArrayList;

public class GridViewLogoNameAdapter extends BaseAdapter {

    private GameViewModel gameViewModel;
    private ArrayList<Character> answerLetter;
    private Context context;

    public GridViewLogoNameAdapter (GameViewModel viewModel, ArrayList<Character> letter) {
        this.gameViewModel = viewModel;
        this.answerLetter = letter;
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

            /*final Observer<ArrayList<Character>> charObserver = new Observer<ArrayList<Character>>() {
                @Override
                public void onChanged(@Nullable ArrayList<Character> characters) {
                    if (characters != null && !gameViewModel.getLetterPressed().getValue().equals("")){
                        notifyDataSetChanged();
                    }
                }
            };

            gameViewModel.getCharArray().observe((LifecycleOwner) context, charObserver);*/


        } else {
            btnLetter[0] =(Button)view;
        }

        return btnLetter[0];
    }
}
