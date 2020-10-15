import java.util.ArrayList;
import java.util.Scanner;

public class Busqueda {

    public static ArrayList<Paquete> paquetes = CRUDPaquetes.paquetes;
    public static ArrayList<Cliente> clientes = CRUDClientes.clientes;
    public static ArrayList<Empleado> empleados = CRUDEmpleados.empleados;
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
                            case "1":  //ordenar alfabeticamente
                                OrdenEmpresas.ordenarAlfabeticamente(CRUDEmpresas.empresas);
                                break;
                            case "2":  // ordenar por Por cantidad de sedes
                                OrdenEmpresas.ordenarPorSedes(CRUDEmpresas.empresas);
                                break;
                            case "3": // ordenar Por cantidad de centros logísticos
                                OrdenEmpresas.ordenarPorCentrosLog(CRUDEmpresas.empresas);
                                break;
                            case "0": // Atrás
                                break label1;
                        }
                    }
                    break;
                case "2":  //...Buscar en Sedes
                    BusquedaSedes.buscar(CRUDSedes.sedes);
                    label2:
                   // while

                    break;
                case "3":  //...Buscar en Centros logisticos
                    BusquedaCentrosLogisticos.buscar(CRUDCentrosLog.centros_logisticos);
                    label3:
                    while (true) {
                        String eleccion_orden = Menus.menuOrdenEmpresas();
                        switch (eleccion_orden) {
                            case "1":  //ordenar alfabeticamente
                                OrdenCentroLogistico.ordenarAlfabeticamente(CRUDCentrosLog.centros_logisticos);
                                break;
                            case "2":  // ordenar por Por cantidad de sedes
                                OrdenEmpresas.ordenarPorSedes(CRUDEmpresas.empresas);
                                break;
                            case "3": // ordenar Por cantidad de centros logísticos
                                OrdenEmpresas.ordenarPorCentrosLog(CRUDEmpresas.empresas);
                                break;
                            case "0": // Atrás
                                break label3;
                        }
                    }
                    break;
                case "4":  //... Buscar en Puntos de atencion
                    BusquedaPuntosAtencion.buscar(CRUDPuntosAtencion.puntos_atencion);

                    break;
                case "5":  //... Buscar en Empleados
                    BusquedaEmpleados.buscar(CRUDEmpleados.empleados);

                    break;
                case "6":  //...  Buscar en Clientes
                    BusquedaClientes.buscar(CRUDClientes.clientes);
                    break;
                case "7":  //... Buscar en Paquetes
                    BusquedaPaquetes.buscar(CRUDPaquetes.paquetes);

                    break;
                case "0":
                    break label;
            }
        }
    }
}
