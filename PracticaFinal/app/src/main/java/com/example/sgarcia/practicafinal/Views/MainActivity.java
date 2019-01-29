package com.example.sgarcia.practicafinal.Views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.renderscript.Allocation;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.Others.ProgressBarAnimation;
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
    Window window;
    private int lastLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        container = findViewById(R.id.container);
        prb1 = findViewById(R.id.progressBar);
        prb2 = findViewById(R.id.progressBar2);
        window = getWindow();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, MainFragment.newInstance());
        transaction.commit();

        final Observer<Integer> progressObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {

                switch (integer){

                    case 0:
                        prb1.setProgress(0);
                        prb2.setProgress(0);
                        window.setStatusBarColor(Color.parseColor(viewModel.getLevel().get(integer).getColor()));
                        prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level1), PorterDuff.Mode.SRC_IN);
                        prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level1), PorterDuff.Mode.SRC_IN);
                        ProgressBarAnimation anim = new ProgressBarAnimation(prb1, 25, 0);
                        anim.setDuration(100);
                        prb1.startAnimation(anim);
                        ProgressBarAnimation anim2 = new ProgressBarAnimation(prb2, 25, 0);
                        anim2.setDuration(100);
                        prb2.startAnimation(anim2);

                        break;

                    case 1:
                        prb1.setProgress(25);
                        prb2.setProgress(25);

                        if (viewModel.getLevel().get(1).isLocked()){
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor("#BDBDBD"));
                        } else {
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level2), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level2), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor(viewModel.getLevel().get(integer).getColor()));
                        }

                        if (lastLevel <= integer){
                            ProgressBarAnimation anim3 = new ProgressBarAnimation(prb1, 0, 25);
                            anim3.setDuration(100);
                            prb1.startAnimation(anim3);

                            ProgressBarAnimation anim4 = new ProgressBarAnimation(prb2, 0, 25);
                            anim4.setDuration(100);
                            prb2.startAnimation(anim4);
                        } else {
                            ProgressBarAnimation anim3 = new ProgressBarAnimation(prb1, 50, 25);
                            anim3.setDuration(100);
                            prb1.startAnimation(anim3);

                            ProgressBarAnimation anim4 = new ProgressBarAnimation(prb2, 50, 25);
                            anim4.setDuration(100);
                            prb2.startAnimation(anim4);
                        }
                        break;

                    case 2:
                        prb1.setProgress(50);
                        prb2.setProgress(50);
                        if (viewModel.getLevel().get(2).isLocked()){
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor("#BDBDBD"));
                        } else {
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level3), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level3), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor(viewModel.getLevel().get(integer).getColor()));
                        }

                        if (lastLevel <= integer){
                            ProgressBarAnimation anim3 = new ProgressBarAnimation(prb1, 25, 50);
                            anim3.setDuration(100);
                            prb1.startAnimation(anim3);

                            ProgressBarAnimation anim4 = new ProgressBarAnimation(prb2, 25, 50);
                            anim4.setDuration(100);
                            prb2.startAnimation(anim4);
                        } else {
                            ProgressBarAnimation anim3 = new ProgressBarAnimation(prb1, 75, 50);
                            anim3.setDuration(100);
                            prb1.startAnimation(anim3);

                            ProgressBarAnimation anim4 = new ProgressBarAnimation(prb2, 75, 50);
                            anim4.setDuration(100);
                            prb2.startAnimation(anim4);
                        }
                        break;

                    case 3:
                        prb1.setProgress(75);
                        prb2.setProgress(75);
                        if (viewModel.getLevel().get(3).isLocked()){
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor("#BDBDBD"));
                        } else {
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level4), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level4), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor(viewModel.getLevel().get(integer).getColor()));
                        }

                        if (lastLevel <= integer){
                            ProgressBarAnimation anim3 = new ProgressBarAnimation(prb1, 50, 75);
                            anim3.setDuration(100);
                            prb1.startAnimation(anim3);

                            ProgressBarAnimation anim4 = new ProgressBarAnimation(prb2, 50, 75);
                            anim4.setDuration(100);
                            prb2.startAnimation(anim4);
                        } else {
                            ProgressBarAnimation anim3 = new ProgressBarAnimation(prb1, 100, 75);
                            anim3.setDuration(100);
                            prb1.startAnimation(anim3);

                            ProgressBarAnimation anim4 = new ProgressBarAnimation(prb2, 100, 75);
                            anim4.setDuration(100);
                            prb2.startAnimation(anim4);
                        }
                        break;

                    case 4:
                        prb1.setProgress(100);
                        prb2.setProgress(100);
                        if (viewModel.getLevel().get(4).isLocked()){
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor("#BDBDBD"));
                        } else {
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level5), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level5), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor(viewModel.getLevel().get(integer).getColor()));
                        }

                        ProgressBarAnimation anim3 = new ProgressBarAnimation(prb1, 75, 100);
                        anim3.setDuration(100);
                        prb1.startAnimation(anim3);
                        ProgressBarAnimation anim4 = new ProgressBarAnimation(prb2, 75, 100);
                        anim4.setDuration(100);
                        prb2.startAnimation(anim4);

                        break;
                }

                lastLevel = integer;
            }
        };

        viewModel.getPosition().observe(this, progressObserver);

        final Observer<LevelSelection> levelObserver = new Observer<LevelSelection>() {
            @Override
            public void onChanged(@Nullable LevelSelection levelSelection) {

                switch (levelSelection){

                    case LEVEL1:
                        Intent intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.putExtra("level", LEVEL1);
                        startActivity(intent);
                        break;

                    case LEVEL2:
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.putExtra("level", LEVEL2);
                        startActivity(intent);
                        break;

                    case LEVEL3:
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.putExtra("level", LEVEL3);
                        startActivity(intent);
                        break;

                    case LEVEL4:
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.putExtra("level", LEVEL4);
                        startActivity(intent);
                        break;

                    case LEVEL5:
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.putExtra("level", LEVEL5);
                        startActivity(intent);
                        break;
                }
            }
        };

        viewModel.getSelectedLevel().observe(this, levelObserver);

    }

}
