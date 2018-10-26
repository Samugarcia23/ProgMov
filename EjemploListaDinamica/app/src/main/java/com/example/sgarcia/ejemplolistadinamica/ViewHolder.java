package com.example.sgarcia.ejemplolistadinamica;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    TextView tv;
    ImageView icon;

    ViewHolder(View fila1, View fila2, int tvId, int imgId){
        this.tv = fila1.findViewById(imgId);
        this.icon = fila2.findViewById(tvId);
    }

    public TextView getLab (){
        return this.tv;
    }

    public ImageView getImg (){
        return this.icon;
    }
}
