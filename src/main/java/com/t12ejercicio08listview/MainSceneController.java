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

/**
 * Controlador de la escena principal en la que se encuentra la ListView que mostrará la información de las personas.<br>
 * <br>
 * Contiene los siguientes atributos:
 * <ul>
 *     <li><strong>ListView listaDatos: </strong>Objecto ListView que muestra el valor devuelto de la función toString() de los objetos Persona que almacena el atributo <strong>datos</strong></li>
 *     <li><strong>Button verDatos: </strong>Boton que al ser pulsado abrirá la escena Ver Datos con los datos de la persona seleccionada</li>
 *     <li><strong>Button botonBorrar: </strong>Boton que al ser pulsado borrará la persona seleccionada del atributo <strong>datos</strong></li>
 *     <li><strong>Button botonModificar: </strong>Boton que al ser pulsado abrirá la escena Modificar Datos con los datos de la persona seleccionada</li>
 *     <li><strong>Button botonAnadir: </strong>Boton que al ser pulsado abrirá la escena Añadir Persona</li>
 *     <li><strong>Stage verDatosStage: </strong>Stage que mostrará la escena Ver Datos</li>
 *     <li><strong>Stage anadirPersonaStage: </strong>Stage que mostrará la escena Añadir Persona</li>
 *     <li><strong>Stage modificarPersonaStage: </strong>Stage que mostrará la escena Modificar Datos</li>
 *     <li><strong>ObservableList datos: </strong>Almacenará los obejetos de clase Persona</li>
 * </ul>
 */
public class MainSceneController implements Initializable {
    @FXML
    private ListView<Persona> listaDeDatos;
    @FXML
    private Button verDatos;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonAnadir;

    private final Stage verDatosStage = new Stage();
    private final Stage anadirPersonaStage = new Stage();
    private final Stage modificarPersonaStage = new Stage();

    private ObservableList<Persona> datos;

    @FXML
    private void pulsadoBoton(ActionEvent event){
        Button boton = (Button) event.getSource();
        switch(boton.getId()){
            case "verDatos":
                abrirVerDatos();
                break;
            case "botonBorrar":
                datos.remove(listaDeDatos.getSelectionModel().getSelectedItem());
                break;
            case "botonModificar":
                abrirModificar();
                break;
            case "botonAnadir":
                abrirAnadir();
                break;
        }
    }

    private void abrirAnadir(){
        try {
            if(!anadirPersonaStage.isShowing()){
                FXMLLoader fxmlLoader = new FXMLLoader(ListViewApplication.class.getResource("modificarYAnadir.fxml"));
                fxmlLoader.setController(new anadirController());
                Scene scene = new Scene(fxmlLoader.load(), 465, 235);

                anadirPersonaStage.setTitle("Añadir nueva persona");
                anadirPersonaStage.setScene(scene);

                anadirController controlador = fxmlLoader.getController();

                Persona nuevaPersona = new Persona("", "");
                controlador.pasarDatos(nuevaPersona);

                anadirPersonaStage.showAndWait();
                if(nuevaPersona.getApellido().length() > 0 && nuevaPersona.getNombre().length() > 0) {
                    datos.add(nuevaPersona);
                }
            }else{
                anadirPersonaStage.toFront();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void abrirModificar(){
        try {
            if(!modificarPersonaStage.isShowing()){
                FXMLLoader fxmlLoader = new FXMLLoader(ListViewApplication.class.getResource("modificarYAnadir.fxml"));
                fxmlLoader.setController(new modificarController());
                Scene scene = new Scene(fxmlLoader.load(), 465, 235);

                modificarPersonaStage.setTitle("Modificar datos de persona");
                modificarPersonaStage.setScene(scene);

                modificarController controlador = fxmlLoader.getController();

                Persona personaSeleccionada = listaDeDatos.getSelectionModel().getSelectedItem();
                controlador.pasarDatos(personaSeleccionada);

                modificarPersonaStage.showAndWait();
                listaDeDatos.refresh();
            }else{
                modificarPersonaStage.toFront();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
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

                ViewDataController controlador = fxmlLoader.getController();

                Persona personaSeleccionada = listaDeDatos.getSelectionModel().getSelectedItem();
                controlador.pasarDatos(personaSeleccionada);
            }else{
             verDatosStage.toFront();
            }
        }catch(IOException ex){
            System.out.println("Sa roto");
        }
    }

    private void deshabilitarBotones(boolean valor){
        verDatos.setDisable(valor);
        botonBorrar.setDisable(valor);
        botonModificar.setDisable(valor);
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
                deshabilitarBotones(true);
            }else{
                deshabilitarBotones(false);
            }
        });
    }
}