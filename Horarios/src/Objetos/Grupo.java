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
public class Grupo {
    
    int id;
    Horario horario;
    Aula aula;
    Titulacion titulacion;
    int curso;
    String letra;

    public Grupo(Horario horario, Aula aula) {
        this.horario = horario;
        this.aula = aula;
    }

    public Grupo(int id,Aula aula, Titulacion titulacion, int curso,String letra) {
        this.aula = aula;
        this.titulacion = titulacion;
        this.curso = curso;
        this.id = id;
        this.letra = letra;
    }

    
    public Grupo() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Titulacion getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(Titulacion titulacion) {
        this.titulacion = titulacion;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return titulacion.getNombre()+" "+curso+" "+letra;
    }
    
    
    
}
