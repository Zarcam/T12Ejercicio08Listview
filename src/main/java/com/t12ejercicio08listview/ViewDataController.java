package com.t12ejercicio08listview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewDataController implements Initializable {
    @FXML
    private Button botonCerrar;

    @FXML
    void pulsadoBoton(ActionEvent event){
        Button boton = (Button) event.getSource();
        Stage stage = (Stage) boton.getScene().getWindow();

        stage.close();
    }

    public void pasarDatos(String persona){
        System.out.println(persona);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
