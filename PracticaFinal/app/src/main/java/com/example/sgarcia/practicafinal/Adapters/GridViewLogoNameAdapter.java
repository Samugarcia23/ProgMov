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

public class GridViewLogoNameAdapter extends BaseAdapter {

    private GameViewModel gameViewModel;
    private char[] answerLetter;
    private Context context;

    public GridViewLogoNameAdapter (GameViewModel viewModel, char[] letter) {
        this.gameViewModel = viewModel;
        this.answerLetter = letter;
    }

    @Override
    public int getCount() {
        return answerLetter.length;
    }

    @Override
    public Object getItem(int i) {
        return answerLetter[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final Button[] btnLetter = new Button[1];
        context = parent.getContext();
        final char [] newLetter = new char[gameViewModel.getSelectedLogo().getValue().getName().toCharArray().length];
        final String[] letter = {""};

        if (view == null){

            btnLetter[0] = new Button(context);
            btnLetter[0].setLayoutParams(new GridLayout.LayoutParams());
            btnLetter[0].setPadding(8,8,8,8);
            btnLetter[0].setBackgroundColor(Color.parseColor("#424242"));
            btnLetter[0].setTextColor(Color.parseColor("#FAFAFA"));
            btnLetter[0].setText(String.valueOf(answerLetter[position]));

            final Observer<String> letterObserver = new Observer<String>() {
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

                        Button newBtn = new Button(context);
                        newBtn.setLayoutParams(new GridLayout.LayoutParams());
                        newBtn.setPadding(8,8,8,8);
                        newBtn.setBackgroundColor(Color.parseColor("#424242"));
                        newBtn.setTextColor(Color.parseColor("#FAFAFA"));
                        newBtn.setText(String.valueOf(newLetter));

                        btnLetter[0] = newBtn;
                        notifyDataSetChanged();

                    }
                }
            };

            gameViewModel.getLetterPressed().observe((LifecycleOwner) context, letterObserver);

        } else {
            btnLetter[0] =(Button)view;
        }

        return btnLetter[0];
    }
}
