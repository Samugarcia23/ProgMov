package com.example.sgarcia.practicafinal;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sgarcia.practicafinal.ui.main.MainFragment;
import com.example.sgarcia.practicafinal.ui.main.MainViewModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private static final String[] totalNiveles = {"1", "2", "3", "4", "5"};
    private ViewModel mViewModel;

    public RecyclerViewAdapter(ViewModel viewModel){
        this.mViewModel = viewModel;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.levelcard_activity, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int viewType) {

        myViewHolder.level.setText(totalNiveles[viewType]);
       // myViewHolder.playerCoins.setText(((MainViewModel)mViewModel).getPlayerCoins());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView lock;
        public TextView level, playerCoins, totalCoins;
        public CardView levelCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            lock = itemView.findViewById(R.id.lock);
            level = itemView.findViewById(R.id.level);
            playerCoins = itemView.findViewById(R.id.playerPoints);
            totalCoins = itemView.findViewById(R.id.levelPoints);
            levelCard = itemView.findViewById(R.id.levelCard);
        }
    }
}
