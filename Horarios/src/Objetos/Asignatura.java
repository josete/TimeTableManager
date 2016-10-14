/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.text.SimpleDateFormat;

/**
 *
 * @author Familia
 */
public class Asignatura {
    
    String nombre;
    Profesor profesor;
    int curso;
    Titulacion titulacion;
    int horasSemanales;
    int horasSesion;
    
    boolean puedeRepetir = false;
    
    
    int tracker = 1;
    //Fin
    boolean diaActualPuede = true;
    boolean topeSemana = false;

    int horasSemanaActual = 0;

    public Asignatura(String nombre, Profesor profesor, int curso, Titulacion titulacion, int horasSemanales, int horasSesion) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.curso = curso;
        this.titulacion = titulacion;
        this.horasSemanales = horasSemanales;
        this.horasSesion = horasSesion;
    }

    public Asignatura(String nombre, int curso, int horasSemanales, int horasSesion) {
        this.nombre = nombre;
        this.curso = curso;
        this.horasSemanales = horasSemanales;
        this.horasSesion = horasSesion;
    }

    public Asignatura() {
        tracker = 2;
    }
    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public int getHorasSesion() {
        return horasSesion;
    }

    public void setHorasSesion(int horasSesion) {
        this.horasSesion = horasSesion;
    }

    public boolean isDiaActualPuede() {
        return diaActualPuede;
    }

    public void sumar(){
        horasSemanaActual+=horasSesion;
        horasSemanales-=horasSesion;
        if(horasSemanaActual==horasSemanales){
            topeSemana=true;
        }
        if(puedeRepetir){diaActualPuede=true;}
    }
    public void setDiaActualPuede(boolean diaActualPuede) {
        this.diaActualPuede = diaActualPuede;
    }

    public boolean isTopeSemana() {
        return topeSemana;
    }

    public void setTopeSemana(boolean topeSemana) {
        this.topeSemana = topeSemana;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public Titulacion getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(Titulacion titulacion) {
        this.titulacion = titulacion;
    }

    @Override
    public String toString() throws NullPointerException{
        if (tracker ==2){
        return ("");
        }
        else return "Asignatura{" + "nombre=" + nombre + ", profesor=" + profesor + ", curso=" + curso + ", titulacion=" + titulacion + ", horasSemanales=" + horasSemanales + ", horasSesion=" + horasSesion + ", puedeRepetir=" + puedeRepetir + ", diaActualPuede=" + diaActualPuede + ", topeSemana=" + topeSemana + ", horasSemanaActual=" + horasSemanaActual + '}';
    }
    
    
    
    
    
}
