import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class Empleado {

    public String cedula;
    public String nombre;
    public String apellidos;
    public String correo;
    public String password;

    public Empleado(String cedula, String nombre, String apellidos, String correo, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return " ___________________________________________" +"\n"+
                "|Nombre      : " + nombre +"\n"+
                "|Apellido    : " + apellidos + "\n"+
                "|Cédula      : " + cedula + "\n"+
                "|Correo      : " + correo + "\n"+
                "|__________________________________________";
    }

    public static Empleado parseEmpleado(JSONObject empleado_json){

        String cedula =  (String) empleado_json.get("cedula");
        String nombre = (String) empleado_json.get("nombre");
        String apellidos = (String) empleado_json.get("apellidos");
        String password = (String) empleado_json.get("password");
        String correo = (String) empleado_json.get("correo");

        return new Empleado(cedula,nombre,apellidos,correo,password);
    }

    public  static  JSONObject parseJsonObjeto(Empleado empleado){
        JSONObject empleadoDatos = new JSONObject();
        empleadoDatos.put("cedula", empleado.cedula);
        empleadoDatos.put("nombre", empleado.nombre);
        empleadoDatos.put("apellidos", empleado.apellidos);
        empleadoDatos.put("correo", empleado.correo);
        empleadoDatos.put("password", empleado.password);

        return  empleadoDatos;
    }

    public static void ingresarDatos(Empleado empleado){
        Scanner input = new Scanner(System.in);
        System.out.print("Cédula:");
        empleado.cedula=input.next();
        System.out.print("Nombre:");
        empleado.nombre= input.next();
        System.out.print("Apellidos:");
        empleado.apellidos = input.next();
        System.out.print("Correo: ");
        empleado.correo = input.next();
        System.out.print("contraseña: ");
        empleado.password = input.next();
    }

    public static boolean cedulaValida(ArrayList<Empleado> empleados, Empleado empleado){
        boolean cedula_valida = true;
        for(Empleado empleado1 : empleados){
            if(empleado.cedula.equals(empleado1.cedula)){
                cedula_valida = false;
            }
        }
        return cedula_valida;
    }

    public static boolean correoValido(ArrayList<Empleado> empleados, Empleado empleado){
        boolean correo_valido = true;
        for(Empleado empleado1 : empleados){
            if(empleado.correo.equals(empleado1.correo)){
                correo_valido= false;
            }
        }
        return correo_valido;
    }

    public static Empleado buscarEmpleado(ArrayList<Empleado> empleados, String correo){
        for(Empleado empleado1 : empleados){
            if(empleado1.correo.equals(correo)){
                return empleado1;
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
