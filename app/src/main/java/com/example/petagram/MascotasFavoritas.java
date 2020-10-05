package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.petagram.adapter.MascotaAdaptador;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MascotasFavoritas extends AppCompatActivity {
    private ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar actionBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        listaMascotas.setLayoutManager(new GridLayoutManager(this, 1));
        inicializarMascotas();
        inicializarAdaptador();
    }

    public void inicializarMascotas() {

        mascotasFavoritas = new ArrayList<Mascota>(5);
        Bundle bundle = getIntent().getExtras();

        ArrayList<Mascota> mascotasRecibidas = (ArrayList<Mascota>) bundle.getSerializable(getResources().getString(R.string.key_mascota_favorita));

        Collections.sort(mascotasRecibidas, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota o1, Mascota o2) {
                return MascotasFavoritas.compare(o1.getRaiting(), o2.getRaiting());
            }
        });

        for (int i = 0; i < 5 ; i++){
            mascotasFavoritas.add(mascotasRecibidas.get(i));
        }


    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasFavoritas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public static int compare(int x, int y) {
        return (x < y) ? 1 : ((x == y) ? 0 : -1);
    }
}