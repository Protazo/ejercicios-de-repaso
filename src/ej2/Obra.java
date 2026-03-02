package ej2;

class Obra {
    private String nombre;
    private String tipo;
    private double precio; // en millones
    private int anio;
    private String artista;

    public Obra(String nombre, String tipo, double precio, int anio, String artista) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.anio = anio;
        this.artista = artista;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }
    public int getAnio() { return anio; }
    public String getArtista() { return artista; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + "), " + precio + "M€, " + anio + ", " + artista;
    }
}