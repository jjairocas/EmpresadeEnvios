import java.util.ArrayList;
import java.util.Scanner;

public class CRUDClientes {

    public static ArrayList<Cliente> clientes = CargarDatos.cargarClientes();
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<C_logistico> centros_logisticos = CRUDCentrosLog.centros_logisticos;
    public static ArrayList<EmpresaEnvio> empresas = CRUDEmpresas.empresas;
    public static ArrayList<Sede> sedes = CRUDSedes.sedes;
    public static ArrayList<P_atencion> puntos_atencion = CRUDPuntosAtencion.puntos_atencion;


    public static void verCliente(){
        System.out.println("LISTADO DE CLIENTES: ");
        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }
    public static void crearCliente(){
        System.out.print("Nombre: ");
        String nombre = input.next();
        System.out.print("Apellido: ");
        String apellido = input.next();
        System.out.print("Cedula:");
        String cedula = input.next();
        for(Cliente cliente : clientes){
            if(cliente.cedula.equalsIgnoreCase(cedula)){
                System.out.println("Lo sentimos,ya existe un cliente con esa cédula");
                return;
            }
        }
        System.out.print("Correo: ");
        String correo = input.next();
        for (Cliente cliente : clientes){
            if(cliente.correo.equalsIgnoreCase(correo)){
                System.out.println("Lo sentimos, ya existe un cliente con ese correo");
                return;
            }
        }
        System.out.print("Password: ");
        String password = input.next();
        for (Cliente cliente : clientes){
            if(cliente.password.equals(password)){
                System.out.println("Lo sentimos, esa contraseña ya existe");
                return;
            }
        }
        ArrayList<Paquete> paquetes = new ArrayList<>();
        Cliente cliente_nuevo = new Cliente(cedula,nombre,apellido,correo,password,paquetes);
        clientes.add(cliente_nuevo);


        System.out.println("LISTADO DE PUNTOS DE ATENCIÓN: ");
        for(P_atencion punto : puntos_atencion){
            System.out.println(punto);
        }
        System.out.println("Escriba el punto de atencion al que accede el cliente");
        String codigoPuntoAtencion = input.next();

        for(P_atencion punto : puntos_atencion){
            if(punto.codigo.equalsIgnoreCase(codigoPuntoAtencion)){
                punto.clientes.add(cliente_nuevo);
                System.out.println("Se agrego el cliente con exito");
                return;
            }
        }


        for(C_logistico Clogistico: centros_logisticos){
            for(P_atencion punto: Clogistico.puntos_atencion){
                if(punto.codigo.equalsIgnoreCase(codigoPuntoAtencion)){
                    punto.clientes.add(cliente_nuevo);
                    return;
                }
            }
        }


        for (Sede sede: sedes){
            for (C_logistico cLogistico: sede.centros_logisticos){
                for (P_atencion punto: cLogistico.puntos_atencion){
                    if(punto.codigo.equalsIgnoreCase(codigoPuntoAtencion)){
                        punto.clientes.add(cliente_nuevo);
                        return;
                    }
                }
            }
        }




        for (EmpresaEnvio empresa : empresas) {
            for (Sede sede : empresa.sedes) {
                for(C_logistico centroLogistico: sede.centros_logisticos){
                    for(P_atencion puntoAtencion: centroLogistico.puntos_atencion){
                        if(puntoAtencion.codigo.equalsIgnoreCase(codigoPuntoAtencion)){
                            puntoAtencion.clientes.add(cliente_nuevo);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("No existe un punto de atencio con este codigo");

    }
    public static void editarCliente(){
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
    public static void eliminarCliente(){
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
        for (Cliente cliente : clientes) {
            if (cliente.cedula.equals(cedula)) {
                cambiarDatos(cliente);
                return;
            }
        }
        System.out.println("No existe Cliente con esa cédula");
    }
    public static void editarPorCorreo() {
        System.out.print("Correo : "); // Editar por  correo
        String correo = input.next();
        for (Cliente cliente : clientes) {
            if (cliente.correo.equalsIgnoreCase(correo)) {
                cambiarDatos(cliente);
                return;
            }
        }
        System.out.println("No existe Cliente con ese correo");
    }

    public static void cambiarDatos(Cliente cliente){
        System.out.println("Nombre : " + cliente.nombre);
        System.out.println("¿Quiere cambiar el nombre? Ingrese Y o N");
        String eleccion1 = input.next();
        if (eleccion1.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo nombre:");
            cliente.nombre = input.next();
        }
        System.out.println("Apellido: " + cliente.apellidos);
        System.out.println("¿Quiere cambiar el apellido? Ingrese Y o N");
        String eleccion2 = input.next();
        if (eleccion2.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo apellido:");
            cliente.apellidos = input.next();
        }
        System.out.println("Cédula: " + cliente.apellidos);
        System.out.println("¿Quiere cambiar la cédula? Ingrese Y o N");
        String eleccion3 = input.next();
        if (eleccion3.equalsIgnoreCase("Y")) {
            System.out.print("Nueva cédula:");
            String cedula = input.next();
            for(Cliente cliente1 : clientes){
                if(cliente1.cedula.equalsIgnoreCase(cedula)){
                    System.out.println("Lo sentimos,ya existe un Cliente con esa cédula");
                    return;
                }
            }
            cliente.cedula= cedula;
        }
        System.out.println("¡CAMBIOS REALIZADOS CON ÉXITO!");
    }

    public static void eliminarPorCedula(){
        System.out.print("Cedula: "); // Borrar por cédula al Cliente
        String cedula = input.next();
        for (Cliente cliente : clientes) {
            if (cliente.cedula.equals(cedula)) {
                confirmarEliminacion(cliente);
                return;
            }
        }
        System.out.println("No existe cliente con esa cédula ");
    }
    public static void eliminarPorCorreo(){
        System.out.print("Correo: "); // Borrar por correo al cliente
        String correo = input.next();
        for (Cliente cliente : clientes) {
            if (cliente.correo.equalsIgnoreCase(correo)) {
                confirmarEliminacion(cliente);
                return;
            }
        }
        System.out.println("No existe empleado con ese correo ");
    }

    public static void confirmarEliminacion(Cliente cliente){
        System.out.println("¿Quiere eliminar el cliente? Ingrese Y o N");
        String eleccion1 = input.next();
        if (eleccion1.equalsIgnoreCase("Y")) {
            clientes.remove(cliente);
            System.out.println("¡Cliente eliminado!");
        }
    }
}
