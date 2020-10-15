import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaClientes {
    public static Scanner input= new Scanner(System.in);

    public static void buscar(ArrayList<Cliente> clientes){
        while(true){
            System.out.println("SELECCIONE: ");
            System.out.println("1. nombre");
            System.out.println("2. cedula");
            System.out.println("3. correo");
            System.out.println("4. Mostrar todos los clientes");
            System.out.println("5. Atras");
            String opcion = input.next();

            if (opcion.equals("1")){
                while(true){
                    String eleccion = Menus.menuAtributoTexto();
                    if(eleccion.equals("1")){
                        System.out.println("Ingrese el nombre del cliente");
                        String nombreCliente = input.next();
                        for (Cliente cliente: clientes){
                            if(cliente.nombre.equals(nombreCliente)){
                                System.out.println(cliente);
                                return;
                            }
                        }
                        System.out.println("No existe un cliente con este nombre");
                    }
                    else if (eleccion.equals("2")){
                        System.out.println("Ingrese el nombre del cliente");
                        String nombreCliente1 = input.next();
                        for (Cliente cliente: clientes){
                            if(cliente.nombre.equalsIgnoreCase(nombreCliente1)){
                                System.out.println(cliente);
                                return;
                            }
                        }
                        System.out.println("No existe un cliente con este nombre");
                    }
                }
            }

            else if (opcion.equals("2")){
                while(true){
                    String eleccion = Menus.menuAtributoTexto();
                    if(eleccion.equals("1")){
                        System.out.println("Ingrese la cedula del cliente");
                        String cedulaCliente = input.next();
                        for (Cliente cliente: clientes){
                            if(cliente.cedula.equals(cedulaCliente)){
                                System.out.println(cliente);
                                return;
                            }
                        }
                        System.out.println("No existe un cliente con esta cedula");
                    }
                    else if (eleccion.equals("2")){
                        System.out.println("Ingrese la cedula del cliente");
                        String cedulaCliente1 = input.next();
                        for (Cliente cliente: clientes){
                            if(cliente.cedula.equalsIgnoreCase(cedulaCliente1)){
                                System.out.println(cliente);
                                return;
                            }
                        }
                        System.out.println("No existe un cliente con esta cedula");
                    }
                }
            }
            else if (opcion.equals("3")){
                while(true){
                    String eleccion = Menus.menuAtributoTexto();
                    if(eleccion.equals("1")){
                        System.out.println("Ingrese el correo del cliente");
                        String correoCliente = input.next();
                        for (Cliente cliente: clientes){
                            if(cliente.correo.equals(correoCliente)){
                                System.out.println(cliente);
                                return;
                            }
                        }
                        System.out.println("No existe un cliente con este correo");
                    }
                    else if (eleccion.equals("2")){
                        System.out.println("Ingrese el correo del cliente");
                        String correoCliente1 = input.next();
                        for (Cliente cliente: clientes){
                            if(cliente.correo.equalsIgnoreCase(correoCliente1)){
                                System.out.println(cliente);
                                return;
                            }
                        }
                        System.out.println("No existe un cliente con este correo");
                    }
                }
            }

            else if (opcion.equals("4")){
                System.out.println("LISTADO DE CLIENTES: ");
                for(Cliente cliente : clientes){
                    System.out.println(cliente);
                }
            }

            else if (opcion.equals("5")){
                return;
            }

        }
    }

}
