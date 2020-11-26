package App;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IniciarSesionController {
    @FXML
    public TextField CorreoTextField;
    @FXML
    public PasswordField ClavePasswordField;
    @FXML
    public Label CorreoLabel;
    @FXML
    public Label ClaveLabel;
    @FXML
    public Label AdvertenciaLabel;
    @FXML
    public void enviar(ActionEvent event) throws IOException{
        String correo = CorreoTextField.getText().trim();
        String clave = ClavePasswordField.getText().trim();
        if(correo.equals("") ||clave.equals("")){
            AdvertenciaLabel.setText("Todos los campos deben ser llenados ");
            AdvertenciaLabel.setVisible(true);
            return;
        }
        else {
            AdvertenciaLabel.setVisible(false);
        }
        if(App.usuarios.containsKey(correo)){
            CorreoLabel.setVisible(false);
            if(App.usuarios.get(correo).clave.equals(clave)){
                App.setRoot("MenuPrincipal");
            }
            else {
                ClaveLabel.setText("Contraseña incorrecta");
                ClaveLabel.setVisible(true);
            }
        }
        else {
            CorreoLabel.setText("Correo no registrado");
            CorreoLabel.setVisible(true);
        }
    }
    @FXML
    public void cerrarVentana(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}