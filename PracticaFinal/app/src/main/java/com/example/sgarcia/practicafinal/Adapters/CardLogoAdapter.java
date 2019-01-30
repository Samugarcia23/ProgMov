package com.example.sgarcia.practicafinal.Adapters;

import com.example.sgarcia.practicafinal.Entities.Logo;

/*
 *
 *   Interfaz para el adaptador "ViewPagerGameAdapter". Contiene:
 *
 *   - getCardViewAt() --> Devuelve el objeto "Logo" de la posicion especificada
 *   - getCount() --> Devuelve el total de objetos "Logo"
 *
 */

public interface CardLogoAdapter {

    Logo getCardViewAt(int position);
    int getCount();

}
