package com.t12ejercicio08listview;

public class Persona {
    private String nombre;
    private String apellido;

    Persona(String nuevoNombre, String nuevoApellido){
        this.setNombre(nuevoNombre);
        this.setApellido(nuevoApellido);
    }

    @Override
    public String toString(){
        return (getApellido() + ", " + getNombre());
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
