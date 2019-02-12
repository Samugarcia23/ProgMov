package com.example.sgarcia.practicafinal.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.sgarcia.practicafinal.Entities.Logo;
import com.example.sgarcia.practicafinal.R;
import com.example.sgarcia.practicafinal.ViewModel.GameViewModel;

/*
 *
 *   Clase que funciona como adaptador del recyclerView "logocontainer" del layout "activity_game"
 *
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private GameViewModel mViewModel;
    private Context context;
    Animation myAnim;

    //Constructor que recibe como parametro el viewmodel

    public RecyclerViewAdapter(GameViewModel viewModel){
        this.mViewModel = viewModel;
    }

    //Metodo que "infla" el layout que se va a ver en cada posicion del recyclerView.
    //Retorna dicha vista como parametro de MyViewHolder

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.logolist, viewGroup, false);
        myAnim = AnimationUtils.loadAnimation(view.getContext(), R.anim.bounce);

        return new MyViewHolder(view);
    }

    //Metodo que hace asigna el valor a los componentes de la vista a traves del viewholder

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int position) {

        int level = 0;

        switch (mViewModel.getSelectedLevel().getValue()){
            case LEVEL1:
                level = 0;
                break;

            case LEVEL2:
                level = 1;
                break;

            case LEVEL3:
                level = 2;
                break;

            case LEVEL4:
                level = 3;
                break;

            case LEVEL5:
                level = 4;
                break;
        }

        final int selected = level;
        final Logo logo = mViewModel.getLevel().get(selected).getLevelLogos().get(position);

        myViewHolder.logo.setImageResource(logo.getImg());

        if (logo.isGuessed()){
            myViewHolder.logoguessed.setVisibility(View.VISIBLE);
            myViewHolder.logo.setImageAlpha(50);
            myViewHolder.logo.setEnabled(false);
        }else{
            myViewHolder.logoguessed.setVisibility(View.INVISIBLE);
            myViewHolder.logoguessed.setEnabled(false);
        }

        myViewHolder.logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.setLogoClicked(true);
                mViewModel.setSelectedLogo(logo);
                mViewModel.setViewPagerPosition(myViewHolder.getAdapterPosition());
                myViewHolder.logo.startAnimation(myAnim);
            }
        });

    }

    //Metodo que retorna el total de items en el RecyclerView

    @Override
    public int getItemCount() {
        return mViewModel.getLevel().get(0).getLevelLogos().size();
    }

    //Clase estatica que recibe una vista y asigna cada componente a su id del layout

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView logo, logoguessed;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            logo = itemView.findViewById(R.id.logo);
            logoguessed = itemView.findViewById(R.id.logoguessed);

        }
    }
}
