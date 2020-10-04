package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(actionBar);

        goToFavorites();

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();
    }

    public void inicializarMascotas() {
        mascotas = new ArrayList();

        mascotas.add(new Mascota(R.drawable.dog, "Firulais", 0));
        mascotas.add(new Mascota(R.drawable.gato, "Ramiro", 0));
        mascotas.add(new Mascota(R.drawable.dog2, "Carlos", 0));
        mascotas.add(new Mascota(R.drawable.gato2, "Bola de nieve", 0));
        mascotas.add(new Mascota(R.drawable.dog, "Firulais 2", 0));
        mascotas.add(new Mascota(R.drawable.gato, "Ramiro 2", 0));
        mascotas.add(new Mascota(R.drawable.dog2, "Carlos 2", 0));
        mascotas.add(new Mascota(R.drawable.gato2, "Bola de nieve 2", 0));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void goToFavorites(){
        ImageView icFavoritos = (ImageView) findViewById(R.id.ic_favoritos);
        icFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MascotasFavoritas.class);
                intent.putExtra(getResources().getString(R.string.key_mascota_favorita), mascotas);
                startActivity(intent);
            }
        });
    }

}