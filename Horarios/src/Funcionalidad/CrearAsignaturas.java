/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Objetos.Asignatura;

/**
 *
 * @author Familia
 */
public class CrearAsignaturas {
    
    public static Asignatura[] crearAsignaturas(){
        Asignatura[] asignaturas = new Asignatura[5];
        asignaturas[0] = new Asignatura("Software", 6, 2);
        asignaturas[1] = new Asignatura("IA", 6, 2);
        asignaturas[2] = new Asignatura("ISI", 4, 2);
        asignaturas[3] = new Asignatura("SI", 4, 2);
        asignaturas[4] = new Asignatura("Proyectos", 4, 2);
        //asignaturas[5] = new Asignatura("Programacion", 4, 2);
        
        return asignaturas;
    }
}

