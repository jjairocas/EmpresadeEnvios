import java.util.ArrayList;
import java.util.Scanner;

public class CRUDEmpresas {

    public static ArrayList<EmpresaEnvio> empresas = CargarDatos.cargarEmpresas();
    public static Scanner input = new Scanner(System.in);

    public static void verEmpresas(){
        System.out.println("LISTADO DE EMPRESAS: ");
        for(EmpresaEnvio empresa : empresas){
            System.out.println(empresa);
        }
    }

    public static void crearEmpresa(){
        System.out.print("Nombre  de la empresa:");
        String nombre = input.next();
        for(EmpresaEnvio empresa : empresas){
            if(empresa.nombre.equalsIgnoreCase(nombre)){
                System.out.println("Lo sentimos,ya existe una empresa con ese nombre");
                return;
            }
        }
        System.out.print("Nit: ");
        String nit = input.next();
        for (EmpresaEnvio empresa : empresas){
            if(empresa.nit.equalsIgnoreCase(nit)){
                System.out.println("Lo sentimos, ya existe una empresa con ese nit");
                return;
            }
        }
        ArrayList<Sede> sedes = new ArrayList<>();
        EmpresaEnvio empresa_nueva = new EmpresaEnvio(nombre,nit,sedes);
        empresas.add(empresa_nueva);
        System.out.println("¡Empresa creada con éxito");
    }

    public static void editarEmpresa(){
        label:
        while (true){
            System.out.println("1. Seleccionar por Nombre");
            System.out.println("2. Seleccionar por NIT");
            System.out.println("0. Atrás");
            String opcion = input.next();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre de la Empresa : "); // Editar por nombre de la empresa

                    String nombre = input.next();
                    for (EmpresaEnvio empresa : empresas) {
                        if (empresa.nombre.equalsIgnoreCase(nombre)) {
                            cambiarDatos(empresa);
                            return;
                        }
                    }
                    System.out.println("No exixte empresa con ese nombre");
                    break;
                case "2":  // editar por NIT
                    System.out.print("NIT de la Empresa : "); // Editar por nombre de la empresa

                    String nit = input.next();
                    for (EmpresaEnvio empresa : empresas) {
                        if (empresa.nit.equalsIgnoreCase(nit)) {
                            cambiarDatos(empresa);
                            return;
                        }
                    }
                    System.out.println("No hay empresas registradas con ese NIT");
                    break;
                case "0":
                    break label;
            }
        }

    }

    public static void eliminarEmpresa(){
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
                case "2":  // Borrar por NIT
                    eliminarPorNit();
                    break;
                case "0":
                    break label;
            }
        }
    }



    public static void cambiarDatos(EmpresaEnvio empresa){
        System.out.println("Nombre: " + empresa.nombre);
        System.out.println("¿Quiere cambiar el nomrbre? Ingrese Y o N");
        String eleccion1 = input.next();
        if (eleccion1.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo nombre:");
            empresa.nombre = input.next();
        }
        System.out.println("NIT: " + empresa.nit);
        System.out.println("¿Quiere cambiar el NIT? Ingrese Y o N");
        String eleccion2 = input.next();
        if (eleccion2.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo NIT:");
            empresa.nit = input.next();
        }
        System.out.println("¡CAMBIOS REALIZADOS CON ÉXITO!");
    }
    public static void eliminarPorNombre(){
        System.out.print("Nombre de la Empresa : "); // Borrar por nombre de la empresa

        String nombre = input.next();
        for (EmpresaEnvio empresa : empresas) {
            if (empresa.nombre.equalsIgnoreCase(nombre)) {
                confirmarEliminacion(empresa);
                return;
            }
        }
        System.out.println("No exixte empresa con ese nombre");
    }
    public static void eliminarPorNit(){
        System.out.print("NIT de la Empresa : "); // Borrar por nit de la empresa
        String nit = input.next();
        for (EmpresaEnvio empresa : empresas) {
            if (empresa.nit.equalsIgnoreCase(nit)) {
                confirmarEliminacion(empresa);
                return;
            }
        }
        System.out.println("No hay empresas registradas con ese NIT");
    }
    public static void confirmarEliminacion(EmpresaEnvio empresa){
        System.out.println("¿Quiere eliminar la empresa? Ingrese Y o N");
        String eleccion1 = input.next();
        if (eleccion1.equalsIgnoreCase("Y")) {
            empresas.remove(empresa);
            System.out.println("¡Empresa eliminada!");
        }
    }
}
