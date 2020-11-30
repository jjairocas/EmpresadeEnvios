package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class EditarEmpresaController {

    @FXML
    public TextField codigoTextField;
    @FXML
    public TextField NuevocodigoTextField;
    @FXML
    public TextField NuevonombreTextField;
    @FXML
    public TextField NuevotelefonoTextField;
    @FXML
    public Label NuevocodigoLabel;
    @FXML
    public Label NuevonombreLabel;
    @FXML
    public Label NuevotelefonoLabel;
    @FXML
    public Label warningMessageNumero;
    @FXML
    public Label warningMessageExistencia;
    @FXML
    public Button enviarButton;
    @FXML
    private void clean(){
        codigoTextField.setText("");
        NuevocodigoTextField.setText("");
        NuevonombreTextField.setText("");
        NuevotelefonoTextField.setText("");
        cleanWarnings();
    }
    @FXML
    private void cleanWarnings(){
        warningMessageNumero.setText("");
        warningMessageExistencia.setText("");
    }

    public void volver(ActionEvent event)throws IOException {
        App.setRoot("CRUDEmpresas");
    }

    public void enviar(ActionEvent event)throws IOException {
        int codigo;
        try{
            codigo = Integer.parseInt(codigoTextField.getText());
        }catch (Exception e){
            warningMessageNumero.setText("El tiene que ser un numero");
            warningMessageNumero.setVisible(true);
            return;
        }

        if(App.misEmpresas.containsKey(codigo)){

            NuevocodigoLabel.setVisible(true);
            NuevocodigoTextField.setVisible(true);
            NuevonombreLabel.setVisible(true);
            NuevonombreTextField.setVisible(true);
            NuevotelefonoLabel.setVisible(true);
            NuevotelefonoTextField.setVisible(true);
        }
        else{
            warningMessageExistencia.setText("No exite empresa con este código");
            warningMessageExistencia.setVisible(true);
        }
    }

    public void enviarConfirmacion(ActionEvent event)throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("¿Estas seguro de confirmar la acción?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            int codigo = Integer.parseInt(codigoTextField.getText());
            String nuevoNombre = NuevonombreTextField.getText().trim();
            int nuevoCodigo = Integer.parseInt(NuevocodigoTextField.getText());
            int nuevoTelefono = Integer.parseInt(NuevotelefonoTextField.getText());

            Empresa empresa = App.misEmpresas.get(codigo);
            empresa.nombreDelaEmpresa = nuevoNombre;
            empresa.codigoEmpresa = nuevoCodigo;
            empresa.numeroTelefonico = nuevoTelefono;

            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Creación satisfactoria");
            alert2.setContentText("¡Se ha  modificado la empresa correctamente!" );
            alert2.showAndWait();
            clean();

        } else {
            return;
        }

    }

}

