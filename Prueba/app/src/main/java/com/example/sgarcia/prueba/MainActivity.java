package com.example.sgarcia.prueba;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//layout de la clase
        cambiar();
    }

    protected void cambiar(){
        final Button b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            //b1.setOnClickListener(this); tambien vale
            public void onClick(View view) {
                TextView tv1 = findViewById(R.id.tv1);
                ConstraintLayout fondo = findViewById(R.id.fondo);
                int rnd1 = (int)(Math.random()*256+1);
                int rnd2 = (int)(Math.random()*256+1);
                int rnd3 = (int)(Math.random()*256+1);

                int rnd4 = (int)(Math.random()*256+1);
                int rnd5 = (int)(Math.random()*256+1);
                int rnd6 = (int)(Math.random()*256+1);

                float rnd7 = (float)(Math.random()*50+20);

                int rnd8 = (int)(Math.random()*256+1);
                int rnd9 = (int)(Math.random()*256+1);
                int rnd10 = (int)(Math.random()*256+1);

                int rnd11 = (int)(Math.random()*256+1);
                int rnd12 = (int)(Math.random()*256+1);
                int rnd13 = (int)(Math.random()*256+1);

                tv1.setTextColor(Color.rgb(rnd1, rnd2, rnd3));
                fondo.setBackgroundColor(Color.rgb(rnd4, rnd5, rnd6));
                tv1.setTextSize(rnd7);
                tv1.setBackgroundColor(Color.rgb(rnd8, rnd9, rnd10));
                b1.setBackgroundColor(Color.rgb(rnd11, rnd12, rnd13));
                tv1.setAllCaps(true);
            }
        });
    }


}
