/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Familia
 */
public class Titulacion {
    
    int id;
    String nombre;
    int creditos;
    int tracker = 1;
    public Titulacion(int id,String nombre, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Titulacion(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }
    
    public Titulacion(){
        tracker = 2;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        if(tracker == 2){
            return "";
        }
        else{ return "Titulacion{" + "id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + '}';
    }
    }
    
    
}
