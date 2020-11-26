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

    public static void main(String[] args){

        misEmpresas.put(1, new Empresa(1,"coordinadora",12345));
        misEmpresas.put(2, new Empresa(2,"envia",12346));
        misEmpresas.put(3, new Empresa(3,"tcc",12347));

        misSedes.put(10, new Sedes(10,"bogota","bogota@coordinadora.com"));
        misSedes.put(11, new Sedes(11,"medellin","medellin@envia.com"));
        misSedes.put(12, new Sedes(12,"cali","cali@tcc.com"));

        misCentroLogistico.put(1, new CentroLogistico(1, "CLchapillin","chapillin"));
        misCentroLogistico.put(2, new CentroLogistico(2, "CLlaureles","laureles"));
        misCentroLogistico.put(4, new CentroLogistico(4, "CLpoblado","poblado"));
        misCentroLogistico.put(3, new CentroLogistico(3, "CLlimonar","limonar"));


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

        

        grafo.addEdge(misEmpresas.get(1),misSedes.get(10));
        grafo.addEdge(misEmpresas.get(2),misSedes.get(11));
        grafo.addEdge(misEmpresas.get(3),misSedes.get(12));

        grafo.addEdge(misSedes.get(10),misCentroLogistico.get(1));
        grafo.addEdge(misSedes.get(11),misCentroLogistico.get(2));
        grafo.addEdge(misSedes.get(11),misCentroLogistico.get(4));
        grafo.addEdge(misSedes.get(12),misCentroLogistico.get(3));

        grafo.addEdge(misCentroLogistico.get(2), misCentroLogistico.get(4));



        while(true){
            crearNuevoVertice();
            System.out.println("- - - V - - - ");
            ArrayList<Object> vertices = new ArrayList<>(grafo.vertexSet());
            for (Object objeto : vertices){
                System.out.println(objeto);
            }
        }


    }

    public static void crearNuevoVertice(){
        System.out.println("Escriba el tipo de vertice que va a crear");
        System.out.println("1. Empresa");
        System.out.println("2. Sede");
        System.out.println("3. Centro Logistico");
        System.out.println("0. atras");
        int option = input.nextInt();

        if(option == 1){
            int codigoEmpresa = input.nextInt();

            for(Empresa empresa: misEmpresas.values()){
                if(empresa.codigoEmpresa == codigoEmpresa){
                    System.out.println("Ya existe una empresa con este codigo");
                    System.out.println();
                    return;
                }
            }

            String nombreEmpresa = input.next();
            int numeroTelefono = input.nextInt();


            Empresa nuevaEmpresa = new Empresa(codigoEmpresa, nombreEmpresa, numeroTelefono);
            misEmpresas.put(codigoEmpresa, nuevaEmpresa);
            grafo.addVertex(nuevaEmpresa);


        } else if(option == 2){

            int codigoSede = input.nextInt();

            for(Sedes sede: misSedes.values()){
                if(sede.codigoSede == codigoSede){
                    System.out.println("Ya existe una sede con este codigo");
                    System.out.println();
                    return;
                }
            }

            String nombreSede = input.next();
            String correoSede = input.next();


            Sedes nuevaSede = new Sedes(codigoSede, nombreSede, correoSede);
            misSedes.put(codigoSede, nuevaSede);
            grafo.addVertex(nuevaSede);

        } else if(option == 3){

            int codigoCentroLogistico = input.nextInt();

            String dirCLogistico = input.next();

            for(CentroLogistico cLogistico: misCentroLogistico.values()){
                if(cLogistico.codigoCentroLogistico == codigoCentroLogistico){
                    System.out.println("Ya existe un centro logistico con este codigo");
                    System.out.println();
                    return;
                } else if(cLogistico.direccionCentroLogistico.equals(dirCLogistico)) {
                    System.out.println("Ya existe un centro logistico con esta direccion");
                    System.out.println();
                    return;
                }
            }
            String nombreCLogistico = input.next();

            CentroLogistico nuevoCLogistico = new CentroLogistico(codigoCentroLogistico, nombreCLogistico, dirCLogistico );
            misCentroLogistico.put(codigoCentroLogistico,nuevoCLogistico);
            grafo.addVertex(nuevoCLogistico);

        } else if(option == 0){
            return;
        }
    }
}

/*


    public static Graph<Object, DefaultEdge> sistema = new SimpleGraph<>(DefaultEdge.class);
    public static Hashtable<String,Ciudad> misCiudades = new Hashtable<>();
    public static Hashtable<String,Estacion> misEstaciones = new Hashtable<>();



    public static void main(String[] args) {

        misEstaciones.put("A",new Estacion("A"));
        misEstaciones.put("B",new Estacion("B"));
        misEstaciones.put("C",new Estacion("C"));

        misCiudades.put("medellin",new Ciudad("medellin",2500000));
        misCiudades.put("bogota",new Ciudad("bogota",8000000));

        sistema.addVertex(misCiudades.get("medellin"));
        sistema.addVertex(misCiudades.get("bogota"));
        sistema.addVertex(misEstaciones.get("A"));
        sistema.addVertex(misEstaciones.get("B"));
        sistema.addVertex(misEstaciones.get("C"));

        crearRelaciones();

        ArrayList<Object> nodosAdyacentes = new ArrayList<>(Graphs.neighborListOf(sistema,misCiudades.get("medellin")));
        for (Object nodo : nodosAdyacentes) {

            if(identificador(nodo,"ciudad")){
                Ciudad miCiudad = (Ciudad) nodo;
                System.out.println(miCiudad.poblacion);

            }
        }

    }
    public static boolean identificador(Object obj , String tipoObjeto){
        if(tipoObjeto.equals("ciudad")){
            return obj instanceof Ciudad;
        }else if(tipoObjeto.equals("estacion")){
            return obj instanceof Estacion;
        }else{
            return false;
        }
    }

    public static void crearRelaciones(){
        sistema.addEdge(misCiudades.get("medellin"),misEstaciones.get("A"));
        sistema.addEdge(misCiudades.get("medellin"),misEstaciones.get("B"));
        sistema.addEdge(misCiudades.get("bogota"),misEstaciones.get("C"));
        sistema.addEdge(misCiudades.get("bogota"),misCiudades.get("medellin"));
    }

}



 System.out.println("- - - V - - - ");
        ArrayList<Object> vertices = new ArrayList<>(grafo.vertexSet());
        for (Object objeto : vertices){
            System.out.println(objeto);
        }
        System.out.println();
        System.out.println("- - - - A - - - ");

        ArrayList<DefaultEdge> aristas = new ArrayList<>(grafo.edgeSet());
        for (DefaultEdge arista : aristas){
            System.out.println(arista);
        }
*/