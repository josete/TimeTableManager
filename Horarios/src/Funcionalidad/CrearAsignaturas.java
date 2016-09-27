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
        Asignatura[] asignaturas = new Asignatura[6];
        asignaturas[0] = new Asignatura("Software", 4, 2);
        asignaturas[1] = new Asignatura("IA", 4, 2);
        asignaturas[2] = new Asignatura("Proyectos", 4, 2);
        asignaturas[3] = new Asignatura("Infraestructuras", 4, 2);
        asignaturas[4] = new Asignatura("Sistemas", 4, 2);
        asignaturas[5] = new Asignatura("Programacion", 4, 2);
        
        return asignaturas;
    }
}

