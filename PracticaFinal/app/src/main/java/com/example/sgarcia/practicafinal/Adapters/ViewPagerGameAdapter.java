package com.example.sgarcia.practicafinal.Adapters;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.Others.Alphabet;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;
import com.example.sgarcia.practicafinal.ui.Fragments.LogoMainPageFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 *
 *   Clase que funciona como adaptador del ViewPager "logoViewPager" del layout "logomainpage_activity"
 *
 */

public class ViewPagerGameAdapter extends PagerAdapter implements CardLogoAdapter {

    GameViewModel gameViewModel;
    private List<Logo> mViews;
    private List<Logo> mData;
    GridViewLettersAdapter lettersAdapter;
    GridViewLogoNameAdapter logoNameAdapter;
    public GridView lettersGridView, logoNameGridView;
    Context context;


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
        context = container.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.logoguesswindow_activity, container, false);
        container.addView(view);
        Logo logo = gameViewModel.getSelectedLogo().getValue();
        bind(mData.get(position), view);
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

    private void bind(Logo logo, View view) {

        ImageView imgLogo;
        final int[] letterPos = {0};

        imgLogo = view.findViewById(R.id.selectedlogo);

        lettersGridView = view.findViewById(R.id.lettersgridview);
        logoNameGridView = view.findViewById(R.id.logonamegridview);

        imgLogo.setImageResource(logo.getImg());

        lettersAdapter = new GridViewLettersAdapter(gameViewModel, logo.getCharList());
        logoNameAdapter = new GridViewLogoNameAdapter(gameViewModel, answerList(logo.getName().toCharArray()));

        lettersGridView.setAdapter(lettersAdapter);
        logoNameGridView.setAdapter(logoNameAdapter);

        /*final Observer<Integer> letterPosObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                letterPos[0] = integer;
            }
        };

        gameViewModel.getLetterPosition().observe((LifecycleOwner) context, letterPosObserver);

        final Observer<String> letterObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if(!s.equals("")){
                    //logo.getCharList().set(letterPos[0], ' ');
                    lettersAdapter.(letterPos[0]);
                    lettersAdapter = new GridViewLettersAdapter(gameViewModel, logo.getCharList());
                    gameViewModel.setLetterPressed("");
                }
            }
        };

        gameViewModel.getLetterPressed().observe((LifecycleOwner) context, letterObserver);*/

    }

    private char[] answerList(char[] answer){
        char result[] = new char[answer.length];
        for (int i=0; i<answer.length;i++)
            result[i] = ' ';

        return result;
    }
}
