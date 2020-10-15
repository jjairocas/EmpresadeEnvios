import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class CRUDPaquetes {

    public static ArrayList<Paquete> paquetes = CargarDatos.cargarPaquetes();
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Cliente> clientes = CargarDatos.cargarClientes();
    public static ArrayList<C_logistico> centros_logisticos = CRUDCentrosLog.centros_logisticos;
    public static ArrayList<EmpresaEnvio> empresas = CRUDEmpresas.empresas;
    public static ArrayList<Sede> sedes = CRUDSedes.sedes;
    public static ArrayList<P_atencion> puntos_atencion = CRUDPuntosAtencion.puntos_atencion;

    public static void verPaquetes(){
        System.out.println("LISTADO DE PAQUETES: ");
        for(Paquete paquete : paquetes){
            System.out.println(paquete);
        }
    }

    public static void crearPaquetes() {

        System.out.println("Codigo del paquete: ");
        String codigoPaquete = input.next();
        for (Paquete paquete : paquetes) {
            if (paquete.codigo_paquete.equalsIgnoreCase(codigoPaquete)) {
                System.out.println("Lo sentimos, ya existe un paquete con este codigo");
                return;
            }
        }

        for (P_atencion punto : puntos_atencion) {
            System.out.println(punto);
        }

        System.out.println("Ingrese el codigo del punto de atencion origen");
        String codigoOrigen = input.next();


        boolean existeOrigen = false;
        boolean existeCedulaRemitente = false;
        String cedulaRemitente = null;


        for (P_atencion punto : puntos_atencion) {
            if (punto.codigo.equalsIgnoreCase(codigoOrigen)) {

                System.out.println("Lista clientes en el punto de atencion");
                for (Cliente cliente : punto.clientes) {
                    System.out.println(cliente);
                }

                System.out.println("Ingrese la cedula del remitente: ");
                cedulaRemitente = input.next();

                for (Cliente cliente : clientes) {
                    if (cliente.cedula.equalsIgnoreCase(cedulaRemitente)) {
                        existeCedulaRemitente = true;
                        break;
                    }
                }

                existeOrigen = true;
                break;
            }
        }
        if (!existeOrigen) {
            System.out.println("No existe un punto de atencion con este codigo");
        } else if (!existeCedulaRemitente)
            System.out.println("No existe un cliente con esta cedula");
        else {

            System.out.println("Ingrese el codigo del punto de atencion destino");
            String codigoPuntoAtencionDestino = input.next();


            for (P_atencion puntoDestino : puntos_atencion) {
                if (puntoDestino.codigo.equalsIgnoreCase(codigoPuntoAtencionDestino)) {
                    String codigoDestino = puntoDestino.codigo;


                    System.out.println("Lista clientes en el punto de atencion");
                    for (Cliente cliente : puntoDestino.clientes) {
                        System.out.println(cliente);
                    }



                    System.out.println("Cedula destinatario: ");
                    String cedulaDestinatario = input.next();

                    for (Cliente cliente1 : puntoDestino.clientes) {
                        if (cliente1.cedula.equalsIgnoreCase(cedulaDestinatario)) {
                            boolean estado = false;
                            Paquete nuevoPaquete = new Paquete(codigoPaquete, codigoOrigen, codigoDestino, cedulaRemitente, cedulaDestinatario, estado);
                            paquetes.add(nuevoPaquete);

                            for (P_atencion puntoDeAtencion : puntos_atencion) {
                                if (puntoDeAtencion.codigo.equalsIgnoreCase(codigoOrigen)) {
                                    puntoDeAtencion.paquetes_por_enviar.add(nuevoPaquete);


                                    for(P_atencion punto : puntos_atencion){
                                        if(punto.codigo.equalsIgnoreCase(codigoOrigen)){
                                            punto.paquetes_por_enviar.add(nuevoPaquete);
                                            return;
                                        }
                                    }


                                    for(C_logistico Clogistico: centros_logisticos){
                                        for(P_atencion punto: Clogistico.puntos_atencion){
                                            if(punto.codigo.equalsIgnoreCase(codigoOrigen)){
                                                punto.paquetes_por_enviar.add(nuevoPaquete);
                                                return;
                                            }
                                        }
                                    }


                                    for (Sede sede: sedes){
                                        for (C_logistico cLogistico: sede.centros_logisticos){
                                            for (P_atencion punto: cLogistico.puntos_atencion){
                                                if(punto.codigo.equalsIgnoreCase(codigoOrigen)){
                                                    punto.paquetes_por_enviar.add(nuevoPaquete);
                                                    return;
                                                }
                                            }
                                        }
                                    }

                                    for (EmpresaEnvio empresa : empresas) {
                                        for (Sede sede : empresa.sedes) {
                                            for (C_logistico centroLogistico : sede.centros_logisticos) {
                                                for (P_atencion puntoAtencion : centroLogistico.puntos_atencion) {
                                                    if (puntoAtencion.codigo.equalsIgnoreCase(codigoOrigen)) {
                                                        puntoAtencion.paquetes_por_enviar.add(nuevoPaquete);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    System.out.println("Se han agregado los datos correctamente");
                                    return;
                                }
                            }
                        }
                    }
                    System.out.println("No existe un cliente con esta cedula");


                }
            }
            System.out.println("No existe un punto de atencion con este codigo");



        }


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
