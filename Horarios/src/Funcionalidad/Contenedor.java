/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Objetos.Asignatura;
import Objetos.Aula;
import Objetos.Curso;
import Objetos.Grupo;
import Objetos.Horario;
import Objetos.Profesor;
import Objetos.Titulacion;
import java.util.ArrayList;

/**
 *
 * @author Portatil-pc
 */
public class Contenedor {

    ArrayList<Asignatura> asignaturas;
    ArrayList<Aula> aulas;
    ArrayList<Curso> cursos;
    ArrayList<Grupo> grupos;
    ArrayList<Profesor> profesores;
    ArrayList<Horario> horarios;
    ArrayList<Titulacion> titulaciones;

    public Contenedor() {
        asignaturas = new ArrayList<>();
        aulas = new ArrayList<>();
        cursos = new ArrayList<>();
        grupos = new ArrayList<>();
        profesores = new ArrayList<>();
        horarios = new ArrayList<>();
        titulaciones = new ArrayList<>();
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public ArrayList<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(ArrayList<Aula> aulas) {
        this.aulas = aulas;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    public ArrayList<Titulacion> getTitulaciones() {
        return titulaciones;
    }

    public void setTitulaciones(ArrayList<Titulacion> titulaciones) {
        this.titulaciones = titulaciones;
    }

    public Profesor getProfesorPorNombre(String nombre) {
        Profesor pr = null;
        for (Profesor p : profesores) {
            if (p.getNombre().equals(nombre)) {
                pr = p;
                break;
            }
        }
        return pr;
    }

    public Titulacion getTitulacionPorNombre(String nombre) {
        Titulacion pr = null;
        for (Titulacion p : titulaciones) {
            if (p.getNombre().equals(nombre)) {
                pr = p;
                break;
            }
        }
        return pr;
    }

    public Aula getAulaPorNombre(String nombre) {
        Aula pr = null;
        for (Aula p : aulas) {
            if (p.getId_aula().equals(nombre)) {
                pr = p;
                break;
            }
        }
        return pr;
    }

    public Grupo getGrupoPorNombre(String titu,int c) {
        Grupo pr = null;
        for (Grupo p : grupos) {
            if (p.getTitulacion().getNombre().equals(titu)&&p.getCurso()==c) {
                pr = p;
                break;
            }
        }
        return pr;
    }
    
    public void anadirAsignatura(Asignatura a){
        asignaturas.add(a);
    }

}
