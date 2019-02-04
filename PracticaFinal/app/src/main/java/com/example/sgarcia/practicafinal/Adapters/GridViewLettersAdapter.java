package com.example.sgarcia.practicafinal.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;

import java.util.List;

public class GridViewLettersAdapter extends BaseAdapter {

    private GameViewModel gameViewModel;
    private Context context;
    private List<Character> alphabet;

    public GridViewLettersAdapter (GameViewModel viewModel, List<Character> alphabet) { this.gameViewModel = viewModel; this.alphabet = alphabet;}

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

            if (alphabet.get(position).equals("null")){

                btnLetter = new Button(context);
                btnLetter.setLayoutParams(new GridLayout.LayoutParams());
                btnLetter.setPadding(8,8,8,8);
                btnLetter.setBackgroundColor(Color.parseColor("#424242"));

            } else{

                btnLetter = new Button(context);
                btnLetter.setLayoutParams(new GridLayout.LayoutParams());
                btnLetter.setPadding(8,8,8,8);
                btnLetter.setBackgroundColor(Color.parseColor("#EEEEEE"));
                btnLetter.setTextColor(Color.parseColor("#424242"));
                btnLetter.setText(alphabet.get(position).toString());
                btnLetter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "Has pulsado "+alphabet.get(position), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }else {
            btnLetter = (Button) view;
        }

        return btnLetter;

    }
}
