package ej2;

import java.util.ArrayList;

class Artista {
    private String nombre;
    private String nacionalidad;
    private ArrayList<Obra> obras;

    public Artista(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.obras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }

    public void agregarObra(Obra obra) {
        obras.add(obra);
    }
}