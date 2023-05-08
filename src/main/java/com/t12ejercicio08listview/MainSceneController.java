package com.t12ejercicio08listview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    private ListView<String> listaDeDatos;
    @FXML
    private Button verDatos;

    private Stage verDatosStage = new Stage();

    @FXML
    void pulsadoBoton(ActionEvent event){
        Button boton = (Button) event.getSource();
        switch(boton.getId()){
            case "verDatos":
                abrirVerDatos();
                break;
        }
    }

    private void abrirVerDatos(){
        try {
            if(!verDatosStage.isShowing()){
            FXMLLoader fxmlLoader = new FXMLLoader(ListViewApplication.class.getResource("viewData.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 465, 235);

            verDatosStage.setTitle("Ver Datos Persona");
            verDatosStage.setScene(scene);
            verDatosStage.show();

            ViewDataController controlador = fxmlLoader.<ViewDataController>getController();
            controlador.pasarDatos(listaDeDatos.getItems().get(0));
            }else{
             verDatosStage.toFront();
            }
        }catch(IOException ex){
            System.out.println("Sa roto");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> lista = new ArrayList<>();

        ObservableList<String> datos;
        datos = FXCollections.observableList(lista);

        datos.add("Garcia, Paco");

        listaDeDatos.setItems(datos);
    }
}