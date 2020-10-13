import java.util.ArrayList;
import java.util.Scanner;

public class CRUDCentrosLog {
    public static ArrayList<C_logistico> centros_logisticos = CargarDatos.cargarCentrosLogisticos();
    public static Scanner input = new Scanner(System.in);

    public static void verCentrosLog(){
        System.out.println("LISTADO DE CENTROS LOGÍSTICOS: ");
        for(C_logistico centro_log : centros_logisticos){
            System.out.println(centro_log);
        }
    }
    public static void crearCentroLog(){
        System.out.print("Código  del centro logístico:");
        String codigo = input.next();
        for(C_logistico centro_log : centros_logisticos){
            if(centro_log.codigo.equalsIgnoreCase(codigo)){
                System.out.println("Lo sentimos,ya existe un centro logístico con ese código");
                return;
            }
        }
        ArrayList<P_atencion> puntos_atencion = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Paquete> paquetes = new ArrayList<>();
        C_logistico centro_log_nuevo = new C_logistico(codigo,puntos_atencion,empleados,paquetes);
        centros_logisticos.add(centro_log_nuevo);
        System.out.println("¡Centro logistico creada con éxito");
    }
    public static void editarCentroLog(){
        while (true) {
            System.out.print("Código : ");
            String codigo = input.next();
            for (C_logistico centro_log : centros_logisticos) {
                if (centro_log.codigo.equalsIgnoreCase(codigo)) {
                    System.out.println("Código: " + centro_log.codigo);
                    System.out.println("¿Quiere cambiar el código? Ingrese Y o N");
                    String eleccion1 = input.next();
                    if (eleccion1.equalsIgnoreCase("Y")) {
                        System.out.print("Nuevo código:");
                        centro_log.codigo = input.next();
                    }
                    System.out.println("¡CAMBIOS REALIZADOS CON ÉXITO!");
                    return;
                }
            }
            System.out.println("No exixte empresa con ese nombre");
        }
    }
    public static void eliminarCentroLog() {
        while (true) {
            System.out.println("1. Seleccionar por Código");
            System.out.println("0. Atrás");
            String opcion = input.next();

            if (opcion.equals("1")) {
                System.out.print("Código del Centro Logistico : "); // Borrar por nombre de la empresa
                String codigo = input.next();
                for (C_logistico centro_log : centros_logisticos) {
                    if (centro_log.codigo.equalsIgnoreCase(codigo)) {
                        System.out.println("¿Quiere eliminar el centro logístico? Ingrese Y o N");
                        String eleccion1 = input.next();
                        if (eleccion1.equalsIgnoreCase("Y")) {
                            centros_logisticos.remove(centro_log);
                            System.out.println("¡Centro_logistico eliminado!");
                            return;
                        }
                    }
                }
                System.out.println("No exixte centro logísitico con ese nombre");
            }else if(opcion.equals("0")){
                break;
            }
        }
    }
}
