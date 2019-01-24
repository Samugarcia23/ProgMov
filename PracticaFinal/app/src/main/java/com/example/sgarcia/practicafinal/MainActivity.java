package com.example.sgarcia.practicafinal;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sgarcia.practicafinal.ui.main.MainFragment;
import com.example.sgarcia.practicafinal.ui.main.MainViewModel;

public class MainActivity extends AppCompatActivity {

    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

    }
}
