import org.json.simple.JSONObject;

class Empleado {

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
}
