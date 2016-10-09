/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Objetos.Asignatura;
import Objetos.Aula;
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
    ArrayList<Grupo> grupos;
    ArrayList<Profesor> profesores;
    ArrayList<Horario> horarios;
    ArrayList<Titulacion> titulaciones;

    public Contenedor() {
        asignaturas = new ArrayList<>();
        aulas = new ArrayList<>();
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
            if (p.getnAula().equals(nombre)) {
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
    
    public void anadirProfesor(Profesor p){
        profesores.add(p);
    }
    
    public void anadidTitulacion(Titulacion t){
        titulaciones.add(t);
    }
    
    public void anadirAula(Aula a){
        aulas.add(a);
    }
    
    public void anadirGrupo(Grupo g){
        grupos.add(g);
    }
    
    public void anadirHorario(Horario h){
        horarios.add(h);
    }
    
    public Profesor getProfesorPorId(int id){
        Profesor p1 = null;
        for(Profesor p: profesores){
            if(p.getId()==id){
                p1 = p;
                break;
            }
        }
        return p1;
    }
    
    public Titulacion getTitulacionPorId(int id){
        Titulacion t1=null;
        for(Titulacion t:titulaciones){
            if(t.getId()==id){
                t1 = t;
                break;
            }
        }
        return t1;
    }
    
    public Aula getAulaPorId(int id){
        Aula a1 = null;
        for(Aula a: aulas){
            if(a.getId()==id){
                a1 = a;
                break;
            }
        }
        return a1;
    }
    
    public Grupo getGrupoPorId(int id){
        Grupo g1 = null;
        for(Grupo g:grupos){
            if(g.getId()==id){
                g1 = g;
                break;
            }
        }
        return g1;
    }

    public boolean hayDatos(){
        boolean hay = false;
        if(asignaturas.size()>0&&aulas.size()>0&&grupos.size()>0&&profesores.size()>0&&titulaciones.size()>0){
            hay = true;
        }
        return hay;
    }
}
