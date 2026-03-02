package ej2;

import java.util.*;

public class MuseoApp {

    static Map<String, Artista> artistas = new HashMap<>();
    static ArrayList<Obra> todasLasObras = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Añadir obra");
            System.out.println("2. Añadir artista");
            System.out.println("3. Buscar obra por nombre");
            System.out.println("4. Buscar obras por artista");
            System.out.println("5. Eliminar obra");
            System.out.println("6. Encontrar obra más barata");
            System.out.println("7. Encontrar obra más moderna");
            System.out.println("8. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> añadirObra();
                case 2 -> añadirArtista();
                case 3 -> buscarObra();
                case 4 -> buscarPorArtista();
                case 5 -> eliminarObra();
                case 6 -> obraMasBarata();
                case 7 -> obraMasModerna();
                case 8 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 8);
    }
    public static void añadirArtista() {
        System.out.print("Nombre artista: ");
        String nombre = sc.nextLine();

        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();

        artistas.put(nombre, new Artista(nombre, nacionalidad));
        System.out.println("Artista añadido correctamente.");
    }

    public static void añadirObra() {
        System.out.print("Nombre obra: ");
        String nombre = sc.nextLine();

        System.out.print("Tipo: ");
        String tipo = sc.nextLine();

        System.out.print("Precio (en millones): ");
        double precio = sc.nextDouble();

        System.out.print("Año: ");
        int anio = sc.nextInt();
        sc.nextLine();

        System.out.print("Artista: ");
        String nombreArtista = sc.nextLine();

        if (artistas.containsKey(nombreArtista)) {
            Obra obra = new Obra(nombre, tipo, precio, anio, nombreArtista);
            todasLasObras.add(obra);
            artistas.get(nombreArtista).agregarObra(obra);
            System.out.println("Obra añadida correctamente.");
        } else {
            System.out.println("El artista no existe.");
        }
    }

    public static void buscarObra() {
        System.out.print("Nombre de la obra: ");
        String nombre = sc.nextLine();

        for (Obra o : todasLasObras) {
            if (o.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(o);
                return;
            }
        }

        System.out.println("Obra no encontrada.");
    }

    public static void buscarPorArtista() {
        System.out.print("Nombre artista: ");
        String nombre = sc.nextLine();

        if (artistas.containsKey(nombre)) {
            ArrayList<Obra> obras = artistas.get(nombre).getObras();
            for (Obra o : obras) {
                System.out.println(o);
            }
        } else {
            System.out.println("Artista no encontrado.");
        }
    }

    public static void eliminarObra() {
        System.out.print("Nombre de la obra a eliminar: ");
        String nombre = sc.nextLine();

        Iterator<Obra> it = todasLasObras.iterator();

        while (it.hasNext()) {
            Obra o = it.next();
            if (o.getNombre().equalsIgnoreCase(nombre)) {
                it.remove(); // Eliminación segura
                artistas.get(o.getArtista()).getObras().remove(o);
                System.out.println("Obra eliminada.");
                return;
            }
        }

        System.out.println("Obra no encontrada.");
    }

    public static void obraMasBarata() {
        if (todasLasObras.isEmpty()) {
            System.out.println("No hay obras.");
            return;
        }

        Obra barata = todasLasObras.get(0);

        for (Obra o : todasLasObras) {
            if (o.getPrecio() < barata.getPrecio()) {
                barata = o;
            }
        }

        System.out.println("Obra más barata:");
        System.out.println(barata);
    }

    public static void obraMasModerna() {
        if (todasLasObras.isEmpty()) {
            System.out.println("No hay obras.");
            return;
        }

        Obra moderna = todasLasObras.get(0);

        for (Obra o : todasLasObras) {
            if (o.getAnio() > moderna.getAnio()) {
                moderna = o;
            }
        }

        System.out.println("Obra más moderna:");
        System.out.println(moderna);
    }
}
