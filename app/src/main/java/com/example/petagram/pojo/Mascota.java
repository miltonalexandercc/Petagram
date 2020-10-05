package com.example.petagram.pojo;

import java.io.Serializable;

public class Mascota implements Serializable {
    private int foto;
    private String nombre;
    private int raiting;

    public Mascota(int foto, String nombre, int raiting) {
        this.foto = foto;
        this.nombre = nombre;
        this.raiting = raiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRaiting() {
        return raiting;
    }

    public void aumentarRaiting() {
        this.raiting += 1;
    }
}
