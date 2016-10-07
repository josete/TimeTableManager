/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Clara
 */
public class EProfesorSinNombre extends Throwable{
    public EProfesorSinNombre(String msg) {
        super(msg);
    }
}
