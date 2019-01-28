package com.example.sgarcia.practicafinal.Views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.renderscript.Allocation;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ui.Fragments.MainFragment;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;

import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL1;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL2;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL3;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL4;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL5;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;
    FrameLayout container;
    ProgressBar prb1, prb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        container = findViewById(R.id.container);
        prb1 = findViewById(R.id.progressBar);
        prb2 = findViewById(R.id.progressBar2);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, MainFragment.newInstance());
        transaction.commit();

        /*final Observer<Integer> progressObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {

                switch (integer){

                    case 0:
                        prb1.setProgress(0);
                        prb2.setProgress(0);
                        break;

                    case 1:
                        prb1.setProgress(25);
                        prb2.setProgress(25);
                        break;

                    case 2:
                        prb1.setProgress(50);
                        prb2.setProgress(50);
                        break;

                    case 3:
                        prb1.setProgress(75);
                        prb2.setProgress(75);
                        break;

                    case 4:
                        prb1.setProgress(100);
                        prb2.setProgress(100);
                        break;
                }
            }
        };

        viewModel.getPosition().observe(this, progressObserver);*/

        final Observer<LevelSelection> levelObserver = new Observer<LevelSelection>() {
            @Override
            public void onChanged(@Nullable LevelSelection levelSelection) {

                switch (levelSelection){

                    case LEVEL1:
                        Intent intent = new Intent(MainActivity.this, GameActivity.class);
                        startActivity(intent);
                        break;

                    case LEVEL2:
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        startActivity(intent);
                        break;

                    case LEVEL3:
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        startActivity(intent);
                        break;

                    case LEVEL4:
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        startActivity(intent);
                        break;

                    case LEVEL5:
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };

        viewModel.getSelectedLevel().observe(this, levelObserver);

    }

}
