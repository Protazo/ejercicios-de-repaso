package ej3;

import java.util.*;

public class JuegoApp {

    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        cargarJugadoresIniciales();

        while (true) {
            System.out.println("\nIntroduce nombre del jugador inicial (o 'salir'):");
            String nombre = sc.nextLine();

            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            Jugador jugadorActual = buscarJugador(nombre);

            if (jugadorActual == null) {
                System.out.println("Jugador no encontrado.");
                continue;
            }

            menuJugador(jugadorActual);
        }
    }

    public static void cargarJugadoresIniciales() {

        jugadores.add(new Jugador("Sergio", "inventor",
                new ArrayList<>(Arrays.asList("fórmula", "microscopio", "microorganismo", "autómata")), 90));

        jugadores.add(new Jugador("Mara", "guerrera",
                new ArrayList<>(Arrays.asList("escudo", "ballesta", "hacha", "unicornio")), 80));

        jugadores.add(new Jugador("Miquel", "rastreador",
                new ArrayList<>(Arrays.asList("lupa", "escoba", "dragón", "brújula")), 85));

        jugadores.add(new Jugador("Claudia", "maga",
                new ArrayList<>(Arrays.asList("varita", "hechizo", "libro", "gata")), 110));

        jugadores.add(new Jugador("Carlos", "sabio",
                new ArrayList<>(Arrays.asList("varita", "conjuro", "sombrero", "búho")), 95));

        jugadores.add(new Jugador("Alexia", "exploradora",
                new ArrayList<>(Arrays.asList("látigo", "semillas", "hacha", "yegua")), 100));
    }
    public static void menuJugador(Jugador jugador) {

        int opcion;

        do {
            System.out.println("\n1. Imprimir datos");
            System.out.println("2. Jugar");
            System.out.println("3. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> jugador.imprimirDatos();
                case 2 -> jugar(jugador);
                case 3 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 3);
    }
    public static void jugar(Jugador j1) {

        System.out.println("Introduce nombre del amigo:");
        String nombreAmigo = sc.nextLine();

        Jugador j2 = buscarJugador(nombreAmigo);

        if (j2 == null) {
            System.out.println("Jugador no encontrado.");
            return;
        }

        int victorias1 = 0;
        int victorias2 = 0;

        while (victorias1 < 2 && victorias2 < 2) {

            // Asignar valores aleatorios a herramientas
            HashMap<String, Integer> valores1 = asignarValores(j1);
            HashMap<String, Integer> valores2 = asignarValores(j2);

            // Elegir herramienta
            String herramienta1 = elegirHerramienta(j1);
            String herramienta2 = elegirHerramienta(j2);

            int valor1 = valores1.get(herramienta1);
            int valor2 = valores2.get(herramienta2);

            System.out.println(j1.getNombre() + " eligió " + herramienta1 + " (" + valor1 + ")");
            System.out.println(j2.getNombre() + " eligió " + herramienta2 + " (" + valor2 + ")");

            if (valor1 > valor2) {
                victorias1++;
                System.out.println(j1.getNombre() + " gana la ronda");
            } else if (valor2 > valor1) {
                victorias2++;
                System.out.println(j2.getNombre() + " gana la ronda");
            } else {
                System.out.println("Empate");
            }
        }

        if (victorias1 == 2) {
            System.out.println("GANADOR FINAL: " + j1.getNombre());
            j1.aumentarVida(10);
        } else {
            System.out.println("GANADOR FINAL: " + j2.getNombre());
            j2.aumentarVida(10);
        }
    }
    public static Jugador buscarJugador(String nombre) {
        for (Jugador j : jugadores) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                return j;
            }
        }
        return null;
    }

    public static HashMap<String, Integer> asignarValores(Jugador j) {

        HashMap<String, Integer> mapa = new HashMap<>();

        for (String herramienta : j.getHerramientas()) {
            mapa.put(herramienta, random.nextInt(4) + 1); // 1-4
        }

        return mapa;
    }

    public static String elegirHerramienta(Jugador j) {

        System.out.println("Herramientas disponibles: " + j.getHerramientas());
        System.out.println("Elige herramienta:");

        return sc.nextLine();
    }
}
