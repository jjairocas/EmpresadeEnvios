package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CRUDEmpresasController {
    @FXML
    public Button crearButton;
    @FXML
    public Button editarButton;
    @FXML
    public Button verButton;
    @FXML
    public Button eliminarButton;
    @FXML
    public Button volverButton;
    @FXML
    public void volver(ActionEvent event)throws IOException {
        App.setRoot("MenuAdmin");
    }
    @FXML
    public void crear(ActionEvent event)throws IOException {
        App.setRoot("CrearEmpresa");
    }

}
