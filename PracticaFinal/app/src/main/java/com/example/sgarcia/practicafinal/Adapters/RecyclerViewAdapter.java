package com.example.sgarcia.practicafinal.Adapters;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;
import com.example.sgarcia.practicafinal.Views.GameActivity;
import com.example.sgarcia.practicafinal.Views.MainActivity;
import com.example.sgarcia.practicafinal.ui.Fragments.LogoListFragment;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    GameViewModel mViewModel;
    Context context;

    public RecyclerViewAdapter(GameViewModel viewModel){
        this.mViewModel = viewModel;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.logolist, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int posicion) {

        int level = 0;
        switch (mViewModel.getSelectedLevel().getValue()){
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


        myViewHolder.logo.setImageResource(mViewModel.getLevel().get(level).getLevelLogos().get(myViewHolder.getAdapterPosition()).getImg());

        myViewHolder.logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PREGUNTAR A DYLAN
            }
        });

    }

    @Override
    public int getItemCount() {
        return mViewModel.getLevel().get(0).getLevelLogos().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView logo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            logo = itemView.findViewById(R.id.logo);

        }
    }
}
