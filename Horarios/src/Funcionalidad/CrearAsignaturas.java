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

/**
 *
 * @author Familia
 */
public class CrearAsignaturas {
    
    public static Sesion[] crearAsignaturas(){
        Sesion[] sesiones = new Sesion[5];
        sesiones[0] = new Sesion(new Asignatura("Software", new Profesor("RAul", "raul@usp.ceu.es", "3.4"), 3, new Titulacion("Informatica", 180), 6, 2), new Aula("1.5.10"), new Grupo());
        sesiones[1] = new Sesion(new Asignatura("IA", new Profesor("Mariano", "mariano@usp.ceu.es", "3.4"), 3, new Titulacion("Informatica", 180), 6, 2), new Aula("1.5.10"), new Grupo());
        sesiones[2] = new Sesion(new Asignatura("ISI", new Profesor("Paloma", "paloma@usp.ceu.es", "3.4"), 3, new Titulacion("Informatica", 180), 4, 2), new Aula("1.5.10"), new Grupo());
        sesiones[3] = new Sesion(new Asignatura("SI", new Profesor("Angel", "angel@usp.ceu.es", "3.4"), 3, new Titulacion("Informatica", 180), 4, 2), new Aula("1.5.10"), new Grupo());
        sesiones[4] = new Sesion(new Asignatura("Proyectos", new Profesor("Jose Manuel", "mariano@usp.ceu.es", "3.4"), 3, new Titulacion("Informatica", 180), 4, 2), new Aula("1.5.10"), new Grupo());
        //asignaturas[5] = new Asignatura("Programacion", 4, 2);
        
        return sesiones;
    }
}

