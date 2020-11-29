package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CrearEmpresaController {
    @FXML
    public TextField codigoTextField;
    @FXML
    public TextField nombreTextField;
    @FXML
    public TextField telefonoTextField;
    @FXML
    public Label codigoLabel;
    @FXML
    public void volver(ActionEvent event)throws IOException {
        App.setRoot("CRUDEmpresas");
    }
}
