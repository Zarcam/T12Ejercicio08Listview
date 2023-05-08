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
    private ListView<Persona> listaDeDatos;
    @FXML
    private Button verDatos;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;

    private Stage verDatosStage = new Stage();

    private ObservableList<Persona> datos;

    @FXML
    void pulsadoBoton(ActionEvent event){
        Button boton = (Button) event.getSource();
        switch(boton.getId()){
            case "verDatos":
                abrirVerDatos();
                break;
            case "botonBorrar":
                datos.remove(listaDeDatos.getSelectionModel().getSelectedItem());
                break;
        }
    }

    private void abrirVerDatos(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ListViewApplication.class.getResource("viewData.fxml"));

            if(!verDatosStage.isShowing()){
            Scene scene = new Scene(fxmlLoader.load(), 465, 235);

            verDatosStage.setTitle("Ver Datos Persona");
            verDatosStage.setScene(scene);
            verDatosStage.show();
            }else{
             verDatosStage.toFront();
            }

            ViewDataController controlador = fxmlLoader.getController();

            Persona personaSeleccionada = listaDeDatos.getSelectionModel().getSelectedItem();
            controlador.pasarDatos(personaSeleccionada);
        }catch(IOException ex){
            System.out.println("Sa roto");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Persona> lista = new ArrayList<>();

        datos = FXCollections.observableList(lista);

        datos.add(new Persona("Paco", "Garcia"));
        datos.add(new Persona("Juan", "Perez"));

        listaDeDatos.setItems(datos);

        listaDeDatos.getSelectionModel().select(0);

        listaDeDatos.getSelectionModel().selectedIndexProperty().addListener((valorObservable, valorAntiguo, valorNuevo) -> {
            if(listaDeDatos.getSelectionModel().getSelectedIndex() == -1){
                verDatos.setDisable(true);
                botonBorrar.setDisable(true);
                botonModificar.setDisable(true);
            }else{
                verDatos.setDisable(false);
                botonBorrar.setDisable(false);
                botonModificar.setDisable(false);
            }
        });
    }
}