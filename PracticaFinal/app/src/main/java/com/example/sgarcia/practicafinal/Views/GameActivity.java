package com.example.sgarcia.practicafinal.Views;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sgarcia.practicafinal.Adapters.RecyclerViewAdapter;
import com.example.sgarcia.practicafinal.Entities.Level;
import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.Others.LevelSelection;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;
import com.example.sgarcia.practicafinal.ui.Fragments.LogoListFragment;
import com.example.sgarcia.practicafinal.ui.Fragments.LogoMainPageFragment;
import com.example.sgarcia.practicafinal.ui.Fragments.MainFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL1;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL2;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL3;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL4;
import static com.example.sgarcia.practicafinal.Others.LevelSelection.LEVEL5;

public class GameActivity extends AppCompatActivity {

    GameViewModel mViewModel;
    TextView levelNum, coins;
    ImageView backarrow, coinImg;
    LinearLayout infoBar;
    Window window;
    FrameLayout container;
    Animation myAnim;
    int globalLevelNum = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        backarrow = findViewById(R.id.backarrow);
        levelNum = findViewById(R.id.level);
        coins = findViewById(R.id.coins);
        infoBar = findViewById(R.id.infoBar);
        container = findViewById(R.id.logocontainer);
        window = getWindow();
        coinImg = findViewById(R.id.coinImg);
        myAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);

        mViewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        load();

        LevelSelection level = (LevelSelection) getIntent().getSerializableExtra("level");

        Intent intent = getIntent();

        if (intent.getBundleExtra("BUNDLE2") != null){
            Bundle args = intent.getBundleExtra("BUNDLE2");
            mViewModel.set_levels((ArrayList<Level>) args.getSerializable("ARRAYLEVEL2"));
        }

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

        int finalNum = num;
        globalLevelNum = num;

        if (getIntent().getSerializableExtra("coins2") != null){
            mViewModel.getLevel().get(globalLevelNum).setCoins((Integer) getIntent().getSerializableExtra("coins2"));
            mViewModel.setPlayerCoins((Integer) getIntent().getSerializableExtra("coins2"));
        }

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mViewModel.isLogoClicked().getValue()){
                    Intent intent = new Intent(GameActivity.this, MainActivity.class);
                    intent.putExtra("coins", mViewModel.getLevel().get(globalLevelNum).getCoins());
                    intent.putExtra("levelgame", finalNum);

                    //Enviar Arraylist de levels
                    Bundle args2 = new Bundle();
                    args2.putSerializable("ARRAYLEVEL1", mViewModel.getLevel());
                    intent.putExtra("BUNDLE", args2);

                    startActivity(intent);

                }else{
                    mViewModel.setLogoClicked(false);
                }
                backarrow.startAnimation(myAnim);
                mViewModel.setLetterPressed("");
                for (int i = 0; i < mViewModel.getArraylistLength().length; i++)
                    mViewModel.setArraylistLength(0, i);
            }
        });

        levelNum.setText(String.valueOf(mViewModel.getLevel().get(num).getIdLevel()));
        coins.setText(String.valueOf(mViewModel.getLevel().get(num).getCoins()));
        infoBar.setBackgroundColor(Color.parseColor(mViewModel.getLevel().get(num).getColor()));
        window.setStatusBarColor(Color.parseColor(mViewModel.getLevel().get(num).getColor()));

        final Observer<Boolean> logoClickedObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean bool) {

                if (!bool){
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.logocontainer, LogoListFragment.newInstance());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }else{
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.logocontainer, LogoMainPageFragment.newInstance());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        };

        mViewModel.isLogoClicked().observe(this, logoClickedObserver);

        final Observer<Integer> playerCoinsObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                coins.setText(integer.toString());
                coinImg.startAnimation((Animation) AnimationUtils.loadAnimation(GameActivity.this,R.anim.bounce));
                coins.startAnimation((Animation) AnimationUtils.loadAnimation(GameActivity.this,R.anim.bounce));
                coinImg.startAnimation((Animation) AnimationUtils.loadAnimation(GameActivity.this,R.anim.rotate));
            }
        };
        mViewModel.getPlayerCoins().observe(this, playerCoinsObserver);
    }

    @Override
    public void onBackPressed()
    {
        if (!mViewModel.isLogoClicked().getValue()){
            Intent intent = new Intent(GameActivity.this, MainActivity.class);
            intent.putExtra("coins", mViewModel.getLevel().get(globalLevelNum).getCoins());
            if (globalLevelNum != -1)
                intent.putExtra("levelgame", globalLevelNum);

            //Enviar Arraylist de levels
            Bundle args2 = new Bundle();
            args2.putSerializable("ARRAYLEVEL1", mViewModel.getLevel());
            intent.putExtra("BUNDLE2", args2);

            startActivity(intent);

        }else{
            mViewModel.setLogoClicked(false);
        }
        backarrow.startAnimation(myAnim);
        mViewModel.setLetterPressed("");
        for (int i = 0; i < mViewModel.getArraylistLength().length; i++)
            mViewModel.setArraylistLength(0, i);
    }

    @Override
    protected void onPause() {
        super.onPause();
        save();
    }

    private void save(){
        SharedPreferences shref;
        SharedPreferences.Editor editor;

        shref = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        editor = shref.edit();

        Gson gson = new Gson();
        String json = gson.toJson(mViewModel.getLevel());

        editor.putString("arrayLevel", json);

        editor.apply();
    }

    private void load(){
        SharedPreferences shref;
        shref = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());

        Gson gson = new Gson();
        Type type = new TypeToken<List<Level>>(){}.getType();

        String response = shref.getString("arrayLevel" , "default");

        if (!response.equals("default")){
            mViewModel.set_levels(gson.fromJson(response,type));
        }

    }
}
