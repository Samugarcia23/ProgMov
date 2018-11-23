package com.example.sgarcia.ejemplolistadinamica;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String[] items = {"Boston Celtics","Boston Celtics", "New York Knics", "New York Knics",
            "Toronto Raptors","Toronto Raptors", "Golden State Warriors","Golden State Warriors",  "Los Angeles Lakers","Los Angeles Lakers", "Phoenix Suns", "Phoenix Suns", "Boston Celtics","Boston Celtics", "New York Knics", "New York Knics",
            "Toronto Raptors","Toronto Raptors", "Golden State Warriors","Golden State Warriors",  "Los Angeles Lakers","Los Angeles Lakers", "Phoenix Suns", "Phoenix Suns", "Boston Celtics","Boston Celtics", "New York Knics", "New York Knics",
            "Toronto Raptors","Toronto Raptors", "Golden State Warriors","Golden State Warriors",  "Los Angeles Lakers","Los Angeles Lakers", "Phoenix Suns", "Phoenix Suns"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lista;
        lista=findViewById(R.id.lista);
        lista.setAdapter(new IconicAdapter(this, R.layout.filas, R.layout.filas2, items));
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast toast = Toast.makeText(getApplicationContext(), "Has pulsado: " + items[position], Toast.LENGTH_SHORT);
        toast.show();
    }

    public class IconicAdapter extends BaseAdapter{
        Context context;
        int fila1, fila2;
        String[] items;
        IconicAdapter(Context context, int fila1, int fila2, String[] items){
            this.context = context;
            this.fila1 = fila1;
            this.fila2 = fila2;
            this.items = items;
        }


        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return position % 2;
        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent){

            View fila = convertView;
            ViewHolder viewHolder = null;
            ViewHolder2 viewHolder2 = null;

            int type = getItemViewType(position);

            if (fila == null){
                LayoutInflater inflater = getLayoutInflater();
                //fila = inflater.inflate(R.layout.filas, parent, false);
                if (type == 0) {
                    fila = inflater.inflate(R.layout.filas, parent, false);
                    ImageView img = fila.findViewById(R.id.icon);
                    viewHolder = new ViewHolder(img);
                    fila.setTag(viewHolder);
                }else {
                    fila = inflater.inflate(R.layout.filas2, parent, false);
                    TextView tv = fila.findViewById(R.id.label);
                    viewHolder2 = new ViewHolder2(tv);
                    fila.setTag(viewHolder2);
                }
            }else{
                if (type == 0) {
                    viewHolder = (ViewHolder) fila.getTag();
                }else {
                    viewHolder2 = (ViewHolder2) fila.getTag();
                }
            }
            if (type==0){
                if(items[position].equals("Boston Celtics")){
                    viewHolder.getImg().setImageResource(R.drawable.bostonceltics);
                }
                else if(items[position] .equals("New York Knics")){
                    viewHolder.getImg().setImageResource(R.drawable.newyorkknicks);
                }
                else if(items[position].equals("Toronto Raptors")){
                    viewHolder.getImg().setImageResource(R.drawable.torontoraptors);
                }
                else if(items[position].equals("Golden State Warriors")){
                    viewHolder.getImg().setImageResource(R.drawable.goldenstatewarriors);
                }
                else if(items[position].equals("Los Angeles Lakers")){
                    viewHolder.getImg().setImageResource(R.drawable.lakers);
                }
                else if(items[position].equals("Phoenix Suns")){
                    viewHolder.getImg().setImageResource(R.drawable.phoenixsuns);
                }else{
                    viewHolder.getImg().setImageResource(R.drawable.delete);
                }
            }else
                viewHolder2.getLab().setText(items[position]);
            return(fila);
        }
    }


}
