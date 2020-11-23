import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class OrdenPuntosdeAtencion {
    public static Scanner input = new Scanner(System.in);

    public static void ordenarAlfabeticamente(ArrayList<P_atencion> PuntoAtencion) {
        label:
        while (true) {
            System.out.println("1. De A-Z");
            System.out.println("2. De Z-A");
            System.out.println("0. Atrás");
            String eleccion = input.next();
            ArrayList<String> nombres = new ArrayList<>();
            for (P_atencion patencion : PuntoAtencion) {
                nombres.add(patencion.codigo);
            }
            switch (eleccion) {
                case "1":  //ordenar de A-Z
                    Collections.sort(nombres);
                    for (String nombre : nombres) {
                        System.out.println("-" + nombre);
                    }
                    break;
                case "2":  //ordenar de Z-A
                    Collections.sort(nombres, Collections.<String>reverseOrder());
                    for (String nombre : nombres) {
                        System.out.println("-" + nombre);
                    }
                    break;
                case "0":
                    break label;
            }
        }
    }

    public static void ordenarPorPaquetes(ArrayList<P_atencion> puntosAtencion){
        ArrayList<P_atencion> copia_Patencion = (ArrayList<P_atencion>) puntosAtencion.clone();
        label:
        while (true){
            System.out.println("1. De menor a mayor");
            System.out.println("2. De mayor a menor");
            System.out.println("0. Atrás");
            String opcion = input.next();
            switch (opcion){
                case "1": // de menor a mayor
                    Collections.sort(copia_Patencion,new PuntoAtencionComparator("Cantidad de paquetes por enviar"));
                    for(P_atencion pat: copia_Patencion){
                        System.out.println(pat);
                    }
                    break;
                case "2": // de mayor a menor
                    Collections.sort(copia_Patencion,new PuntoAtencionComparator("Cantidad de paquetes por enviar").reversed());
                    for(P_atencion pat: copia_Patencion){
                        System.out.println(pat);
                    }
                    break;
                case "0":
                    break label;
            }
        }
    }

    public static void ordenarPorClientes(ArrayList<P_atencion> puntosAtencion){
        ArrayList<P_atencion> copia_Patencion = (ArrayList<P_atencion>) puntosAtencion.clone();
        label:
        while (true){
            System.out.println("1. De menor a mayor");
            System.out.println("2. De mayor a menor");
            System.out.println("0. Atrás");
            String opcion = input.next();
            switch (opcion){
                case "1": // de menor a mayor
                    Collections.sort(copia_Patencion,new PuntoAtencionComparator("Cantidad de clientes"));
                    for(P_atencion pat: copia_Patencion){
                        System.out.println(pat);
                    }
                    break;
                case "2": // de mayor a menor
                    Collections.sort(copia_Patencion,new PuntoAtencionComparator("Cantidad de clientes").reversed());
                    for(P_atencion pat: copia_Patencion){
                        System.out.println(pat);
                    }
                    break;
                case "0":
                    break label;
            }
        }
    }


}