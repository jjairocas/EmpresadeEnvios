package App;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuPrincipalController {

    @FXML
    public Button AdminButton;
    @FXML
    public Button BusquedaButton;
    @FXML
    public Button VolverButton;
    @FXML
    public void volver(ActionEvent event)throws IOException{
        App.setRoot("IniciarSesion");
    }
    @FXML
    public void administrar(ActionEvent event)throws IOException{
        App.setRoot("MenuAdmin");
    }
    @FXML
    public void buscar(ActionEvent event)throws IOException{
        App.setRoot("Busqueda");
    }
}