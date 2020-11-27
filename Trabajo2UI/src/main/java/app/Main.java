package app;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class Main {

    public static Graph<Object, DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);
    public static Hashtable<Integer, Empresa> misEmpresas = new Hashtable<>();
    public static Hashtable<Integer, Sedes> misSedes = new Hashtable<>();
    public static Hashtable<Integer, CentroLogistico> misCentroLogistico = new Hashtable<>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        misEmpresas.put(1, new Empresa(1, "coordinadora", 12345));
        misEmpresas.put(2, new Empresa(2, "envia", 12346));
        misEmpresas.put(3, new Empresa(3, "tcc", 12347));

        misSedes.put(10, new Sedes(10, "bogota", "bogota@coordinadora.com"));
        misSedes.put(11, new Sedes(11, "medellin", "medellin@envia.com"));
        misSedes.put(12, new Sedes(12, "cali", "cali@tcc.com"));

        misCentroLogistico.put(1, new CentroLogistico(1, "CLchapillin", "chapillin"));
        misCentroLogistico.put(2, new CentroLogistico(2, "CLlaureles", "laureles"));
        misCentroLogistico.put(4, new CentroLogistico(4, "CLpoblado", "poblado"));
        misCentroLogistico.put(3, new CentroLogistico(3, "CLlimonar", "limonar"));


        grafo.addVertex(misEmpresas.get(1));
        grafo.addVertex(misEmpresas.get(2));
        grafo.addVertex(misEmpresas.get(3));

        grafo.addVertex(misSedes.get(10));
        grafo.addVertex(misSedes.get(11));
        grafo.addVertex(misSedes.get(12));

        grafo.addVertex(misCentroLogistico.get(1));
        grafo.addVertex(misCentroLogistico.get(2));
        grafo.addVertex(misCentroLogistico.get(3));
        grafo.addVertex(misCentroLogistico.get(4));


        grafo.addEdge(misEmpresas.get(1), misSedes.get(10));
        grafo.addEdge(misEmpresas.get(2), misSedes.get(11));
        grafo.addEdge(misEmpresas.get(3), misSedes.get(12));

        grafo.addEdge(misSedes.get(10), misCentroLogistico.get(1));
        grafo.addEdge(misSedes.get(11), misCentroLogistico.get(2));
        grafo.addEdge(misSedes.get(11), misCentroLogistico.get(4));
        grafo.addEdge(misSedes.get(12), misCentroLogistico.get(3));


        grafo.addEdge(misCentroLogistico.get(2), misCentroLogistico.get(4));


        while (true) {
            crearNuevoVertice();
            //editarSede();
            //editarCentroLog();
            //editarEmpresa();
            borrarVertice();
            ArrayList<Object> vertices = new ArrayList<>(grafo.vertexSet());
            for (Object objeto : vertices) {
                System.out.println(objeto);
            }
            System.out.println();
            System.out.println("- - - - A - - - ");

            ArrayList<DefaultEdge> aristas = new ArrayList<>(grafo.edgeSet());
            for (DefaultEdge arista : aristas){
                System.out.println(arista);
            }

        }

    }

    public static void crearNuevoVertice() {
        System.out.println("Escriba el tipo de vertice que va a crear");
        System.out.println("1. Empresa");
        System.out.println("2. Sede");
        System.out.println("3. Centro Logistico");
        System.out.println("0. atras");
        int option = input.nextInt();

        if (option == 1) {
            int codigoEmpresa = input.nextInt();

            if (misEmpresas.containsKey(codigoEmpresa)){
                System.out.println("Ya existe una empresa con este codigo");
                return;
            }



            String nombreEmpresa = input.next();
            int numeroTelefono = input.nextInt();

            Empresa nuevaEmpresa = new Empresa(codigoEmpresa, nombreEmpresa, numeroTelefono);
            misEmpresas.put(codigoEmpresa, nuevaEmpresa);
            grafo.addVertex(nuevaEmpresa);


        } else if (option == 2) {
            int codigoSede = input.nextInt();

            if (misSedes.containsKey(codigoSede)){
                System.out.println("Ya existe una sede con este codigo");
                return;
            }

            String nombreSede = input.next();
            String correoSede = input.next();


            Sedes nuevaSede = new Sedes(codigoSede, nombreSede, correoSede);
            misSedes.put(codigoSede, nuevaSede);
            grafo.addVertex(nuevaSede);

        } else if (option == 3) {

            int codigoCentroLogistico = input.nextInt();

            String dirCLogistico = input.next();

            for (CentroLogistico cLogistico : misCentroLogistico.values()) {
                if (cLogistico.codigoCentroLogistico == codigoCentroLogistico) {
                    System.out.println("Ya existe un centro logistico con este codigo");
                    System.out.println();
                    return;
                } else if (cLogistico.direccionCentroLogistico.equals(dirCLogistico)) {
                    System.out.println("Ya existe un centro logistico con esta direccion");
                    System.out.println();
                    return;
                }
            }
            String nombreCLogistico = input.next();

            CentroLogistico nuevoCLogistico = new CentroLogistico(codigoCentroLogistico, nombreCLogistico, dirCLogistico);
            misCentroLogistico.put(codigoCentroLogistico, nuevoCLogistico);
            grafo.addVertex(nuevoCLogistico);

        } else if (option == 0) {
            return;
        }
    }

    public static void borrarVertice() {

        //MI REY, ESTO TODAVIA NO FUNCIONA +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        System.out.println("Escriba el tipo de vertice que va a borrar");
        System.out.println("1. Empresa");
        System.out.println("2. Sede");
        System.out.println("3. Centro Logistico");
        System.out.println("0. atras");

        int option = input.nextInt();

        if (option == 1) {
            int codigoEmpresa = input.nextInt();

            if(!misEmpresas.containsKey(codigoEmpresa)){
                System.out.println("No existe una empresa con este codigo");
            }

            misEmpresas.remove(codigoEmpresa);
            ArrayList<Object> empresasSinEnlaces = new ArrayList<>(grafo.vertexSet());
            empresasSinEnlaces.remove(misEmpresas.get(codigoEmpresa));


        } else if (option == 2) {

            int codigoSede = input.nextInt();

            if(!misSedes.containsKey(codigoSede)){
                System.out.println("No existe una sede con este codigo");
            }

            misSedes.remove(codigoSede);
            grafo.removeVertex(misSedes.get(codigoSede));

        } else if (option == 3) {

            int codigoCentro = input.nextInt();

            if(!misCentroLogistico.containsKey(codigoCentro)){
                System.out.println("No existe una centro con este codigo");
            }

            misCentroLogistico.remove(codigoCentro);
            grafo.removeVertex(misCentroLogistico.get(codigoCentro));

        } else if (option == 0) {
            return;
        }
    }



    public static void editarEmpresa() {
        label:
        while (true) {
            System.out.println("Edición empresa");
            System.out.println("1. Seleccionar por Nombre");
            System.out.println("2. Seleccionar por Código");
            System.out.println("0. Atrás");
            String opcion = input.next();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre de la Empresa : "); // Editar por nombre de la empresa

                    String nombre = input.next();
                    for (Empresa empresa : misEmpresas.values()) {
                        if (empresa.nombreDelaEmpresa.equalsIgnoreCase(nombre)) {
                            cambiarDatosEmpresa(empresa);
                            return;
                        }
                    }
                    System.out.println("No existe empresa con ese nombre");
                    break;
                case "2":  // editar por Código
                    System.out.print("Código de la Empresa : "); // Editar por código de la empresa

                    Integer codigo = input.nextInt();
                    for (Empresa empresa : misEmpresas.values()) {
                        if (empresa.codigoEmpresa == codigo) {
                            //cambiarDatosEmpresa(empresa);
                            //editarConexionEmpresa_Sede(empresa);
                            borrarConexionEmpresa(empresa);
                            return;
                        }
                    }
                    System.out.println("No hay empresas registradas con ese Código");
                    break;
                case "0":
                    break label;
            }
        }

    }

    public static void cambiarDatosEmpresa(Empresa empresa) {
        System.out.println("Nombre: " + empresa.nombreDelaEmpresa);
        System.out.println("¿Quiere cambiar el nombre? Ingrese Y o N");
        String eleccion1 = input.next();
        if (eleccion1.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo nombre:");
            empresa.nombreDelaEmpresa = input.next();
        }
        System.out.println("Código: " + empresa.codigoEmpresa);
        System.out.println("¿Quiere cambiar el Código? Ingrese Y o N");
        String eleccion2 = input.next();
        if (eleccion2.equalsIgnoreCase("Y")) {
            misEmpresas.remove(empresa.codigoEmpresa);
            System.out.print("Nuevo Código:");
            empresa.codigoEmpresa = input.nextInt();
            Integer nuevoCodigo = empresa.codigoEmpresa;
            misEmpresas.put(nuevoCodigo, new Empresa(empresa.codigoEmpresa, empresa.nombreDelaEmpresa, empresa.numeroTelefonico));
        }
        System.out.println("Teléfono: " + empresa.numeroTelefonico);
        System.out.println("¿Quiere cambiar el Teléfono? Ingrese Y o N");
        String eleccion3 = input.next();
        if (eleccion3.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo Teléfono:");
            empresa.numeroTelefonico = input.nextInt();
            misEmpresas.put(empresa.codigoEmpresa, new Empresa(empresa.codigoEmpresa, empresa.nombreDelaEmpresa, empresa.numeroTelefonico));
        }
        System.out.println("¡CAMBIOS REALIZADOS CON ÉXITO!");
        System.out.println(misEmpresas);

        System.out.println("- - - V - - - ");
        ArrayList<Object> vertices = new ArrayList<>(grafo.vertexSet());
        for (Object objeto : vertices) {
            System.out.println(objeto);
        }
        System.out.println();
        System.out.println("- - - - A - - - ");

        ArrayList<DefaultEdge> aristas = new ArrayList<>(grafo.edgeSet());
        for (DefaultEdge arista : aristas) {
            System.out.println(arista);
        }
    }

    public static void editarConexionEmpresa_Sede(Empresa origen) {
        System.out.println();
        System.out.println("Editar relaciones");

        ArrayList<Object> empresasSinEnlaces = new ArrayList<>(grafo.vertexSet());
        empresasSinEnlaces.remove(origen);

//      Llamo la lista de centros log adyacentes a sede origen
        ArrayList<Object> empresasAdyacentes = new ArrayList<>(Graphs.neighborListOf(grafo, origen));

//      Compruebo que sí hay estaciones adyacentes
        if (empresasAdyacentes.size() == 0) {
            System.out.println("No hay conexiones adyacentes para la sede " + origen);
        }

        for (Object centro : empresasAdyacentes) {
            empresasSinEnlaces.remove(centro);
        }

//      Selecciono uno de los centros adyacentes
        System.out.println("Centros adyacentes sin enlace para editar conexión");
        for (int i = 0; i < empresasSinEnlaces.size(); i++) {
            if (misSedes.contains(empresasSinEnlaces.get(i))) {
                System.out.println(i + 1 + ", " + empresasSinEnlaces.get(i));
            }
        }
        System.out.println("Ingrece el índice del menú correspondiente al centro log, -1 para cancelar");
        int indice = input.nextInt();

        if (indice <= empresasSinEnlaces.size() && indice > 0) {
            Object destino = empresasSinEnlaces.get(indice - 1);
            grafo.addEdge(origen, destino);
        }

        System.out.println();
        System.out.println("- - - - A - - - ");

        ArrayList<DefaultEdge> aristas = new ArrayList<>(grafo.edgeSet());
        for (DefaultEdge arista : aristas) {
            System.out.println(arista);
        }
    }

    public static void borrarConexionEmpresa(Empresa origen) {

        System.out.println();
        System.out.println("Editar relaciones");


//      Llamo la lista de centros log adyacentes a sede origen
        ArrayList<Object> empresasAdyacentes = new ArrayList<>(Graphs.neighborListOf(grafo, origen));

//      Compruebo que sí hay estaciones adyacentes
        if (empresasAdyacentes.size() == 0) {
            System.out.println("No hay conexiones adyacentes para la sede " + origen);
        }


//      Selecciono uno de los centros adyacentes
        System.out.println("Sedes adyacentes con enlace para borrar conexión");
        for (int i = 0; i < empresasAdyacentes.size(); i++) {
            System.out.println(i + 1 + ", " + empresasAdyacentes.get(i));
        }

        System.out.println("Ingrece el índice del menú correspondiente a la conexion a eliminar, -1 para cancelar");
        int indice = input.nextInt();

        if (indice <= empresasAdyacentes.size() && indice > 0) {
            Object destino = empresasAdyacentes.get(indice - 1);
            grafo.removeEdge(origen, destino);
        }

        System.out.println();
        System.out.println("- - - - A - - - ");

        ArrayList<DefaultEdge> aristas = new ArrayList<>(grafo.edgeSet());
        for (DefaultEdge arista : aristas) {
            System.out.println(arista);
        }
    }


    public static void editarSede() {
        label:
        while (true) {
            System.out.println("Edición Sede");
            System.out.println("1. Seleccionar por Nombre");
            System.out.println("2. Seleccionar por Código");
            System.out.println("0. Atrás");
            String opcion = input.next();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre de la Sede : "); // Editar por nombre de la sede

                    String nombre = input.next();
                    for (Sedes sede : misSedes.values()) {
                        if (sede.nombreSede.equalsIgnoreCase(nombre)) {
                           //cambiarDatosSede(sede);
                            //editarConexionSede_Centro(sede);
                            //editarConexionSede_Empresa(sede);
                            //borrarConexionSede(sede);
                            return;
                        }
                    }
                    System.out.println("No existe sede con ese nombre");
                    break;
                case "2":  // editar por Código
                    System.out.print("Código de la sede : "); // Editar por código de la sede

                    Integer codigo = input.nextInt();
                    for (Sedes sede : misSedes.values()) {
                        if (sede.codigoSede == codigo) {
                            cambiarDatosSede(sede);
                            editarConexionSede_Centro(sede);
                            return;
                        }
                    }
                    System.out.println("No hay sedes registradas con ese código");
                    break;
                case "0":
                    break label;
            }
        }

    }

    public static void cambiarDatosSede(Sedes sedes) {
        System.out.println("Nombre: " + sedes.nombreSede);
        System.out.println("¿Quiere cambiar el nombre? Ingrese Y o N");
        String eleccion1 = input.next();
        if (eleccion1.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo nombre:");
            sedes.nombreSede = input.next();
        }
        System.out.println("Código: " + sedes.codigoSede);
        System.out.println("¿Quiere cambiar el Código? Ingrese Y o N");
        String eleccion2 = input.next();
        if (eleccion2.equalsIgnoreCase("Y")) {
            misSedes.remove("" + sedes.codigoSede);
            System.out.print("Nuevo código:");
            sedes.codigoSede = input.nextInt();
            Integer nuevoCodigo = sedes.codigoSede;
            misSedes.put(nuevoCodigo, new Sedes(sedes.codigoSede, sedes.nombreSede, sedes.correoSede));
        }
        System.out.println("Correo: " + sedes.correoSede);
        System.out.println("¿Quiere cambiar el Correo? Ingrese Y o N");
        String eleccion3 = input.next();
        if (eleccion3.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo Correo:");
            sedes.correoSede = input.next();
            misSedes.put(sedes.codigoSede, new Sedes(sedes.codigoSede, sedes.nombreSede, sedes.correoSede));
        }
        System.out.println("¡CAMBIOS REALIZADOS CON ÉXITO!");
        System.out.println(misSedes);
    }


    public static void editarConexionSede_Centro(Sedes origen) {
        System.out.println();
        System.out.println("Editar relaciones");

        ArrayList<Object> centrosSinEnlace = new ArrayList<>(grafo.vertexSet());
        centrosSinEnlace.remove(origen);

//      Llamo la lista de centros log adyacentes a sede origen
        ArrayList<Object> centrosAdyacentes = new ArrayList<>(Graphs.neighborListOf(grafo, origen));

//      Compruebo que sí hay estaciones adyacentes
        if (centrosAdyacentes.size() == 0) {
            System.out.println("No hay conexiones adyacentes para la sede " + origen);
        }

        for (Object centro : centrosAdyacentes) {
            centrosSinEnlace.remove(centro);
        }

//      Selecciono uno de los centros adyacentes
        System.out.println("Centros adyacentes sin enlace para editar conexión");
        for (int i = 0; i < centrosSinEnlace.size(); i++) {
            if (misCentroLogistico.contains(centrosSinEnlace.get(i))) {
                System.out.println(i + 1 + ", " + centrosSinEnlace.get(i));
            }
        }
        System.out.println("Ingrece el índice del menú correspondiente al centro log, -1 para cancelar");
        int indice = input.nextInt();

        if (indice <= centrosSinEnlace.size() && indice > 0) {
            Object destino = centrosSinEnlace.get(indice - 1);
            grafo.addEdge(origen, destino);
        }

        System.out.println();
        System.out.println("- - - - A - - - ");

        ArrayList<DefaultEdge> aristas = new ArrayList<>(grafo.edgeSet());
        for (DefaultEdge arista : aristas) {
            System.out.println(arista);
        }
    }

    public static void editarConexionSede_Empresa(Sedes origen) {

        System.out.println();
        System.out.println("Editar relaciones");

        ArrayList<Object> empresasSinEnlace = new ArrayList<>(grafo.vertexSet());
        empresasSinEnlace.remove(origen);

//      Llamo la lista de centros log adyacentes a sede origen
        ArrayList<Object> empresasAdyacentes = new ArrayList<>(Graphs.neighborListOf(grafo, origen));

//      Compruebo que sí hay estaciones adyacentes
        if (empresasAdyacentes.size() == 0) {
            System.out.println("No hay conexiones adyacentes para la empresa " + origen);
        }

        for (Object centro : empresasAdyacentes) {
            empresasSinEnlace.remove(centro);
        }

//      Selecciono uno de los centros adyacentes
        System.out.println("Empresas adyacentes sin enlace para editar conexión");
        for (int i = 0; i < empresasSinEnlace.size(); i++) {
            if (misEmpresas.contains(empresasSinEnlace.get(i))) {
                System.out.println(i + 1 + ", " + empresasSinEnlace.get(i));
            }
        }
        System.out.println("Ingrece el índice del menú correspondiente a la empresa, -1 para cancelar");
        int indice = input.nextInt();

        if (indice <= empresasSinEnlace.size() && indice > 0) {
            Object destino = empresasSinEnlace.get(indice - 1);
            grafo.addEdge(origen, destino);
        }

        System.out.println();
        System.out.println("- - - - A - - - ");

        ArrayList<DefaultEdge> aristas = new ArrayList<>(grafo.edgeSet());
        for (DefaultEdge arista : aristas) {
            System.out.println(arista);
        }
    }

    public static void borrarConexionSede(Sedes origen) {

        System.out.println();
        System.out.println("Editar relaciones");


//      Llamo la lista de centros log adyacentes a sede origen
        ArrayList<Object> sedesAdyacentes = new ArrayList<>(Graphs.neighborListOf(grafo, origen));

//      Compruebo que sí hay estaciones adyacentes
        if (sedesAdyacentes.size() == 0) {
            System.out.println("No hay conexiones adyacentes para la sede " + origen);
        }


//      Selecciono uno de los centros adyacentes
        System.out.println("Sedes adyacentes con enlace para borrar conexión");
        for (int i = 0; i < sedesAdyacentes.size(); i++) {
               System.out.println(i + 1 + ", " + sedesAdyacentes.get(i));
        }

        System.out.println("Ingrece el índice del menú correspondiente a la conexion a eliminar, -1 para cancelar");
        int indice = input.nextInt();

        if (indice <= sedesAdyacentes.size() && indice > 0) {
            Object destino = sedesAdyacentes.get(indice - 1);
            grafo.removeEdge(origen, destino);
        }

        System.out.println();
        System.out.println("- - - - A - - - ");

        ArrayList<DefaultEdge> aristas = new ArrayList<>(grafo.edgeSet());
        for (DefaultEdge arista : aristas) {
            System.out.println(arista);
        }
    }



    public static void editarCentroLog() {
        label:
        while (true) {
            System.out.println("Edición Centro Logístico");
            System.out.println("1. Seleccionar por Nombre");
            System.out.println("2. Seleccionar por Código");
            System.out.println("0. Atrás");
            String opcion = input.next();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del Centro Logístico : "); // Editar por nombre del Centro Logístico

                    String nombre = input.next();
                    for (CentroLogistico centro : misCentroLogistico.values()) {
                        if (centro.nombreCentroLogistico.equalsIgnoreCase(nombre)) {
                            //cambiarDatosCentroLog(centro);
                            //editarConexionCentroL_CentroL(centro);
                            //editarConexionCentro_Sede(centro);
                            borrarConexionCentro(centro);
                            return;
                        }
                    }
                    System.out.println("No existe centro logístico con ese nombre");
                    break;
                case "2":  // editar por Código
                    System.out.print("Código del centro logístico : "); // Editar por código del centro logístico

                    Integer codigo = input.nextInt();
                    for (CentroLogistico centro : misCentroLogistico.values()) {
                        if (centro.codigoCentroLogistico == codigo) {
                            cambiarDatosCentroLog(centro);
                            return;
                        }
                    }
                    System.out.println("No hay centros logísticos registrados con ese código");
                    break;
                case "0":
                    break label;
            }
        }

    }

    public static void cambiarDatosCentroLog(CentroLogistico centro) {
        System.out.println("Nombre: " + centro.nombreCentroLogistico);
        System.out.println("¿Quiere cambiar el nombre? Ingrese Y o N");
        String eleccion1 = input.next();
        if (eleccion1.equalsIgnoreCase("Y")) {
            System.out.print("Nuevo nombre:");
            centro.nombreCentroLogistico = input.next();
        }
        System.out.println("Código: " + centro.codigoCentroLogistico);
        System.out.println("¿Quiere cambiar el Código? Ingrese Y o N");
        String eleccion2 = input.next();
        if (eleccion2.equalsIgnoreCase("Y")) {
            misCentroLogistico.remove(centro.codigoCentroLogistico);
            System.out.print("Nuevo código:");
            centro.codigoCentroLogistico = input.nextInt();
            Integer nuevoCodigo = centro.codigoCentroLogistico;
            misCentroLogistico.put(nuevoCodigo, new CentroLogistico(centro.codigoCentroLogistico, centro.nombreCentroLogistico, centro.direccionCentroLogistico));
        }
        System.out.println("Dirección: " + centro.direccionCentroLogistico);
        System.out.println("¿Quiere cambiar la Dirección? Ingrese Y o N");
        String eleccion3 = input.next();
        if (eleccion3.equalsIgnoreCase("Y")) {
            System.out.print("Nueva dirección:");
            centro.direccionCentroLogistico = input.next();
            misCentroLogistico.put(centro.codigoCentroLogistico, new CentroLogistico(centro.codigoCentroLogistico, centro.nombreCentroLogistico, centro.direccionCentroLogistico));
        }
        System.out.println("¡CAMBIOS REALIZADOS CON ÉXITO!");
        System.out.println(misCentroLogistico);

    }

    public static void editarConexionCentroL_CentroL(CentroLogistico origen) {
        System.out.println();
        System.out.println("Editar relaciones");

        ArrayList<Object> centrosSinEnlace = new ArrayList<>(grafo.vertexSet());
        centrosSinEnlace.remove(origen);

//      Llamo la lista de centros log adyacentes a sede origen
        ArrayList<Object> centrosAdyacentes = new ArrayList<>(Graphs.neighborListOf(grafo, origen));

//      Compruebo que sí hay estaciones adyacentes
        if (centrosAdyacentes.size() == 0) {
            System.out.println("No hay conexiones mi rey " + origen);
        }

        for (Object centro : centrosAdyacentes) {
            centrosSinEnlace.remove(centro);
        }

//      Selecciono uno de los centros adyacentes
        System.out.println("Centros adyacentes sin enlace para editar conexión");
        for (int i = 0; i < centrosSinEnlace.size(); i++) {
            if (misCentroLogistico.contains(centrosSinEnlace.get(i))) {
                System.out.println(i + 1 + ", " + centrosSinEnlace.get(i));
            }
        }
        System.out.println("Ingrece el índice del menú correspondiente al centro log, -1 para cancelar");
        int indice = input.nextInt();

        if (indice <= centrosSinEnlace.size() && indice > 0) {
            Object destino = centrosSinEnlace.get(indice - 1);
            grafo.addEdge(origen, destino);
        }

        System.out.println();
        System.out.println("- - - - A - - - ");

        ArrayList<DefaultEdge> aristas = new ArrayList<>(grafo.edgeSet());
        for (DefaultEdge arista : aristas) {
            System.out.println(arista);
        }
    }

    public static void editarConexionCentro_Sede(CentroLogistico origen) {
        System.out.println();
        System.out.println("Editar relaciones");

        ArrayList<Object> centrosSinEnlace = new ArrayList<>(grafo.vertexSet());
        centrosSinEnlace.remove(origen);

//      Llamo la lista de centros log adyacentes a sede origen
        ArrayList<Object> centrosAdyacentes = new ArrayList<>(Graphs.neighborListOf(grafo, origen));

//      Compruebo que sí hay estaciones adyacentes
        if (centrosAdyacentes.size() == 0) {
            System.out.println("No hay conexiones adyacentes para la sede " + origen);
        }

        for (Object centro : centrosAdyacentes) {
            centrosSinEnlace.remove(centro);
        }

//      Selecciono uno de los centros adyacentes
        System.out.println("Centros adyacentes sin enlace para editar conexión");
        for (int i = 0; i < centrosSinEnlace.size(); i++) {
            if (misSedes.contains(centrosSinEnlace.get(i))) {
                System.out.println(i + 1 + ", " + centrosSinEnlace.get(i));
            }
        }
        System.out.println("Ingrece el índice del menú correspondiente al centro log, -1 para cancelar");
        int indice = input.nextInt();

        if (indice <= centrosSinEnlace.size() && indice > 0) {
            Object destino = centrosSinEnlace.get(indice - 1);
            grafo.addEdge(origen, destino);
        }

        System.out.println();
        System.out.println("- - - - A - - - ");

        ArrayList<DefaultEdge> aristas = new ArrayList<>(grafo.edgeSet());
        for (DefaultEdge arista : aristas) {
            System.out.println(arista);
        }
    }

    public static void borrarConexionCentro(CentroLogistico origen) {

        System.out.println();
        System.out.println("Editar relaciones");


//      Llamo la lista de centros log adyacentes a sede origen
        ArrayList<Object> centrosAdyacentes = new ArrayList<>(Graphs.neighborListOf(grafo, origen));

//      Compruebo que sí hay estaciones adyacentes
        if (centrosAdyacentes.size() == 0) {
            System.out.println("No hay conexiones adyacentes para la sede " + origen);
        }


//      Selecciono uno de los centros adyacentes
        System.out.println("Sedes adyacentes con enlace para borrar conexión");
        for (int i = 0; i < centrosAdyacentes.size(); i++) {
            System.out.println(i + 1 + ", " + centrosAdyacentes.get(i));
        }

        System.out.println("Ingrece el índice del menú correspondiente a la conexion a eliminar, -1 para cancelar");
        int indice = input.nextInt();

        if (indice <= centrosAdyacentes.size() && indice > 0) {
            Object destino = centrosAdyacentes.get(indice - 1);
            grafo.removeEdge(origen, destino);
        }

        System.out.println();
        System.out.println("- - - - A - - - ");

        ArrayList<DefaultEdge> aristas = new ArrayList<>(grafo.edgeSet());
        for (DefaultEdge arista : aristas) {
            System.out.println(arista);
        }
    }


}
