/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Excepciones.EProfesorSinNombre;
import Objetos.Profesor;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Clara
 */
public class Testeo {
    
    @Test
    public void unProfesorConNombre(){
        Profesor profesor=new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "");
        assertEquals("Adolfo",profesor.getNombre());
        
    }
        @Test
    public void unProfesorSinNombre(){
        Profesor profesor=new Profesor(null, "a.dolfo@usp.ceu.es", "");
        boolean sin = false;
        if(profesor.getNombre()==null){
            sin = true;
        }
        assertEquals(true,sin);
    }
    
       @Test
       public void profesorSinNombre(){
           Profesor profesor=new Profesor(null, "a.dolfo@usp.ceu.es", "2.2.2");
           assertNull(profesor.getNombre());
       }
    
    
       @Test
    public void unProfesorConCorreo(){
        Profesor profesor=new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "2.2.2");
        assertEquals("a.dolfo@usp.ceu.es",profesor.getEmail());
        
    }
       @Test
    public void unProfesorConDespacho(){
        Profesor profesor=new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "2.2.2");
        assertEquals("2.2.2",profesor.getDespacho());
        
    }

    private void assertNull(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
