package com.example.sgarcia.practicafinal.ui.Fragments;

import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.sgarcia.practicafinal.Adapters.GridViewLogoNameAdapter;
import com.example.sgarcia.practicafinal.Adapters.ViewPagerGameAdapter;
import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.Others.Alphabet;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 *
 *   Clase LogoMainPageFragment (extiende de Fragment)
 *
 */

public class LogoMainPageFragment extends Fragment {

    GameViewModel gameViewModel;
    ViewPagerGameAdapter adapter;
    ViewPager vp;
    LevelSelection levelSelection;
    GridViewLogoNameAdapter logoNameAdapter;
    GridView logoNameGridView;

    //Metodo que devuelve un nuevo LogoMainPageFragment

    public static LogoMainPageFragment newInstance() {
        return new LogoMainPageFragment();
    }

    //Metodo que infla el layout del fragment

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.logomainpage_activity, container, false);
    }

    //Metodo que se ejecuta al crearse la actividad. Asigna el adaptador (ViewPagerGameAdapter) al viewpager

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gameViewModel = ViewModelProviders.of(getActivity()).get(GameViewModel.class);
        vp = getActivity().findViewById(R.id.logoViewPager);
        adapter = new ViewPagerGameAdapter(gameViewModel);
        levelSelection = gameViewModel.getSelectedLevel().getValue();
        ArrayList<ArrayList<Character>> characters = new ArrayList<>();
        final boolean[] arrayCreated = {false};

        for (int i = 0; i < 20; i++)
            characters.add(new ArrayList<>());

        int level = 0;
        final int level2;

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

        level2 = level;

        for (int i = 0; i< gameViewModel.getLevel().get(level).getLevelLogos().size(); i++){
            adapter.addCardItem(gameViewModel.getLevel().get(level).getLevelLogos().get(i));
        }

        vp.setAdapter(adapter);

        vp.setCurrentItem(gameViewModel.getViewPagerPosition().getValue());

        vp.setOffscreenPageLimit(gameViewModel.getLevel().get(level2).getLevelLogos().size());

        vp.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                gameViewModel.setViewPagerPosition(vp.getCurrentItem());
            }
        });

        final Observer<String> letterObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                Logo logo = gameViewModel.getLevel().get(level2).getLevelLogos().get(vp.getCurrentItem());
                String logoName = "";

                if (!logo.isGuessed()){

                    gameViewModel.setLogoGuessed(false);
                    gameViewModel.setHelpClicked(false);

                    if (!s.equals("") && gameViewModel.getArraylistLength()[vp.getCurrentItem()] < logo.getName().toCharArray().length){

                        if (!arrayCreated[0]){
                            for (int i = 0; i<logo.getName().toCharArray().length; i ++){
                                gameViewModel.getCharArray().getValue().get(vp.getCurrentItem()).add(logo.getName().toCharArray()[i]);
                                arrayCreated[0] = true;
                            }
                        }

                        if (characters.get(vp.getCurrentItem()).size() == 0){
                            for (int i=0; i<logo.getName().toCharArray().length;i++)
                                characters.get(vp.getCurrentItem()).add(i, '_');
                        }

                        int posLetter = -1;
                        while (posLetter == -1){
                            for (int i = 0; i< characters.get(vp.getCurrentItem()).size(); i++){
                                if (characters.get(vp.getCurrentItem()).get(i).toString().equals("_")){
                                    characters.get(vp.getCurrentItem()).set(i, gameViewModel.getLetterPressed().getValue().charAt(0));
                                    posLetter = i;
                                    break;
                                }
                            }
                        }

                        gameViewModel.setArraylistLength(gameViewModel.getArraylistLength()[vp.getCurrentItem()] + 1, vp.getCurrentItem());
                        logoNameAdapter = new GridViewLogoNameAdapter(gameViewModel, characters.get(vp.getCurrentItem()));
                        logoNameGridView = vp.findViewWithTag("logoNameGridView" + logo.getName());
                        logoNameGridView.setAdapter(logoNameAdapter);
                        logoNameAdapter.notifyDataSetChanged();

                        for (int i = 0; i < characters.get(vp.getCurrentItem()).size(); i++){
                            logoName += characters.get(vp.getCurrentItem()).get(i).toString();
                        }

                        if (logoName.equals(logo.getName())){
                            int count = 0;
                            logo.setGuessed(true);
                            gameViewModel.setLogoGuessed(true);
                            gameViewModel.setPlayerCoins(gameViewModel.getLevel().get(level2).getCoins() + 1);
                            gameViewModel.getLevel().get(level2).setCoins(gameViewModel.getLevel().get(level2).getCoins() + 1);
                            for (int i = 0; i < gameViewModel.getLevel().get(level2).getLevelLogos().size(); i++){
                                if (gameViewModel.getLevel().get(level2).getLevelLogos().get(i).isGuessed())
                                    count++;
                            }
                            if(count == gameViewModel.getLevel().get(level2).getLevelLogos().size())
                                allGuessedDialog();
                            logoGuessedDialog();
                        }

                        gameViewModel.setDeleteClicked(false);
                        vibrate();
                    }
                }else{
                    if (characters.get(vp.getCurrentItem()).size() == 0){
                        for (int i=0; i<logo.getName().toCharArray().length;i++)
                            characters.get(vp.getCurrentItem()).add(logo.getName().toCharArray()[i]);
                    }
                    gameViewModel.setArraylistLength(gameViewModel.getArraylistLength()[vp.getCurrentItem()] + 1, vp.getCurrentItem());
                    logoNameAdapter = new GridViewLogoNameAdapter(gameViewModel, characters.get(vp.getCurrentItem()));
                    logoNameGridView = vp.findViewWithTag("logoNameGridView" + logo.getName());
                    logoNameGridView.setAdapter(logoNameAdapter);
                    logoNameAdapter.notifyDataSetChanged();
                }
            }
        };

        gameViewModel.getLetterPressed().observe(this, letterObserver);

        final Observer<Integer> vpPositionObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                vp.setCurrentItem(integer);
            }
        };

        gameViewModel.getViewPagerPosition().observe(this, vpPositionObserver);

        final Observer<Boolean> rightArrowObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean == true){
                    vp.setCurrentItem(gameViewModel.getViewPagerPosition().getValue() + 1);
                    gameViewModel.setRightArrowPressed(false);
                }
            }
        };

        gameViewModel.getRightArrowPressed().observe(this, rightArrowObserver);

        final Observer<Boolean> leftArrowObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean == true){
                    vp.setCurrentItem(gameViewModel.getViewPagerPosition().getValue() - 1);
                    gameViewModel.setLeftArrowPressed(false);
                }
            }
        };

        gameViewModel.getLeftArrowPressed().observe(this, leftArrowObserver);

        final Observer<Boolean> deleteClickedObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {

                Logo logo = gameViewModel.getLevel().get(level2).getLevelLogos().get(vp.getCurrentItem());

                if (!logo.isGuessed()){

                    if (characters.get(vp.getCurrentItem()).size() == 0){
                        for (int i = 0; i < logo.getName().toCharArray().length; i++)
                            characters.get(vp.getCurrentItem()).add(i, '_');
                    }

                    if (aBoolean && characters.get(vp.getCurrentItem()) != null && !characters.get(vp.getCurrentItem()).get(0).toString().equals("_")){
                        for (int i=0; i<characters.get(vp.getCurrentItem()).size();i++)
                            characters.get(vp.getCurrentItem()).set(i, '_');

                        gameViewModel.setArraylistLength(gameViewModel.getArraylistLength()[vp.getCurrentItem()] = 0, vp.getCurrentItem());
                        logoNameAdapter = new GridViewLogoNameAdapter(gameViewModel, characters.get(vp.getCurrentItem()));
                        logoNameGridView = vp.findViewWithTag("logoNameGridView" + logo.getName());
                        logoNameGridView.setAdapter(logoNameAdapter);
                        logoNameAdapter.notifyDataSetChanged();
                    }
                }else{
                    gameViewModel.setLogoGuessed(true);
                }
            }
        };

        gameViewModel.get_deleteClicked().observe(this, deleteClickedObserver);

        final Observer<Boolean> helpClickedObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {

                Logo logo = gameViewModel.getLevel().get(level2).getLevelLogos().get(vp.getCurrentItem());

                if (aBoolean == true && !logo.isGuessed()){

                    char[] answer = logo.getName().toCharArray();
                    ArrayList<Character> charList = new ArrayList<>();

                    Alphabet.selectedName = new char[answer.length];

                    for (char letter : answer){
                        charList.add(letter);
                    }

                    Collections.shuffle(charList);

                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Help");
                    alert.setMessage(charList.toString());
                    alert.setIcon(R.drawable.help);

                    alert.setPositiveButton("Ok", (dialog, whichButton) -> {});

                    alert.show();
                }
            }
        };

        gameViewModel.getHelpClicked().observe(this, helpClickedObserver);

    }

    public void logoGuessedDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getContext());
        alert.setTitle("+ 1 Coin");
        alert.setIcon(R.drawable.coin);

        alert.setPositiveButton("Next Logo", (dialog, whichButton) ->vp.setCurrentItem(gameViewModel.getViewPagerPosition().getValue() + 1));

        alert.show();
    }

    public void allGuessedDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getContext());
        alert.setTitle("Level Completed");
        alert.setIcon(R.drawable.check);

        alert.setPositiveButton("Exit", (dialog, whichButton) ->gameViewModel.setAllGuessed(true));

        alert.show();
    }

    public void vibrate(){
        Vibrator v = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(10);
        }
    }

}
