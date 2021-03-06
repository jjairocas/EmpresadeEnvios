import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class OrdenSedes {
    public static Scanner input=new Scanner(System.in);

    public static void ordenarAlfabeticamente(ArrayList<Sede> sedes){
        ArrayList<Sede> copia_sedes = (ArrayList<Sede>) sedes.clone();
        label:
        while (true){
            System.out.println("1. De A-Z");
            System.out.println("2. De Z-A");
            System.out.println("0. Atrás");
            String eleccion = input.next();
            ArrayList<String> nombres = new ArrayList<>();
            for(Sede sede : copia_sedes){
                nombres.add(sede.nombre);
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

    public static void ordenarPorCentrosLog(ArrayList<Sede> sedes){
        ArrayList<Sede> copia_sedes = (ArrayList<Sede>) sedes.clone();
        label:
        while (true){
            System.out.println("1. De menor a mayor");
            System.out.println("2. De mayor a menor");
            System.out.println("0. Atrás");
            String opcion = input.next();
            switch (opcion){
                case "1": // de menor a mayor
                    Collections.sort(copia_sedes,new SedesComparator());
                    for(Sede sede : copia_sedes){
                        System.out.println(sede);
                    }
                    break;
                case "2": // de mayor a menor
                    Collections.sort(copia_sedes,new SedesComparator().reversed());
                    for(Sede sede: copia_sedes){
                        System.out.println(sede);
                    }
                    break;
                case "0":
                    break label;
            }
        }
    }

}
