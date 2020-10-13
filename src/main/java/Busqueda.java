import java.util.ArrayList;
import java.util.Scanner;

public class Busqueda {

    public static ArrayList<Paquete> paquetes = CRUDPaquetes.paquetes;
    public static ArrayList<Cliente> clientes = CRUDClientes.clientes;
    public static  ArrayList<Empleado> empleados = CRUDEmpleados.empleados;
    public static ArrayList<P_atencion> puntos_atencion = CRUDPuntosAtencion.puntos_atencion;
    public static ArrayList<C_logistico> centros_logisticos = CRUDCentrosLog.centros_logisticos;
    public static ArrayList<Sede> sedes = CRUDSedes.sedes;
    public static ArrayList<EmpresaEnvio> empresas = CRUDEmpresas.empresas;

    public static Scanner input = new Scanner(System.in);

    public static void busqueda(){
        label:
        while (true){
            System.out.println("BÚSQUEDA");
            String opcion = Menus.menuAdminstracion();
            switch (opcion) {
                case "1":  // Buscar en empresas
                    BusquedaEmpresas.buscar(CRUDEmpresas.empresas);
                    label1:
                    while (true) {
                        String eleccion_orden = Menus.menuOrdenEmpresas();
                        switch (eleccion_orden) {
                            case "1":  //oredenar alfabeticamente
                                OrdenEmpresas.ordenarAlfabeticamente(CRUDEmpresas.empresas);
                                break;
                            case "2":  // ordenar por Por cantidad de sedes

                                break;
                            case "3": // ordenar Por cantidad de centros logísticos

                                break;
                            case "4": // ordenar Por cantidad de Puntos de atencion

                                break;
                            case "5": // ordenar Por cantidad de Empleados

                                break;
                            case "6": // Por cantidad de Clientes

                                break;
                            case "7": // Por cantidad de Paquetes registrados

                                break;
                            case "0": // Atrás
                                break label1;
                        }
                    }
                    break;
                case "2":  //...Buscar en Sedes

                    break;
                case "3":  //...Buscar en Centros logisticos

                    break;
                case "4":  //... Buscar en Puntos de atencion

                    break;
                case "5":  //... Buscar en Empleados

                    break;
                case "6":  //...  Buscar en Clientes

                    break;
                case "7":  //... Buscar en Paquetes

                    break;
                case "0":
                    break label;
            }
        }
    }
}
