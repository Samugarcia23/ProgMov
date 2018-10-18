package com.example.sgarcia.calculadorasimple;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sumar();
    }

    public void sumar(){
        Button bsumar = findViewById(R.id.bsumar);
        bsumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = findViewById(R.id.num1);
                EditText et2 = findViewById(R.id.num2);
                EditText et3 = findViewById(R.id.num3);
                et.setGravity(Gravity.CENTER_HORIZONTAL);
                et2.setGravity(Gravity.CENTER_HORIZONTAL);
                et3.setGravity(Gravity.CENTER_HORIZONTAL);
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

                inputMethodManager.hideSoftInputFromWindow(et.getWindowToken(), 0);

                et3.setText(String.valueOf(Integer.parseInt(et.getText().toString()) + Integer.parseInt(et2.getText().toString())));
            }
        });
    }
}
