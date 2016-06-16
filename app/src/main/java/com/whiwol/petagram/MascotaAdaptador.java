package com.whiwol.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jmdra on 16/06/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    //4.- Declarando la coleccion de los contactos
    ArrayList<Mascota> mascotas;
    Activity activity;

    //10.- Generando el metodo Constructor


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override //6.- Esto infla o le da vida a nuestro layout cardview, Infla el layout y lo pasa al viewholder
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_petagram, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override //7.- Aqui vamos a pasar la lista de Mascotas
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvLikesCV.setText(mascota.getLikes());
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());

        //8.- Haciendo Click en la Imagen
        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        //9.- Haciendo Click en el boton Like
        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override //5.- EL numero total de contactos
    public int getItemCount() {
        return mascotas.size();
    }

    //1.-Creando Clase Inner Statica de View Holer
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        //2.- Se declaran todos los views declarados dentro del cardview aqui es donde se adaptan
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvLikesCV;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            // 3.- Se asocia el ImageView y se hace el casting
            imgFoto         = (ImageView)   itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView)    itemView.findViewById(R.id.tvNombreCV);
            tvLikesCV       = (TextView)    itemView.findViewById(R.id.tvLikesCV);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
