package com.example.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
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
        holder.foto.setImageResource(mascota.getFoto());
        holder.nombre.setText(mascota.getNombre());
        holder.raiting.setText(String.valueOf(mascota.getRaiting()));

        holder.huesoAmarillo.setOnClickListener(new View.OnClickListener() {
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

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private TextView nombre;
        private TextView raiting;
        private ImageView huesoAmarillo;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            raiting = (TextView) itemView.findViewById(R.id.posicion);
            huesoAmarillo = (ImageView) itemView.findViewById(R.id.imgIconoHuesoAmarillo);
        }

        public TextView getRaiting() {
            return raiting;
        }
    }
}
