package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CRUDEliminarSede {

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
        if (!App.misSedes.containsKey(codigo)) {
            warningMessageCodigo.setText("No existe una sede con este código");
            return;
        }

        App.grafo.removeVertex(App.misSedes.get(codigo));
        App.misSedes.remove(codigo);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setTitle("Eliminación satisfactoria");
        alert.setHeaderText("Eliminación satisfactoria");
        alert.setContentText("Se ha Eliminado la sede satisfactoriamente:\n" + App.misSedes);
        alert.showAndWait();
        clean();
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("CRUDSedes");
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
