import java.util.ArrayList;
import java.util.Scanner;

public class CRUDEmpleados {
    public static ArrayList<Empleado> empleados = CargarDatos.cargarEmpleados();
    public static Scanner input = new Scanner(System.in);

    public static void verEmpleados(){
        System.out.println("LISTADO DE EMPLEADOS: ");
        for(Empleado empleado : empleados){
            System.out.println(empleado);
        }
    }
    public static void crearEmpleado(){
        System.out.print("Nombre: ");
        String nombre = input.next();
        System.out.print("Apellido: ");
        String apellido = input.next();
        System.out.print("Cedula:");
        String cedula = input.next();
        for(Empleado empleado : empleados){
            if(empleado.cedula.equalsIgnoreCase(cedula)){
                System.out.println("Lo sentimos,ya existe un empleado con esa cédula");
                return;
            }
        }
        System.out.print("Correo: ");
        String correo = input.next();
        for (Empleado empleado : empleados){
            if(empleado.correo.equalsIgnoreCase(correo)){
                System.out.println("Lo sentimos, ya existe un empleado con ese correo");
                return;
            }
        }
        System.out.print("Password: ");
        String password = input.next();
        for (Empleado empleado : empleados){
            if(empleado.password.equals(password)){
                System.out.println("Lo sentimos, esa contraseña ya existe");
                return;
            }
        }
        Empleado empleado_nuevo = new Empleado(cedula,nombre,apellido,correo,password);
        empleados.add(empleado_nuevo);
        System.out.println("¡Empleado registrado con éxito");
    }
    public static void editarEmpleado(){
        label:
        while (true){
            System.out.println("1. Seleccionar por Cédula");
            System.out.println("2. Seleccionar por Correo");
            System.out.println("0. Atrás");
            String opcion = input.next();

            switch (opcion) {
                case "1":
                    editarPorCedula();
                    break;
                case "2":
                    editarPorCorreo();
                    break;
                case "0":
                    break label;
            }
        }
    }
    public static void eliminarEmpleado(){
        label:
        while (true){
            System.out.println("1. Eliminar por Cédula");
            System.out.println("2. Eliminar por Correo");
            System.out.println("0. Atrás");
            String opcion = input.next();

            switch (opcion) {
                case "1":
                    eliminarPorCedula();
                    break;
                case "2":
                    eliminarPorCorreo();
                    break;
                case "0":
                    break label;
            }
        }
    }
    public static void editarPorCedula() {
        System.out.print("Cédula : "); // Editar por  cedula
        String cedula = input.next();
        for (Empleado empleado : empleados) {
            if (empleado.cedula.equals(cedula)) {
                cambiarDatos(empleado);
                return;
            }
        }
        System.out.println("No existe Empleado con esa cédula");
    }
    public static void editarPorCorreo() {
        System.out.print("Correo : "); // Editar por  correo
        String correo = input.next();
        for (Empleado empleado : empleados) {
            if (empleado.correo.equalsIgnoreCase(correo)) {
                cambiarDatos(empleado);
                return;
            }
        }
        System.out.println("No existe Empleado con ese correo");
    }

    public static void cambiarDatos(Empleado empleado){
        System.out.println("Nombre : " + empleado.nombre);
        System.out.println("¿Quiere cambiar el nombre? Ingrese Y o N");
        String eleccion1 = input.next();
        if (eleccion1.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo nombre:");
            empleado.nombre = input.next();
        }
        System.out.println("Apellido: " + empleado.apellidos);
        System.out.println("¿Quiere cambiar el apellido? Ingrese Y o N");
        String eleccion2 = input.next();
        if (eleccion2.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo apellido:");
            empleado.apellidos = input.next();
        }
        System.out.println("Cédula: " + empleado.apellidos);
        System.out.println("¿Quiere cambiar la cédula? Ingrese Y o N");
        String eleccion3 = input.next();
        if (eleccion3.equalsIgnoreCase("Y")) {
            System.out.print("Nueva cédula:");
            String cedula = input.next();
            for(Empleado empleado1 : empleados){
                if(empleado1.cedula.equalsIgnoreCase(cedula)){
                    System.out.println("Lo sentimos,ya existe un empleado con esa cédula");
                    return;
                }
            }
            empleado.cedula = cedula;
        }
        System.out.println("¡CAMBIOS REALIZADOS CON ÉXITO!");
    }

    public static void eliminarPorCedula(){
        System.out.print("Cedula: "); // Borrar por cédula al empleado
        String cedula = input.next();
        for (Empleado empleado : empleados) {
            if (empleado.cedula.equals(cedula)) {
                confirmarEliminacion(empleado);
                return;
            }
        }
        System.out.println("No exixte empleado con esa cédula ");
    }
    public static void eliminarPorCorreo(){
        System.out.print("Correo: "); // Borrar por correo al empleado
        String correo = input.next();
        for (Empleado empleado : empleados) {
            if (empleado.correo.equalsIgnoreCase(correo)) {
                confirmarEliminacion(empleado);
                return;
            }
        }
        System.out.println("No exixte empleado con ese correo ");
    }

    public static void confirmarEliminacion(Empleado empleado){
        System.out.println("¿Quiere eliminar el empleado? Ingrese Y o N");
        String eleccion1 = input.next();
        if (eleccion1.equalsIgnoreCase("Y")) {
            empleados.remove(empleado);
            System.out.println("¡Empleado eliminado!");
        }
    }
}

