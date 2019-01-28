package com.example.sgarcia.practicafinal.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sgarcia.practicafinal.Adapters.RecyclerViewAdapter;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.MainViewModel;

public class GameActivity extends AppCompatActivity {

    MainViewModel mViewModel;
    RecyclerView rvlogo;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        adapter = new RecyclerViewAdapter(mViewModel);
        rvlogo = findViewById(R.id.rvlogo);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        rvlogo.setLayoutManager(mLayoutManager);
        rvlogo.setAdapter(adapter);
    }
}
