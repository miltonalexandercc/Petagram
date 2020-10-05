package com.example.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.petagram.adapter.PageAdapter;
import com.example.petagram.fragment.MascotaFragment;
import com.example.petagram.fragment.PerfilMascotaFragment;
import com.example.petagram.pojo.Mascota;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Mascota> mascotas;


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarMascotas();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    public void goToFavorites() {
        Intent intent = new Intent(getApplicationContext(), MascotasFavoritas.class);
        intent.putExtra(getResources().getString(R.string.key_mascota_favorita), mascotas);
        startActivity(intent);
    }

    public void goToRegistrer() {
        Intent intent = new Intent(getApplicationContext(), RegistrarComentario.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ic_favoritos:
                goToFavorites();
                break;
            case R.id.mContacto:
                goToRegistrer();
                break;
            case R.id.mAcerca:
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MascotaFragment());
        fragments.add(new PerfilMascotaFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_bone_yellow);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_bone_white);

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
}