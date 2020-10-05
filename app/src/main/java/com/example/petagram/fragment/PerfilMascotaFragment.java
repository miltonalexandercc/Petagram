package com.example.petagram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.R;
import com.example.petagram.adapter.MascotaAdaptador;

import static com.example.petagram.MainActivity.mascotas;

public class PerfilMascotaFragment extends Fragment {
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.mascotasGrid);
        GridLayoutManager llm = new GridLayoutManager(getActivity(), 3);

        listaMascotas.setLayoutManager(llm);
        inicializarAdaptador();

        return v;

    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity(), true);
        listaMascotas.setAdapter(adaptador);
    }
}