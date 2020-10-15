import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaPuntosAtencion {

        public static Scanner input = new Scanner(System.in);

        public static void buscar(ArrayList<P_atencion> P_Atencion) {
            while (true) {

                System.out.println("SELECCIONE :");
                System.out.println("1.Codigo");
                System.out.println("2.Direccion");
                System.out.println("3.Mostrar todas las sedes");
                System.out.println("0.Atras");
                String opcion = input.next();
                if (opcion.equals("1")) { // Codigo
                    while (true) {
                        String eleccion = Menus.menuAtributoTexto();
                        if (eleccion.equals("1")) { // valor exacto
                            System.out.println("Ingrese el codigo del Punto de atencion:");
                            String P_attenc = input.next();
                            for (P_atencion p_atencion : P_Atencion) {
                                if (p_atencion.codigo.equals(P_attenc)) {
                                    System.out.println(p_atencion);
                                    return;
                                }
                            }
                            System.out.println("No existe el codigo del Punto de atención");
                        }

                     else if (eleccion.equals("2")) { // valor sin considerar mayúsculas
                            System.out.println("Ingrese el codigo del Punto de atencion:");
                            String P_attenc1 = input.next();
                            for (P_atencion p_atencion : P_Atencion) {
                                if (p_atencion.codigo.equalsIgnoreCase(P_attenc1)) {
                                    System.out.println(p_atencion);
                                    return;
                                }
                            }
                            System.out.println("No existe el codigo del Punto de atención");
                        }

                     else if (eleccion.equals("0")) { // atras
                            break;
                        }
                    }
                } else if (opcion.equals("2")) { // Direccion
                    while (true) {
                        String eleccion = Menus.menuAtributoTexto();
                        if (eleccion.equals("1")) { // valor exacto
                            System.out.println("Ingrese la direccion del punto de atencion:");
                            String dir = input.next();
                            for (P_atencion p_atencion : P_Atencion) {
                                if (p_atencion.direccion.equals(dir)) {
                                    System.out.println(p_atencion);
                                    return;
                                }
                            }
                            System.out.println("No existe la direccion del punto de atencion");

                        } else if (eleccion.equals("2")) { // valor sin considerar mayúsculas
                            System.out.println("Ingrese la direccion del punto de atencion:");
                            String dir1 = input.next();
                            for (P_atencion p_atencion : P_Atencion) {
                                if (p_atencion.direccion.equalsIgnoreCase(dir1)) {
                                    System.out.println(p_atencion);
                                    return;
                                }
                            }
                            System.out.println("No existe la direccion del punto de atencion");

                        } else if (eleccion.equals("0")) { // atras
                            break;
                        }
                    }


                } else if (opcion.equals("3")) { // Mostrar todas las sedes
                    System.out.println("LISTADO DE SEDES: ");
                    for (P_atencion p_atencion : P_Atencion) {
                        System.out.println(p_atencion);
                    }
                    return;
                } else if (opcion.equals("0")) {
                    break;
                }
            }
        }

    }

