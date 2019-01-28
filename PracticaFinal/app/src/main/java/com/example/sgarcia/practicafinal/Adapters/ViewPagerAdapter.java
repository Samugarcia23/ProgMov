package com.example.sgarcia.practicafinal.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.sgarcia.practicafinal.Entities.Level;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;
import com.example.sgarcia.practicafinal.Views.GameActivity;
import com.example.sgarcia.practicafinal.Views.MainActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL1;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL2;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL3;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL4;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL5;

public class ViewPagerAdapter extends PagerAdapter implements CardAdapter{

    private MainViewModel mViewModel;
    private float mBaseElevation;
    private List<Level> mViews;
    private List<Level> mData;

    public ViewPagerAdapter(MainViewModel viewModel){
        this.mViewModel = viewModel;
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(Level level) {
        mViews.add(null);
        mData.add(level);
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public Level getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view;
        Context context = container.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.levelcard2_activity, container, false);
        container.addView(view);
        bind(mData.get(position), view, position);
        Level level = mViewModel.getLevel().get(position);
        mViews.set(position, level);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(Level lv, View view, final int position ) {

        ImageView lock;
        TextView level, playerCoins;
        CardView levelCard;
        Button btnPlay;

        lock = view.findViewById(R.id.lock);
        level = view.findViewById(R.id.level);
        playerCoins = view.findViewById(R.id.playerPoints);
        levelCard = view.findViewById(R.id.card_view);
        btnPlay = view.findViewById(R.id.btnPlay);

        level.setText(Integer.toString(lv.getIdLevel()));
        playerCoins.setText(String.valueOf(mViewModel.getPlayerCoins().getValue()));

        /*if (level.getText().equals("1"))
            mViewModel.setPosition(0);
        else {
            if (level.getText().equals("2"))
                mViewModel.setPosition(1);
            else{
                if (level.getText().equals("3"))
                    mViewModel.setPosition(2);
                else{
                    if (level.getText().equals("4"))
                        mViewModel.setPosition(3);
                    else{
                        if (level.getText().equals("5"))
                            mViewModel.setPosition(4);
                    }
                }
            }
        }*/



        if(mViewModel.levelLocked(position)){
            lock.setImageResource(R.drawable.lockclosed);
            levelCard.setCardBackgroundColor(Color.parseColor("#BDBDBD"));
            btnPlay.setClickable(false);
            btnPlay.setTextColor(Color.parseColor("#9E9E9E"));
        }else{
            lock.setImageResource(R.drawable.lockopen);
            levelCard.setCardBackgroundColor(Color.parseColor(mViewModel.getLevel().get(position).getColor()));
            btnPlay.setClickable(true);
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position){

                    case 0:
                        mViewModel.setSelectedLevel(LEVEL1);
                        mViewModel.setAlgodistinto(LEVEL1);
                        break;

                    case 1:
                        mViewModel.setSelectedLevel(LEVEL2);
                        mViewModel.setAlgodistinto(LEVEL2);
                        break;

                    case 2:
                        mViewModel.setSelectedLevel(LEVEL3);
                        break;

                    case 3:
                        mViewModel.setSelectedLevel(LEVEL4);
                        break;

                    case 4:
                        mViewModel.setSelectedLevel(LEVEL5);
                        break;
                }
            }
        });
    }

}
