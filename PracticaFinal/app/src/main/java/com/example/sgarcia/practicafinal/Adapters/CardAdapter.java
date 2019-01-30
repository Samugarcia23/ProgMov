package com.example.sgarcia.practicafinal.Adapters;

import com.example.sgarcia.practicafinal.Entities.Level;

/*
*
*   Interfaz para el adaptador "ViewPagerAdapter". Contiene:
*
*   - getCardViewAt() --> Devuelve el objeto "Level" de la posicion especificada
*   - getCount() --> Devuelve el total de objetos "Level"
*
*/

interface CardAdapter {

    Level getCardViewAt(int position);
    int getCount();

}
