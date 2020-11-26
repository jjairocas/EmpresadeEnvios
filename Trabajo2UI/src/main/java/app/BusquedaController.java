package App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class BusquedaController {
    @FXML
    public Button VolverButton;
    @FXML
    public ChoiceBox<String> entidadChoiceBox;
    @FXML
    public ChoiceBox<String> atributoChoiceBox;
    @FXML
    public TextField valorTextField;
    @FXML
    public void volver(ActionEvent event)throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
