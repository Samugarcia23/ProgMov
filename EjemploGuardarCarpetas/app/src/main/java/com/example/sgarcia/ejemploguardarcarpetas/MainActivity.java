package com.example.sgarcia.ejemploguardarcarpetas;

import android.Manifest;
import android.app.AlertDialog;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spFolder, spSample;
    private Button btnPlaySound;
    private FloatingActionButton btnNewFolder;
    public ViewModel miViewModel;
    private static final String[] soundList = {"perc1.wav", "perc2.wav", "perc3.wav", "perc4.wav", "perc5.wav", "perc6.wav"};
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFolder = findViewById(R.id.spFolder);
        spSample = findViewById(R.id.spSample);

        btnPlaySound = findViewById(R.id.btnPlaySound);
        btnNewFolder = findViewById(R.id.btnAddFolder);

        miViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, soundList);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSample.setAdapter(a);

        btnPlaySound.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String fname = spSample.getSelectedItem().toString();
        int resID=getResources().getIdentifier(fname, "raw", getPackageName());

        mp = MediaPlayer.create(this, resID);
        mp.start();
    }
}
