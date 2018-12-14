package com.example.sgarcia.ejemplofragments;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MainViewModel(MutableLiveData<String> color) {
        this.color = color;
    }

    public MainViewModel() {
        color = new MutableLiveData<>();
    }

    private MutableLiveData<String> color;

    public MutableLiveData<String> getColor(){
        if (color == null){
            color = new MutableLiveData<>();
        }
        return color;
    }

    public void setColor(String color) {
        this.color.setValue(color);
    }

}
