package com.t12ejercicio08listview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    public void pasarDatos(Persona nuevaPersona){
        personaAnadida = nuevaPersona;
    }

    private void establecerDatos(){
        personaAnadida.setNombre(fieldNombre.getText().strip());
        personaAnadida.setApellido(fieldApellido.getText().strip());
        cerrar();
    }
}
