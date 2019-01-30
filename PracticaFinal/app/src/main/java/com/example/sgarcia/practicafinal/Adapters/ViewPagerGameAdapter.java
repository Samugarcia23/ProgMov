package com.example.sgarcia.practicafinal.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;

import java.util.ArrayList;
import java.util.List;

/*
 *
 *   Clase que funciona como adaptador del ViewPager "logoViewPager" del layout "logomainpage_activity"
 *
 */

public class ViewPagerGameAdapter extends PagerAdapter implements CardLogoAdapter {

    GameViewModel gameViewModel;
    private List<Logo> mViews;
    private List<Logo> mData;

    //Constructor que recibe como parametro el viewmodel

    public ViewPagerGameAdapter(GameViewModel gameViewModel){

        this.gameViewModel = gameViewModel;
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    //Metodo que recibe un objeto "Logo" y lo añade al listado "mData"

    public void addCardItem(Logo logo) {
        mViews.add(null);
        mData.add(logo);
    }

    //Metodo que devuelve el objeto "Logo" de la posicion recibida por parametro

    @Override
    public Logo getCardViewAt(int position) {
        return mViews.get(position);
    }

    //Metodo que devuelve el total de objetos "Logo" en el listado "mData"

    @Override
    public int getCount() {
        return mData.size();
    }

    //Metodo que recibe una vista y un objeto. Devuelve true si la vista el la del objeto y false si no lo es

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    //Metodo que infla la vista y añade los logos al listado "mViews"

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view;
        Context context = container.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.logoguesswindow_activity, container, false);
        container.addView(view);
        bind(mData.get(position), view, position);
        Logo logo = gameViewModel.getSelectedLogo();
        mViews.set(position, logo);

        return view;
    }

    //Metodo que elimina un objeto "Logo" del listado "mViews" a traves de su posicion

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    //Metodo que asigna cada componente a su vista y les da valores

    private void bind(Logo logo, View view, final int position ) {

        ImageView imgLogo;
        LevelSelection levelSelection;

        imgLogo = view.findViewById(R.id.selectedlogo);
        levelSelection = gameViewModel.getSelectedLevel().getValue();

        int level = 0;

        switch (levelSelection){

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

        imgLogo.setImageResource(gameViewModel.getLevel().get(level).getLevelLogos().get(position).getImg());
    }
}
