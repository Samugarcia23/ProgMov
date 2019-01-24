package com.example.sgarcia.practicafinal.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> playerCoins;

    public MainViewModel(){}

    public MutableLiveData<Integer> getPlayerCoins() {
        if (playerCoins == null)
            playerCoins = new MutableLiveData<>();

        return playerCoins;
    }

    public void setPlayerCoins(int playerCoins) {
        this.playerCoins.setValue(playerCoins);
    }
}
