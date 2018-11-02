package com.example.sgarcia.ejemplolistadinamica;

import android.widget.ImageView;

public class ViewHolder {
    ImageView icon;

    ViewHolder(ImageView img){
        this.icon = img;
    }

    public ImageView getImg (){
        return this.icon;
    }
}
