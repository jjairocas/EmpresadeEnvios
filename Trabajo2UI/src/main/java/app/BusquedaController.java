package app;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BusquedaController implements Initializable {
    @FXML
    public Button VolverButton;
    @FXML
    public ChoiceBox<String> entidadChoiceBox;
    @FXML
    public ChoiceBox<String> atributoEmpresaChoiceBox;
    @FXML
    public ChoiceBox<String> atributoSedeChoiceBox;
    @FXML
    public ChoiceBox<String> atributoCentroChoiceBox;
    @FXML
    public TextField valorTextField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> opcionesEntidadChoiseBox = new ArrayList<>();
        opcionesEntidadChoiseBox.add("Empresa");
        opcionesEntidadChoiseBox.add("Sede");
        opcionesEntidadChoiseBox.add("Centro logistico");
        entidadChoiceBox.setItems(FXCollections.observableList(opcionesEntidadChoiseBox));

        ArrayList<String> opcionesAtributoEmpresaChoiseBox = new ArrayList<>();
        opcionesAtributoEmpresaChoiseBox.add("Codigo");
        opcionesAtributoEmpresaChoiseBox.add("Nombre");
        opcionesAtributoEmpresaChoiseBox.add("Telefono");
        atributoEmpresaChoiceBox.setItems(FXCollections.observableList(opcionesAtributoEmpresaChoiseBox));

        ArrayList<String> opcionesAtributoSedeChoiseBox = new ArrayList<>();
        opcionesAtributoSedeChoiseBox.add("Codigo");
        opcionesAtributoSedeChoiseBox.add("Nombre");
        opcionesAtributoSedeChoiseBox.add("Correo");
        atributoSedeChoiceBox.setItems(FXCollections.observableList(opcionesAtributoSedeChoiseBox));

        ArrayList<String> opcionesAtributoCentroChoiseBox = new ArrayList<>();
        opcionesAtributoCentroChoiseBox.add("Codigo");
        opcionesAtributoCentroChoiseBox.add("Nombre");
        opcionesAtributoCentroChoiseBox.add("Direccion");
        atributoCentroChoiceBox.setItems(FXCollections.observableList(opcionesAtributoCentroChoiseBox));

    }
    @FXML
    public void volver(ActionEvent event)throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
