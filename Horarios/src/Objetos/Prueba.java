/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Excepciones.EProfesorSinNombre;

/**
 *
 * @author Clara
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EProfesorSinNombre {
        Profesor profesor=new Profesor("","d2","2.2");
        System.out.println("longitud"+profesor.nombre.length());
    }
    
}
