import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    public String cedula;
    public String nombre;
    public String apellidos;
    public String correo;
    public String password;
    ArrayList<Paquete> paquetes;

    public Cliente(String cedula, String nombre, String apellidos, String correo, String password, ArrayList<Paquete> paquetes) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        this.paquetes = paquetes;
    }
    public Cliente() {
    }
    public void setPaquetes(ArrayList<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        return " ___________________________________________" +"\n"+
                "|Nombre      : " + nombre +"\n"+
                "|Apellido    : " + apellidos + "\n"+
                "|Cédula      : " + cedula + "\n"+
                "|Correo      : " + correo + "\n"+
                "|# Paquetes  : " + paquetes.size() + "\n"+
                "|__________________________________________";
    }

    public static Cliente parseCliente(JSONObject cliente_json){

        String cedula =  (String) cliente_json.get("cedula");
        String nombre = (String) cliente_json.get("nombre");
        String apellidos = (String) cliente_json.get("apellidos");
        String password = (String) cliente_json.get("password");
        String correo = (String) cliente_json.get("correo");

        JSONArray paquetes_json = (JSONArray) cliente_json.get("paquetes");
        ArrayList<Paquete> paquetes = new ArrayList<>();
        for (Object paquete_objeto : paquetes_json){
            JSONObject paquete_json = (JSONObject) paquete_objeto;
            paquetes.add(Paquete.parsePaquete(paquete_json));
        }

        return new Cliente(cedula,nombre,apellidos,correo,password,paquetes);
    }

    public  static  JSONObject parseJsonObjeto(Cliente cliente){
        JSONObject clienteDatos = new JSONObject();
        clienteDatos.put("cedula", cliente.cedula);
        clienteDatos.put("nombre", cliente.nombre);
        clienteDatos.put("apellidos", cliente.apellidos);
        clienteDatos.put("correo", cliente.correo);
        clienteDatos.put("password", cliente.password);
        JSONArray paquetes_json = new JSONArray();
        for(Paquete paquete : cliente.paquetes){
            paquetes_json.add(Paquete.parseJsonObjeto(paquete));
        }
        clienteDatos.put("paquetes", paquetes_json);

        return  clienteDatos;
    }

    public static void ingresarDatos(Cliente cliente){
        Scanner input = new Scanner(System.in);
        System.out.print("Cédula:");
        cliente.cedula=input.next();
        System.out.print("Nombre:");
        cliente.nombre= input.next();
        System.out.print("Apellidos:");
        cliente.apellidos = input.next();
        System.out.print("Correo: ");
        cliente.correo = input.next();
        System.out.print("contraseña: ");
        cliente.password = input.next();

    }
    public static boolean cedulaValida(ArrayList<Cliente> clientes,Cliente cliente){
        boolean cedula_valida = true;
        for(Cliente cliente1 : clientes){
            if(cliente.cedula.equals(cliente1.cedula)){
                cedula_valida = false;
            }
        }
        return cedula_valida;
    }

    public static boolean correoValido(ArrayList<Cliente> clientes,Cliente cliente){
        boolean correo_valido = true;
        for(Cliente cliente1 : clientes){
            if(cliente.correo.equals(cliente1.correo)){
                correo_valido= false;
            }
        }
        return correo_valido;
    }

    public static Cliente buscarCliente(ArrayList<Cliente> clientes,String correo){
        for(Cliente cliente1 : clientes){
            if(cliente1.correo.equals(correo)){
                return cliente1;
            }
        }
        return null;
    }

    public static boolean passwordValida(ArrayList<Cliente> clientes,Cliente cliente){
        boolean passw_valida = true;
        for(Cliente cliente1 : clientes){
            if(cliente.password.equals(cliente1.password)){
                passw_valida= false;
            }
        }
        return passw_valida;
    }
}
