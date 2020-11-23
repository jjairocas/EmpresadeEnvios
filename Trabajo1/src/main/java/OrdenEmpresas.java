import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrdenEmpresas {
    public static Scanner input = new Scanner(System.in);

    public static void ordenarAlfabeticamente(ArrayList<EmpresaEnvio> empresas){
       // ArrayList<EmpresaEnvio> copia_empresas = (ArrayList<EmpresaEnvio>) empresas.clone();
        label:
        while (true){
            System.out.println("1. De A-Z");
            System.out.println("2. De Z-A");
            System.out.println("0. Atrás");
            String eleccion = input.next();
            ArrayList<String> nombres = new ArrayList<>();
            for(EmpresaEnvio empresa : empresas){
                nombres.add(empresa.nombre);
            }
            switch (eleccion) {
                case "1":  //ordenar de A-Z
                    Collections.sort(nombres);
                    for (String nombre : nombres) {
                        for(EmpresaEnvio empresa: empresas){
                            if(empresa.nombre.equalsIgnoreCase(nombre)){
                                System.out.println(empresa);
                            }
                        }
                    }
                    break;
                case "2":  //ordenar de Z-A
                    Collections.sort(nombres, Collections.<String>reverseOrder());
                    for (String nombre : nombres) {
                        for(EmpresaEnvio empresa: empresas){
                            if(empresa.nombre.equalsIgnoreCase(nombre)){
                                System.out.println(empresa);
                            }
                        }
                    }
                    break;
                case "0":
                    break label;
            }
        }

    }

    public static void ordenarPorSedes(ArrayList<EmpresaEnvio> empresas){
        ArrayList<EmpresaEnvio> copia_empresas = (ArrayList<EmpresaEnvio>) empresas.clone();
        label:
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
                    break label;
            }
        }
    }

    public static void ordenarPorCentrosLog(ArrayList<EmpresaEnvio> empresas){
        ArrayList<EmpresaEnvio> copia_empresas = (ArrayList<EmpresaEnvio>) empresas.clone();
        label:
        while (true){
            System.out.println("1. De menor a mayor");
            System.out.println("2. De mayor a menor");
            System.out.println("0. Atrás");
            String opcion = input.next();
            switch (opcion){
                case "1": // de menor a mayor
                    Collections.sort(copia_empresas,new EmpresaComparator("centros logisticos"));
                    for(EmpresaEnvio empresa : copia_empresas){
                        System.out.println(empresa);
                    }
                    break;
                case "2": // de mayor a menor
                    Collections.sort(copia_empresas,new EmpresaComparator("centros logisticos").reversed());
                    for(EmpresaEnvio empresa : copia_empresas){
                        System.out.println(empresa);
                    }
                    break;
                case "0":
                    break label;
            }
        }
    }

}
