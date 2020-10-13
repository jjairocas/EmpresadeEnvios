import java.util.ArrayList;
import java.util.Scanner;

public class Autenticacion {

    public static ArrayList<Admin> adminstradores = CargarDatos.cargarAdmins();
    public static ArrayList<Cliente> clientes = CargarDatos.cargarClientes();
    public static ArrayList<Empleado> empleados = CargarDatos.cargarEmpleados();

    public static Admin admin_logeado = null;
    public static Cliente cliente_logeado = null;
    public static Empleado empleado_logeado = null;

    public static void iniciarSesion(){
        adminstradores = CargarDatos.cargarAdmins(); // actualizar lista de admins
        Scanner input = new Scanner(System.in);
        String opcion = Menus.menuTipoUsuarioIngreso();
        label:
        while (true){
            switch (opcion) {
                case "1":  // Ingresa com un adminstrador
                    if (!adminstradores.isEmpty()) {
                        while (true) {
                            System.out.print("Cédula :");
                            String cedula = input.next();
                            if (adminstradores.get(0).cedula.equals(cedula)) { // solo hay un adminstrador
                                System.out.print("Contraseña :");
                                String password = input.next();
                                if (adminstradores.get(0).password.equals(password)) {
                                    System.out.println("____________________________________________________________");
                                    System.out.println("BIENVENIDO AL SISTEMA DE ENVIÓS SEÑOR@ ADMINISTRADOR  ");
                                    System.out.println("____________________________________________________________");
                                    admin_logeado = adminstradores.get(0);
                                    return;
                                } else {
                                    System.out.println("Contraseña incorrecta");
                                }
                            } else {
                                System.out.println("Cédula no errónea");
                            }
                        }
                    } else {
                        System.out.println("No hay admistradores registrados");
                    }
                    break;
                case "2":  // Ingresa un como un cliente
                    if (!empleados.isEmpty()) {
                        System.out.print("Correo:");
                        String correo = input.next();
                        for (Cliente cliente : clientes) {
                            if (cliente.correo.equals(correo)) {
                                System.out.print("Contraseña: ");
                                String password = input.next();
                                if (cliente.password.equals(password)) {
                                    System.out.println("____________________________________________________________");
                                    System.out.println("BIENVENIDO AL SISTEMA DE ENVIÓS   ");
                                    System.out.println("Cliente : " + cliente.nombre + " " + cliente.apellidos);
                                    System.out.println("____________________________________________________________");
                                    cliente_logeado = cliente;
                                    return;
                                } else {
                                    System.out.println("Contraseña incorrecta");
                                }
                            }
                        }
                        System.out.println("No hay clientes registrados con ese correo, verifique su datos por favor");
                    } else {
                        System.out.println("No hay clientes registrados");
                    }
                    break label;
                case "3":  // Ingresa un como un empleado
                    if (!clientes.isEmpty()) {
                        System.out.print("Correo:");
                        String correo = input.next();
                        for (Empleado empleado : empleados) {
                            if (empleado.correo.equals(correo)) {
                                System.out.print("Contraseña: ");
                                String password = input.next();
                                if (empleado.password.equals(password)) {
                                    System.out.println("____________________________________________________________");
                                    System.out.println("BIENVENIDO AL SISTEMA DE ENVIÓS   ");
                                    System.out.println("Empleado : " + empleado.nombre + " " + empleado.apellidos);
                                    System.out.println("____________________________________________________________");
                                    empleado_logeado = empleado;
                                    return;
                                } else {
                                    System.out.println("Contraseña incorrecta");
                                }
                            }
                        }
                        System.out.println("No existe  empleado registrado con ese correo, verifique su datos por favor");
                    } else {
                        System.out.println("No hay empleados registrados en  el sistema");
                    }
                    break label;
                case "0":   // Usuario elige cancelar
                    break label;
            }
        }
    }

    public static Admin getAdmin_logeado() {
        return admin_logeado;
    }

    public static Cliente getCliente_logeado() {
        return cliente_logeado;
    }

    public static Empleado getEmpleado_logeado() {
        return empleado_logeado;
    }
}
