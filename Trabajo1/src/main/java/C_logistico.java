import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;


public class C_logistico {
    String codigo;
    ArrayList<P_atencion> puntos_atencion;
    ArrayList<Empleado> empleados;
    ArrayList<Paquete> paquetes;

    public C_logistico(String codigo, ArrayList<P_atencion> puntos_atencion, ArrayList<Empleado> empleados, ArrayList<Paquete> paquetes) {
        this.codigo = codigo;
        this.puntos_atencion = puntos_atencion;
        this.empleados = empleados;
        this.paquetes = paquetes;
    }

    public C_logistico() {
    }

    @Override
    public String toString() {
        return " _________________________________________________" +"\n"+
                "|codigo                         :" + codigo + "\n"+
                "|Cantidad  de puntos_atencion   :" + puntos_atencion.size() +"\n"+
                "|Cantidad de empleados          :" + empleados.size() +"\n"+
                "|Catidad de paquetes regsitrados:" + paquetes.size() +"\n"+
                "|_________________________________________________" +"\n";
    }

    public static C_logistico parseCentroLogistico(JSONObject centro_logistico_json){

        String codigo =  (String) centro_logistico_json.get("codigo");

        //recuperacion del arreglo de paquetes_por enviar del archivo json
        JSONArray puntos_atencion_json  =(JSONArray) centro_logistico_json.get("puntos_atencion");
        ArrayList<P_atencion> puntos_atencion = new ArrayList<>();
        for(Object punto_atencion_Objeto : puntos_atencion_json){
            JSONObject punto_atencion_json = (JSONObject) punto_atencion_Objeto;
            puntos_atencion.add(P_atencion.parsePuntoAtencion(punto_atencion_json));
        }

        //recuperacion del arreglo de paquetes_por_entregar del archivo json
        JSONArray empleados_json  =(JSONArray) centro_logistico_json.get("empleados");
        ArrayList<Empleado> empleados = new ArrayList<>();
        for(Object empleadoObjeto : empleados_json){
            JSONObject empleado_json = (JSONObject) empleadoObjeto;
            empleados.add(Empleado.parseEmpleado(empleado_json));
        }
        //recuperacion de clientes del archivo json
        JSONArray paquetes_json  =(JSONArray) centro_logistico_json.get("paquetes");
        ArrayList<Paquete> paquetes = new ArrayList<>();
        for(Object paqueteObjeto : paquetes_json){
            JSONObject paquete_json = (JSONObject) paqueteObjeto;
            paquetes.add(Paquete.parsePaquete(paquete_json));
        }

        return new C_logistico(codigo,puntos_atencion,empleados,paquetes);
    }

    public  static  JSONObject parseJsonObjeto(C_logistico centro_logistico){
        JSONObject centro_logistico_json = new JSONObject();
        centro_logistico_json.put("codigo", centro_logistico.codigo);

        JSONArray puntos_atencion_json = new JSONArray();
        for(P_atencion punto_atencion: centro_logistico.puntos_atencion){
            JSONObject punto_atencion_json = P_atencion.parseJsonObjeto(punto_atencion);
            puntos_atencion_json.add(punto_atencion_json);
        }
        centro_logistico_json.put("puntos_atencion",puntos_atencion_json);

        JSONArray empleados_json = new JSONArray();
        for(Empleado empleado: centro_logistico.empleados){
            JSONObject empleado_json = Empleado.parseJsonObjeto(empleado);
            empleados_json.add(empleado_json);
        }
        centro_logistico_json.put("empleados",empleados_json);

        JSONArray paquetes_json = new JSONArray();
        for(Paquete paquete: centro_logistico.paquetes){
            JSONObject paquete_json = Paquete.parseJsonObjeto(paquete);
            paquetes_json.add(paquete_json);
        }
        centro_logistico_json.put("paquetes",paquetes_json);


        return  centro_logistico_json;
    }
}
