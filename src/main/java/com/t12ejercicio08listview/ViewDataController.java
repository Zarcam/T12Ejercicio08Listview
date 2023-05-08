package com.t12ejercicio08listview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewDataController implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
