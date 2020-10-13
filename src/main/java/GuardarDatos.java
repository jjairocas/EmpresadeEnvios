import org.json.simple.JSONArray;

import java.io.FileWriter;

public class GuardarDatos {

    public static void guardarAdmin(Admin admin){
        // llamamos al método parseJson de la clase Admin para que
        // devuelva el objeto admin como una cadena en formato Json.

        // Creamos un JSONarray para guardar los objetos admin en una cadena en formato Json
        JSONArray lista_admin = new JSONArray();

        // agregamos el objeto Usuario cons sus Datos al arreglo JSON
        lista_admin.add(Admin.parseJsonObjeto(admin));

        // Creamos el archivo JSON llamado "admin.json" que va a almacenar los administradores creados en el sistema.
        try (FileWriter file = new FileWriter("admin.json")) {
            file.write(lista_admin.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }

    public static void guardarCliente(Cliente cliente) {
        // llamamos al método parseJson de la clase Cliente para que
        // devuelva el objeto cliente como una cadena en formato Json.

        // Creamos un JSONarray para guardar los objetos cliente en una cadena en formato Json
        JSONArray lista_clientes = new JSONArray();

        // agregamos el objeto Cliente cons sus Datos al arreglo JSON
        lista_clientes.add(Cliente.parseJsonObjeto(cliente));

        // Creamos el archivo JSON llamado "clinetes.json" que va a almacenar los clientes creados en el sistema.
        try (FileWriter file = new FileWriter("clientes.json")) {
            file.write(lista_clientes.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
    }

    public static void guardarEmpleado(Empleado empleado) {
        // llamamos al método parseJson de la clase Empleado para que
        // devuelva el objeto empleado como un objeto  Json.

        // Creamos un JSONarray para guardar los objetos empleados en una cadena en formato Json
        JSONArray lista_empleados = new JSONArray();

        // agregamos el objeto Empleados cons sus Datos al arreglo JSON
        lista_empleados.add(Empleado.parseJsonObjeto(empleado));

        // Creamos el archivo JSON llamado "empleados.json" que va a almacenar los empleados creados en el sistema.
        try (FileWriter file = new FileWriter("empleados.json")) {
            file.write(lista_empleados.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
    }

    public static void guardarPaquete(Paquete paquete) {

        JSONArray lista_paquetes= new JSONArray();

        // agregamos el objeto Paquete cons sus Datos al arreglo JSON
        lista_paquetes.add(Paquete.parseJsonObjeto(paquete));

        // Creamos el archivo JSON llamado "paquetes.json" que va a almacenar los paquetes creados en el sistema.
        try (FileWriter file = new FileWriter("paquetes.json")) {
            file.write(lista_paquetes.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
    }

    public static void guardarPuntoAtencion(P_atencion punto_atencion) {

        JSONArray lista_puntos_atencion= new JSONArray();

        // agregamos el objeto Paquete cons sus Datos al arreglo JSON
        lista_puntos_atencion.add(P_atencion.parseJsonObjeto(punto_atencion));

        // Creamos el archivo JSON llamado "paquetes.json" que va a almacenar los paquetes creados en el sistema.
        try (FileWriter file = new FileWriter("puntos_atencion.json")) {
            file.write(lista_puntos_atencion.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
    }
    public static void guardarCentroLogistico(C_logistico centro_logistico) {

        JSONArray lista_centros_logisticos= new JSONArray();

       lista_centros_logisticos.add(C_logistico.parseJsonObjeto(centro_logistico));

        // Creamos el archivo JSON llamado "centros_logisticos.json"
        try (FileWriter file = new FileWriter("centros_logisticos.json")) {
            file.write(lista_centros_logisticos.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
    }
    public static void guardarSede(Sede sede) {

        JSONArray lista_sedes= new JSONArray();

        lista_sedes.add(Sede.parseJsonObjeto(sede));

        // Creamos el archivo JSON llamado "sedes.json"
        try (FileWriter file = new FileWriter("sedes.json")) {
            file.write(lista_sedes.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
    }

    public static void guardarEmpresa(EmpresaEnvio empresa) {

        JSONArray lista_empresas= new JSONArray();

       lista_empresas.add(EmpresaEnvio.parseJsonObjeto(empresa));

        // Creamos el archivo JSON llamado "empresas.json"
        try (FileWriter file = new FileWriter("empresas.json")) {
            file.write(lista_empresas.toJSONString());
            file.flush();
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
    }
}
