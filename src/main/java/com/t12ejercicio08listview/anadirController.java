package com.t12ejercicio08listview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controlador de la escena Añadir Datos en la cual se introducirán los datos de una nueva persona.<br>
 * <br>
 * Contiene los siguientes atributos:
 * <ul>
 *     <li><strong>TextField fieldNombre: </strong>Textfield donde se introducirá el nombre de la nueva persona</li>
 *     <li><strong>TextField fieldApellido: </strong>Textfield donde se introducirá el apellido de la nueva persona</li>
 *     <li><strong>Button botonSalvar: </strong>Boton que al ser pulsado modificará los atributos del objeto Persona seleccionado para que sean los introducidos en los textfields y cerrara la ventana</li>
 *     <li><strong>Button botonCancelar: </strong>Boton que al ser pulsado cerrará la ventana sin guardar cambios</li>
 *     <li><strong>Persona personaModificada: </strong>Objeto de la clase persona de la cual se van a introducir los datos</li>
 * </ul>
 * Es necesario llamar a la funcion pasarDatos() antes de mostrar la ventana.
 */
public class anadirController {
    @FXML
    private TextField fieldNombre;
    @FXML
    private TextField fieldApellido;
    @FXML
    private Button botonSalvar;
    @FXML
    private Button botonCancelar;

    private Persona personaAnadida;

    @FXML
    void pulsadoBoton(ActionEvent event){
        Button boton = (Button) event.getSource();
        switch(boton.getId()){
            case "botonSalvar":
                establecerDatos();
                break;
            case "botonCancelar":
                cerrar();
                break;
        }
    }

    private void cerrar(){
        Stage stage = (Stage) botonSalvar.getScene().getWindow();
        stage.close();
    }

    /**
     * Recibe un objeto de clase Persona que pasará a ser referenciada en el atributo <strong>perosnaModificada</strong>
     *
     * @param nuevaPersona Persona que va a ser creada
     */
    public void pasarDatos(Persona nuevaPersona){
        personaAnadida = nuevaPersona;
    }

    private void establecerDatos(){
        personaAnadida.setNombre(fieldNombre.getText().strip());
        personaAnadida.setApellido(fieldApellido.getText().strip());
        cerrar();
    }
}
