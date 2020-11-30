package app;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BusquedaController implements Initializable {
    public ListView list;


    @FXML
    public Button VolverButton;
    @FXML
    public Button buscarButton;
    @FXML
    public ChoiceBox<String> entidadChoiceBox;
    @FXML
    public ChoiceBox<String> atributoChoiceBox;

    @FXML
    public Label ErrorBloque1;
    @FXML
    public TextField busqueda;
    @FXML
    public Label ErrorBloque2;
    @FXML
    public Label ErrorBusqueda;


    @FXML
    public TextField valorTextField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<String> opcionesEntidadChoiseBox = new ArrayList<>();
        opcionesEntidadChoiseBox.add("Empresa");
        opcionesEntidadChoiseBox.add("Sede");
        opcionesEntidadChoiseBox.add("Centro logistico");
        entidadChoiceBox.setItems(FXCollections.observableList(new ArrayList<>(opcionesEntidadChoiseBox)));


        ArrayList<String> opcionesAtributosChoiseBox = new ArrayList<>();
        opcionesAtributosChoiseBox.add("Codigo");
        opcionesAtributosChoiseBox.add("Nombre");
        opcionesAtributosChoiseBox.add("Telefono/Correo/Direccion");
        atributoChoiceBox.setItems(FXCollections.observableList(new ArrayList<>(opcionesAtributosChoiseBox)));

        }



    public void buscar(ActionEvent event)throws IOException{
        cleanWarnings();
        String claseSeleccionada = String.valueOf(entidadChoiceBox.getValue());
        ArrayList<Object> imprimirObjetos = new ArrayList<>();
        if(!claseSeleccionada.equals("")){

            String busquedaObjeto = busqueda.getText().trim();
            String atributoSeleccionado = String.valueOf(atributoChoiceBox.getValue());
            if (busquedaObjeto.equals("") || atributoSeleccionado.equals("")){
                ErrorBloque1.setText("Debe escribir un dato");
                ErrorBloque2.setText("Debe escribir un dato");
                ErrorBloque1.setVisible(true);
                ErrorBloque2.setVisible(true);
                return;
            }

            if(claseSeleccionada.equals("Empresa")){

                if(atributoSeleccionado.equals("Codigo")){
                    try{
                        Integer.parseInt(busqueda.getText().trim());
                    }catch (Exception e){
                        ErrorBusqueda.setText("El codigo tiene que ser un numero");
                        return;
                    }
                    imprimirObjetos.add(App.misEmpresas.get(Integer.parseInt(busquedaObjeto)));

                } else if(atributoSeleccionado.equals("Nombre")){
                    for (Empresa empresa: App.misEmpresas.values()){
                        if(empresa.nombreDelaEmpresa.equals(busquedaObjeto)){
                            imprimirObjetos.add(empresa);
                        }
                    }
                } else if(atributoSeleccionado.equals("Telefono/Correo/Direccion")){

                    int numeroTelefono;
                    try{
                        numeroTelefono = Integer.parseInt(busqueda.getText().trim());
                    }catch (Exception e){
                        ErrorBusqueda.setText("El codigo tiene que ser un numero");
                        return;
                    }

                    for (Empresa empresa: App.misEmpresas.values()){
                        if(empresa.numeroTelefonico == numeroTelefono){
                            imprimirObjetos.add(empresa);
                        }
                    }

                }

            }else if(claseSeleccionada.equals("Sede")){


                if(atributoSeleccionado.equals("Codigo")){

                    try{
                        Integer.parseInt(busqueda.getText().trim());
                    }catch (Exception e){
                        ErrorBusqueda.setText("El codigo tiene que ser un numero");
                        return;
                    }
                    imprimirObjetos.add(App.misSedes.get(Integer.parseInt(busquedaObjeto)));

                } else if(atributoSeleccionado.equals("Nombre")){
                    for (Sedes sede: App.misSedes.values()){
                        if(sede.nombreSede.equals(busquedaObjeto)){
                            imprimirObjetos.add(sede);
                        }
                    }
                } else if(atributoSeleccionado.equals("Telefono/Correo/Direccion")){
                    for (Sedes sede: App.misSedes.values()){
                        if(sede.correoSede.equals(busquedaObjeto)){
                            imprimirObjetos.add(sede);
                        }
                    }
                }

            }else if(claseSeleccionada.equals("Centro logistico")){

                if(atributoSeleccionado.equals("Codigo")){
                    try{
                        Integer.parseInt(busquedaObjeto);
                    }catch (Exception e){
                        ErrorBusqueda.setText("El codigo tiene que ser un numero");
                        return;
                    }
                    imprimirObjetos.add(App.misCentroLogistico.get(Integer.parseInt(busquedaObjeto)));

                } else if(atributoSeleccionado.equals("Nombre")){

                    for (CentroLogistico CLogistico: App.misCentroLogistico.values()){
                        if(CLogistico.nombreCentroLogistico.equals(busquedaObjeto)){
                            imprimirObjetos.add(CLogistico);
                        }
                    }
                } else if(atributoSeleccionado.equals("Telefono/Correo/Direccion")){

                    for (CentroLogistico CLogistico: App.misCentroLogistico.values()){
                        if(CLogistico.direccionCentroLogistico.equals(busquedaObjeto)){
                            imprimirObjetos.add(CLogistico);
                            break;
                        }
                    }
                }

            }
        }


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setTitle("Busqueda satisfactoria");
        alert.setHeaderText("Busqueda satisfactoria");
        alert.setContentText("Se ha encontrado satisfactoriamente:\n" + imprimirObjetos);
        alert.showAndWait();

    }



    @FXML
    public void volver(ActionEvent event)throws IOException {
        App.setRoot("MenuPrincipal");
    }

    @FXML
    private void cleanWarnings(){
        ErrorBloque2.setText("");
        ErrorBusqueda.setText("");
        ErrorBloque1.setText("");
    }
}
