package com.example.sgarcia.ejemplolista;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class CargarLista extends ViewModel {

    private String[] lista = {"item 1", "item 2", "item 3", "item 4", "item 5", "item 6","item 7", "item 8"};
    private MutableLiveData<String> mlistaItem;

    public String[] getLista(){
        return lista;
    }

    public void setLista(int pos, String item){
        this.lista[pos] = item;
    }

    public MutableLiveData<String> getListaItem(int pos){
        if (mlistaItem == null){
            mlistaItem = new MutableLiveData<String>();
        }

        setLista(pos, mlistaItem.toString());

        return mlistaItem;
    }

}
