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
    @FXML
    public void editar(ActionEvent event)throws IOException {
        App.setRoot("EditarEmpresa");
    }
    @FXML
    public void ver(ActionEvent event)throws IOException {
        App.setRoot("VerEmpresa");
    }
    @FXML
    public void eliminar(ActionEvent event)throws IOException {
        App.setRoot("EliminarEmpresa");
    }
    @FXML
    public void editarRelaciones(ActionEvent event)throws IOException {
        App.setRoot("EditarRelacionesEmpresa");
    }

}
