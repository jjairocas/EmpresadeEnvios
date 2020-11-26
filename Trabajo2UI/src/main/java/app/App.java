package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    public static void main(String[] args) {
        // AQUI SE PUEDEN HACER TODOS LOS PRECÁLCULOS

        //usuarios del sistema

        Usuario usuario1 = new Usuario("carlos","cnhurtadom@unal.edu.co","0000");
       usuarios.put("cnhurtadom@unal.edu.co",usuario1);

        launch();
    }


}