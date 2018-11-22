package com.example.sam.repasoexamen1eva;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnElegir;
    ListView lista;
    String [] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnElegir = findViewById(R.id.btnElegir);
        lista = findViewById(R.id.listado);
        btnElegir.setOnClickListener(this);
        ArrayAdapter a = new ArrayAdapter <>(this, R.layout.fila, R.id.label, items);
        lista.setAdapter(a);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
    }

}
