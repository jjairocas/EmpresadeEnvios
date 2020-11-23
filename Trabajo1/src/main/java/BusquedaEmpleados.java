
import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaEmpleados {
    public static Scanner input= new Scanner(System.in);

    public static void buscar(ArrayList<Empleado> empleados){
        while(true){
            System.out.println("SELECCIONE: ");
            System.out.println("1. nombre");
            System.out.println("2. cedula");
            System.out.println("3. correo");
            System.out.println("4. Mostrar todos los empleados");
            System.out.println("0. Atras");
            String opcion = input.next();

            switch (opcion) {
                case "1":
                    while (true) {
                        String eleccion = Menus.menuAtributoTexto();
                        if (eleccion.equals("1")) {
                            System.out.println("Ingrese el nombre del empleado");
                            String nombreEmpleado = input.next();
                            for (Empleado empleado : empleados) {
                                if (empleado.nombre.equals(nombreEmpleado)) {
                                    System.out.println(empleado);
                                    return;
                                }
                            }
                            System.out.println("No existe un empleado con este nombre");
                        } else if (eleccion.equals("2")) {
                            System.out.println("Ingrese el nombre del empleado");
                            String nombreEmpleado = input.next();
                            for (Empleado empleado : empleados) {
                                if (empleado.nombre.equalsIgnoreCase(nombreEmpleado)) {
                                    System.out.println(empleado);
                                    return;
                                }
                            }
                            System.out.println("No existe un empleado con este nombre");
                        }
                        else if(eleccion.equals("0")){
                            break;
                        }
                    }
                case "2":
                    while (true) {
                        String eleccion = Menus.menuAtributoTexto();
                        if (eleccion.equals("1")) {
                            System.out.println("Ingrese la cedula del empleado");
                            String cedulaEmpleado = input.next();
                            for (Empleado empleado : empleados) {
                                if (empleado.cedula.equals(cedulaEmpleado)) {
                                    System.out.println(empleado);
                                    return;
                                }
                            }
                            System.out.println("No existe un empleado con esta cedula");
                        } else if (eleccion.equals("2")) {
                            System.out.println("Ingrese la cedula del empleado");
                            String cedulaEmpleado = input.next();
                            for (Empleado empleado : empleados) {
                                if (empleado.cedula.equalsIgnoreCase(cedulaEmpleado)) {
                                    System.out.println(empleado);
                                    return;
                                }
                            }
                            System.out.println("No existe un empleado con esta cedula");
                        }
                        else if(eleccion.equals("0")){
                           break;
                        }

                    }
                case "3":
                    while (true) {
                        String eleccion = Menus.menuAtributoTexto();
                        if (eleccion.equals("1")) {
                            System.out.println("Ingrese el correo del empleado");
                            String correoEmpleado = input.next();
                            for (Empleado empleado : empleados) {
                                if (empleado.correo.equals(correoEmpleado)) {
                                    System.out.println(empleado);
                                    return;
                                }
                            }
                            System.out.println("No existe un empleado con este correo");
                        } else if (eleccion.equals("2")) {
                            System.out.println("Ingrese el correo del cliente");
                            String correoCliente1 = input.next();
                            for (Empleado empleado : empleados) {
                                if (empleado.correo.equalsIgnoreCase(correoCliente1)) {
                                    System.out.println(empleado);
                                    return;
                                }
                            }
                            System.out.println("No existe un empleado con este correo");
                        }
                        else if(eleccion.equals("0")){
                            break;
                        }
                    }
                case "4":
                    System.out.println("LISTADO DE EMPLEADOS: ");
                    for (Empleado empleado : empleados) {
                        System.out.println(empleado);
                    }
                    Label5:
                    while(true){
                        System.out.println("1. ordenar alfabeticamente");
                        System.out.println("0. atras");
                        String eleccion_orden = input.next();
                        switch (eleccion_orden){
                            case "1":
                                OrdenEmpleado.ordenarAlfabeticamente(CRUDEmpleados.empleados);
                                break;
                            case "0":
                                break Label5;
                        }
                    }

                    break;
                case "0":
                    return;
            }

        }
    }

}
