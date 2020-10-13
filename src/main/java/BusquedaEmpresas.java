import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaEmpresas {

    public static Scanner input = new Scanner(System.in);

    //métodos
    public static void buscar(ArrayList<EmpresaEnvio> empresas){
        while (true){
            System.out.println("SELECCIONE :");
            System.out.println("1.Nombre");
            System.out.println("2.NIT");
            System.out.println("3.Mostrar todas las empresas");
            System.out.println("0.Atras");
            String opcion = input.next();
            if(opcion.equals("1")){ // nombre
                while (true){
                    String eleccion = Menus.menuAtributoTexto();
                    if(eleccion.equals("1")){ // valor exacto
                        for(EmpresaEnvio empresa: empresas){
                            System.out.println("- "+empresa.nombre);
                        }
                        return;
                    }else if(eleccion.equals("2")){ // valor sin considerar mayúsculas
                        for(EmpresaEnvio empresa: empresas){
                            String nombre = empresa.nombre;
                            nombre = nombre.toLowerCase();
                            System.out.println("- "+ nombre);
                        }
                        return;
                    }else if(eleccion.equals("0")){ // atras
                        break;
                    }
                }
            }else if(opcion.equals("2")){ // NIT
                while (true){
                    String eleccion = Menus.menuAtributoTexto();
                    if(eleccion.equals("1")){ // valor exacto
                        for(EmpresaEnvio empresa: empresas){
                            System.out.println("- "+empresa.nit);
                        }
                    }else if(eleccion.equals("2")){ // valor sin considerar mayúsculas
                        for(EmpresaEnvio empresa: empresas){
                            String nit = empresa.nit;
                            nit = nit.toLowerCase();
                            System.out.println("- "+ nit);
                        }
                    }else if(eleccion.equals("0")){ // atras
                        break;
                    }
                }
            }else if(opcion.equals("3")){ // Mostrar todas las empresas
                System.out.println("LISTADO DE EMPRESAS: ");
                for(EmpresaEnvio empresa : empresas){
                    System.out.println(empresa);
                }
                return;
            }else if(opcion.equals("0")){
                break;
            }
        }
    }
}
