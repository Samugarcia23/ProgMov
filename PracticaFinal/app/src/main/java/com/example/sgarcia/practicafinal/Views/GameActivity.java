package com.example.sgarcia.practicafinal.Views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sgarcia.practicafinal.Adapters.RecyclerViewAdapter;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;

import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL1;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL2;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL3;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL4;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL5;

public class GameActivity extends AppCompatActivity {

    GameViewModel mViewModel;
    RecyclerView rvlogo;
    RecyclerViewAdapter adapter;
    TextView levelNum, coins;
    ImageView backarrow;
    LinearLayout infoBar;
    Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        backarrow = findViewById(R.id.backarrow);
        levelNum = findViewById(R.id.level);
        coins = findViewById(R.id.coins);
        infoBar = findViewById(R.id.infoBar);
        window = getWindow();

        mViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        adapter = new RecyclerViewAdapter(mViewModel);
        rvlogo = findViewById(R.id.rvlogo);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        rvlogo.setLayoutManager(mLayoutManager);
        rvlogo.setAdapter(adapter);

        LevelSelection level = (LevelSelection) getIntent().getSerializableExtra("level");

        int num = 0;

        switch (level){

            case LEVEL1:
                mViewModel.setSelectedLevel(LevelSelection.LEVEL1);
                num = 0;
                break;

            case LEVEL2:
                mViewModel.setSelectedLevel(LevelSelection.LEVEL2);
                num = 1;
                break;

            case LEVEL3:
                mViewModel.setSelectedLevel(LevelSelection.LEVEL3);
                num = 2;
                break;

            case LEVEL4:
                mViewModel.setSelectedLevel(LevelSelection.LEVEL4);
                num = 3;
                break;

            case LEVEL5:
                mViewModel.setSelectedLevel(LevelSelection.LEVEL5);
                num = 4;
                break;
        }

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

                /*final Observer<LevelSelection> levelObserver = new Observer<LevelSelection>() {
                    @Override
                    public void onChanged(@Nullable LevelSelection levelSelection) {

                        switch (levelSelection){

                            case LEVEL1:
                                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                                intent.putExtra("level", LEVEL1);
                                startActivity(intent);
                                break;

                            case LEVEL2:
                                intent = new Intent(GameActivity.this, MainActivity.class);
                                intent.putExtra("level", LEVEL2);
                                startActivity(intent);
                                break;

                            case LEVEL3:
                                intent = new Intent(GameActivity.this, MainActivity.class);
                                intent.putExtra("level", LEVEL3);
                                startActivity(intent);
                                break;

                            case LEVEL4:
                                intent = new Intent(GameActivity.this, MainActivity.class);
                                intent.putExtra("level", LEVEL4);
                                startActivity(intent);
                                break;

                            case LEVEL5:
                                intent = new Intent(GameActivity.this, MainActivity.class);
                                intent.putExtra("level", LEVEL5);
                                startActivity(intent);
                                break;
                        }
                    }
                };*/

               // mViewModel.getSelectedLevel().observe(GameActivity.this, levelObserver);
            }
        });

        levelNum.setText(String.valueOf(mViewModel.getLevel().get(num).getIdLevel()));
        coins.setText(String.valueOf(mViewModel.getPlayerCoins().getValue()));
        infoBar.setBackgroundColor(Color.parseColor(mViewModel.getLevel().get(num).getColor()));
        window.setStatusBarColor(Color.parseColor(mViewModel.getLevel().get(num).getColor()));

    }
}
