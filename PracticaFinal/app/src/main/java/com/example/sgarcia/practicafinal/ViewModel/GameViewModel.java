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
    private MutableLiveData<Integer> _viewPagerPosition;
    private MutableLiveData<String> _letterPressed;
    private MutableLiveData<Integer> _letterPosition;
    private MutableLiveData<ArrayList<ArrayList<Character>>> _charArrayList;
    private MutableLiveData<Boolean> _rightArrowPressed;
    private MutableLiveData<Boolean> _leftArrowPressed;
    private MutableLiveData<Boolean> _deleteClicked;
    private MutableLiveData<Boolean> _logoGuessed;
    private MutableLiveData<Boolean> _helpClicked;
    private MutableLiveData<Boolean> _allGuessed;
    private int[] _arraylistLength;

    //Constructor

    public GameViewModel () {
        _selectedLevel = new MutableLiveData<>();
        _playerCoins = new MutableLiveData<>();
        _logoClicked = new MutableLiveData<>();
        _selectedLogo = new MutableLiveData<>();
        _viewPagerPosition = new MutableLiveData<>();
        _letterPressed = new MutableLiveData<>();
        _letterPosition = new MutableLiveData<>();
        _charArrayList = new MutableLiveData<>();
        _rightArrowPressed = new MutableLiveData<>();
        _leftArrowPressed = new MutableLiveData<>();
        _deleteClicked = new MutableLiveData<>();
        _logoGuessed = new MutableLiveData<>();
        _helpClicked = new MutableLiveData<>();
        _allGuessed = new MutableLiveData<>();

        _helpClicked.setValue(false);
        _allGuessed.setValue(false);
        _logoClicked.setValue(false);
        _logoGuessed.setValue(false);
        _deleteClicked.setValue(false);
        _letterPressed.setValue("");
        _letterPosition.setValue(0);
        _arraylistLength = new int[20];

        for (int i = 0; i < _arraylistLength.length; i++)
            _arraylistLength[i] = 0;

        addLevels();
        loadCharArray();

    }

    //GETTER del listado _levels

    public ArrayList<Level> getLevel(){
        return _levels;
    }

    public void set_levels(ArrayList<Level> _levels) {
        this._levels = _levels;
    }

    //GETTER del mutable _playerCoins

    public MutableLiveData<Integer> getPlayerCoins() {return _playerCoins;}

    public void setPlayerCoins(int coins) {
        this._playerCoins.setValue(coins);
    }

    //Metodo que añade 5 objetos level al listado _levels

    private void addLevels(){
        _levels = new ArrayList<>();
        LogoList levelList = new LogoList();

        _levels.add(new Level(1,"#00897B", false, levelList.levelOne(), 0));
        _levels.add(new Level(2,"#00ACC1", false, levelList.levelTwo(), 0));
        _levels.add(new Level(3,"#FFB300", true, levelList.levelThree(),0));
        _levels.add(new Level(4,"#8E24AA", true, levelList.levelFour(), 0));
        _levels.add(new Level(5,"#e53935", true, levelList.levelFive(), 0));

    }

    public void loadCharArray(){
        ArrayList<ArrayList<Character>> characters = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            characters.add(new ArrayList<>());
        _charArrayList.setValue(characters);
    }

    //GETTER del mutable _selectedLevel

    public MutableLiveData<LevelSelection> getSelectedLevel() {
        return _selectedLevel;
    }

    //SETTER del mutable _selectedLevel

    public void setSelectedLevel(LevelSelection selectedLevel) {
        this._selectedLevel.setValue(selectedLevel);
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

    //GETTER del mutable _viewPagerPosition

    public MutableLiveData<Integer> getViewPagerPosition() {
        return _viewPagerPosition;
    }

    //SETTER del mutable _viewPagerPosition

    public void setViewPagerPosition(int logoPosition) {
        this._viewPagerPosition.setValue(logoPosition);
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

    public MutableLiveData<ArrayList<ArrayList<Character>>> getCharArray() {
        return _charArrayList;
    }

    public void setCharArray(ArrayList<ArrayList<Character>> charArray) {
        this._charArrayList.setValue(charArray);
    }

    public int[] getArraylistLength() {
        return _arraylistLength;
    }

    public void setArraylistLength(int arraylistLength, int pos) {
        this._arraylistLength[pos] = arraylistLength;
    }

    public MutableLiveData<Boolean> getRightArrowPressed() {
        return _rightArrowPressed;
    }

    public void setRightArrowPressed(boolean arrowPressed) {
        this._rightArrowPressed.setValue(arrowPressed);
    }

    public MutableLiveData<Boolean> getLeftArrowPressed() {
        return _leftArrowPressed;
    }

    public void setLeftArrowPressed(boolean leftArrowPressed) {
        this._leftArrowPressed.setValue(leftArrowPressed);
    }

    public MutableLiveData<Boolean> get_deleteClicked() {
        return _deleteClicked;
    }

    public void setDeleteClicked(boolean deleteType) {
        this._deleteClicked.setValue(deleteType);
    }

    public MutableLiveData<Boolean> getLogoGuessed() {
        return _logoGuessed;
    }

    public void setLogoGuessed(boolean logoGuessed) {
        this._logoGuessed.setValue(logoGuessed);
    }

    public MutableLiveData<Boolean> getHelpClicked() {
        return _helpClicked;
    }

    public void setHelpClicked(boolean helpClicked) {
        this._helpClicked.setValue(helpClicked);
    }

    public MutableLiveData<Boolean> getAllGuessed() {
        return _allGuessed;
    }

    public void setAllGuessed(boolean allGuessed) {
        this._allGuessed.setValue(allGuessed);
    }
}
