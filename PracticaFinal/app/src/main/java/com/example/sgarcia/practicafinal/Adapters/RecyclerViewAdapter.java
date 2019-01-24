package com.example.sgarcia.practicafinal.Adapters;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private static final String[] levelCount = {"1", "2", "3", "4", "5"};
    MainViewModel mViewModel;

    public RecyclerViewAdapter(MainViewModel viewModel){
        this.mViewModel = viewModel;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.levelcard_activity, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int viewType) {

        myViewHolder.level.setText(levelCount[viewType]);
        myViewHolder.playerCoins.setText(String.valueOf(mViewModel.getPlayerCoins().getValue()));
        myViewHolder.lock.setImageResource(R.drawable.unlocked);
        //myViewHolder.levelCard.setCardBackgroundColor();

    }

    @Override
    public int getItemCount() {
        return levelCount.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView lock;
        public TextView level, playerCoins;
        public CardView levelCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            lock = itemView.findViewById(R.id.lock);
            level = itemView.findViewById(R.id.level);
            playerCoins = itemView.findViewById(R.id.playerPoints);
            levelCard = itemView.findViewById(R.id.card_view);
        }
    }
}
