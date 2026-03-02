package ej3;

import java.util.ArrayList;

class Jugador {

    private String nombre;
    private String personaje;
    private ArrayList<String> herramientas;
    private int vida;

    public Jugador(String nombre, String personaje, ArrayList<String> herramientas, int vida) {
        this.nombre = nombre;
        this.personaje = personaje;
        this.herramientas = herramientas;
        this.vida = vida;
    }

    public String getNombre() { return nombre; }
    public String getPersonaje() { return personaje; }
    public ArrayList<String> getHerramientas() { return herramientas; }
    public int getVida() { return vida; }

    public void aumentarVida(int cantidad) {
        vida += cantidad;
    }

    public void imprimirDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Personaje: " + personaje);
        System.out.println("Herramientas: " + herramientas);
        System.out.println("Vida: " + vida);
    }
}
