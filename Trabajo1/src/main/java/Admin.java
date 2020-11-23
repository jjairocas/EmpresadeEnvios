import org.json.simple.JSONObject;


public class Admin {

    public String cedula;
    public String nombre;
    public String apellidos;
    public String correo;
    public String password;

    public Admin(String cedula, String nombre, String apellidos, String correo, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
    }
   public static Admin parseAdmin(JSONObject admin_json){

       String cedula =  (String) admin_json.get("cedula");
       String nombre = (String) admin_json.get("nombre");
       String apellidos = (String) admin_json.get("apellidos");
       String password = (String) admin_json.get("password");
       String correo = (String) admin_json.get("correo");

       return new Admin(cedula,nombre,apellidos,correo,password);
   }

    public  static  JSONObject parseJsonObjeto(Admin admmin){
        JSONObject adminDatos = new JSONObject();
        adminDatos.put("cedula", admmin.cedula);
        adminDatos.put("nombre", admmin.nombre);
        adminDatos.put("apellidos", admmin.apellidos);
        adminDatos.put("correo", admmin.correo);
        adminDatos.put("password", admmin.password);

        return  adminDatos;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
