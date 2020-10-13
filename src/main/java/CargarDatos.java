import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CargarDatos {

    public static ArrayList<Admin> cargarAdmins(){
        ArrayList<Admin> adminsLeidos = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("admin.json"))   {
            Object obj = jsonParser.parse(reader);
            JSONArray lista_admins = (JSONArray)obj ;

            for(Object adminObjeto : lista_admins){
                JSONObject adminJSON = (JSONObject) adminObjeto ;
                adminsLeidos.add(Admin.parseAdmin(adminJSON));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return adminsLeidos;
    }

    public static ArrayList<Cliente> cargarClientes() {

        ArrayList<Cliente> clientesLeidos = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("clientes.json"))   {
            Object obj = jsonParser.parse(reader);
            JSONArray lista_clientes = (JSONArray)obj ;

            for(Object clienteObjeto : lista_clientes){
                JSONObject clineteJSON = (JSONObject) clienteObjeto ;
                clientesLeidos.add(Cliente.parseCliente(clineteJSON));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return clientesLeidos;
    }

    public static ArrayList<Empleado> cargarEmpleados() {

        ArrayList<Empleado> empleadosLeidos = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("empleados.json"))   {
            Object obj = jsonParser.parse(reader);
            JSONArray lista_empleados = (JSONArray)obj ;

            for(Object empleadoObjeto : lista_empleados){
                JSONObject empleadoJSON = (JSONObject) empleadoObjeto ;
                empleadosLeidos.add(Empleado.parseEmpleado(empleadoJSON));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return empleadosLeidos;
    }

    public static ArrayList<Paquete> cargarPaquetes() {

        ArrayList<Paquete> paquetesLeidos = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("paquetes.json"))   {
            Object obj = jsonParser.parse(reader);
            JSONArray lista_paquetes = (JSONArray)obj ;

            for(Object paqueteObjeto : lista_paquetes){
                JSONObject paqueteJSON = (JSONObject) paqueteObjeto ;
                paquetesLeidos.add(Paquete.parsePaquete(paqueteJSON));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return paquetesLeidos;
    }

    public static ArrayList<P_atencion> cargarPuntosAtencion() {

        ArrayList<P_atencion> puntos_atencion_leidos = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("puntos_atencion.json"))   {
            Object obj = jsonParser.parse(reader);
            JSONArray lista_puntos_atencion_json= (JSONArray)obj ;

            for(Object punto_atencion_Objeto : lista_puntos_atencion_json){
                JSONObject punto_atencion_JSON = (JSONObject) punto_atencion_Objeto ;
                puntos_atencion_leidos.add(P_atencion.parsePuntoAtencion(punto_atencion_JSON));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return puntos_atencion_leidos;
    }
    public static ArrayList<C_logistico> cargarCentrosLogisticos() {

        ArrayList<C_logistico> centros_log_leidos = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("centros_logisticos.json"))   {
            Object obj = jsonParser.parse(reader);
            JSONArray lista_centros_log_json= (JSONArray)obj ;

            for(Object centro_log_Objeto : lista_centros_log_json){
                JSONObject centro_log_JSON = (JSONObject)centro_log_Objeto;
                centros_log_leidos.add(C_logistico.parseCentroLogistico(centro_log_JSON));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return centros_log_leidos;
    }
    public static ArrayList<Sede> cargarSedes() {

        ArrayList<Sede> sedes_leidas = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("sedes.json"))   {
            Object obj = jsonParser.parse(reader);
            JSONArray lista_sedes_json= (JSONArray)obj ;

            for(Object sede_Objeto : lista_sedes_json){
                JSONObject sede_JSON = (JSONObject)sede_Objeto;
                sedes_leidas.add(Sede.parseSede(sede_JSON));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return sedes_leidas;
    }
    public static ArrayList<EmpresaEnvio> cargarEmpresas() {

        ArrayList<EmpresaEnvio> empresas_leidas = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("empresas.json"))   {
            Object obj = jsonParser.parse(reader);
            JSONArray lista_empresas_json= (JSONArray)obj ;

            for(Object empresa_Objeto : lista_empresas_json){
                JSONObject empresa_JSON = (JSONObject)empresa_Objeto;
                empresas_leidas.add(EmpresaEnvio.parseEmpresa(empresa_JSON));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return empresas_leidas;
    }
}
