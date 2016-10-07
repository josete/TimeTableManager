/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Objetos.Asignatura;
import Objetos.Aula;
import Objetos.Grupo;
import Objetos.Profesor;
import Objetos.Sesion;
import Objetos.Titulacion;
import java.util.ArrayList;

/**
 *
 * @author Familia
 */
public class CrearAsignaturas {

    public static Sesion[] crearAsignaturas(Contenedor almacenamiento) {
        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        ArrayList<Profesor> profesores = new ArrayList<>();
        ArrayList<Titulacion> titulaciones = new ArrayList<>();
        ArrayList<Aula> aulas = new ArrayList<>();
        ArrayList<Grupo> grupos = new ArrayList<>();

        profesores.add(new Profesor("Raul", "raul@usp.ceu.es", "3.4"));
        profesores.add(new Profesor("Mariano", "mariano@usp.ceu.es", "3.4"));
        profesores.add(new Profesor("Paloma", "paloma@usp.ceu.es", "3.4"));
        profesores.add(new Profesor("Angel", "angel@usp.ceu.es", "3.4"));
        profesores.add(new Profesor("Jose Manuel", "joseManuel@usp.ceu.es", "3.4"));

        almacenamiento.setProfesores(profesores);

        titulaciones.add(new Titulacion("informatica", 240));
        almacenamiento.setTitulaciones(titulaciones);

        asignaturas.add(new Asignatura("Software", almacenamiento.getProfesorPorNombre("Raul"), 3, almacenamiento.getTitulacionPorNombre("informatica"), 6, 2));
        asignaturas.add(new Asignatura("IA", almacenamiento.getProfesorPorNombre("Raul"), 3, almacenamiento.getTitulacionPorNombre("informatica"), 6, 2));
        asignaturas.add(new Asignatura("IS", almacenamiento.getProfesorPorNombre("Raul"), 3, almacenamiento.getTitulacionPorNombre("informatica"), 4 ,2));
        asignaturas.add(new Asignatura("ISI", almacenamiento.getProfesorPorNombre("Raul"), 3, almacenamiento.getTitulacionPorNombre("informatica"), 4, 2));
        asignaturas.add(new Asignatura("Proyectos", almacenamiento.getProfesorPorNombre("Raul"), 3, almacenamiento.getTitulacionPorNombre("informatica"), 4, 2));
        almacenamiento.setAsignaturas(asignaturas);
        
        aulas.add(new Aula(1,"1.5.10"));
        almacenamiento.setAulas(aulas);
        
        grupos.add(new Grupo(1,almacenamiento.getAulaPorNombre("1.5.10"), almacenamiento.getTitulacionPorNombre("informatica"), 3,"A"));
        almacenamiento.setGrupos(grupos);
        
        Sesion[] s = crearSeiones(asignaturas, almacenamiento.getGrupoPorNombre("informatica", 3));
        return s;
        
    }
    
    public static Sesion[] crearSeiones(ArrayList<Asignatura> asignaturas,Grupo g){
        ArrayList<Sesion> sesiones = new ArrayList();
        for(Asignatura a:asignaturas){
            if(a.getHorasSemanales()>0){
                sesiones.add(new Sesion(a,g));
                //a.sumar();
            }
        }
        Sesion[] sesiones2 = new Sesion[sesiones.size()];
        sesiones2=sesiones.toArray(sesiones2);
        return sesiones2;
    }
}
