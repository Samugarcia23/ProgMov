package com.example.sgarcia.ejemploguardarcarpetas;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spFolder, spSample;
    private Button btnPlaySound;
    private FloatingActionButton btnNewFolder;
    public ViewModel miViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFolder = findViewById(R.id.spFolder);
        spSample = findViewById(R.id.spSample);

        btnPlaySound = findViewById(R.id.btnPlaySound);
        btnNewFolder = findViewById(R.id.btnAddFolder);

        miViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

    }
}
