import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class OrdenEmpleado {
    public static Scanner input = new Scanner(System.in);

    public static void ordenarAlfabeticamente(ArrayList<Empleado> Empleados){
        label:
        while (true) {
            System.out.println("1. De A-Z");
            System.out.println("2. De Z-A");
            System.out.println("0. Atrás");
            String eleccion = input.next();
            ArrayList<String> nombres = new ArrayList<>();
            for (Empleado empleado : Empleados) {
                nombres.add(empleado.nombre);
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
}