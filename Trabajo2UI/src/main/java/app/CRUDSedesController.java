package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CRUDSedesController {
    @FXML
    public Button crearButton;
    @FXML
    public Button editarButton;
    @FXML
    public Button verButton;
    @FXML
    public Button editarAristasButton;
    @FXML
    public Button eliminarButton;
    @FXML
    public Button volverButton;
    @FXML
    public void volver(ActionEvent event)throws IOException {
        App.setRoot("MenuAdmin");
    }

    @FXML
    public void crearSede(ActionEvent event)throws IOException{
        App.setRoot("CrearSede");
    }

    @FXML
    public void buscarAEditar(ActionEvent event)throws IOException{
        App.setRoot("editarSede");
    }

    @FXML
    public void verSede(ActionEvent event)throws IOException{
        App.setRoot("verSede");
    }

    @FXML
    public void editarAristas(ActionEvent event)throws IOException{
        App.setRoot("CRUDEditarAristas");
    }

    @FXML
    public void eliminarSede(ActionEvent event)throws IOException{
        App.setRoot("eliminarSede");
    }



}
