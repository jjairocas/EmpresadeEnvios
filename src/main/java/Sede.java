import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Sede {
    String nombre;
    String codigo;
    ArrayList<C_logistico> centros_logisticos;

    public Sede(String nombre, String codigo, ArrayList<C_logistico> centros_logisticos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.centros_logisticos = centros_logisticos;
    }

    public Sede() {
    }

    @Override
    public String toString() {
        return "____________________________________________" +"\n"+
                "nombre    :" + nombre +"\n"+
                "codigo    :" + codigo +"\n"+
                " Cantidad de centros_logisticos: " + centros_logisticos.size() +"\n"+
                "____________________________________________";
    }

    public static Sede parseSede(JSONObject sede_json){

        String nombre =  (String) sede_json.get("nombre");
        String codigo =  (String) sede_json.get("codigo");

        //recuperacion del arreglo de paquetes_por enviar del archivo json
        JSONArray centros_log_json  =(JSONArray) sede_json.get("centros_logisticos");
        ArrayList<C_logistico> centros_log = new ArrayList<>();
        for(Object centro_log_Objeto : centros_log_json){
            JSONObject centro_log_json = (JSONObject) centro_log_Objeto;
            centros_log.add(C_logistico.parseCentroLogistico(centro_log_json));
        }

        return new Sede(nombre,codigo,centros_log);
    }

    public  static  JSONObject parseJsonObjeto(Sede sede){
        JSONObject sede_json = new JSONObject();
        sede_json.put("nombre", sede.nombre);
        sede_json.put("codigo", sede.codigo);

        JSONArray centros_log_json = new JSONArray();
        for(C_logistico centro_log: sede.centros_logisticos){
            JSONObject centro_log_json = C_logistico.parseJsonObjeto(centro_log);
            centros_log_json.add(centro_log_json);
        }
        sede_json.put("centros_logisticos",centros_log_json);

        return  sede_json;
    }
}
