import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class CRUDPuntosAtencion {

    public static ArrayList<P_atencion> puntos_atencion = CargarDatos.cargarPuntosAtencion();
    public static Scanner input = new Scanner(System.in);

    public static void verPuntosAtencion(){
        System.out.println("LISTADO DE PUNTOS DE ATENCIÓN: ");
        for(P_atencion punto : puntos_atencion){
            System.out.println(punto);
        }
    }
    public static void crearPuntoAtencion(){
        System.out.print("Código  del punto de atención:");
        String codigo = input.next();
        for(P_atencion punto : puntos_atencion){
            if(punto.codigo.equalsIgnoreCase(codigo)){
                System.out.println("Lo sentimos,ya existe un punto de atencion  con ese código");
                return;
            }
        }
        System.out.print("Dirección : ");
        String direccion = input.next();
        for (P_atencion punto : puntos_atencion){
            if(punto.direccion.equalsIgnoreCase(direccion)){
                System.out.println("Lo sentimos, ya existe un punto de atención con esa dirección");
                return;
            }
        }
        Deque<Paquete> paquetes_por_enviar = new LinkedList<>();
        ArrayList<Paquete> paquetes_por_entregar = new ArrayList<>();
        Deque<Cliente> cola_clientes = new LinkedList<>();
        P_atencion punto_nuevo = new P_atencion(codigo,direccion,paquetes_por_enviar,paquetes_por_entregar,cola_clientes);
        puntos_atencion.add(punto_nuevo);
        System.out.println("¡Punto de Atencion creado con éxito");
    }
    public static void editarPuntoAtencion(){
        label:
        while (true){
            System.out.println("1. Seleccionar por Código");
            System.out.println("2. Seleccionar por Dirección");
            System.out.println("0. Atrás");
            String opcion = input.next();

            switch (opcion) {
                case "1":
                   editarPorCodigo();
                    break;
                case "2":
                    editarPorDireccion();
                    break;
                case "0":
                    break label;
            }
        }
    }
    public static void eliminarPuntoAtencion(){
        label:
        while (true){
            System.out.println("1. Eliminar por Código");
            System.out.println("2. Eliminar por Dirección");
            System.out.println("0. Atrás");
            String opcion = input.next();

            switch (opcion) {
                case "1":
                    eliminarPorCodigo();
                    break;
                case "2":
                    eliminarPorDireccion();
                    break;
                case "0":
                    break label;
            }
        }
    }
    //Métodos auxiliares
    public static void editarPorCodigo(){
        System.out.print("Código del punto de atención : "); // Editar por  código del P_A
        String codigo = input.next();
        for (P_atencion punto : puntos_atencion) {
            if (punto.codigo.equalsIgnoreCase(codigo)) {
                cambiarDatos(punto);
                return;
            }
        }
        System.out.println("No exixte punto de atencion con ese código");
    }
    public static void editarPorDireccion(){
        System.out.print("Dirección del punto de atención : "); // Editar por dirección del P_A
        String direccion = input.next();
        for (P_atencion punto : puntos_atencion) {
            if (punto.direccion.equalsIgnoreCase(direccion)) {
                cambiarDatos(punto);
                return;
            }
        }
        System.out.println("No existen puntos de atención con esa dirección");
    }

    public static void cambiarDatos(P_atencion punto){
        System.out.println("Código : " + punto.codigo);
        System.out.println("¿Quiere cambiar el código? Ingrese Y o N");
        String eleccion1 = input.next();
        if (eleccion1.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo Código:");
            punto.codigo = input.next();
        }
        System.out.println("Dirección: " + punto.direccion);
        System.out.println("¿Quiere cambiar la dirección? Ingrese Y o N");
        String eleccion2 = input.next();
        if (eleccion2.equalsIgnoreCase("Y")) {
            System.out.print("Nueva dirección:");
            punto.direccion = input.next();
        }
        System.out.println("¡CAMBIOS REALIZADOS CON ÉXITO!");
    }
    public static void eliminarPorCodigo(){
        System.out.print("Código del punto de atención: "); // Borrar por código del punto de atencion
        String codigo = input.next();
        for (P_atencion punto : puntos_atencion) {
            if (punto.codigo.equalsIgnoreCase(codigo)) {
                confirmarEliminacion(punto);
                return;
            }
        }
        System.out.println("No exixte punto de atención con ese código ");
    }

    public static void eliminarPorDireccion(){
        System.out.print("Dirección  del punto de atención : ");
        String direccion = input.next();
        for (P_atencion punto : puntos_atencion) {
            if (punto.direccion.equalsIgnoreCase(direccion)) {
                confirmarEliminacion(punto);
                return;
            }
        }
        System.out.println("No hay puntos de atención con esa dirección");
    }
    public static void confirmarEliminacion(P_atencion punto){
        System.out.println("¿Quiere eliminar el punto de atención? Ingrese Y o N");
        String eleccion1 = input.next();
        if (eleccion1.equalsIgnoreCase("Y")) {
            puntos_atencion.remove(punto);
            System.out.println("¡Punto de atención eliminado!");
        }
    }
}
