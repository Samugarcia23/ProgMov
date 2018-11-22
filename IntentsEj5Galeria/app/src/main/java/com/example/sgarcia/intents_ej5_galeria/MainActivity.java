package com.example.sgarcia.intents_ej5_galeria;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button btnFoto;
    ImageView myImage;
    File directory; //Directorio de las imagenes
    File[] files; //Array de imagenes del directorio
    String path; //path del directorio
    Bitmap myBitmap;
    ViewPager visor;
    int imagenActual = 0;
    int numImagenes = 0;
    Integer [] imagenes;
    ArrayList<File> arrayList;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        path = "/DCIM/Camera/";
        arrayList = new ArrayList<>();
        directory = new File(path);
        files = directory.listFiles();
        arrayList = new ArrayList<>();
        cargarImagenes();
        init();
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    public void cargarImagenes(){
        for (int i = 0; i < files.length; i++){

            Log.d("Files", "FileName:" + files[i].getName());

            File imgFile = new  File(path + files[i].getName());
            if(imgFile.exists()){

                myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

                myImage = findViewById(R.id.image);

                myImage.setImageBitmap(myBitmap);

            }
        }
    }

    private void init(){

        for (int i=0;i<files.length;i++){
            arrayList.add(files[i]);
        }

        visor = findViewById(R.id.visor);
        visor.setAdapter(new SlidingImage_Adapter(this, arrayList));

        numImagenes = files.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (imagenActual == numImagenes) {
                    imagenActual = 0;
                }
                visor.setCurrentItem(imagenActual++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

    }
}
