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
 * @author Rafael
 */
public class Sesion {
    
    int id;
    Asignatura asignatura;
    Grupo grupo;
    int numeroHoras;

    public Sesion(Asignatura asignatura, Grupo grupo) {
        this.asignatura = asignatura;
        this.grupo = grupo;
    }
     public Sesion(Asignatura asignatura, Grupo grupo, int numeroHoras) {
        this.asignatura = asignatura;
        this.grupo = grupo;
        this.numeroHoras=numeroHoras;
    }

    public Sesion() {
        asignatura = new Asignatura("----",null,0,null,2, 2);
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNumetoHoras(int numeroHoras){
        this.numeroHoras=numeroHoras;
    }
    
    public int getNumeroHoras(){
        return numeroHoras;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return asignatura.getNombre();
    }
    
    public String getInfo(){
        String info = "";
        info = "Profesor: "+asignatura.getProfesor().getNombre()
                +"\nCurso: "+asignatura.getCurso();
                //"\nAula: "+grupo.getAula().getId_aula();
        return info;
    }
    
    
    
    
 
    
}
