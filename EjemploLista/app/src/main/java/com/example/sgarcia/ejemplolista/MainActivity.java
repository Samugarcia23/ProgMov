package com.example.sgarcia.ejemplolista;

import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    public ViewModel miViewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list;
        list=findViewById(R.id.lvLista);
        miViewmodel = ViewModelProviders.of(this).get(CargarLista.class);
        ((CargarLista) miViewmodel).getLista().observe(this, lista -> {
            ArrayAdapter<String> a = new ArrayAdapter<String>(this,
                    R.layout.fila, R.id.tv1 , lista);
            list.setAdapter(a);
        });

        list.setOnItemClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView item;
        item = view.findViewById(R.id.tv1);
        String b = item.getText().toString();
        Toast toast = Toast.makeText(this, b + " pulsado", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Cambiar Nombre");
        alert.setMessage("¿Quieres cambiar el nombre?");

        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Sí", (dialog, whichButton) -> ((CargarLista) miViewmodel).setLista(position, input.getText().toString()));

        alert.setNegativeButton("No", (dialog, whichButton) -> {});

        alert.show();

        return true;
    }



}
