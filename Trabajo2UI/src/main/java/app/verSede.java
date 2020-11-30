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

public class verSede implements Initializable {

    public ListView listView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getItems().add("Vértices = Sedes: ");
        for (Sedes sede : App.misSedes.values()) {
            listView.getItems().add(sede);
        }

        listView.getItems().add("");
        listView.getItems().add("");

        listView.getItems().add("Aristas = Relaciones: ");

        for (Sedes sede : App.misSedes.values()) {


            for (Sedes centro : App.misSedes.values()) {


                try{
                    if(!(App.grafo.outgoingEdgesOf(centro) == null)){
                        ArrayList<Object> Adyacentes = new ArrayList<>(Graphs.neighborListOf(App.grafo, centro));
                        listView.getItems().add(centro + ": ");
                        listView.getItems().add(Adyacentes);
                        listView.getItems().add("");
                    }
                }catch (Exception e){
                    return;
                }
            }

            ArrayList<Object> Adyacentes = new ArrayList<>(Graphs.neighborListOf(App.grafo, sede));
            listView.getItems().add(sede+": ");
            listView.getItems().add(Adyacentes);
            listView.getItems().add("");

        }
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("CRUDSedes");
    }
}
