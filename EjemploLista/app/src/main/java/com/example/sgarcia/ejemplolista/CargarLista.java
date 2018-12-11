package com.example.sgarcia.ejemplolista;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CargarLista extends ViewModel {

    private MutableLiveData<List<String>> lista;
    private List<String> listaItems;

    public MutableLiveData<List<String>> getLista(){
        if (lista == null){
            lista = new MutableLiveData<>();
            cargarLista();
        }
        return lista;
    }

    public void setLista(int pos, String item){
        listaItems.set(pos, item);
        lista.setValue(listaItems);
    }

    private void cargarLista(){
        listaItems = new ArrayList<>();
        listaItems.add("item 1");
        listaItems.add("item 2");
        listaItems.add("item 3");
        listaItems.add("item 4");
        listaItems.add("item 5");
        listaItems.add("item 6");
        listaItems.add("item 7");
        listaItems.add("item 8");
        listaItems.add("item 9");
        listaItems.add("item 10");
        listaItems.add("item 11");
        listaItems.add("item 12");
        listaItems.add("item 13");
        listaItems.add("item 14");
        listaItems.add("item 15");
        lista.setValue(listaItems);
    }

}
