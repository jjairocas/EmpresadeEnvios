import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaEmpresas {

    public static Scanner input = new Scanner(System.in);

    //métodos
    public static void buscar(ArrayList<EmpresaEnvio> empresas) {
        while (true) {
            System.out.println("SELECCIONE :");
            System.out.println("1.Nombre");
            System.out.println("2.NIT");
            System.out.println("3.Mostrar todas las empresas");
            System.out.println("0.Atras");
            String opcion = input.next();
            if (opcion.equals("1")) { // nombre
                while (true) {
                    String eleccion = Menus.menuAtributoTexto();
                    if (eleccion.equals("1")) { // valor exacto
                        System.out.println("Ingrese el nombre de la empresa:");
                        String nombre_empresa = input.next();
                        for (EmpresaEnvio empresa : empresas) {
                            if (empresa.nombre.equals(nombre_empresa)) {
                                System.out.println(empresa);
                                return;
                            }
                        }

                        System.out.println("No existe un empresa con este nombre");

                    } else if (eleccion.equals("2")) { // valor sin considerar mayúsculas
                        System.out.println("Ingrese el nommbre de la empresa:");
                        String nombre_empresa = input.next();
                        for (EmpresaEnvio empresa : empresas) {
                            if (empresa.nombre.equalsIgnoreCase(nombre_empresa)) {
                                System.out.println(empresa);
                                return;
                            }
                        }
                        System.out.println("No existe un empresa con este nombre");
                    } else if (eleccion.equals("0")) { // atras
                        break;
                    }
                }
            } else if (opcion.equals("2")) { // NIT
                while (true) {
                    String eleccion = Menus.menuAtributoTexto();
                    if (eleccion.equals("1")) { // valor exacto
                        System.out.println("Ingrese el nit de la empresa:");
                        String nitEmpresa = input.next();
                        for (EmpresaEnvio empresa : empresas) {
                            if (empresa.nit.equals(nitEmpresa)) {
                                System.out.println(empresa);
                                return;
                            }
                        }
                        System.out.println("No se encontró esta empresa con este Nit");
                        /*for(EmpresaEnvio empresa: empresas){
                            System.out.println("- "+empresa.nit);
                        }*/
                            } else if (eleccion.equals("2")) { // valor sin considerar mayúsculas
                                System.out.println("Ingrese el nit de la empresa:");
                                String nit_Empresa = input.next();
                                for (EmpresaEnvio empresa1 : empresas) {
                                    if (empresa1.nit.equalsIgnoreCase(nit_Empresa)) {
                                        System.out.println(empresa1);
                                        return;
                                    }
                                    System.out.println("No se encontró esta empresa con este Nit");
                            /*for(EmpresaEnvio empresa: empresas){
                            String nit = empresa.nit;
                            nit = nit.toLowerCase();
                            System.out.println("- "+ nit);
                        }*/

                                    }
                                    } else if (eleccion.equals("0")) { // atras
                                        break;
                                    }
                                }
                            } else if (opcion.equals("3")) { // Mostrar todas las empresas
                                System.out.println("LISTADO DE EMPRESAS: ");
                                for (EmpresaEnvio empresa2 : empresas) {
                                    System.out.println(empresa2);
                                }
                                return;
                            } else if (opcion.equals("0")) {
                                break;
                            }
                        }
                    }
                }



