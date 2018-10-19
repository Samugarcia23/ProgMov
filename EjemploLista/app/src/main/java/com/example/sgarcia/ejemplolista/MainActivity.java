package com.example.sgarcia.ejemplolista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista;
        lista=findViewById(R.id.lvLista);

        String[] items = {"item 1", "item 2", "item 3", "item 4", "item 5", "item 6","item 7", "item 8"};
        ArrayAdapter a = new ArrayAdapter<String>(this,
                R.layout.fila, R.id.tv1 , items);
        lista.setAdapter(a);
        lista.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = ((TextView)view.findViewById(R.id.tv1)).getText().toString();
        Toast toast = Toast.makeText(this, item + " pulsado", Toast.LENGTH_SHORT);
        toast.show();
    }
}
