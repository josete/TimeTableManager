/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import Objetos.Profesor;

/**
 *
 * @author Clara
 */
public class EjemploProfesorSinNombre {
    Profesor profesor;
    EProfesorSinNombre e= new EProfesorSinNombre("No puede haber un profesor sin nombre");
   public void lanzarException(Profesor profesor) throws EProfesorSinNombre{
       if (profesor.getNombre().length()==0){
           throw e;
       }
   }
}
