import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.ArrayList;

public class EmpresaEnvio {
    String nombre;
    String nit;
    ArrayList<Sede> sedes;

    public EmpresaEnvio(String nombre, String nit, ArrayList<Sede> sedes) {
        this.nombre = nombre;
        this.nit = nit;
        this.sedes = sedes;
    }

    public EmpresaEnvio() {
    }

    @Override
    public String toString() {
        return " _________________________________" +"\n"+
                "|Nombre : " + nombre + "\n" +
                "|Nit    : " + nit +"\n" +
                "|Cantidad de sedes :" + sedes.size() +"\n" +
                "|_________________________________";
    }

    public static EmpresaEnvio parseEmpresa(JSONObject empresa_json){

        String nombre =  (String) empresa_json.get("nombre");
        String nit =  (String) empresa_json.get("nit");
        JSONArray sedes_json = (JSONArray) empresa_json.get("sedes");
        ArrayList<Sede> sedes = new ArrayList<>();
        for(Object sede_Objeto : sedes_json){
            JSONObject sede_json = (JSONObject) sede_Objeto;
            sedes.add(Sede.parseSede(sede_json));
        }

        return new EmpresaEnvio(nombre,nit,sedes);
    }

    public  static  JSONObject parseJsonObjeto(EmpresaEnvio empresa){
        JSONObject empresa_json = new JSONObject();
        empresa_json.put("nombre", empresa.nombre);
        empresa_json.put("nit", empresa.nit);

        JSONArray sedes_json = new JSONArray();
        for(Sede sede: empresa.sedes){
            JSONObject sede_json = Sede.parseJsonObjeto(sede);
            sedes_json.add(sede_json);
        }
        empresa_json.put("sedes",sedes_json);

        return  empresa_json;
    }
}
