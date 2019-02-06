package com.example.sgarcia.practicafinal.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.sgarcia.practicafinal.Entities.Level;
import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.Lists.LogoList;
import com.example.sgarcia.practicafinal.Others.LevelSelection;

import java.util.ArrayList;

/*
 *
 * Clase GameViewModel (extiende de ViewModel). Es el viewmodel de la actividad "MainActivity"
 *
 */

public class GameViewModel extends ViewModel {

    private MutableLiveData<LevelSelection> _selectedLevel;
    private ArrayList<Level> _levels;
    private MutableLiveData<Integer> _playerCoins;
    private MutableLiveData<Boolean> _logoClicked;
    private MutableLiveData<Logo> _selectedLogo;
    private MutableLiveData<Integer> _logoPosition;
    private MutableLiveData<String> _letterPressed;
    private MutableLiveData<Integer> _letterPosition;
    private MutableLiveData<char[]> _charArray;

    //Constructor

    public GameViewModel () {
        _selectedLevel = new MutableLiveData<>();
        _playerCoins = new MutableLiveData<>();
        _logoClicked = new MutableLiveData<>();
        _selectedLogo = new MutableLiveData<>();
        _logoPosition = new MutableLiveData<>();
        _letterPressed = new MutableLiveData<>();
        _letterPosition = new MutableLiveData<>();
        _charArray = new MutableLiveData<>();

        _logoClicked.setValue(false);
        _letterPressed.setValue("");
        _letterPosition.setValue(0);

        loadCoins();
        addLevels();

    }

    //GETTER del listado _levels

    public ArrayList<Level> getLevel(){
        return _levels;
    }

    //GETTER del mutable _playerCoins

    public MutableLiveData<Integer> getPlayerCoins() {return _playerCoins;}

    //Metodo que añade 5 objetos level al listado _levels

    private void addLevels(){
        _levels = new ArrayList<>();
        LogoList levelList = new LogoList();

        _levels.add(new Level(1,"#00897B", false, levelList.levelOne()));
        _levels.add(new Level(2,"#00ACC1", false, levelList.levelTwo()));
        _levels.add(new Level(3,"#FFB300", true, levelList.levelThree()));
        _levels.add(new Level(4,"#8E24AA", true, levelList.levelFour()));
        _levels.add(new Level(5,"#e53935", true, levelList.levelFive()));

    }

    public void initCharArray(int size){
        char[] characters = new char[size];
        _charArray.setValue(characters);
    }

    public void addChar(char letter, int pos){
        _charArray.getValue()[pos] =(letter);
    }

    //GETTER del mutable _selectedLevel

    public MutableLiveData<LevelSelection> getSelectedLevel() {
        return _selectedLevel;
    }

    //SETTER del mutable _selectedLevel

    public void setSelectedLevel(LevelSelection selectedLevel) {
        this._selectedLevel.setValue(selectedLevel);
    }

    //Metodo que suma 1 al mutable _playerCoins

    public void addCoin(){
        int coins = _playerCoins.getValue() + 1;
    }

    //----

    public void loadCoins(){
        int coins = 0;
        _playerCoins.setValue(coins);
    }

    //GETTER del mutable _logoClicked

    public MutableLiveData<Boolean> isLogoClicked() {
        return _logoClicked;
    }

    //SETTER del mutable _logoClicked

    public void setLogoClicked(boolean logoClicked) {
        this._logoClicked.setValue(logoClicked);
    }

    //GETTER del mutable _selectedLogo

    public MutableLiveData<Logo> getSelectedLogo() {
        return _selectedLogo;
    }

    //SETTER del mutable _selectedLogo

    public void setSelectedLogo(Logo selectedLogo) {
        this._selectedLogo.setValue(selectedLogo);
    }

    //GETTER del mutable _logoPosition

    public MutableLiveData<Integer> getLogoPosition() {
        return _logoPosition;
    }

    //SETTER del mutable _logoPosition

    public void setLogoPosition(int logoPosition) {
        this._logoPosition.setValue(logoPosition);
    }

    public MutableLiveData<String> getLetterPressed() {
        return _letterPressed;
    }

    public void setLetterPressed(String letterPressed) {
        this._letterPressed.setValue(letterPressed);
    }

    public MutableLiveData<Integer> getLetterPosition() {
        return _letterPosition;
    }

    public void setLetterPosition(int letterPosition) {
        this._letterPosition.setValue(letterPosition);
    }

    public MutableLiveData<char []> getCharArray() {
        return _charArray;
    }

    public void setCharArray(char[] charArray) {
        this._charArray.setValue(charArray);
    }
}
