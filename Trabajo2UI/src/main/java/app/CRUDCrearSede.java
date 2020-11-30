package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CRUDCrearSede {


    @FXML
    public TextField codigoSede;

    @FXML
    public TextField NombreSede;

    @FXML
    public TextField correoSede;


    @FXML
    public Label AdvertenciaLabel;

    @FXML
    public Button volverButton;

    @FXML
    public Button enviar;

    @FXML
    public Label codigoError;

    @FXML
    public Label nombreError;




    @FXML
    public void volver(ActionEvent event)throws IOException {
        App.setRoot("CRUDSedes");
    }

    public void enviar(ActionEvent event) throws IOException{
        cleanWarnings();
        String codigo = codigoSede.getText().trim();
        String nombre = NombreSede.getText().trim();
        String telefono = correoSede.getText().trim();





        if(codigo.equals("") ||nombre.equals("") || telefono.equals("")){
            AdvertenciaLabel.setText("Todos los campos deben ser llenados");
            AdvertenciaLabel.setVisible(true);
            return;
        }
        else {
            AdvertenciaLabel.setVisible(false);
        }
        int codigoNumero;
        try{
            codigoNumero = Integer.parseInt(codigoSede.getText().trim());
        }catch (Exception e){
            codigoError.setText("El codigo tiene que ser un numero");
            return;
        }

        if(!App.misSedes.containsKey(codigoNumero)){
            codigoError.setVisible(false);

            

            Sedes nuevaSede = new Sedes(codigoNumero, nombre, telefono);
            App.misSedes.put(codigoNumero, nuevaSede);
            App.grafo.addVertex(nuevaSede);


            App.setRoot("CRUDSedes");
        }
        else {
            nombreError.setText("La sede ya existe");
            nombreError.setVisible(true);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setTitle("Creacion exitosa");
        alert.setHeaderText("Creacion exitosa");
        alert.setContentText("Creacion exitosa");
        alert.showAndWait();

    }




    @FXML
    private void cleanWarnings(){
        AdvertenciaLabel.setText("");
        codigoError.setText("");
        nombreError.setText("");
    }


}
