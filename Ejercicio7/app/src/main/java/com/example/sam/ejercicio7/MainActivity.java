package com.example.sam.ejercicio7;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbold, cgiant, csmall, cred;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        state();
    }

    public void state(){
        cbold=findViewById(R.id.cbold);
        cgiant=findViewById(R.id.cgiant);
        csmall=findViewById(R.id.csmall);
        cred=findViewById(R.id.cred);

        cbold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cgiant.isChecked() || csmall.isChecked() || cred.isChecked()){
                    cgiant.setChecked(false);
                    csmall.setChecked(false);
                    cred.setChecked(false);
                }
                tv1.setTypeface(null, Typeface.BOLD);
            }
        });

        cgiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbold.isChecked() || csmall.isChecked() || cred.isChecked()){
                    cbold.setChecked(false);
                    csmall.setChecked(false);
                    cred.setChecked(false);
                }
                tv1.setTextSize(35);
            }
        });

        csmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cgiant.isChecked() || cbold.isChecked() || cred.isChecked()){
                    cgiant.setChecked(false);
                    cbold.setChecked(false);
                    cred.setChecked(false);
                }
                tv1.setTextSize(8);
            }
        });

        cred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cgiant.isChecked() || csmall.isChecked() || cbold.isChecked()){
                    cgiant.setChecked(false);
                    csmall.setChecked(false);
                    cbold.setChecked(false);
                }
                tv1.setTextColor(Color.RED);
            }
        });
    }
}
