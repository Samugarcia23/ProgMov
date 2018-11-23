package com.example.sgarcia.examen1eval;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    ListadoJugadores listadoJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listadoJugadores = new ListadoJugadores();
        lista = findViewById(R.id.listaJugadores);
        lista.setAdapter(new IconicAdapter(this, R.layout.filafutbol, R.layout.filabasket, listadoJugadores.listaBasket(), listadoJugadores.listaFutbol()));
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String nombreF = listadoJugadores.listaFutbol().get(position).getNombre();
            String pos = listadoJugadores.listaFutbol().get(position).getPosicion();
            int fotoF = listadoJugadores.listaFutbol().get(position).getFoto();

            String nombreB = listadoJugadores.listaBasket().get(position).getNombre();
            int fotoB = listadoJugadores.listaBasket().get(position).getFoto();
            int puntos = listadoJugadores.listaBasket().get(position).getPuntos();
            int asist = listadoJugadores.listaBasket().get(position).getAsistencias();
            int rebotes = listadoJugadores.listaBasket().get(position).getRebotes();

            Intent i;

            if (!nombreF.equals("")){
                i = new Intent(this, Edit.class);
                i.putExtra("Nombre", nombreF);
                i.putExtra("Posicion", pos);
                i.putExtra("Foto", fotoF);
            }else{
                if(!nombreB.equals("")){
                  i = new Intent(this, EditBasket.class);
                  i.putExtra("Nombre", nombreB);
                  i.putExtra("Foto", fotoB);
                  i.putExtra("Puntos", puntos);
                  i.putExtra("Asist", asist);
                  i.putExtra("Rebotes", rebotes);
                }
            }



    }

    private class IconicAdapter extends BaseAdapter {

        Context context;
        int filaFutbol, filaBasket;
        ArrayList<JugadorBasket> listaBasket;
        ArrayList<JugadorFutbol> listaFutbol;

        IconicAdapter(Context context, int filaFutbol, int filaBasket, ArrayList<JugadorBasket> listaBasket, ArrayList<JugadorFutbol> listaFutbol){
            this.context = context;
            this.filaFutbol = filaFutbol;
            this.filaBasket = filaBasket;
            this.listaBasket = listaBasket;
            this.listaFutbol = listaFutbol;
        }

        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return listaBasket.size() + listaFutbol.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View filaJugadores = convertView;
            ViewHolderFutbol viewHolderFutbol = null;
            ViewHolderBasket viewHolderBasket = null;

            int type = getItemViewType(position);

            if (filaJugadores == null){
                LayoutInflater inflater = getLayoutInflater();
                if (type == 0){
                    filaJugadores = inflater.inflate(R.layout.filafutbol, parent, false);
                    ImageView fotoFut = findViewById(R.id.fotofutbol);
                    TextView nombreFut = findViewById(R.id.tvnombre);
                    TextView posicion = findViewById(R.id.tvpos);
                    viewHolderFutbol = new ViewHolderFutbol(fotoFut, nombreFut, posicion);
                    filaJugadores.setTag(viewHolderFutbol);
                }else{
                    filaJugadores = inflater.inflate(R.layout.filabasket, parent, false);
                    ImageView fotoBasket = findViewById(R.id.fotobasket);
                    TextView nombreBasket = findViewById(R.id.tvnombrebasket);
                    TextView rebotes = findViewById(R.id.tvrebotes);
                    TextView puntos = findViewById(R.id.tvpuntos);
                    TextView asist = findViewById(R.id.tvasist);
                    viewHolderBasket = new ViewHolderBasket(fotoBasket, nombreBasket, rebotes, puntos, asist);
                    filaJugadores.setTag(viewHolderBasket);
                }
            }else{
                if(type == 0){
                    viewHolderFutbol = (ViewHolderFutbol) filaJugadores.getTag();
                }else{
                    viewHolderBasket = (ViewHolderBasket) filaJugadores.getTag();
                }
            }

            if(type == 0){
                if (listaFutbol.get(position).getNombre().equals("Lukaku")) {
                    viewHolderFutbol.getFoto().setImageResource(R.drawable.romelu_lukaku_f);
                    viewHolderFutbol.getNombre().setText(listaFutbol.get(position).getNombre());
                    viewHolderFutbol.getPosicion().setText(listaFutbol.get(position).getPosicion());
                }else{
                    if (listaFutbol.get(position).getNombre().equals("Bruyne")) {
                        viewHolderFutbol.getFoto().setImageResource(R.drawable.kevin_de_bruyne_f);
                        viewHolderFutbol.getNombre().setText(listaFutbol.get(position).getNombre());
                        viewHolderFutbol.getPosicion().setText(listaFutbol.get(position).getPosicion());
                    }
                }
            }else{
                if (listaBasket.get(position).getNombre().equals("Lebron James")) {

                    viewHolderBasket.getNombre().setText(listaBasket.get(position).getNombre());
                    viewHolderBasket.getPuntos().setText(Integer.toString(listaBasket.get(position).getPuntos()));
                    viewHolderBasket.getAsistencias().setText(Integer.toString(listaBasket.get(position).getAsistencias()));
                    viewHolderBasket.getRebotes().setText(Integer.toString(listaBasket.get(position).getRebotes()));
                }else{
                    if (listaBasket.get(position).getNombre().equals("Marc Gasol")) {
                        viewHolderBasket.getFoto().setImageResource(R.drawable.marc_gasol_b);
                        viewHolderBasket.getNombre().setText(listaBasket.get(position).getNombre());
                        viewHolderBasket.getPuntos().setText(Integer.toString(listaBasket.get(position).getPuntos()));
                        viewHolderBasket.getAsistencias().setText(Integer.toString(listaBasket.get(position).getAsistencias()));
                        viewHolderBasket.getRebotes().setText(Integer.toString(listaBasket.get(position).getRebotes()));
                    }else{
                        if (listaBasket.get(position).getNombre().equals("Pau Gasol")) {
                            viewHolderBasket.getFoto().setImageResource(R.drawable.pau_gasol_b);
                            viewHolderBasket.getNombre().setText(listaBasket.get(position).getNombre());
                            viewHolderBasket.getPuntos().setText(Integer.toString(listaBasket.get(position).getPuntos()));
                            viewHolderBasket.getAsistencias().setText(Integer.toString(listaBasket.get(position).getAsistencias()));
                            viewHolderBasket.getRebotes().setText(Integer.toString(listaBasket.get(position).getRebotes()));
                        }
                    }
                }
            }

            return (filaJugadores);
        }
    }
}
