import java.util.ArrayList;
import java.util.Scanner;

public class Registro {

    public static ArrayList<Cliente> clientes = CargarDatos.cargarClientes();

    public static void registrarse(){
        // opción válida sólo para clientes  nuevos

        System.out.println("¡Hola , registra tus datos por favor");
        Cliente cliente = new Cliente();
        Cliente.ingresarDatos(cliente);
        if(!clientes.isEmpty()){
            if (Cliente.cedulaValida(clientes,cliente)) {
                if(Cliente.correoValido(clientes,cliente)){
                    System.out.println("¡REGISTRO EXITOSO!, BIENVENID@");
                    GuardarDatos.guardarCliente(cliente);
                }
                else {
                    System.out.println("Ya existe un cliente registrado con ese correo");
                }
            }
            else {
                System.out.println("Ya existe un cliente con esa cédula");
            }
        }
        else {
            System.out.println("¡REGISTRO EXITOSO!, BIENVENIDO");
            GuardarDatos.guardarCliente(cliente);
        }
    }
}
