/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Alr6
 */
public class EProfesorNoPuedeCambiarNombre extends Throwable{
    public EProfesorNoPuedeCambiarNombre(){
        super("El profesor no puede cambiar de nombre");
    }
}
