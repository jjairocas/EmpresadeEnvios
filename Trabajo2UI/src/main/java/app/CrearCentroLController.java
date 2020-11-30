package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CrearCentroLController {

    @FXML
    public TextField textCodigo;
    @FXML
    public TextField textNombre;
    @FXML
    public TextField textDireccion;


    @FXML
    public Label warningMessageCodigo;
    @FXML
    public Label warningMessageDireccion;
    @FXML
    public Label warningMessageGeneral;

    @FXML
    public void enviar(ActionEvent event) throws IOException {
        cleanWarnings();
        int codigoCentroLogistico;
        if(textCodigo.getText().trim().equals("")){
            warningMessageGeneral.setText("¡El campo no puede estar vacío!");
            return;
        }
        try{
            codigoCentroLogistico = Integer.parseInt(textCodigo.getText().trim());
        }catch (Exception e){
            warningMessageCodigo.setText("El código tiene que ser un número");
            return;
        }

        if(App.misCentroLogistico.containsKey(codigoCentroLogistico)){
            warningMessageCodigo.setText("Ya existe un centro logístico con este código");
            return;
        }

        String nombreCLogistico;
        if(textNombre.getText().trim().equals("")){
            warningMessageGeneral.setText("¡El campo no puede estar vacío!");
            return;
        }
        nombreCLogistico = textNombre.getText().trim();

        String dirCLogistico;
        if(textDireccion.getText().trim().equals("")){
            warningMessageGeneral.setText("¡El campo no puede estar vacío!");
            return;
        }

        dirCLogistico = textDireccion.getText().trim();

        for (CentroLogistico cLogistico : App.misCentroLogistico.values()) {
            if (cLogistico.direccionCentroLogistico.equals(dirCLogistico)) {
                warningMessageDireccion.setText("Ya existe un centro logistico con esta direccion");
                return;
            }
        }

        CentroLogistico nuevoCLogistico = new CentroLogistico(codigoCentroLogistico, nombreCLogistico, dirCLogistico);
        App.misCentroLogistico.put(codigoCentroLogistico, nuevoCLogistico);
        App.grafo.addVertex(nuevoCLogistico);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setTitle("Creación satisfactoria");
        alert.setHeaderText("Creación satisfactoria");
        alert.setContentText("Se ha ingresado el Centro logístico satisfactoriamente:\n" + nuevoCLogistico.toString());
        alert.showAndWait();
        clean();
    }


    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("CRUDCentrosLogisticos");
    }

    @FXML
    private void clean(){
        textCodigo.setText("");
        textNombre.setText("");
        textDireccion.setText("");
        cleanWarnings();
    }

    @FXML
    private void cleanWarnings(){
        warningMessageCodigo.setText("");
        warningMessageDireccion.setText("");
        warningMessageGeneral.setText("");
    }
}
