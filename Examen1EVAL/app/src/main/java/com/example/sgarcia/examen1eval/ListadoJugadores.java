package com.example.sgarcia.examen1eval;

import java.util.ArrayList;

public class ListadoJugadores {

    public ArrayList<JugadorFutbol> listaFutbol(){

        ArrayList<JugadorFutbol> listaJugadoresFutbol = new ArrayList<>();
        listaJugadoresFutbol.add(new JugadorFutbol("Delantero", "Lukaku", R.drawable.romelu_lukaku_f));
        listaJugadoresFutbol.add(new JugadorFutbol("Defensa", "Bruyne", R.drawable.kevin_de_bruyne_f));
        listaJugadoresFutbol.add(new JugadorFutbol("Centrocampista", "Lukaku", R.drawable.romelu_lukaku_f));
        listaJugadoresFutbol.add(new JugadorFutbol("Defensa", "Bruyne", R.drawable.kevin_de_bruyne_f));
        listaJugadoresFutbol.add(new JugadorFutbol("Delantero", "Lukaku", R.drawable.romelu_lukaku_f));
        listaJugadoresFutbol.add(new JugadorFutbol("Centrocampista", "Bruyne", R.drawable.kevin_de_bruyne_f));
        listaJugadoresFutbol.add(new JugadorFutbol("Delantero", "Lukaku", R.drawable.romelu_lukaku_f));
        listaJugadoresFutbol.add(new JugadorFutbol("Defensa", "Bruyne", R.drawable.kevin_de_bruyne_f));
        listaJugadoresFutbol.add(new JugadorFutbol("Centrocampista", "Lukaku", R.drawable.romelu_lukaku_f));
        listaJugadoresFutbol.add(new JugadorFutbol("Defensa", "Bruyne", R.drawable.kevin_de_bruyne_f));
        listaJugadoresFutbol.add(new JugadorFutbol("Delantero", "Lukaku", R.drawable.romelu_lukaku_f));
        listaJugadoresFutbol.add(new JugadorFutbol("Centrocampista", "Bruyne", R.drawable.kevin_de_bruyne_f));

        return listaJugadoresFutbol;
    }

    public ArrayList<JugadorBasket> listaBasket(){
        ArrayList<JugadorBasket> listaJugadoresBasket = new ArrayList<>();
        listaJugadoresBasket.add(new JugadorBasket(52, 26, 10, "Lebron James", R.drawable.lebron_james_b));
        listaJugadoresBasket.add(new JugadorBasket(56, 31, 5, "Marc Gasol", R.drawable.marc_gasol_b));
        listaJugadoresBasket.add(new JugadorBasket(62, 10, 20, "Pau Gasol", R.drawable.pau_gasol_b));
        listaJugadoresBasket.add(new JugadorBasket(52, 26, 10, "Lebron James", R.drawable.lebron_james_b));
        listaJugadoresBasket.add(new JugadorBasket(56, 31, 5, "Marc Gasol", R.drawable.marc_gasol_b));
        listaJugadoresBasket.add(new JugadorBasket(62, 10, 20, "Pau Gasol", R.drawable.pau_gasol_b));
        listaJugadoresBasket.add(new JugadorBasket(52, 26, 10, "Lebron James", R.drawable.lebron_james_b));
        listaJugadoresBasket.add(new JugadorBasket(56, 31, 5, "Marc Gasol", R.drawable.marc_gasol_b));
        listaJugadoresBasket.add(new JugadorBasket(62, 10, 20, "Pau Gasol", R.drawable.pau_gasol_b));
        listaJugadoresBasket.add(new JugadorBasket(52, 26, 10, "Lebron James", R.drawable.lebron_james_b));
        listaJugadoresBasket.add(new JugadorBasket(56, 31, 5, "Marc Gasol", R.drawable.marc_gasol_b));
        listaJugadoresBasket.add(new JugadorBasket(62, 10, 20, "Pau Gasol", R.drawable.pau_gasol_b));

        return listaJugadoresBasket;
    }
}
