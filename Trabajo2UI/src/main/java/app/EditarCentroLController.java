package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditarCentroLController {

    @FXML
    public TextField textCodigoActual;
    @FXML
    public TextField textCodigo;
    @FXML
    public TextField textNombre;
    @FXML
    public TextField textDireccion;


    @FXML
    public Label warningMessageCodigoActual;
    @FXML
    public Label warningMessageCodigo;
    @FXML
    public Label warningMessageDireccion;
    @FXML
    public Label warningMessageGeneral;


    @FXML
    public void enviar(ActionEvent event) throws IOException {
        cleanWarnings();

        int codigoActual;
        if (textCodigoActual.getText().trim().equals("")) {
            warningMessageCodigoActual.setText("¡El campo no puede estar vacío!");
            return;
        }
        try {
            codigoActual = Integer.parseInt(textCodigoActual.getText().trim());
        } catch (Exception e) {
            warningMessageCodigo.setText("El código tiene que ser un número");
            return;
        }
        if (!App.misCentroLogistico.containsKey(codigoActual)) {
            warningMessageCodigoActual.setText("No existe un centro logístico con este código");
            return;
        }


        int nuevoCodigo;
        if (textCodigo.getText().trim().equals("") && textNombre.getText().trim().equals("") && textDireccion.getText().trim().equals("")) {
            warningMessageGeneral.setText("¡Todos los campos para edición no pueden estar vacíos!");
            return;
        }
        try {
            nuevoCodigo = Integer.parseInt(textCodigo.getText().trim());
        } catch (Exception e) {
            warningMessageCodigo.setText("El código tiene que ser un número");
            return;
        }

        if (App.misCentroLogistico.containsKey(nuevoCodigo)) {
            warningMessageCodigo.setText("Ya existe un centro logístico con este código");
            return;
        }

        String nuevoNombre;
        nuevoNombre = textNombre.getText().trim();

        String nuevaDireccion;
        nuevaDireccion = textDireccion.getText().trim();

        for (CentroLogistico cLogistico : App.misCentroLogistico.values()) {
            if (cLogistico.direccionCentroLogistico.equals(nuevaDireccion)) {
                warningMessageDireccion.setText("Ya existe un centro logístico con esta dirección");
                return;
            }
        }

        if (App.misCentroLogistico.containsKey(codigoActual)) {
            CentroLogistico centro = App.misCentroLogistico.get(codigoActual);
            if (!textNombre.getText().trim().equals("")) {
                centro.nombreCentroLogistico = nuevoNombre;
            }
            if (!textDireccion.getText().trim().equals("")) {
                centro.direccionCentroLogistico = nuevaDireccion;
            }
            if (!textCodigo.getText().trim().equals("")) {
                App.misCentroLogistico.remove(codigoActual);
                App.misCentroLogistico.put(nuevoCodigo, new CentroLogistico(nuevoCodigo, centro.nombreCentroLogistico, centro.direccionCentroLogistico));
            }
        }

//        CentroLogistico nuevoCentro;
//        if (!textCodigo.getText().trim().equals("")) {
//            nuevoCentro = App.misCentroLogistico.get(nuevoCodigo);
//        }
//        else {
//            nuevoCentro = App.misCentroLogistico.get(codigoActual);
//        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setTitle("Edición satisfactoria");
        alert.setHeaderText("Edición satisfactoria");
        alert.setContentText("Se ha Editado el Centro logístico satisfactoriamente:\n" + App.misCentroLogistico);
        alert.showAndWait();
        clean();
    }


    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("CRUDCentrosLogisticos");
    }

    @FXML
    private void clean() {
        textCodigoActual.setText("");
        textCodigo.setText("");
        textNombre.setText("");
        textDireccion.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings() {
        warningMessageCodigoActual.setText("");
        warningMessageCodigo.setText("");
        warningMessageDireccion.setText("");
        warningMessageGeneral.setText("");
    }
}