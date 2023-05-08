package com.t12ejercicio08listview;

public class Persona {
    private String nombre;
    private String apellido;

    Persona(String nuevoNombre, String nuevoApellido){
        this.nombre = nuevoNombre;
        this.apellido = nuevoApellido;
    }

    @Override
    public String toString(){
        return (apellido + ", " + nombre);
    }
}
