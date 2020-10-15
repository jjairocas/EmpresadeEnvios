import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrdenCentroLogistico {
    public static Scanner input = new Scanner(System.in);

    public static void ordenarAlfabeticamente(ArrayList<C_logistico> CentroLogistico) {
        label:
        while (true) {
            System.out.println("1. De A-Z");
            System.out.println("2. De Z-A");
            System.out.println("0. Atrás");
            String eleccion = input.next();
            ArrayList<String> codigos = new ArrayList<>();
            for (C_logistico c_logistico : CentroLogistico) {
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
    /*public static void ordenarPorPuntosdeAtencion(ArrayList<P_atencion> PuntosdeAtencion){
        ArrayList<EmpresaEnvio> copia_empresas = (ArrayList<EmpresaEnvio>) empresas.clone();
        while (true){
            System.out.println("1. De menor a mayor");
            System.out.println("2. De mayor a menor");
            System.out.println("0. Atrás");
            String opcion = input.next();
            switch (opcion){
                case "1": // de menor a mayor
                    Collections.sort(copia_empresas,new EmpresaComparator("sedes"));
                    for(EmpresaEnvio empresa : copia_empresas){
                        System.out.println(empresa);
                    }
                    break;
                case "2": // de mayor a menor
                    Collections.sort(copia_empresas,new EmpresaComparator("sedes").reversed());
                    for(EmpresaEnvio empresa : copia_empresas){
                        System.out.println(empresa);
                    }
                    break;
                case "0":
                    break;
            }
        }
    }*/
}

