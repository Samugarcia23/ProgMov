package com.example.sgarcia.ejercicio2;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pulsarVerde();
        pulsarRojo();
        pulsarAzul();
        EditText et = findViewById(R.id.et1);
        et.setText("");
    }

    public void pulsarVerde() {
        Button b = findViewById(R.id.b1);
        final TextView tv = findViewById(R.id.lb1);
        final EditText et = findViewById(R.id.et1);
        et.setGravity(Gravity.CENTER_HORIZONTAL);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(et.getWindowToken(), 0);
                tv.setText(et.getText());
                tv.setTextColor(Color.GREEN);
            }
        });
    }

    public void pulsarRojo(){
        Button b = findViewById(R.id.brojo);
        final TextView tv = findViewById(R.id.lb1);
        final EditText et = findViewById(R.id.et1);
        et.setGravity(Gravity.CENTER_HORIZONTAL);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(et.getWindowToken(), 0);
                tv.setText(et.getText());
                tv.setTextColor(Color.RED);
            }
        });

    }

    public void pulsarAzul(){
        Button b = findViewById(R.id.bazul);
        final TextView tv = findViewById(R.id.lb1);
        final EditText et = findViewById(R.id.et1);
        et.setGravity(Gravity.CENTER_HORIZONTAL);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(et.getWindowToken(), 0);
                tv.setText(et.getText());
                tv.setTextColor(Color.BLUE);
            }
        });

    }
}
