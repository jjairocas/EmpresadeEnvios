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

public class VerCentrosLController implements Initializable {

    public ListView listView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getItems().add("Vértices = Centros logísticos: ");
        for (CentroLogistico centro : App.misCentroLogistico.values()) {
            listView.getItems().add(centro);
        }

        listView.getItems().add("");
        listView.getItems().add("");

        listView.getItems().add("Aristas = Relaciones: ");

        for (CentroLogistico centro : App.misCentroLogistico.values()) {
            try {
                if (!(App.grafo.outgoingEdgesOf(centro) == null)) {
                    ArrayList<Object> Adyacentes = new ArrayList<>(Graphs.neighborListOf(App.grafo, centro));
                    listView.getItems().add(centro + ": ");
                    listView.getItems().add(Adyacentes);
                    listView.getItems().add("");
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("CRUDCentrosLogisticos");
    }
}
