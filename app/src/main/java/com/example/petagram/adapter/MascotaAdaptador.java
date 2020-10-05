package com.example.petagram.adapter;

import android.app.Activity;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.pojo.Mascota;
import com.example.petagram.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    boolean grid;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity, boolean grid) {
        this.mascotas = mascotas;
        this.activity = activity;
        this.grid = grid;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.getFoto().setImageResource(mascota.getFoto());
        holder.getNombre().setText(mascota.getNombre());

        if (grid) {
            gridConfig(holder);
        }

        holder.getRaiting().setText(String.valueOf(mascota.getRaiting()));

        holder.getHuesoAmarillo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.aumentarRaiting();
                holder.getRaiting().setText(String.valueOf(mascota.getRaiting()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public void gridConfig(MascotaViewHolder holder) {
        holder.getNombre().setVisibility(View.GONE);
        holder.getHuesoBlanco().setVisibility(View.GONE);

        ViewGroup.LayoutParams cardParam= holder.getCardView().getLayoutParams();
        cardParam.height = 400;
        cardParam.width = 300;

    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private TextView nombre;
        private TextView raiting;
        private ImageView huesoAmarillo;
        private ImageView huesoBlanco;

        private CardView cardView;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            raiting = (TextView) itemView.findViewById(R.id.posicion);
            huesoAmarillo = (ImageView) itemView.findViewById(R.id.imgIconoHuesoAmarillo);
            huesoBlanco = (ImageView) itemView.findViewById(R.id.imgIconoHuesoBlanco);
            cardView = (CardView) itemView.findViewById(R.id.cvMascota);
        }

        public TextView getRaiting() {
            return raiting;
        }

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getFoto() {
            return foto;
        }

        public ImageView getHuesoAmarillo() {
            return huesoAmarillo;
        }

        public ImageView getHuesoBlanco() {
            return huesoBlanco;
        }


        public CardView getCardView() {
            return cardView;
        }

    }

}
