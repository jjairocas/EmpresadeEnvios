package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EliminarEmpresaController {
    @FXML
    public TextField textCodigo;
    @FXML
    public Label warningMessageCodigo;
    @FXML
    public Label warningMessageGeneral;
    @FXML
    public void enviar(ActionEvent event) throws IOException {

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
        if (!App.misEmpresas.containsKey(codigo)) {
            warningMessageCodigo.setText("No existe una empresa con este código");
            return;
        }

        App.grafo.removeVertex(App.misEmpresas.get(codigo));
        App.misEmpresas.remove(codigo);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setTitle("Eliminación satisfactoria");
        alert.setHeaderText("Eliminación satisfactoria");
        alert.setContentText("Se ha Eliminado la empresa satisfactoriamente");
        alert.showAndWait();
        clean();
    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("CRUDEmpresas");
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

