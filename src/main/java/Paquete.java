import org.json.simple.JSONObject;

public class Paquete {
    String codigo_paquete;
    String codigo_origen =null;
    String codigo_destino =null;
    String cedula_remitente;
    String cedula_destinatario = null;
    boolean estado = false;

    public Paquete(String codigo_paquete, String codigo_origen, String codigo_destino, String cedula_remitente, String cedula_destinatario, boolean estado) {
        this.codigo_paquete = codigo_paquete;
        this.codigo_origen = codigo_origen;
        this.codigo_destino = codigo_destino;
        this.cedula_remitente = cedula_remitente;
        this.cedula_destinatario = cedula_destinatario;
        this.estado = estado;
    }

    public Paquete() {
    }

    @Override
    public String toString() {
        return " ________________________________________________" +"\n"+
                "|Código Paquete     : " + codigo_paquete          +"\n"+
                "|Código Origen      : " + codigo_origen           + "\n"+
                "|Código Destino     : " + codigo_destino          + "\n"+
                "|Remitente          : " + cedula_remitente        + "\n"+
                "|Destinatatio       : " + cedula_destinatario     + "\n"+
                "|Estado             : " + estado                  + "\n"+
                "|________________________________________________";
    }
    public static Paquete parsePaquete(JSONObject paquete_json){

        String codigo_paquete =  (String) paquete_json.get("codigo_paquete");
        String codigo_origen = (String) paquete_json.get("codigo_origen");
        String codigo_destino = (String) paquete_json.get("codigo_destino");
        String cedula_remitente = (String) paquete_json.get("cedula_remitente");
        String cedula_destinatario = (String) paquete_json.get("cedula_destinatario");
        boolean estado = (boolean) paquete_json.get("estado");

        return new Paquete(codigo_paquete,codigo_origen,codigo_destino,cedula_remitente,cedula_destinatario,estado);
    }

    public  static  JSONObject parseJsonObjeto(Paquete paquete){
        JSONObject paqueteDatos = new JSONObject();
        paqueteDatos.put("codigo_paquete", paquete.codigo_paquete);
        paqueteDatos.put("codigo_origen",paquete.codigo_origen);
        paqueteDatos.put("codigo_destino", paquete.codigo_destino);
        paqueteDatos.put("cedula_remitente", paquete.cedula_remitente);
        paqueteDatos.put("cedula_destinatario",paquete.cedula_destinatario);
        paqueteDatos.put("estado", paquete.estado);

        return  paqueteDatos;
    }
}
