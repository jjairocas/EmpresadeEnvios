import java.util.ArrayList;
import java.util.Scanner;

public class CRUDSedes {
    public static ArrayList<Sede> sedes = CargarDatos.cargarSedes();
    public static Scanner input = new Scanner(System.in);

    public static void verSedes(){
        System.out.println("LISTADO DE SEDES: ");
        for(Sede sede :sedes){
            System.out.println(sede);
        }
    }
    public static void crearSede(){
        System.out.print("Nombre  de la sede:");
        String nombre = input.next();
        for(Sede sede : sedes){
            if(sede.nombre.equalsIgnoreCase(nombre)){
                System.out.println("Lo sentimos,ya existe una sede con ese nombre");
                return;
            }
        }
        System.out.print("Código : ");
        String codigo = input.next();
        for (Sede sede : sedes){
            if(sede.codigo.equalsIgnoreCase(codigo)){
                System.out.println("Lo sentimos, ya existe una sede con ese codigo");
                return;
            }
        }
        ArrayList<C_logistico> centros_log = new ArrayList<>();
        Sede sede_nueva = new Sede(nombre,codigo,centros_log);
        sedes.add(sede_nueva);
        System.out.println("¡Empresa creada con éxito");
    }

    public static void editarSede(){
        label:
        while (true){
            System.out.println("1. Seleccionar por Nombre");
            System.out.println("2. Seleccionar por Código");
            System.out.println("0. Atrás");
            String opcion = input.next();

            switch (opcion) {
                case "1":
                    editarPorNombre();
                    break;
                case "2":  // editar por código
                    editarPorCodigo();
                    break;
                case "0":
                    break label;
            }
        }
    }

    public static void eliminarSede(){
        label:
        while (true){
            System.out.println("1. Eliminar por Nombre");
            System.out.println("2. Eliminar por NIT");
            System.out.println("0. Atrás");
            String opcion = input.next();
            switch (opcion) {
                case "1":
                    eliminarPorNombre();
                    break;
                case "2":  // Borrar por código
                    eliminarPorCodigo();
                    break;
                case "0":
                    break label;
            }
        }
    }
    //Métodos auxiliares
    public static void cambiarDatos(Sede sede){
        System.out.println("Nombre: "+sede.nombre);
        System.out.println("¿Quiere cambiar el nombre? Ingrese Y o N");
        String eleccion1 = input.next();
        if(eleccion1.equalsIgnoreCase("Y")){
            System.out.print("Nuevo nombre:");
            sede.nombre = input.next();
        }
        System.out.println("Código: "+sede.codigo);
        System.out.println("¿Quiere cambiar el Código? Ingrese Y o N");
        String eleccion2 = input.next();
        if(eleccion2.equalsIgnoreCase("Y")){
            System.out.print("Nuevo Código: ");
            sede.codigo = input.next();
        }
        System.out.println("¡CAMBIOS REALIZADOS CON ÉXITO!");
    }
    public static void editarPorNombre(){
        System.out.print("Nombre de la Sede : "); // Editar por nombre de la sede
        String nombre = input.next();
        for (Sede sede : sedes) {
            if (sede.nombre.equalsIgnoreCase(nombre)) {
                cambiarDatos(sede);
                return;
            }
        }
        System.out.println("No exixte sede con ese nombre");
    }

    public static void editarPorCodigo(){
        System.out.print("Código de la Sede : ");
        String codigo = input.next();
        for (Sede sede : sedes) {
            if (sede.codigo.equalsIgnoreCase(codigo)) {
                cambiarDatos(sede);
                return;
            }
        }
        System.out.println("No hay sedes registradas con ese CÓDIGO");
    }

    public static void eliminarPorNombre(){
        System.out.print("Nombre de la Sede : "); // Borrar por nombre de la empresa
        String nombre = input.next();
        for (Sede sede : sedes) {
            if (sede.nombre.equalsIgnoreCase(nombre)) {
                System.out.println("¿Quiere eliminar la sede? Ingrese Y o N");
                String eleccion1 = input.next();
                if (eleccion1.equalsIgnoreCase("Y")) {
                    sedes.remove(sede);
                    System.out.println("¡Sede eliminada!");
                    return;
                }
            }
        }
        System.out.println("No exixte sede con ese nombre");
    }
    public static void eliminarPorCodigo(){
        System.out.print("Código de la Sede : "); // Borrar por nit de la empresa
        String codigo = input.next();
        for (Sede sede : sedes) {
            if (sede.codigo.equalsIgnoreCase(codigo)) {
                System.out.println("¿Quiere eliminar la sede? Ingrese Y o N");
                String eleccion1 = input.next();
                if (eleccion1.equalsIgnoreCase("Y")) {
                    sedes.remove(sede);
                    System.out.println("¡Sede eliminada!");
                    return;
                }
            }
        }
        System.out.println("No hay sedes registradas con ese código");
    }
}
