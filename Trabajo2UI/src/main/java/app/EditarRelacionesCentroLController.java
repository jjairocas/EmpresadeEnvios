package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.jgrapht.graph.DefaultEdge;

import java.io.IOException;

public class EditarRelacionesCentroLController {

    @FXML
    public TextField textCodigoCentro1;
    @FXML
    public TextField textCodigoSede;
    @FXML
    public TextField textCodigoCentro2;

    @FXML
    public Label warningMessageCodigoCentro1;
    @FXML
    public Label warningMessageCodigoSede;
    @FXML
    public Label warningMessageCodigoCentro2;
    @FXML
    public Label warningMessageGeneral;


    @FXML
    public void crear(ActionEvent event) throws IOException {
        cleanWarnings();

        int codigoCentro1;
        if (textCodigoCentro1.getText().trim().equals("")) {
            warningMessageCodigoCentro1.setText("¡El campo no puede estar vacío!");
            return;
        }
        try {
            codigoCentro1 = Integer.parseInt(textCodigoCentro1.getText().trim());
        } catch (Exception e) {
            warningMessageCodigoCentro1.setText("El código tiene que ser un número");
            return;
        }
        if (!App.misCentroLogistico.containsKey(codigoCentro1)) {
            warningMessageCodigoCentro1.setText("No existe un centro logístico con este código");
            return;
        }

        int codigoSede;
        Sedes destino1 = null;
        if (textCodigoSede.getText().trim().equals("") && textCodigoCentro2.getText().trim().equals("")) {
            warningMessageGeneral.setText("¡Todos los campos para edición de relaciones no pueden estar vacíos!");
            return;
        }
        if (!textCodigoSede.getText().trim().equals("")) {
            try {
                codigoSede = Integer.parseInt(textCodigoSede.getText().trim());
            } catch (Exception e) {
                warningMessageCodigoSede.setText("El código tiene que ser un número");
                return;
            }
            if (!App.misSedes.containsKey(codigoSede)) {
                warningMessageCodigoSede.setText("No existe una sede con este código");
                return;
            }
            destino1 = App.misSedes.get(codigoSede);
        }

        int codigoCentro2;
        CentroLogistico destino2 = null;
        if (!textCodigoCentro2.getText().trim().equals("")) {
            try {
                codigoCentro2 = Integer.parseInt(textCodigoCentro2.getText().trim());
            } catch (Exception e) {
                warningMessageCodigoCentro2.setText("El código tiene que ser un número");
                return;
            }
            if (!App.misCentroLogistico.containsKey(codigoCentro2)) {
                warningMessageCodigoCentro2.setText("No existe un centro logístico con este código");
                return;
            }
            destino2 = App.misCentroLogistico.get(codigoCentro2);
        }


//      Creación de relación con sede o centroL
        CentroLogistico origen = App.misCentroLogistico.get(codigoCentro1);

        DefaultEdge nuevaArista = null;
//      Hago la relación con la sede
        if (!textCodigoSede.getText().trim().equals("")) {
            nuevaArista = App.grafo.addEdge(origen, destino1);
        }
//      Hago la relación con el otro centro
        else if (!textCodigoCentro2.getText().trim().equals("")) {
            nuevaArista = App.grafo.addEdge(origen, destino2);
        }

        if (nuevaArista == null) {
            warningMessageGeneral.setText("La relación ya existe");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setTitle("Creación de relación satisfactoria");
        alert.setHeaderText("Creación de relación satisfactoria");
        alert.setContentText("Se ha Creado la relación con el CentroL satisfactoriamente:\n" + nuevaArista);
        alert.showAndWait();
        clean();
    }


    @FXML
    public void eliminar(ActionEvent event) throws IOException {
        cleanWarnings();

        int codigoCentro1;
        if (textCodigoCentro1.getText().trim().equals("")) {
            warningMessageCodigoCentro1.setText("¡El campo no puede estar vacío!");
            return;
        }
        try {
            codigoCentro1 = Integer.parseInt(textCodigoCentro1.getText().trim());
        } catch (Exception e) {
            warningMessageCodigoCentro1.setText("El código tiene que ser un número");
            return;
        }
        if (!App.misCentroLogistico.containsKey(codigoCentro1)) {
            warningMessageCodigoCentro1.setText("No existe un centro logístico con este código");
            return;
        }

        int codigoSede;
        Sedes destino1 = null;
        if (textCodigoSede.getText().trim().equals("") && textCodigoCentro2.getText().trim().equals("")) {
            warningMessageGeneral.setText("¡Todos los campos para edición de relaciones no pueden estar vacíos!");
            return;
        }
        if (!textCodigoSede.getText().trim().equals("")) {
            try {
                codigoSede = Integer.parseInt(textCodigoSede.getText().trim());
            } catch (Exception e) {
                warningMessageCodigoSede.setText("El código tiene que ser un número");
                return;
            }
            if (!App.misSedes.containsKey(codigoSede)) {
                warningMessageCodigoSede.setText("No existe una sede con este código");
                return;
            }
            destino1 = App.misSedes.get(codigoSede);
        }

        int codigoCentro2;
        CentroLogistico destino2 = null;
        if (!textCodigoCentro2.getText().trim().equals("")) {
            try {
                codigoCentro2 = Integer.parseInt(textCodigoCentro2.getText().trim());
            } catch (Exception e) {
                warningMessageCodigoCentro2.setText("El código tiene que ser un número");
                return;
            }
            if (!App.misCentroLogistico.containsKey(codigoCentro2)) {
                warningMessageCodigoCentro2.setText("No existe un centro logístico con este código");
                return;
            }
            destino2 = App.misCentroLogistico.get(codigoCentro2);
        }


//      Eliminación de relación con sede o centroL
        CentroLogistico origen = App.misCentroLogistico.get(codigoCentro1);

        DefaultEdge Arista = null;
//      Remuevo la relación con la sede
        if (!textCodigoSede.getText().trim().equals("")) {
            Arista = App.grafo.removeEdge(origen, destino1);;
        }
//      Remuevo la relación con el otro centro
        else if (!textCodigoCentro2.getText().trim().equals("")) {
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
        App.setRoot("CRUDCentrosLogisticos");
    }

    @FXML
    private void clean() {
        textCodigoCentro1.setText("");
        textCodigoSede.setText("");
        textCodigoCentro2.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings() {
        warningMessageCodigoCentro1.setText("");
        warningMessageCodigoSede.setText("");
        warningMessageCodigoCentro2.setText("");
        warningMessageGeneral.setText("");
    }
}
