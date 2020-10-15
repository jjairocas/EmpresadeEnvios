import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaCentrosLogisticos {
    public static Scanner input = new Scanner(System.in);

    public static void buscar(ArrayList<C_logistico> CentroLogisticos){
        while (true){

            System.out.println("SELECCIONE :");
            System.out.println("1.Codigo");
            System.out.println("2.Mostrar todos los centros logisticos");
            System.out.println("0.Atras");
            String opcion = input.next();
            if(opcion.equals("1")) { // codigo
                while (true) {
                    String eleccion = Menus.menuAtributoTexto();
                    if (eleccion.equals("1")) { // valor exacto
                        System.out.println("Ingrese el codigo del centro logistico:");
                        String codigo_centroLogistico = input.next();
                        for (C_logistico Clog : CentroLogisticos) {
                            if (Clog.codigo.equals(codigo_centroLogistico)) {
                                System.out.println(Clog);
                                return;
                            }
                        }
                        System.out.println("No existe un centro logistico con ese codigo");
                    } else if (eleccion.equals("2")) { // valor sin considerar mayúsculas
                        System.out.println("Ingrese el nombre del sede:");
                        String codigo_centroLogistico1 = input.next();
                        for (C_logistico Clog : CentroLogisticos) {
                            if (Clog.codigo.equalsIgnoreCase(codigo_centroLogistico1)) {
                                System.out.println(Clog);
                                return;
                            }
                        }
                        System.out.println("No existe un centro  logistico con ese codigo");
                    } else if (eleccion.equals("0")) { // atras
                        break;
                    }
                }
            }

            else if(opcion.equals("2")){ // Mostrar todas centros logisticos
                System.out.println("LISTADO CENTROS LOGISTICOS");
                for(C_logistico Clog : CentroLogisticos){
                    System.out.println(Clog);
                }
                return;
            }else if(opcion.equals("0")){
                break;
            }
        }
    }

}


