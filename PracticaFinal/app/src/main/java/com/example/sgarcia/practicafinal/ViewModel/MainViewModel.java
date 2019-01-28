package com.example.sgarcia.practicafinal.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.sgarcia.practicafinal.Entities.Level;
import com.example.sgarcia.practicafinal.Lists.Levels;
import com.example.sgarcia.practicafinal.Others.LevelSelection;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> _playerCoins;
    private ArrayList<Level> _levels;
    private MutableLiveData<LevelSelection> _selectedLevel;

    public MainViewModel(){
        _playerCoins = new MutableLiveData<>();
        _selectedLevel = new MutableLiveData<>();

        loadCoins();
        addLevels();
    }

    public MutableLiveData<Integer> getPlayerCoins() {return _playerCoins;}

    public ArrayList<Level> getLevel(){
        return _levels;
    }

    public void setPlayerCoins(int playerCoins) {
        this._playerCoins.setValue(playerCoins);
    }

    public void loadCoins(){
        int coins = 0;
        _playerCoins.setValue(coins);
    }

    public void addCoin(){
        int coins = _playerCoins.getValue() + 1;
    }

    public boolean levelLocked(int level){
        boolean locked = false;
        if (_levels.get(level).isLocked()){
            locked = true;
        }
        return locked;
    }

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

    public void setSelectedLevel(LevelSelection level){
        this._selectedLevel.setValue(level);
    }
}
