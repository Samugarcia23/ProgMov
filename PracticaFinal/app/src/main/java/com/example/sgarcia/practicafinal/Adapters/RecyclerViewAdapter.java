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
        view = inflater.inflate(R.layout.logolist, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.logo.setImageResource(mViewModel.getLevel().get(0).getLevelLogos().get(position).getImg());

        /*myViewHolder.level.setText(levelCount[viewType]);
        myViewHolder.playerCoins.setText(String.valueOf(mViewModel.getPlayerCoins().getValue()));

        if(mViewModel.levelLocked(viewType)){
            myViewHolder.lock.setImageResource(R.drawable.lockclosed);
           // myViewHolder.levelCard.setCardBackgroundColor(Color.parseColor("#BDBDBD"));
        }else{
            myViewHolder.lock.setImageResource(R.drawable.lockopen);
            myViewHolder.levelCard.setCardBackgroundColor(Color.parseColor(mViewModel.getLevel().get(viewType).getColor()));
        }
        myViewHolder.levelCard.setCardBackgroundColor(Color.parseColor(mViewModel.getLevel().get(viewType).getColor()));*/



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
