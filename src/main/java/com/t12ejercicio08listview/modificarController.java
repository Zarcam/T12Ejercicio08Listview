package com.t12ejercicio08listview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controlador de la escena Modificar Datos en la cual se mostraran los datos de la persona seleccionada y podrán ser modificados.<br>
 * <br>
 * Contiene los siguientes atributos:
 * <ul>
 *     <li><strong>TextField fieldNombre: </strong>Textfield donde se mostrará el nombre de la persona seleccionada y se podrá modificar</li>
 *     <li><strong>TextField fieldApellido: </strong>Textfield donde se mostrará el apellido de la persona seleccionada y se podrá modificar</li>
 *     <li><strong>Button botonSalvar: </strong>Boton que al ser pulsado modificará los atributos del objeto Persona seleccionado para que sean los introducidos en los textfields y cerrara la ventana</li>
 *     <li><strong>Button botonCancelar: </strong>Boton que al ser pulsado cerrará la ventana sin guardar cambios</li>
 *     <li><strong>Persona personaModificada: </strong>Objeto de la clase persona de la cual se van a modificar los datos</li>
 * </ul>
 * Es necesario llamar a la funcion pasarDatos() antes de mostrar la ventana.
 */
public class modificarController {
    @FXML
    private TextField fieldNombre;
    @FXML
    private TextField fieldApellido;
    @FXML
    private Button botonSalvar;
    @FXML
    private Button botonCancelar;

    private Persona personaModificada;

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
     * y sus atributos <strong>nombre</strong> y <strong>apellidos</strong> se mostrarán en sus textFields correspondientes
     *
     * @param nuevaPersona Persona que va ha ser modificada
     */
    public void pasarDatos(Persona nuevaPersona){
        personaModificada = nuevaPersona;
        fieldApellido.setText(nuevaPersona.getApellido());
        fieldNombre.setText(nuevaPersona.getNombre());
    }

    private void establecerDatos(){
        if(fieldNombre.getText().strip().length() > 0 && fieldApellido.getText().strip().length() > 0) {
            personaModificada.setNombre(fieldNombre.getText().strip());
            personaModificada.setApellido(fieldApellido.getText().strip());
            cerrar();
        }
    }
}
