import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GuardaCambio {

    public static ArrayList<Paquete> paquetes = CRUD.paquetes;
    public static ArrayList<Cliente> clientes = CRUDClientes.clientes;
    public static  ArrayList<Empleado> empleados = CRUDEmpleados.empleados;
    public static ArrayList<P_atencion> puntos_atencion = CRUDPuntosAtencion.puntos_atencion;
    public static ArrayList<C_logistico> centros_logisticos = CRUDCentrosLog.centros_logisticos;
    public static ArrayList<Sede> sedes = CRUDSedes.sedes;
    public static ArrayList<EmpresaEnvio> empresas = CRUDEmpresas.empresas;

    public static Scanner input = new Scanner(System.in);

    public static void guardar(){
        //guardar cambios en empresas
        try (FileWriter file = new FileWriter("empresas.json")) {
            file.write("");
            file.flush();
            //guardar  cambios para las empresas
            JSONArray lista_empresas_nueva= new JSONArray();
            for(EmpresaEnvio empresa:empresas){
                lista_empresas_nueva.add(EmpresaEnvio.parseJsonObjeto(empresa));
            }
            file.write(lista_empresas_nueva.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
    }
}
