package com.example.sgarcia.practicafinal.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;

public class GridViewLogoNameAdapter extends BaseAdapter {

    private GameViewModel gameViewModel;
    private char[] answerLetter;
    private Context context;

    public GridViewLogoNameAdapter (GameViewModel viewModel, char[] letter) { this.gameViewModel = viewModel; this.answerLetter = letter;}

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
        Button btnLetter;
        context = parent.getContext();

        if (view == null){

            btnLetter = new Button(context);
            btnLetter.setLayoutParams(new GridLayout.LayoutParams());
            btnLetter.setPadding(8,8,8,8);
            btnLetter.setBackgroundColor(Color.parseColor("#424242"));
            btnLetter.setTextColor(Color.parseColor("#FAFAFA"));
            btnLetter.setText(String.valueOf(answerLetter[position]));

        } else {
            btnLetter =(Button)view;
        }

        return btnLetter;
    }
}
