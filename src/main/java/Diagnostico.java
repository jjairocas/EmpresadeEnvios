import java.util.ArrayList;
import java.util.Scanner;

public class Diagnostico {
    public static ArrayList<Paquete> paquetes = CRUDPaquetes.paquetes;
    public static ArrayList<Cliente> clientes = CRUDClientes.clientes;
    public static  ArrayList<Empleado> empleados = CRUDEmpleados.empleados;
    public static ArrayList<P_atencion> puntos_atencion = CRUDPuntosAtencion.puntos_atencion;
    public static ArrayList<C_logistico> centros_logisticos = CRUDCentrosLog.centros_logisticos;
    public static ArrayList<Sede> sedes = CRUDSedes.sedes;
    public static ArrayList<EmpresaEnvio> empresas = CRUDEmpresas.empresas;

    public static Scanner input = new Scanner(System.in);

    public static void diagnosticarInconsistencias(){
        System.out.println("________________________________________");
        System.out.println("              INFORME");
        System.out.println("________________________________________");
        System.out.println("* EMPRESAS SIN SEDES");
        for(EmpresaEnvio empresa: empresas){
            if(empresa.sedes.isEmpty()){
                System.out.println(empresa);
            }
        }
        System.out.println("________________________________________");
        //.....Quedan pendientes los informes para sede, centros log, puntos atencion, clientes y paquetes.
    }
}
