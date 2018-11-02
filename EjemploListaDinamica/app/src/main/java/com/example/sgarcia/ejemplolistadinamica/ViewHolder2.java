package com.example.sgarcia.ejemplolistadinamica;

import android.widget.TextView;

public class ViewHolder2 {
    TextView tv;

    ViewHolder2(TextView label){
        this.tv = label;
    }

    public TextView getLab (){
        return this.tv;
    }
}
