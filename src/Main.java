import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("=====================================");
        System.out.println("  VUELOS DEL AEROPUERTO DE VALENCIA  ");
        System.out.println("=====================================");
        System.out.println();
        System.out.println("1 - Imprimir todos lo vuelos");
        System.out.println("2 - Buscar un número de vuelo");
        System.out.println("3 - Buscar vuelos por clave");
        System.out.println("4 - Añadir vuelo nuevo");
        System.out.println("5 - Borrar vuelo por número");
        System.out.println("6 - Mostrar el menú");
        System.out.println("0 - SALIR");
        System.out.println("-------------------------------------");
    }

    public static ListIterator<Vuelos> hacervuelos(LinkedList<Vuelos> vuelos) {
        Vuelos vuelo01 = new Vuelos("2023-01", "Valencia", "Menorca", "15-08", Vuelos.Tipo.TURISTA);
        Vuelos vuelo02 = new Vuelos("2023-02", "Valencia", "Tenerife", "15-08", Vuelos.Tipo.TURISTA);
        Vuelos vuelo03 = new Vuelos("2023-03", "París", "Valencia", "15-08", Vuelos.Tipo.PRIMERA);
        Vuelos vuelo04 = new Vuelos("2023-04", "Atenas", "Valencia", "15-08", Vuelos.Tipo.PRIMERA);

        vuelos.add(vuelo01);
        vuelos.add(vuelo02);
        vuelos.add(vuelo03);
        vuelos.add(vuelo04);

        ListIterator<Vuelos> iterator = vuelos.listIterator();

        return iterator;
    }

    static void main() {
        Scanner scan = new Scanner(System.in);


        LinkedList<Vuelos> vueloslist = new LinkedList<>();
        ListIterator<Vuelos> iterator = hacervuelos(vueloslist);

        menu();
        boolean repetir = true;
        do {

            int opcion = 0;
            System.out.println("Dame la opción (6 para menú): ");

            try {

                opcion = scan.nextInt();
                switch (opcion) {

                    case 0 -> repetir = false;

                    case 1 -> {
                        if (iterator.hasNext())
                        for (int i = 0; i < vueloslist.size(); i++) {
                            System.out.println(iterator.next());
                        }
                        while (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                    }

                    case 2 -> {
                        boolean continuar = false;
                        do {
                            try {

                                System.out.println("Dime el número de vuelo: ");
                                String numero = scan.nextLine();

                                for (Vuelos x : vueloslist) {
                                    x.g
                                }

                                continuar = true;
                            } catch (Exception e) {
                                System.out.println("ERROR, repite");
                                continuar = false;
                            }
                        } while (!continuar);
                    }

                    case 6 -> menu();
                }

            } catch (Exception e) {
                System.out.println("ERROR, solo números enteros del 0 al 6");
            }
        } while (repetir);
    }
}
