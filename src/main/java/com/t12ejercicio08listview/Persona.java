package com.t12ejercicio08listview;

/**
 * Contiene atributos para guardar información de las personas que se mostrarán en la ListView:
 * <ul>
 *     <li><strong>String nombre: </strong>Nombre de la persona</li>
 *     <li><strong>String apellido: </strong>Apellido de la persona</li>
 * </ul>
 * El metodo toString() está sobreescrito para devolver (nombre + ", " + apellido)
 */
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
