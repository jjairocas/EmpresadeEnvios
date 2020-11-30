package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CRUDEditarSede {

    @FXML
    public TextField codigoSede;

    @FXML
    public TextField nuevoCodigoSede;

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
    public Label CodigoOriginalError;


    @FXML
    public void volver(ActionEvent event)throws IOException {
        App.setRoot("CRUDSedes");
    }


    public void enviar(ActionEvent event) throws IOException{
        cleanWarnings();

        String codigo = codigoSede.getText().trim();
        String nuevoCodigo = nuevoCodigoSede.getText().trim();
        String nombre = NombreSede.getText().trim();
        String correo = correoSede.getText().trim();

        if(codigo.equals("")){
            codigoError.setText("Debe escribir el codigo de la sede");
            codigoError.setVisible(true);
            return;
        }
        else {
            codigoError.setVisible(false);
        }
        if(nuevoCodigo.equals("")){
            CodigoOriginalError.setText("Debe escribir el codigo de la sede");
            CodigoOriginalError.setVisible(true);
            return;
        }



        int codigoNumero;
        int codigoNumeroViejo;
        try{
            codigoNumero = Integer.parseInt(nuevoCodigoSede.getText().trim());
        }catch (Exception e){
            codigoError.setText("El codigo tiene que ser un numero");
            codigoError.setVisible(true);
            return;
        }
        try{
            codigoNumeroViejo = Integer.parseInt(codigoSede.getText().trim());
        }catch (Exception e){
            CodigoOriginalError.setText("El codigo tiene que ser un numero");
            CodigoOriginalError.setVisible(true);
            return;
        }


        if(!App.misSedes.containsKey(codigoNumeroViejo)){
            CodigoOriginalError.setText("No existe una sede con este codigo");
            CodigoOriginalError.setVisible(true);
            return;
        }

        if(App.misSedes.containsKey(codigoNumero)){
            codigoError.setText("Ya existe una sede con este codigo");
            codigoError.setVisible(true);
            return;
        }



        if (App.misSedes.containsKey(codigoNumeroViejo)) {
            Sedes sede = App.misSedes.get(codigoNumeroViejo);
            if (!NombreSede.getText().trim().equals("")) {
                sede.nombreSede = nombre;
            }
            if (!correoSede.getText().trim().equals("")) {
                sede.correoSede = correo;
            }
            if (!nuevoCodigoSede.getText().trim().equals("")) {
                App.misSedes.remove(codigoNumeroViejo);



                App.misSedes.put(codigoNumero, new Sedes(codigoNumero, sede.nombreSede, sede.correoSede));

            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setTitle("Edicion exitosa");
        alert.setHeaderText("Edicion exitosa");
        alert.setContentText("Edicion exitosa");
        alert.showAndWait();

    }

    @FXML
    private void cleanWarnings(){
        AdvertenciaLabel.setText("");
        codigoError.setText("");
        CodigoOriginalError.setText("");
    }




}
