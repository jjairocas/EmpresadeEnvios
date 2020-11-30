package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.jgrapht.graph.DefaultEdge;

import java.io.IOException;

public class EditarRelacionesEmpresaController {
    @FXML
    public TextField textCodigoEmpresa1;
    @FXML
    public TextField textCodigoSede;
    @FXML
    public TextField textCodigoEmpresa2;

    @FXML
    public Label warningMessageCodigoEmpresa1;
    @FXML
    public Label warningMessageCodigoSede;
    @FXML
    public Label warningMessageCodigoEmpresa2;
    @FXML
    public Label warningMessageGeneral;


    @FXML
    public void crear(ActionEvent event) throws IOException {
        cleanWarnings();

        int codigoEmpresa;
        if (textCodigoEmpresa1.getText().trim().equals("")) {
            warningMessageCodigoEmpresa1.setText("¡El campo no puede estar vacío!");
            return;
        }
        try {
            codigoEmpresa = Integer.parseInt(textCodigoEmpresa1.getText().trim());
        } catch (Exception e) {
            warningMessageCodigoEmpresa1.setText("El código tiene que ser un número");
            return;
        }
        if (!App.misEmpresas.containsKey(codigoEmpresa)) {
            warningMessageCodigoEmpresa1.setText("No existe una Empresa con este código");
            return;
        }

        int codigoSede;
        Sedes destino1 = null;
        if (textCodigoSede.getText().trim().equals("") && textCodigoEmpresa2.getText().trim().equals("")) {
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

        int codigoEmpresa2;
        Empresa destino2 = null;
        if (!textCodigoEmpresa2.getText().trim().equals("")) {
            try {
                codigoEmpresa2 = Integer.parseInt(textCodigoEmpresa2.getText().trim());
            } catch (Exception e) {
                warningMessageCodigoEmpresa2.setText("El código tiene que ser un número");
                return;
            }
            if (!App.misEmpresas.containsKey(codigoEmpresa2)) {
                warningMessageCodigoEmpresa2.setText("No existe una Empresa con este código");
                return;
            }
            destino2 = App.misEmpresas.get(codigoEmpresa2);
        }


//      Creación de relación con sede o centroL
        Empresa origen = App.misEmpresas.get(codigoEmpresa);

        DefaultEdge nuevaArista = null;
//      Hago la relación con la sede
        if (!textCodigoSede.getText().trim().equals("")) {
            nuevaArista = App.grafo.addEdge(origen, destino1);
        }
//      Hago la relación con la otra empresa
        else if (!textCodigoEmpresa2.getText().trim().equals("")) {
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
        alert.setContentText("Se ha Creado la relación con la empresa satisfactoriamente:\n" + nuevaArista);
        alert.showAndWait();
        clean();
    }


    @FXML
    public void eliminar(ActionEvent event) throws IOException {
        cleanWarnings();

        int codigoEmpresa1;
        if (textCodigoEmpresa1.getText().trim().equals("")) {
            warningMessageCodigoEmpresa1.setText("¡El campo no puede estar vacío!");
            return;
        }
        try {
            codigoEmpresa1 = Integer.parseInt(textCodigoEmpresa1.getText().trim());
        } catch (Exception e) {
            warningMessageCodigoEmpresa1.setText("El código tiene que ser un número");
            return;
        }
        if (!App.misEmpresas.containsKey(codigoEmpresa1)) {
            warningMessageCodigoEmpresa1.setText("No existe una Empresa con este código");
            return;
        }

        int codigoSede;
        Sedes destino1 = null;
        if (textCodigoSede.getText().trim().equals("") && textCodigoEmpresa2.getText().trim().equals("")) {
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

        int codigoEmpresa2;
        Empresa destino2 = null;
        if (!textCodigoEmpresa2.getText().trim().equals("")) {
            try {
                codigoEmpresa2 = Integer.parseInt(textCodigoEmpresa2.getText().trim());
            } catch (Exception e) {
                warningMessageCodigoEmpresa2.setText("El código tiene que ser un número");
                return;
            }
            if (!App.misEmpresas.containsKey(codigoEmpresa2)) {
                warningMessageCodigoEmpresa2.setText("No existe una Empresa con este código");
                return;
            }
            destino2 = App.misEmpresas.get(codigoEmpresa2);
        }


//      Eliminación de relación con sede o centroL
        Empresa origen = App.misEmpresas.get(codigoEmpresa1);

        DefaultEdge Arista = null;
//      Remuevo la relación con la sede
        if (!textCodigoSede.getText().trim().equals("")) {
            Arista = App.grafo.removeEdge(origen, destino1);;
        }
//      Remuevo la relación con el otro centro
        else if (!textCodigoEmpresa2.getText().trim().equals("")) {
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
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("CRUDEmpresas");
    }

    @FXML
    private void clean() {
        textCodigoEmpresa1.setText("");
        textCodigoSede.setText("");
        textCodigoEmpresa2.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings() {
        warningMessageCodigoEmpresa1.setText("");
        warningMessageCodigoSede.setText("");
        warningMessageCodigoEmpresa2.setText("");
        warningMessageGeneral.setText("");
    }
}
