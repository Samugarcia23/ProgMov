package com.example.sgarcia.practicafinal.Adapters;

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
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;
import com.example.sgarcia.practicafinal.ui.Fragments.LogoMainPageFragment;

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

                        Toast.makeText(view.getContext(), gameViewModel.getSelectedLogo().getValue().getName(), Toast.LENGTH_SHORT).show();

                        /*if (gameViewModel.getSelectedLogo().getValue().getName().contains(alphabet.get(position).toString())) {

                            char compare = alphabet.get(position);

                            for (int i = 0; i < gameViewModel.getSelectedLogo().getValue().getName().toCharArray().length; i++){

                            }

                        }*/
                    }
                });
            }

        }else {
            btnLetter = (Button) view;
        }

        return btnLetter;

    }
}
