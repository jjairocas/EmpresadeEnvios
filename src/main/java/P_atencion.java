import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class P_atencion {
    String codigo;
    String direccion;
    Deque<Paquete> paquetes_por_enviar;
    ArrayList<Paquete> paquetes_por_entregar;
    Deque<Cliente> clientes;

    public P_atencion(String codigo, String direccion, Deque<Paquete> paquetes_por_enviar, ArrayList<Paquete> paquetes_por_entregar, Deque<Cliente> clientes) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.paquetes_por_enviar = paquetes_por_enviar;
        this.paquetes_por_entregar = paquetes_por_entregar;
        this.clientes = clientes;
    }

    public P_atencion() {
    }

    @Override
    public String toString() {
        return "___________________________________________________" +"\n"+
                "codigo :'" + codigo + "\n"+
                "direccion : '" + direccion + "\n"+
                "Cantidad de paquetes por enviar : " + paquetes_por_enviar.size() +"\n"+
                "Cantidad de paquetes por entregar :" + paquetes_por_entregar.size()+"\n"+
                "cantidad de clientes en cola =" + clientes.size() +"\n"+
                "___________________________________________________" +"\n";
    }

    public static P_atencion parsePuntoAtencion(JSONObject punto_atencion_json){

        String codigo =  (String) punto_atencion_json.get("codigo");
        String direccion = (String) punto_atencion_json.get("direccion");
        
        //recuperacion del arreglo de paquetes_por enviar del archivo json
        JSONArray paquetes_por_enviar_json  =(JSONArray) punto_atencion_json.get("paquetes_por_enviar");
        Deque<Paquete> paquetes_por_enviar = new LinkedList<>();
        for(Object paqueteObjeto : paquetes_por_enviar_json){
            JSONObject paquete_json = (JSONObject) paqueteObjeto;
            paquetes_por_enviar.add(Paquete.parsePaquete(paquete_json));
        }
        //recuperacion del arreglo de paquetes_por_entregar del archivo json
        JSONArray paquetes_por_entregar_json  =(JSONArray) punto_atencion_json.get("paquetes_por_entregar");
        ArrayList<Paquete> paquetes_por_entregar = new ArrayList<>();
        for(Object paqueteObjeto : paquetes_por_entregar_json){
            JSONObject paquete_json = (JSONObject) paqueteObjeto;
            paquetes_por_entregar.add(Paquete.parsePaquete(paquete_json));
        }
        //recuperacion de clientes del archivo json
        JSONArray clientes_json  =(JSONArray) punto_atencion_json.get("clientes");
        Deque<Cliente> clientes = new LinkedList<>();
        for(Object clienteObjeto : clientes_json){
            JSONObject cliente_json = (JSONObject) clienteObjeto;
            clientes.add(Cliente.parseCliente(cliente_json));
        }


        return new P_atencion(codigo,direccion,paquetes_por_enviar,paquetes_por_entregar,clientes);
    }

    public  static  JSONObject parseJsonObjeto(P_atencion punto_atencion){
        JSONObject punto_atencion_json = new JSONObject();
        punto_atencion_json.put("codigo", punto_atencion.codigo);
        punto_atencion_json.put("direccion", punto_atencion.direccion);

        JSONArray paquetes_por_enviar_json = new JSONArray();
        for(Paquete paquete: punto_atencion.paquetes_por_enviar){
            JSONObject paquete_json = Paquete.parseJsonObjeto(paquete);
            paquetes_por_enviar_json.add(paquete_json);
        }
        punto_atencion_json.put("paquetes_por_enviar",paquetes_por_enviar_json);

        JSONArray paquetes_por_entregar_json = new JSONArray();
        for(Paquete paquete: punto_atencion.paquetes_por_entregar){
            JSONObject paquete_json = Paquete.parseJsonObjeto(paquete);
            paquetes_por_entregar_json.add(paquete_json);
        }
        punto_atencion_json.put("paquetes_por_entregar",paquetes_por_entregar_json);

        JSONArray clientes_json = new JSONArray();
        for(Cliente cliente: punto_atencion.clientes){
            JSONObject cliente_json = Cliente.parseJsonObjeto(cliente);
            clientes_json.add(cliente_json);
        }
        punto_atencion_json.put("clientes",clientes_json);
        

        return  punto_atencion_json;
    }
}
