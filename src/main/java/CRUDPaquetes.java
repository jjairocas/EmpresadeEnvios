import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class CRUDPaquetes {

    public static ArrayList<Paquete> paquetes = CargarDatos.cargarPaquetes();
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Cliente> clientes = CargarDatos.cargarClientes();

    public static void verPaquetes(){
        System.out.println("LISTADO DE PAQUETES: ");
        for(Paquete paquete : paquetes){
            System.out.println(paquete);
        }
    }

    public static void crearPaquetes(){
        System.out.println("Codigo del paquete: ");
        String codigoPaquete = input.next();
        for(Paquete paquete: paquetes){
            if(paquete.codigo_paquete.equalsIgnoreCase(codigoPaquete)){
                System.out.println("Lo sentimos, ya existe un paquete con este codigo");
                return;
            }
        }
        System.out.println("Codigo origen: ");
        String codigoOrigen = input.next();

        System.out.println("Codigo Destino: ");
        String codigoDestino = input.next();

        System.out.println("Cedula remitente: ");
        String cedulaRemitente = input.next();

        for(Paquete paquete: paquetes){
            if(paquete.cedula_remitente.equalsIgnoreCase(cedulaRemitente)){
                System.out.println("Lo sentimos, no existe un cliente con esta cedula");
                return;
            }
        }

        /*System.out.println("Cedula destinatario: ");*/
        String cedulaDestinatario = null;

        /*for(Paquete paquete: paquetes){
            if(paquete.cedula_destinatario.equalsIgnoreCase(cedulaDestinatario)){
                System.out.println("Lo sentimos, no existe un cliente con esta cedula");
                return;
            }
        }*/

        Boolean estado = false;

        Paquete paquete = new Paquete(codigoPaquete,codigoOrigen,codigoDestino,cedulaRemitente,cedulaDestinatario,estado);
        paquetes.add(paquete);
    }

    public static void borrarPaquete(){

        System.out.println("Codigo del paquete: ");
        String codigoPaquete = input.next();
        for(Paquete paquete: paquetes){
            if(paquete.codigo_paquete.equalsIgnoreCase(codigoPaquete)){
                confirmarEliminacion(paquete);
                return;
            }
        }
        System.out.println("No existe paquete con este codigo");
    }

    public static void confirmarEliminacion(Paquete paquete){
        System.out.println("Quiere eliminar este paquete? Ingrese Y O N");
        String eleccion1 = input.next();
        if(eleccion1.equalsIgnoreCase("Y")){
            paquetes.remove(paquete);
            System.out.println("Paquete eliminado");
        }
    }

    public static void editarPaquete(){
        System.out.print("Escriba el codigo del paquete que desea modificar: ");
        String codigo = input.next();
        for(Paquete paquete:paquetes){
            if (paquete.codigo_paquete.equals(codigo)){
                cambiarDatos(paquete);
                return;
            }
        }
        System.out.println("No existe paquete con este codigo");
    }

    public static void cambiarDatos(Paquete paquete){
        System.out.println("Codigo: " + paquete.codigo_paquete);
        System.out.println("Desea cambiar el codigo del paquete? Y o N");
        String eleccion1 = input.next();
        if(eleccion1.equalsIgnoreCase("Y")){
            System.out.println("Nuevo codigo:");
            paquete.codigo_paquete = input.next();
        }

        System.out.println("Codigo origen: " + paquete.codigo_origen);
        System.out.println("Desea cambiar el codigo origen? Y o N");
        String eleccion2 = input.next();
        if(eleccion2.equalsIgnoreCase("Y")){
            System.out.println("Nuevo codigo origen:");
            paquete.codigo_origen = input.next();
        }

        /*System.out.println("Codigo Destino: " + paquete.codigo_destino);
        System.out.println("Desea cambiar el codigo destino? Y o N");
        String eleccion3 = input.next();
        if(eleccion3.equalsIgnoreCase("Y")){
            System.out.println("Nuevo codigo destino:");
            paquete.codigo_destino = input.next();
        }*/

        System.out.println("Cedula del remitente " + paquete.cedula_remitente);
        System.out.println("¿Quiere cambiar la cedula del remitente? Ingrese Y o N");
        String eleccion4 = input.next();
        if(eleccion4.equalsIgnoreCase("Y")){
            System.out.println("Nueva cedula remitente: ");
            String cedula = input.next();

            for(Cliente cliente: clientes){
                if(cliente.cedula.equalsIgnoreCase(cedula)){
                    cliente.cedula = cedula;
                    System.out.println("Los cambios se realizaron con exito");
                    return;
                }
            }
            System.out.println("Lo sentimos, no existe una persona con esta cedula");
        }

    }


}
