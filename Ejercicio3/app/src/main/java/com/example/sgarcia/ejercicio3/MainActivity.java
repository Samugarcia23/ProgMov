package com.example.sgarcia.ejercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aLaIzq();
        aLaDer();
    }

    public void aLaIzq(){
        Button bizq = findViewById(R.id.bizq);
        final TextView tv = findViewById(R.id.tv1);
        bizq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = findViewById(R.id.et1);
                tv.setText(et.getText());
                tv.setGravity(Gravity.LEFT);
            }
        });
    }

    public void aLaDer(){
        Button bder = findViewById(R.id.bder);
        final TextView tv = findViewById(R.id.tv1);
        bder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = findViewById(R.id.et1);
                tv.setText(et.getText());
                tv.setGravity(Gravity.RIGHT);
            }
        });
    }
}
