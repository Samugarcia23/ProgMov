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
    LevelSelection levelSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        container = findViewById(R.id.container);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, MainFragment.newInstance());
        transaction.commit();

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
