package com.example.sgarcia.practicafinal.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sgarcia.practicafinal.Entities.Level;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL1;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL2;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL3;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL4;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL5;

/*
 *
 *   Clase que funciona como adaptador del ViewPager "viewpager" del layout "main2_fragment"
 *
 */

public class ViewPagerAdapter extends PagerAdapter implements CardAdapter{

    private MainViewModel mViewModel;
    private List<Level> mViews;
    private List<Level> mData;

    //Constructor que recibe como parametro el viewmodel

    public ViewPagerAdapter(MainViewModel viewModel){
        this.mViewModel = viewModel;
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    //Metodo que recibe un objeto "Level" y lo añade al listado "mData"

    public void addCardItem(Level level) {
        mViews.add(null);
        mData.add(level);
    }

    //Metodo que devuelve el objeto "Level" de la posicion recibida por parametro

    @Override
    public Level getCardViewAt(int position) {
        return mViews.get(position);
    }

    //Metodo que devuelve el total de objetos "Level" en el listado "mData"

    @Override
    public int getCount() {
        return mData.size();
    }

    //Metodo que recibe una vista y un objeto. Devuelve true si la vista el la del objeto y false si no lo es

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    //Metodo que infla la vista y añade los niveles al listado "mViews"

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

    //Metodo que elimina un objeto "Level" del listado "mViews" a traves de su posicion

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    //Metodo que asigna cada componente a su vista y les da valores

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

        level.setText(String.valueOf(lv.getIdLevel()));
        playerCoins.setText(String.valueOf(mViewModel.getPlayerCoins().getValue()));

        if(mViewModel.levelLocked(position)){
            lock.setImageResource(R.drawable.lockclosed);
            levelCard.setCardBackgroundColor(Color.parseColor("#BDBDBD"));
            btnPlay.setEnabled(false);
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
                        break;

                    case 1:
                        mViewModel.setSelectedLevel(LEVEL2);
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
