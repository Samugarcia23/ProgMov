package com.example.sgarcia.practicafinal.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> _playerCoins;
    private MutableLiveData<Integer> _guessedLogos;
    private MutableLiveData<Boolean> _levelUnlocked;

    public MainViewModel(){
        _playerCoins = new MutableLiveData<>();
        loadCoins();
    }

    public MutableLiveData<Integer> getPlayerCoins() {return _playerCoins;}


    public void setPlayerCoins(int playerCoins) {
        this._playerCoins.setValue(playerCoins);
    }

    public void loadCoins(){
        int coins = 0;
        _playerCoins.setValue(coins);
    }

    public boolean levelUnlocked(){
        boolean unlocked = false;

        return unlocked;
    }
}
