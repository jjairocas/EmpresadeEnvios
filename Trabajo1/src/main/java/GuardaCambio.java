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

        try (FileWriter file = new FileWriter("sedes.json")) {
            file.write("");
            file.flush();
            //guardar  cambios para las sedes
            JSONArray lista_sedes_nuevas = new JSONArray();
            for(Sede sede: sedes){
                lista_sedes_nuevas.add(Sede.parseJsonObjeto(sede));
            }
            file.write(lista_sedes_nuevas.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }

        try (FileWriter file = new FileWriter("centros_logisticos.json")) {
            file.write("");
            file.flush();
            //guardar  cambios para los centros logisticos
            JSONArray lista_centros_logisticos = new JSONArray();
            for(C_logistico clogistico: centros_logisticos){
                lista_centros_logisticos.add(C_logistico.parseJsonObjeto(clogistico));
            }
            file.write(lista_centros_logisticos.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }

        try (FileWriter file = new FileWriter("puntos_atencion.json")) {
            file.write("");
            file.flush();
            //guardar  cambios para los puntos de atencion
            JSONArray lista_puntos_atencion = new JSONArray();
            for(P_atencion pAtencion: puntos_atencion){
                lista_puntos_atencion.add(P_atencion.parseJsonObjeto(pAtencion));
            }
            file.write(lista_puntos_atencion.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }

        try (FileWriter file = new FileWriter("empleados.json")) {
            file.write("");
            file.flush();
            //guardar  cambios para los empleados
            JSONArray lista_empleados = new JSONArray();
            for(Empleado empleado: empleados){
                lista_empleados.add(Empleado.parseJsonObjeto(empleado));
            }
            file.write(lista_empleados.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }

        try (FileWriter file = new FileWriter("clientes.json")) {
            file.write("");
            file.flush();
            //guardar  cambios para los clientes
            JSONArray lista_clientes = new JSONArray();
            for(Cliente cliente: clientes){
                lista_clientes.add(Cliente.parseJsonObjeto(cliente));
            }
            file.write(lista_clientes.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }

        try (FileWriter file = new FileWriter("paquetes.json")) {
            file.write("");
            file.flush();
            //guardar  cambios para los paquetes
            JSONArray lista_paquetes = new JSONArray();
            for(Paquete paquete: paquetes){
                lista_paquetes.add(Paquete.parseJsonObjeto(paquete));
            }
            file.write(lista_paquetes.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }

        System.out.println("Datos guardados con exito");
    }

}
