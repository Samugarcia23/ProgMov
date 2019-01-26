package com.example.sgarcia.practicafinal.Adapters;

import android.support.v7.widget.CardView;

import com.example.sgarcia.practicafinal.Entities.Level;

interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    Level getCardViewAt(int position);

    int getCount();

}
