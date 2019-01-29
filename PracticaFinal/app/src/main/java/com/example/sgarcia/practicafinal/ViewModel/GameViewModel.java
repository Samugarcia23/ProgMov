package com.example.sgarcia.practicafinal.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.sgarcia.practicafinal.Entities.Level;
import com.example.sgarcia.practicafinal.Lists.Levels;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.Views.GameActivity;

import java.util.ArrayList;

public class GameViewModel extends ViewModel {

    private MutableLiveData<LevelSelection> _selectedLevel;
    private ArrayList<Level> _levels;
    private MutableLiveData<Integer> _playerCoins;

    public GameViewModel () {
        _selectedLevel = new MutableLiveData<>();
        _playerCoins = new MutableLiveData<>();

        loadCoins();
        addLevels();
    }

    public ArrayList<Level> getLevel(){
        return _levels;
    }

    public MutableLiveData<Integer> getPlayerCoins() {return _playerCoins;}

    private void addLevels(){
        _levels = new ArrayList<>();
        Levels levelList = new Levels();

        _levels.add(new Level(1,"#00897B", false, levelList.levelOne()));
        _levels.add(new Level(2,"#00ACC1", false, levelList.levelTwo()));
        _levels.add(new Level(3,"#FFB300", true, levelList.levelThree()));
        _levels.add(new Level(4,"#8E24AA", true, levelList.levelFour()));
        _levels.add(new Level(5,"#e53935", true, levelList.levelFive()));
    }

    public MutableLiveData<LevelSelection> getSelectedLevel() {
        return _selectedLevel;
    }

    public void setSelectedLevel(LevelSelection selectedLevel) {
        this._selectedLevel.setValue(selectedLevel);
    }

    public void addCoin(){
        int coins = _playerCoins.getValue() + 1;
    }

    public void loadCoins(){
        int coins = 0;
        _playerCoins.setValue(coins);
    }
}
