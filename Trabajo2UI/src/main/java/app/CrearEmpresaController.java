package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CrearEmpresaController {
    @FXML
    public TextField codigoTextField;
    @FXML
    public TextField nombreTextField;
    @FXML
    public TextField telefonoTextField;
    @FXML
    public Label codigoLabel;
    @FXML
    public Label AdvertenciaLabel;
    @FXML
    public Label warningMessageCodigo;
    @FXML
    public void volver(ActionEvent event)throws IOException {
        App.setRoot("CRUDEmpresas");
    }
    @FXML
    private void clean(){
        codigoTextField.setText("");
        nombreTextField.setText("");
        telefonoTextField.setText("");
        cleanWarnings();
    }
    @FXML
    private void cleanWarnings(){
        AdvertenciaLabel.setText("");
        warningMessageCodigo.setText("");
    }
    @FXML
    public void enviar(ActionEvent event)throws IOException{

        if(codigoTextField.getText().equals("") ||nombreTextField.getText().equals("")||telefonoTextField.getText().equals("")){
            AdvertenciaLabel.setText("Todos los campos deben ser llenados ");
            AdvertenciaLabel.setVisible(true);
            return;
        }

        try{
            int codigoEmpresa = Integer.parseInt(codigoTextField.getText().trim());
            String nombre = nombreTextField.getText();
            int telefono = Integer.parseInt(telefonoTextField.getText());
            if (App.misEmpresas.containsKey(codigoEmpresa)){
                codigoLabel.setText("Ya existe una empresa con ese código");
                codigoLabel.setVisible(true);
            }
            else{
                Empresa nuevaEmpresa = new Empresa(codigoEmpresa, nombre, telefono);
                App.misEmpresas.put(codigoEmpresa, nuevaEmpresa);
                App.grafo.addVertex(nuevaEmpresa);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Creación satisfactoria");
                alert.setContentText("Se ha creado la empresa:\n" + nuevaEmpresa.toString());
                alert.showAndWait();
                clean();
            }
        }catch (Exception e){
            warningMessageCodigo.setText("El código tiene que ser un número");
        }
    }
}
