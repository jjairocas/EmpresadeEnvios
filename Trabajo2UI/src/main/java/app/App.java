package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.IOException;
import java.util.Hashtable;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("IniciarSesion"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static Hashtable<String,Usuario> usuarios =new Hashtable<String, Usuario>();
    public static Graph<Object, DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);
    public static Hashtable<Integer, Empresa> misEmpresas = new Hashtable<>();
    public static Hashtable<Integer, Sedes> misSedes = new Hashtable<>();
    public static Hashtable<Integer, CentroLogistico> misCentroLogistico = new Hashtable<>();

    public static void main(String[] args) {
        // Creacion de los objetos

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


        Usuario usuario1 = new Usuario("carlos","cnhurtadom@unal.edu.co","0000");
        Usuario usuario2 = new Usuario("Sara","saduquema@unal.edu.co","1111");
        Usuario usuario3 = new Usuario("Cristian","cgiraldo@unal.edu.co","2222");
        usuarios.put("cnhurtadom@unal.edu.co",usuario1);
        usuarios.put("saduquema@unal.edu.co",usuario2);
        usuarios.put("cgiraldo@unal.edu.co",usuario3);

        launch();
    }


}