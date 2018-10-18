package com.example.sgarcia.ejercicio5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private TextView tv1;
    float tam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        tv1 = findViewById(R.id.tv1);
        tam = (float) tv1.getTextSize();
        aumentar();
        disminuir();
    }


    public void aumentar(){
        Button bau = findViewById(R.id.bau);
        bau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv1.setTextSize(tam);
                tv1.setText(et1.getText());
                tam++;
            }
        });
    }

    public void disminuir(){
        Button bdis = findViewById(R.id.bdis);
        bdis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv1.setTextSize(tam);
                tv1.setText(et1.getText());
                tam--;
            }
        });
    }
}
