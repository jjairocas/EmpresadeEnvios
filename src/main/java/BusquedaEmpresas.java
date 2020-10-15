import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaEmpresas {

    public static Scanner input = new Scanner(System.in);

    //métodos
    public static void buscar(ArrayList<EmpresaEnvio> empresas) {
        label:
        while (true) {
            System.out.println("SELECCIONE :");
            System.out.println("1.Nombre");
            System.out.println("2.NIT");
            System.out.println("3.Mostrar todas las empresas");
            System.out.println("0.Atras");
            String opcion = input.next();
            switch (opcion) {
                case "1":  // nombre
                    label1:
                    while (true) {
                        String eleccion = Menus.menuAtributoTexto();
                        switch (eleccion) {
                            case "1": { // valor exacto
                                System.out.println("Ingrese el nombre de la empresa:");
                                String nombre_empresa = input.next();
                                for (EmpresaEnvio empresa : empresas) {
                                    if (empresa.nombre.equals(nombre_empresa)) {
                                        System.out.println(empresa);
                                        return;
                                    }
                                }

                                System.out.println("No existe un empresa con este nombre");

                                break;
                            }
                            case "2": { // valor sin considerar mayúsculas
                                System.out.println("Ingrese el nommbre de la empresa:");
                                String nombre_empresa = input.next();
                                for (EmpresaEnvio empresa : empresas) {
                                    if (empresa.nombre.equalsIgnoreCase(nombre_empresa)) {
                                        System.out.println(empresa);
                                        return;
                                    }
                                }
                                System.out.println("No existe un empresa con este nombre");
                                break;
                            }
                            case "0":  // atras
                                break label1;
                        }
                    }
                    break;
                case "2":  // NIT
                    label1:
                    while (true) {
                        String eleccion = Menus.menuAtributoTexto();
                        switch (eleccion) {
                            case "1":  // valor exacto
                                System.out.println("Ingrese el nit de la empresa:");
                                String nitEmpresa = input.next();
                                for (EmpresaEnvio empresa : empresas) {
                                    if (empresa.nit.equals(nitEmpresa)) {
                                        System.out.println(empresa);
                                        return;
                                    }
                                }
                                System.out.println("No se encontró esta empresa con este Nit");

                                break;
                            case "2":  // valor sin considerar mayúsculas
                                System.out.println("Ingrese el nit de la empresa:");
                                String nit_Empresa = input.next();
                                for (EmpresaEnvio empresa1 : empresas) {
                                    if (empresa1.nit.equalsIgnoreCase(nit_Empresa)) {
                                        System.out.println(empresa1);
                                        return;
                                    }
                                    System.out.println("No se encontró esta empresa con este Nit");
                                }
                                break;
                            case "0":  // atras
                                break label1;
                        }
                    }
                    break;
                case "3":  // Mostrar todas las empresas
                    System.out.println("LISTADO DE EMPRESAS: ");
                    for (EmpresaEnvio empresa2 : empresas) {
                        System.out.println(empresa2);
                    }
                    return;
                case "0":
                    break label;
            }
                        }
    }
                }



