import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaSedes {
    public static Scanner input = new Scanner(System.in);

    public static void buscar(ArrayList<Sede> sedes){
        while (true){

            System.out.println("SELECCIONE :");
            System.out.println("1.Nombre");
            System.out.println("2.Codigo");
            System.out.println("3.Mostrar todas las sedes");
            System.out.println("0.Atras");
            String opcion = input.next();
            if(opcion.equals("1")) { // nombre
                while (true) {
                    String eleccion = Menus.menuAtributoTexto();
                    if (eleccion.equals("1")) { // valor exacto
                        System.out.println("Ingrese el nombre de la Sede:");
                        String nombre_sede = input.next();
                        for (Sede sede : sedes) {
                            if (sede.nombre.equals(nombre_sede)) {
                                System.out.println(sede);
                                return;
                            }
                        }
                        System.out.println("No existe un sede con este nombre");
                    } else if (eleccion.equals("2")) { // valor sin considerar mayúsculas
                        System.out.println("Ingrese el nombre del sede:");
                        String nombre_sede = input.next();
                        for (Sede sede : sedes) {
                            if (sede.nombre.equalsIgnoreCase(nombre_sede)) {
                                System.out.println(sede);
                                return;
                            }
                        }
                        System.out.println("No existe una sede con este nombre");
                    } else if (eleccion.equals("0")) { // atras
                        break;
                    }
                }
            }

            else if(opcion.equals("2")){ // CODIGO
                    while (true){
                        String eleccion = Menus.menuAtributoTexto();
                        if(eleccion.equals("1")){ // valor exacto
                            System.out.println("Ingrese el codigo de la Sede:");
                            String nombre_codigo = input.next();
                            for(Sede sede : sedes){
                                if (sede.codigo.equals(nombre_codigo)) {
                                    System.out.println(sede);
                                    return;
                                }
                            }
                            System.out.println("No existe un empresa con este codigo");
                        }else if(eleccion.equals("2")){ // valor sin considerar mayúsculas
                            System.out.println("Ingrese el codigo de la Sede:");
                            String nombre_codigo1= input.next();
                            for(Sede sede : sedes){
                                if (sede.codigo.equalsIgnoreCase(nombre_codigo1)) {
                                    System.out.println(sede);
                                    return;
                                }
                            }
                            System.out.println("No existe un empresa con este codigo");

                        }else if(eleccion.equals("0")){ // atras
                            break;
                        }
                    }


            }else if(opcion.equals("3")){ // Mostrar todas las sedes
                System.out.println("LISTADO DE SEDES: ");
                for(Sede sede: sedes){
                    System.out.println(sede);
                }
                return;
            }else if(opcion.equals("0")){
                break;
            }
        }
    }


}
