/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Excepciones.EProfesorSinNombre;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Familia
 */
public class Profesor {
    
    int id;
    String nombre;
    String email;
    String despacho;
    EProfesorSinNombre e= new EProfesorSinNombre("No puede haber un profesor sin nombre");

    public Profesor(String nombre, String email, String despacho,int id) throws EProfesorSinNombre {
        if (nombre==null){
            throw e;
        }
        else{
        this.nombre = nombre;
        this.email = email;
        this.despacho = despacho;
        this.id = id;
        }
    }
    

    public Profesor(String nombre, String email, String despacho) throws EProfesorSinNombre{
        if (nombre==null){
            throw e;
        }
        else{
        this.nombre = nombre;
        this.email = email;
        this.despacho = despacho;
        }
    }
    //public Profesor() {
      // }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre(){
        return nombre;
        }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    @Override
    public String toString() {
        return "Profesor{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", despacho=" + despacho + ", e=" + e + '}';
    }
    
    
           
}
