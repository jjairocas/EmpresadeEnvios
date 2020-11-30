package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EliminarCentroLController {

    @FXML
    public TextField textCodigo;

    @FXML
    public Label warningMessageCodigo;
    @FXML
    public Label warningMessageGeneral;

    @FXML
    public void enviar(ActionEvent event) throws IOException {
        cleanWarnings();

        int codigo;
        if (textCodigo.getText().trim().equals("")) {
            warningMessageCodigo.setText("¡El campo no puede estar vacío!");
            return;
        }
        try {
            codigo = Integer.parseInt(textCodigo.getText().trim());
        } catch (Exception e) {
            warningMessageCodigo.setText("El código tiene que ser un número");
            return;
        }
        if (!App.misCentroLogistico.containsKey(codigo)) {
            warningMessageCodigo.setText("No existe un centro logístico con este código");
            return;
        }

        App.grafo.removeVertex(App.misCentroLogistico.get(codigo));
        App.misCentroLogistico.remove(codigo);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setTitle("Eliminación satisfactoria");
        alert.setHeaderText("Eliminación satisfactoria");
        alert.setContentText("Se ha Eliminado el Centro logístico satisfactoriamente:\n" + App.misCentroLogistico);
        alert.showAndWait();
        clean();
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("CRUDCentrosLogisticos");
    }

    @FXML
    private void clean() {
        textCodigo.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings() {
        warningMessageCodigo.setText("");
        warningMessageGeneral.setText("");
    }
}
