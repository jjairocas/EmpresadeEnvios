import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {

    public static ArrayList<Paquete> paquetes = CRUDPaquetes.paquetes;
    public static ArrayList<Cliente> clientes = CRUDClientes.clientes;
    public static  ArrayList<Empleado> empleados = CRUDEmpleados.empleados;
    public static ArrayList<P_atencion> puntos_atencion = CRUDPuntosAtencion.puntos_atencion;
    public static ArrayList<C_logistico> centros_logisticos = CRUDCentrosLog.centros_logisticos;
    public static ArrayList<Sede> sedes = CRUDSedes.sedes;
    public static ArrayList<EmpresaEnvio> empresas = CRUDEmpresas.empresas;
    public static Scanner input = new Scanner(System.in);

    public static void crudClases(){
        label:
        while (true){
            System.out.println("ADMINISTRACIÓN");
            String opcion = Menus.menuAdminstracion();
            switch (opcion) {
                case "1":  // CRUD empresas
                    label1:
                    while (true) {
                        String opcion1 = Menus.menuCrudEmpresas();
                        switch (opcion1) {
                            case "1": // ver empresas
                                CRUDEmpresas.verEmpresas();
                                break;
                            case "2":  // crear empresa
                                CRUDEmpresas.crearEmpresa();
                                break;
                            case "3":  //editar empresa
                                CRUDEmpresas.editarEmpresa();
                                break;
                            case "4":  // Eliminar empresa
                                CRUDEmpresas.eliminarEmpresa();
                                break;
                            case "0":
                                break label1;
                        }
                    }
                    break;
                case "2":  //CRUD Sedes
                    label1:
                    while (true) {
                        String opcion1 = Menus.menuCrudSedes();
                        switch (opcion1) {
                            case "1": // ver sedes
                                CRUDSedes.verSedes();
                                break;
                            case "2":  // crear sede
                                CRUDSedes.crearSede();
                                break;
                            case "3":  //editar sede
                                CRUDSedes.editarSede();
                                break;
                            case "4":  // Eliminar sede
                                CRUDSedes.eliminarSede();
                                break;
                            case "0":
                                break label1;
                        }
                    }
                    break;
                case "3":  //CRUD Centros logisticos
                    label1:
                    while (true) {
                        String opcion1 = Menus.menuCrudCentrosLog();
                        switch (opcion1) {
                            case "1": // ver centro logistico
                                CRUDCentrosLog.verCentrosLog();
                                break;
                            case "2":  // crear centro logistico
                                CRUDCentrosLog.crearCentroLog();
                                break;
                            case "3":  //editar centro logistico
                                CRUDCentrosLog.editarCentroLog();
                                break;
                            case "4":  // Eliminar centro logistico
                                CRUDCentrosLog.eliminarCentroLog();
                                break;
                            case "0":
                                break label1;
                        }
                    }
                    break;
                case "4":  // CRUD Puntos de atencion
                    label1:
                    while (true) {
                        String opcion1 = Menus.menuCrudPuntosAtencion();
                        switch (opcion1) {
                            case "1": // ver puntos atencions
                                CRUDPuntosAtencion.verPuntosAtencion();
                                break;
                            case "2":  // crear punto de atencion
                                CRUDPuntosAtencion.crearPuntoAtencion();
                                break;
                            case "3":  //editar punto de atencion
                                CRUDPuntosAtencion.editarPuntoAtencion();
                                break;
                            case "4":  // Eliminar punto de atencion
                                CRUDPuntosAtencion.eliminarPuntoAtencion();
                                break;
                            case "0":
                                break label1;
                        }
                    }
                    break;
                case "5":  // CRUD Empleados
                    label1:
                    while (true){
                        String opcion1 = Menus.menuCrudEmpleados();
                        switch (opcion1){
                            case "1": // ver empleados
                                CRUDEmpleados.verEmpleados();
                                break;
                            case "2":  // crear empleado
                                CRUDEmpleados.crearEmpleado();
                                break;
                            case "3":  //editar empleado
                                CRUDEmpleados.editarEmpleado();
                                break;
                            case "4":  // Eliminar empleado
                                CRUDEmpleados.eliminarEmpleado();
                                break;
                            case "0":
                                break label1;
                        }
                    }
                    break;
                case "6":  //  CRUD Clientes
                    label1:
                    while (true){
                        String opcion1 = Menus.menuCrudClientes();
                        switch (opcion1){
                            case "1": // ver clientes
                                CRUDClientes.verCliente();
                                break;
                            case "2":  // crear empleado
                                CRUDClientes.crearCliente();
                                break;
                            case "3":  //editar empleado
                                CRUDClientes.editarCliente();
                                break;
                            case "4":  // Eliminar empleado
                                CRUDClientes.eliminarCliente();
                                break;
                            case "0":
                                break label1;
                        }
                    }
                    break;
                case "7":  // Administrar Paquetes
                    label1:
                    while (true){
                        String opcion1 = Menus.menuCrudPaquetes();
                        switch (opcion1){
                            case "1": // ver empleados
                                CRUDPaquetes.verPaquetes();
                                break;
                            case "2":  // crear empleado
                                //..pendiente
                                break;
                            case "3":  //editar empleado
                                //...pendiente
                                break;
                            case "4":  // Eliminar empleado
                                //...pendiente
                                break;
                            case "0":
                                break label1;
                        }
                    }
                    break;
                case "0":
                    break label;
            }
        }
    }
}
