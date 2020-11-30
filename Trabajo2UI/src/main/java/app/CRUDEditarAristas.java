package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;

import java.io.IOException;
import java.util.ArrayList;

public class CRUDEditarAristas {

    @FXML
    public TextField textCodigoSede1;
    @FXML
    public TextField textCodigoEmpresa;
    @FXML
    public TextField textCodigoCentro;

    @FXML
    public Label warningMessageCodigoSede;
    @FXML
    public Label warningMessageCodigoEmpresa;
    @FXML
    public Label warningMessageCodigoCentro;
    @FXML
    public Label warningMessageGeneral;


    @FXML
    public void crear(ActionEvent event) throws IOException {
        cleanWarnings();

        int codigoCentro1;
        if (textCodigoSede1.getText().trim().equals("")) {
            warningMessageCodigoSede.setText("¡El campo no puede estar vacío!");
            return;
        }
        try {
            codigoCentro1 = Integer.parseInt(textCodigoSede1.getText().trim());
        } catch (Exception e) {
            warningMessageCodigoSede.setText("El código tiene que ser un número");
            return;
        }
        if (!App.misSedes.containsKey(codigoCentro1)) {
            warningMessageCodigoSede.setText("No existe una sede con este código");
            return;
        }

        int codigoSede;
        Empresa destino1 = null;
        if (textCodigoEmpresa.getText().trim().equals("") && textCodigoCentro.getText().trim().equals("")) {
            warningMessageGeneral.setText("¡Todos los campos para edición de relaciones no pueden estar vacíos!");
            return;
        }
        if (!textCodigoEmpresa.getText().trim().equals("")) {
            try {
                codigoSede = Integer.parseInt(textCodigoEmpresa.getText().trim());
            } catch (Exception e) {
                warningMessageCodigoEmpresa.setText("El código tiene que ser un número");
                return;
            }
            if (!App.misEmpresas.containsKey(codigoSede)) {
                warningMessageCodigoEmpresa.setText("No existe una empresa con este código");
                return;
            }
            destino1 = App.misEmpresas.get(codigoSede);
        }

        int codigoCentro2;
        CentroLogistico destino2 = null;
        if (!textCodigoCentro.getText().trim().equals("")) {
            try {
                codigoCentro2 = Integer.parseInt(textCodigoCentro.getText().trim());
            } catch (Exception e) {
                warningMessageCodigoCentro.setText("El código tiene que ser un número");
                return;
            }
            if (!App.misCentroLogistico.containsKey(codigoCentro2)) {
                warningMessageCodigoCentro.setText("No existe un centro logístico con este código");
                return;
            }
            destino2 = App.misCentroLogistico.get(codigoCentro2);
        }


//      Creación de relación con sede o centroL
        Sedes origen = App.misSedes.get(codigoCentro1);

        DefaultEdge nuevaArista = null;
//      Hago la relación con la sede
        if (!textCodigoEmpresa.getText().trim().equals("")) {
            nuevaArista = App.grafo.addEdge(origen, destino1);
        }
//      Hago la relación con el otro centro
        else if (!textCodigoCentro.getText().trim().equals("")) {

            try{
                nuevaArista = App.grafo.addEdge(origen, destino2);
            }catch (Exception e){
                warningMessageGeneral.setText("Ha ocurrido un error al ingresar los datos");

                return;
            }

        }

        if (nuevaArista == null) {
            warningMessageGeneral.setText("La relación ya existe");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setTitle("Creación de relación satisfactoria");
        alert.setHeaderText("Creación de relación satisfactoria");
        alert.setContentText("Se ha Creado la relación con la sede satisfactoriamente:\n" + nuevaArista);
        alert.showAndWait();
        clean();
    }


    @FXML
    public void eliminar(ActionEvent event) throws IOException {
        cleanWarnings();

        int codigoCentro1;
        if (textCodigoSede1.getText().trim().equals("")) {
            warningMessageCodigoSede.setText("¡El campo no puede estar vacío!");
            return;
        }
        try {
            codigoCentro1 = Integer.parseInt(textCodigoSede1.getText().trim());
        } catch (Exception e) {
            warningMessageCodigoSede.setText("El código tiene que ser un número");
            return;
        }
        if (!App.misSedes.containsKey(codigoCentro1)) {
            warningMessageCodigoSede.setText("No existe una sede con este código");
            return;
        }

        int codigoSede;
        Empresa destino1 = null;
        if (textCodigoEmpresa.getText().trim().equals("") && textCodigoCentro.getText().trim().equals("")) {
            warningMessageGeneral.setText("¡Todos los campos para edición de relaciones no pueden estar vacíos!");
            return;
        }
        if (!textCodigoEmpresa.getText().trim().equals("")) {
            try {
                codigoSede = Integer.parseInt(textCodigoEmpresa.getText().trim());
            } catch (Exception e) {
                warningMessageCodigoEmpresa.setText("El código tiene que ser un número");
                return;
            }
            if (!App.misEmpresas.containsKey(codigoSede)) {
                warningMessageCodigoEmpresa.setText("No existe una empresa con este código");
                return;
            }
            destino1 = App.misEmpresas.get(codigoSede);
        }

        int codigoCentro2;
        CentroLogistico destino2 = null;
        if (!textCodigoCentro.getText().trim().equals("")) {
            try {
                codigoCentro2 = Integer.parseInt(textCodigoCentro.getText().trim());
            } catch (Exception e) {
                warningMessageCodigoCentro.setText("El código tiene que ser un número");
                return;
            }
            if (!App.misCentroLogistico.containsKey(codigoCentro2)) {
                warningMessageCodigoCentro.setText("No existe un centro logístico con este código");
                return;
            }
            destino2 = App.misCentroLogistico.get(codigoCentro2);
        }


//      Eliminación de relación con sede o centroL
        Sedes origen = App.misSedes.get(codigoCentro1);

        DefaultEdge Arista = null;
//      Remuevo la relación con la sede
        if (!textCodigoEmpresa.getText().trim().equals("")) {
            Arista = App.grafo.removeEdge(origen, destino1);;
        }
//      Remuevo la relación con el otro centro
        else if (!textCodigoCentro.getText().trim().equals("")) {
            Arista = App.grafo.removeEdge(origen, destino2);
        }

        if (Arista == null) {
            warningMessageGeneral.setText("La relación no existe");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setTitle("Eliminación de relación satisfactoria");
        alert.setHeaderText("Eliminación de relación satisfactoria");
        alert.setContentText("Se ha Eliminado la relación con el CentroL satisfactoriamente:\n" + Arista);
        alert.showAndWait();
        clean();
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("CRUDSedes");
    }

    @FXML
    private void clean() {
        textCodigoSede1.setText("");
        textCodigoEmpresa.setText("");
        textCodigoCentro.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings() {
        warningMessageCodigoSede.setText("");
        warningMessageCodigoEmpresa.setText("");
        warningMessageCodigoCentro.setText("");
        warningMessageGeneral.setText("");
    }
}
