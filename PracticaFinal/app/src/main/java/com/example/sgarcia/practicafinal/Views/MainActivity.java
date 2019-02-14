package com.example.sgarcia.practicafinal.Views;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sgarcia.practicafinal.Entities.Level;
import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;
import com.example.sgarcia.practicafinal.ui.Fragments.MainFragment;

import java.util.ArrayList;

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
    TextView totalCoins, tvtotal;
    ImageView bitCoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        container = findViewById(R.id.container);
        prb1 = findViewById(R.id.progressBar);
        prb2 = findViewById(R.id.progressBar2);
        tvtotal = findViewById(R.id.tvtotalcoins);
        totalCoins = findViewById(R.id.totalcoins);
        bitCoin = findViewById(R.id.mvcoin);

        tvtotal.startAnimation((Animation) AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate));
        totalCoins.startAnimation((Animation)AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate));
        bitCoin.startAnimation((Animation)AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate));

        window = getWindow();

        if (getIntent().getSerializableExtra("coins") != null){
            viewModel.getLevel().get((Integer) getIntent().getSerializableExtra("levelgame")).setCoins((Integer) getIntent().getSerializableExtra("coins"));
            viewModel.setPlayerCoins((Integer) getIntent().getSerializableExtra("coins"));
        }else{
            viewModel.setPlayerCoins(0);
        }


        Intent intent = getIntent();
        if (intent.getBundleExtra("BUNDLE") != null){
            Bundle args = intent.getBundleExtra("BUNDLE");
            viewModel.setLevels((ArrayList<Level>) args.getSerializable("ARRAYLEVEL1"));
        }

        if (getIntent().getSerializableExtra("levelgame") != null){
            viewModel.setLevelBack((Integer) getIntent().getSerializableExtra("levelgame"));
        }

        int total = 0;

        for (int i = 0; i < viewModel.getLevel().size(); i++)
            total += viewModel.getLevel().get(i).getCoins();

        totalCoins.setText(String.valueOf(total));

        if (total >= 6 && viewModel.getLevel().get(4).isLocked()){
            viewModel.getLevel().get(4).setLocked(false);
            levelUnlockedDialog(4);
        }

        if (total >= 4 && viewModel.getLevel().get(3).isLocked()){
            viewModel.getLevel().get(3).setLocked(false);
            levelUnlockedDialog(3);
        }

        if (total >= 2 && viewModel.getLevel().get(2).isLocked()){
            viewModel.getLevel().get(2).setLocked(false);
            levelUnlockedDialog(2);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, MainFragment.newInstance());
        transaction.commit();

        final Observer<Integer> progressObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {

                switch (integer){

                    case 0:

                        window.setStatusBarColor(Color.parseColor(viewModel.getLevel().get(integer).getColor()));
                        prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level1), PorterDuff.Mode.SRC_IN);
                        prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level1), PorterDuff.Mode.SRC_IN);

                        ObjectAnimator animation = ObjectAnimator.ofInt(prb1, "progress", 0);
                        animation.setDuration(50);
                        animation.setInterpolator(new DecelerateInterpolator());
                        animation.start();

                        ObjectAnimator animation2 = ObjectAnimator.ofInt(prb2, "progress", 0);
                        animation2.setDuration(50);
                        animation2.setInterpolator(new DecelerateInterpolator());
                        animation2.start();

                        break;

                    case 1:

                        if (viewModel.getLevel().get(1).isLocked()){
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor("#BDBDBD"));
                        } else {
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level2), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level2), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor(viewModel.getLevel().get(integer).getColor()));
                        }

                        animation = ObjectAnimator.ofInt(prb1, "progress", 25);
                        animation.setDuration(50);
                        animation.setInterpolator(new DecelerateInterpolator());
                        animation.start();

                        animation2 = ObjectAnimator.ofInt(prb2, "progress", 25);
                        animation2.setDuration(50);
                        animation2.setInterpolator(new DecelerateInterpolator());
                        animation2.start();

                        break;

                    case 2:

                        if (viewModel.getLevel().get(2).isLocked()){
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor("#BDBDBD"));
                        } else {
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level3), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level3), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor(viewModel.getLevel().get(integer).getColor()));
                        }

                        animation = ObjectAnimator.ofInt(prb1, "progress", 50);
                        animation.setDuration(50);
                        animation.setInterpolator(new DecelerateInterpolator());
                        animation.start();

                        animation2 = ObjectAnimator.ofInt(prb2, "progress", 50);
                        animation2.setDuration(50);
                        animation2.setInterpolator(new DecelerateInterpolator());
                        animation2.start();
                        break;

                    case 3:

                        if (viewModel.getLevel().get(3).isLocked()){
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor("#BDBDBD"));
                        } else {
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level4), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level4), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor(viewModel.getLevel().get(integer).getColor()));
                        }

                        animation = ObjectAnimator.ofInt(prb1, "progress", 75);
                        animation.setDuration(50);
                        animation.setInterpolator(new DecelerateInterpolator());
                        animation.start();

                        animation2 = ObjectAnimator.ofInt(prb2, "progress", 75);
                        animation2.setDuration(50);
                        animation2.setInterpolator(new DecelerateInterpolator());
                        animation2.start();

                        break;

                    case 4:

                        if (viewModel.getLevel().get(4).isLocked()){
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.levellocked), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor("#BDBDBD"));
                        } else {
                            prb1.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level5), PorterDuff.Mode.SRC_IN);
                            prb2.getProgressDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.level5), PorterDuff.Mode.SRC_IN);
                            window.setStatusBarColor(Color.parseColor(viewModel.getLevel().get(integer).getColor()));
                        }

                        animation = ObjectAnimator.ofInt(prb1, "progress", 100);
                        animation.setDuration(50);
                        animation.setInterpolator(new DecelerateInterpolator());
                        animation.start();

                        animation2 = ObjectAnimator.ofInt(prb2, "progress", 100);
                        animation2.setDuration(50);
                        animation2.setInterpolator(new DecelerateInterpolator());
                        animation2.start();

                        break;
                }
            }
        };

        viewModel.getPosition().observe(this, progressObserver);

        final Observer<LevelSelection> levelObserver = new Observer<LevelSelection>() {
            @Override
            public void onChanged(@Nullable LevelSelection levelSelection) {
                int finalNum;

                switch (levelSelection){

                    case LEVEL1:
                        finalNum = 0;
                        Intent intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.putExtra("level", LEVEL1);
                        intent.putExtra("coins2", viewModel.getLevel().get(finalNum).getCoins());
                        intent.putExtra("levelNum2", finalNum);

                        //Enviar Arraylist de levels
                        Bundle args = new Bundle();
                        args.putSerializable("ARRAYLEVEL2", viewModel.getLevel());
                        intent.putExtra("BUNDLE2", args);

                        startActivity(intent);
                        break;

                    case LEVEL2:
                        finalNum = 1;
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.putExtra("level", LEVEL2);
                        intent.putExtra("coins2", viewModel.getLevel().get(finalNum).getCoins());
                        intent.putExtra("levelNum2", finalNum);

                        //Enviar Arraylist de levels
                        args = new Bundle();
                        args.putSerializable("ARRAYLEVEL2", viewModel.getLevel());
                        intent.putExtra("BUNDLE2", args);

                        startActivity(intent);
                        break;

                    case LEVEL3:
                        finalNum = 2;
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.putExtra("level", LEVEL3);
                        intent.putExtra("coins2", viewModel.getLevel().get(finalNum).getCoins());
                        intent.putExtra("levelNum2", finalNum);

                        //Enviar Arraylist de levels
                        args = new Bundle();
                        args.putSerializable("ARRAYLEVEL2", viewModel.getLevel());
                        intent.putExtra("BUNDLE2", args);

                        startActivity(intent);
                        break;

                    case LEVEL4:
                        finalNum = 3;
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.putExtra("level", LEVEL4);
                        intent.putExtra("coins2", viewModel.getLevel().get(finalNum).getCoins());
                        intent.putExtra("levelNum2", finalNum);

                        //Enviar Arraylist de levels
                        args = new Bundle();
                        args.putSerializable("ARRAYLEVEL2", viewModel.getLevel());
                        intent.putExtra("BUNDLE2", args);

                        startActivity(intent);
                        break;

                    case LEVEL5:
                        finalNum = 4;
                        intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.putExtra("level", LEVEL5);
                        intent.putExtra("coins2", viewModel.getLevel().get(finalNum).getCoins());
                        intent.putExtra("levelNum2", finalNum);

                        //Enviar Arraylist de levels
                        args = new Bundle();
                        args.putSerializable("ARRAYLEVEL2", viewModel.getLevel());
                        intent.putExtra("BUNDLE2", args);

                        startActivity(intent);
                        break;
                }
            }
        };

        viewModel.getSelectedLevel().observe(this, levelObserver);
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Exit");
        alert.setMessage("Do you want to exit the app?");
        alert.setIcon(R.drawable.exit2);

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        alert.setNegativeButton("No", (dialog, whichButton) -> {});

        alert.show();

    }

    public void levelUnlockedDialog(int level){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        level += 1;
        alert.setTitle("Level " + level + " unlocked!!");
        alert.setIcon(R.drawable.unlocked);

        int finalLevel = level - 1;

        alert.setPositiveButton("Go", (dialog, whichButton) ->viewModel.setLevelBack(finalLevel));

        alert.show();
    }

}
