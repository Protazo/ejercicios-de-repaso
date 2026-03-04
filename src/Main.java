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
        Vuelos vuelo02 = new Vuelos("2023-02", "Valencia", "Tenerife", "20-08", Vuelos.Tipo.TURISTA);
        Vuelos vuelo03 = new Vuelos("2023-03", "París", "Valencia", "15-08", Vuelos.Tipo.PRIMERA);
        Vuelos vuelo04 = new Vuelos("2023-04", "Atenas", "Valencia", "20-08", Vuelos.Tipo.PRIMERA);

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
                scan.nextLine();
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

                                boolean encontrado = false;
                                if (vueloslist.size() != 0) {
                                    for (Vuelos x : vueloslist) {
                                        if (x.getNumero().equals(numero)) {
                                            System.out.println("Datos del vuelo");
                                            System.out.println("Número: " + x.getNumero() + " Origen: " + x.getOrigen() + " Destino: " + x.getDestino() + " Día: " + x.getDia() + " Clase: " + x.getTipo());
                                            encontrado = true;
                                        }
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("El número de vuelo no se ha encontrado");
                                }

                                continuar = true;
                            } catch (Exception e) {
                                System.out.println("ERROR, repite");
                                continuar = false;
                            }
                        } while (!continuar);
                    }

                    case 3 -> {
                        boolean continuar = false;
                        do {

                            try {

                                System.out.println("Dime la clave por la que quieres buscar un vuelo: ");
                                System.out.println("Claves disponibles: numero, origen, destino, dia, clase");
                                String clave = scan.nextLine();

                                switch (clave) {
                                    case "numero" -> {
                                        System.out.println("Ahora escribe el número de vuelo: ");
                                        String opcion2 = scan.nextLine();

                                        boolean encontrado = false;
                                        if (vueloslist.size() != 0) {
                                            for (Vuelos x : vueloslist) {
                                                if (x.getNumero().equals(opcion2)) {
                                                    encontrado = true;
                                                    System.out.println("Datos del vuelo");
                                                    System.out.println("Número: " + x.getNumero() + " Origen: " + x.getOrigen() + " Destino: " + x.getDestino() + " Día: " + x.getDia() + " Clase: " + x.getTipo());
                                                }
                                            }
                                        }
                                        if (!encontrado) {
                                            System.out.println("El vuelo no se ha encontrado");
                                        }

                                    }

                                    case "origen" -> {
                                        System.out.println("Ahora escribe el origen del vuelo: ");
                                        String opcion2 = scan.nextLine();

                                        boolean encontrado = false;
                                        if (vueloslist.size() != 0) {
                                            for (Vuelos x : vueloslist) {
                                                if (x.getOrigen().equals(opcion2)) {
                                                    encontrado = true;
                                                    System.out.println("Datos del vuelo");
                                                    System.out.println("Número: " + x.getNumero() + " Origen: " + x.getOrigen() + " Destino: " + x.getDestino() + " Día: " + x.getDia() + " Clase: " + x.getTipo());
                                                }
                                            }
                                        }
                                        if (!encontrado) {
                                            System.out.println("El vuelo no se ha encontrado");
                                        }

                                    }

                                    case "destino" -> {
                                        System.out.println("Ahora escribe el destino del vuelo: ");
                                        String opcion2 = scan.nextLine();

                                        boolean encontrado = false;
                                        if (vueloslist.size() != 0) {
                                            for (Vuelos x : vueloslist) {
                                                if (x.getDestino().equals(opcion2)) {
                                                    encontrado = true;
                                                    System.out.println("Datos del vuelo");
                                                    System.out.println("Número: " + x.getNumero() + " Origen: " + x.getOrigen() + " Destino: " + x.getDestino() + " Día: " + x.getDia() + " Clase: " + x.getTipo());
                                                }
                                            }
                                        }
                                        if (!encontrado) {
                                            System.out.println("El vuelo no se ha encontrado");
                                        }

                                    }

                                    case "dia" -> {
                                        System.out.println("Ahora escribe el dia y mes del vuelo: (xx-x)");
                                        String opcion2 = scan.nextLine();

                                        boolean encontrado = false;
                                        if (vueloslist.size() != 0) {
                                            for (Vuelos x : vueloslist) {
                                                if (x.getDia().equals(opcion2)) {
                                                    encontrado = true;
                                                    System.out.println("Datos del vuelo");
                                                    System.out.println("Número: " + x.getNumero() + " Origen: " + x.getOrigen() + " Destino: " + x.getDestino() + " Día: " + x.getDia() + " Clase: " + x.getTipo());
                                                }
                                            }
                                        }
                                        if (!encontrado) {
                                            System.out.println("El vuelo no se ha encontrado");
                                        }

                                    }
                                    case "clase" -> {
                                        System.out.println("Ahora escribe la clase del vuelo: (TURISTA o PRIMERA)");
                                        String opcion2 = scan.nextLine();

                                        boolean encontrado = false;
                                        if (vueloslist.size() != 0) {
                                            for (Vuelos x : vueloslist) {
                                                if (x.getTipo().equals(opcion2)) {
                                                    encontrado = true;
                                                    System.out.println("Datos del vuelo");
                                                    System.out.println("Número: " + x.getNumero() + " Origen: " + x.getOrigen() + " Destino: " + x.getDestino() + " Día: " + x.getDia() + " Clase: " + x.getTipo());
                                                }
                                            }
                                        }
                                        if (!encontrado) {
                                            System.out.println("El vuelo no se ha encontrado");
                                        }

                                    }
                                }

                                continuar = true;
                            } catch (Exception e) {
                                System.out.println("ERROR, repite");
                            }

                        } while (!continuar);
                    }

                    case 4 -> {
                        boolean continuar = false;
                        do {

                            try {



                            } catch (Exception e) {
                                System.out.println("ERROR, repite");
                            }

                        } while (!continuar);
                    }

                    case 5 -> {
                        boolean continuar = false;
                        do {

                            try {



                            } catch (Exception e) {
                                System.out.println("ERROR, repite");
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
