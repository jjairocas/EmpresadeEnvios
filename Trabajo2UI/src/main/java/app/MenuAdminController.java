package App;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MenuAdminController  implements Initializable{

    @FXML
    public Button volverButton;
    @FXML
    public Button enviarButton;
    @FXML
    public ChoiceBox<String> opciones;
    @FXML
    public Label opcionesLabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> opcionesChoiseBox = new ArrayList<>();
        opcionesChoiseBox.add("Empresa");
        opcionesChoiseBox.add("Sede");
        opcionesChoiseBox.add("Centro logistico");
        opciones.setItems(FXCollections.observableList(opcionesChoiseBox));
    }

    @FXML
    public void volver(ActionEvent event)throws IOException {
        App.setRoot("MenuPrincipal");
    }
    @FXML
    public void enviar(ActionEvent event)throws IOException{
        String claseSeleccionada = String.valueOf(opciones.getValue());
        if(!claseSeleccionada.equals("")){
            if(claseSeleccionada.equals("Empresa")){
                App.setRoot("CRUDEmpresas");
            }else if(claseSeleccionada.equals("Sede")){
                App.setRoot("CRUDSedes");
            }else if(claseSeleccionada.equals("Centro logistico")){
                App.setRoot("CRUDCentrosLogisticos");
            }
        }
        else{
            opcionesLabel.setText("Debe seleccionar una clase");
            opcionesLabel.setVisible(true);
        }

    }








}
