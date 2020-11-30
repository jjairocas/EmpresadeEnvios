package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.jgrapht.Graphs;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VerEmpresaController implements Initializable {

    public ListView listView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getItems().add("Vértices = Empresas: ");
        for (Empresa empresa : App.misEmpresas.values()) {
            listView.getItems().add(empresa);
        }

        listView.getItems().add("");
        listView.getItems().add("");

        listView.getItems().add("Aristas = Relaciones: ");

        for (Empresa empresa : App.misEmpresas.values()) {
            ArrayList<Object> Adyacentes = new ArrayList<>(Graphs.neighborListOf(App.grafo, empresa));
            listView.getItems().add(empresa+": ");
            listView.getItems().add(Adyacentes);
            listView.getItems().add("");

        }
    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        App.setRoot("CRUDEmpresas");
    }
}
