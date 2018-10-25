package com.example.sgarcia.ejemplolistadinamica;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String[] items = {"Boston Celtics", "New York Knics",
            "Toronto Raptors", "Golden State Warriors", "Los Angeles Lakers", "Phoenix Suns"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lista;
        lista=findViewById(R.id.lista);
        lista.setAdapter(new IconicAdapter<>(this, R.layout.filas, R.id.label, items));
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast toast = Toast.makeText(getApplicationContext(), "Has pulsado: " + items[position], Toast.LENGTH_SHORT);
        toast.show();
    }

    class IconicAdapter<T> extends ArrayAdapter<T> {
        IconicAdapter(Context c, int resourceId, int textId, T[] objects) {
            super(c, resourceId, textId, objects);
        }
        public View getView(int position, View convertView, ViewGroup parent){

            View fila = convertView;

            if (fila == null){
                LayoutInflater inflater = getLayoutInflater();
                fila = inflater.inflate(R.layout.filas, parent, false);
            }

            TextView nombreEquipo = fila.findViewById(R.id.label);
            nombreEquipo.setText(items[position]);

            ImageView escudo = fila.findViewById(R.id.icon);

            if(items[position].equals("Boston Celtics")){
                escudo.setImageResource(R.drawable.bostonceltics);
            }
            else if(items[position].equals("New York Knics")){
                escudo.setImageResource(R.drawable.newyorkknicks);
            }
            else if(items[position].equals("Toronto Raptors")){
                escudo.setImageResource(R.drawable.torontoraptors);
            }
            else if(items[position].equals("Golden State Warriors")){
                escudo.setImageResource(R.drawable.goldenstatewarriors);
            }
            else if(items[position].equals("Los Angeles Lakers")){
                escudo.setImageResource(R.drawable.lakers);
            }
            else if(items[position].equals("Phoenix Suns")){
                escudo.setImageResource(R.drawable.phoenixsuns);
            }

            return(fila);
        }
    }


}
