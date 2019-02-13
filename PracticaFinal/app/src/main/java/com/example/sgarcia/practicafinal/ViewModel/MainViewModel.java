package com.example.sgarcia.practicafinal.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.sgarcia.practicafinal.Entities.Level;
import com.example.sgarcia.practicafinal.Lists.LogoList;
import com.example.sgarcia.practicafinal.Others.LevelSelection;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> _playerCoins;
    private ArrayList<Level> _levels;
    private MutableLiveData<LevelSelection> _selectedLevel;
    private MutableLiveData<Integer> _position;
    private MutableLiveData<Integer> _levelBack;

    public MainViewModel(){
        _playerCoins = new MutableLiveData<>();
        _selectedLevel = new MutableLiveData<>();
        _position = new MutableLiveData<>();
        _levelBack = new MutableLiveData<>();

        _position.setValue(0);
        addLevels();
    }

    public MutableLiveData<Integer> getPlayerCoins() {return _playerCoins;}

    public ArrayList<Level> getLevel(){
        return _levels;
    }

    public void setPlayerCoins(int playerCoins) {
        this._playerCoins.setValue(playerCoins);
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
        LogoList levelList = new LogoList();

        _levels.add(new Level(1,"#00897B", false, levelList.levelOne(), 0));
        _levels.add(new Level(2,"#00ACC1", false, levelList.levelTwo(), 0));
        _levels.add(new Level(3,"#FFB300", true, levelList.levelThree(), 0));
        _levels.add(new Level(4,"#8E24AA", true, levelList.levelFour(), 0));
        _levels.add(new Level(5,"#e53935", true, levelList.levelFive(), 0));
    }

    public MutableLiveData<LevelSelection> getSelectedLevel() {
        return _selectedLevel;
    }

    public void setSelectedLevel(LevelSelection level){
        this._selectedLevel.setValue(level);
    }

    public void setPosition(int position) {
        this._position.setValue(position);
    }

    public MutableLiveData<Integer> getPosition() {
        return _position;
    }

    public MutableLiveData<Integer> getLevelBack() {
        return _levelBack;
    }

    public void setLevelBack(int levelBack) {
        this._levelBack.setValue(levelBack);
    }
}
