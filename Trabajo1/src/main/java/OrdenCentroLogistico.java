import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrdenCentroLogistico {
    public static Scanner input = new Scanner(System.in);

    public static void ordenarAlfabeticamente(ArrayList<C_logistico> centroLogisticos) {
        label:
        while (true) {
            System.out.println("1. De A-Z");
            System.out.println("2. De Z-A");
            System.out.println("0. Atrás");
            String eleccion = input.next();
            ArrayList<String> codigos = new ArrayList<>();
            for (C_logistico c_logistico : centroLogisticos) {
                codigos.add(c_logistico.codigo);
            }
            switch (eleccion) {
                case "1":  //ordenar de A-Z
                    Collections.sort(codigos);
                    for (String codigo :codigos) {
                        System.out.println("-" + codigo);
                    }
                    break;
                case "2":  //ordenar de Z-A
                    Collections.sort(codigos, Collections.<String>reverseOrder());
                    for (String codigo :codigos) {
                        System.out.println("-" + codigo);
                    }
                    break;
                case "0":
                    break label;
            }

        }

    }
    public static void ordenarPorPuntosdeAtencion (ArrayList<C_logistico> centrosLogisticos){
        ArrayList<C_logistico> copia_cLogistico = (ArrayList<C_logistico>) centrosLogisticos.clone();
        label:
        while (true){
            System.out.println("1. De menor a mayor");
            System.out.println("2. De mayor a menor");
            System.out.println("0. Atrás");
            String opcion = input.next();
            switch (opcion){
                case "1": // de menor a mayor
                    Collections.sort(copia_cLogistico,new C_logComparator("Cantidad de puntos de atencion"));
                    for(C_logistico clog: copia_cLogistico){
                        System.out.println(clog);
                    }
                    break;
                case "2": // de mayor a menor
                    Collections.sort(copia_cLogistico,new C_logComparator("Cantidad de puntos de atencion").reversed());
                    for(C_logistico clog: copia_cLogistico){
                        System.out.println(clog);
                    }
                    break;
                case "0":
                    break label;
            }
        }
    }

    public static void ordenarPorEmpleados(ArrayList<C_logistico> centrosLogisticos){
        ArrayList<C_logistico> copia_centroLog = (ArrayList<C_logistico>) centrosLogisticos.clone();
        label:
        while (true){
            System.out.println("1. De menor a mayor");
            System.out.println("2. De mayor a menor");
            System.out.println("0. Atrás");
            String opcion = input.next();
            switch (opcion){
                case "1": // de menor a mayor
                    Collections.sort(copia_centroLog,new C_logComparator("Cantidad de empleados"));
                    for(C_logistico clog : copia_centroLog){
                        System.out.println(clog);
                    }
                    break;
                case "2": // de mayor a menor
                    Collections.sort(copia_centroLog,new C_logComparator("Cantidad de empleados").reversed());
                    for(C_logistico clog : copia_centroLog){
                        System.out.println(clog);
                    }
                    break;
                case "0":
                    break label;
            }
        }
    }


}

