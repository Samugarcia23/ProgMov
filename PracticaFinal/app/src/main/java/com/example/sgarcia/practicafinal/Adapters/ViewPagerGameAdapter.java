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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.Others.Alphabet;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
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
    GridView lettersGridView, logoNameGridView;
    Context context;
    Animation myAnim;

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

        ImageView imgLogo, rightarrow, leftarrow, delete, help, logoguessed;
        ArrayList<Character> logoNameCharList = new ArrayList<>();
        myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce);
        final Logo[] slctLogo = new Logo[1];

        for (int i = 0; i<logo.getName().toCharArray().length; i ++)
            logoNameCharList.add(logo.getName().toCharArray()[i]);

        imgLogo = view.findViewById(R.id.selectedlogo);
        rightarrow = view.findViewById(R.id.rightarrow);
        leftarrow = view.findViewById(R.id.leftarrow);
        delete = view.findViewById(R.id.delete);
        help = view.findViewById(R.id.help);
        logoguessed = view.findViewById(R.id.logoguessedmain);
        imgLogo.setTag("img" + logo.getName());
        logoguessed.setTag("check" + logo.getName());

        lettersGridView = view.findViewById(R.id.lettersgridview);
        logoNameGridView = view.findViewById(R.id.logonamegridview);
        logoNameGridView.setTag("logoNameGridView" + logo.getName());

        imgLogo.setImageResource(logo.getImg());

        if (logo.isGuessed()){
            ImageView selectedcheck = logoguessed.findViewWithTag("check" + logo.getName());
            selectedcheck.setVisibility(View.VISIBLE);
            ImageView selectedLogo = imgLogo.findViewWithTag("img" + logo.getName());
            selectedLogo.setImageAlpha(50);
        }else{
            logoguessed.setVisibility(View.INVISIBLE);
        }

        final Observer<Integer> vpPosOserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer == 0){
                    leftarrow.setVisibility(View.INVISIBLE);
                }else{
                    leftarrow.setVisibility(View.VISIBLE);
                }

                if (integer == 19){
                    rightarrow.setVisibility(View.INVISIBLE);
                }else{
                    rightarrow.setVisibility(View.VISIBLE);
                }
            }
        };

        gameViewModel.getViewPagerPosition().observe((LifecycleOwner) context, vpPosOserver);

        final Observer<Boolean> logoGuessedObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {

                if (aBoolean){
                    if (aBoolean){
                        help.setEnabled(true);
                        delete.setEnabled(true);
                    }else{
                        logoguessed.setVisibility(View.INVISIBLE);
                    }
                }
            }
        };

        gameViewModel.getLogoGuessed().observe((LifecycleOwner) context, logoGuessedObserver);

        if (!logo.isGuessed()){
            logoNameAdapter = new GridViewLogoNameAdapter(gameViewModel, answerList(logoNameCharList));
            lettersAdapter = new GridViewLettersAdapter(gameViewModel, logo.getCharList());

            lettersGridView.setAdapter(lettersAdapter);
            logoNameGridView.setAdapter(logoNameAdapter);

            lettersAdapter.notifyDataSetChanged();
            logoNameAdapter.notifyDataSetChanged();
        }else{
            logoNameCharList = new ArrayList<>();

            for (int i = 0; i < logo.getName().toCharArray().length; i++)
                logoNameCharList.add(logo.getName().toCharArray()[i]);

            logoNameAdapter = new GridViewLogoNameAdapter(gameViewModel, logoNameCharList);
            for (int i = 0; i < logo.getCharList().size(); i++)
                logo.getCharList().remove(i);
            lettersAdapter = new GridViewLettersAdapter(gameViewModel, logo.getCharList());

            lettersGridView.setAdapter(lettersAdapter);
            lettersGridView.setVisibility(View.INVISIBLE);
            lettersGridView.setEnabled(false);
            logoNameGridView.setAdapter(logoNameAdapter);

            lettersAdapter.notifyDataSetChanged();
            logoNameAdapter.notifyDataSetChanged();
        }


        rightarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightarrow.setAnimation(myAnim);
                gameViewModel.setRightArrowPressed(true);
            }
        });

        leftarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftarrow.setAnimation(myAnim);
                gameViewModel.setLeftArrowPressed(true);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameViewModel.setDeleteClicked(true);
                delete.startAnimation(myAnim);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameViewModel.setHelpClicked(true);
                help.startAnimation(myAnim);
            }
        });

    }

    private ArrayList<Character> answerList(ArrayList<Character> answer){
        ArrayList<Character> result = new ArrayList<>();
        for (int i=0; i<answer.size();i++)
            result.add(i, '_');

        return result;
    }

}
