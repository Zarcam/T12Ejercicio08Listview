package com.t12ejercicio08listview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controlador de la escena Ver Datos en la cual se vera los datos de la persona seleccionada.<br>
 * <br>
 * Contiene los siguientes atributos:
 * <ul>
 *     <li><strong>TextField fieldNombre: </strong>Textfield donde se verá el nombre de la persona seleccionada</li>
 *     <li><strong>TextField fieldApellido: </strong>Textfield donde se verá el apellido de la persona seleccionada</li>
 *     <li><strong>Button botonCerrar: </strong>Boton que al ser pulsado cerrará la ventana</li>
 * </ul>
 * Es necesario llamar a la funcion pasarDatos() antes de mostrar la ventana.
 */
public class ViewDataController{
    @FXML
    private Button botonCerrar;
    @FXML
    private TextField fieldNombre;
    @FXML
    private TextField fieldApellido;

    @FXML
    void pulsadoBoton(ActionEvent event){
        Button boton = (Button) event.getSource();
        Stage stage = (Stage) boton.getScene().getWindow();

        stage.close();
    }

    public void pasarDatos(Persona persona){
        fieldNombre.setText(persona.getNombre());
        fieldApellido.setText(persona.getApellido());
    }
}
