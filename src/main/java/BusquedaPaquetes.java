
import java.util.ArrayList;
        import java.util.Scanner;

public class BusquedaPaquetes {
    public static Scanner input= new Scanner(System.in);

    public static void buscar(ArrayList<Paquete> paquetes){
        while(true){
            System.out.println("SELECCIONE: ");
            System.out.println("1. codigo");
            System.out.println("2. Mostrar todos los paquetes");
            System.out.println("0. Atras");
            String opcion = input.next();

            if (opcion.equals("1")){
                while(true){
                    String eleccion = Menus.menuAtributoTexto();
                    if(eleccion.equals("1")){
                        System.out.println("Ingrese el codigo del paquete");
                        String codigoPaquete = input.next();
                        for (Paquete paquete: paquetes){
                            if(paquete.codigo_paquete.equals(codigoPaquete)){
                                System.out.println(paquete);
                                return;
                            }
                        }
                        System.out.println("No existe un paquete con este codigo");
                    }
                    else if (eleccion.equals("2")){
                        System.out.println("Ingrese el codigo del paquete");
                        String codigoPaquete = input.next();
                        for (Paquete paquete: paquetes){
                            if(paquete.codigo_paquete.equalsIgnoreCase(codigoPaquete)){
                                System.out.println(paquete);
                                return;
                            }
                        }
                        System.out.println("No existe un paquete con este codigo");
                    }
                }
            }
            else if (opcion.equals("2")){
                System.out.println("LISTADO DE PAQUETES: ");
                for(Paquete paquete : paquetes){
                    System.out.println(paquete);
                }
            }

            else if (opcion.equals("0")){
                return;
            }

        }
    }

}