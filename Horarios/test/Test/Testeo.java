/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Excepciones.EHorarioSinAsignaturas;
import Excepciones.EHorarioSinGrupo;
import Excepciones.EProfesorSinNombre;
import Objetos.Grupo;
import Objetos.Horario;
import Objetos.Profesor;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Clara
 */
public class Testeo {

    @Test
    public void unProfesorConNombre() {
        Profesor profesor = new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "");
        assertEquals("Adolfo", profesor.getNombre());
        

    }

    @Test
    public void unProfesorSinNombre() {
        Profesor profesor = new Profesor(null, "a.dolfo@usp.ceu.es", "");
        boolean sin = false;
        if (profesor.getNombre() == null) {
            sin = true;
        }
        assertEquals(true, sin);
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
    public void unProfesorConDespacho() {
        Profesor profesor = new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "2.2.2");
        assertEquals("2.2.2", profesor.getDespacho());

    }

    private void assertNull(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Test(expected = EHorarioSinGrupo.class)
    public void horarioSinGrupo() throws EHorarioSinGrupo{
        Horario horario = new Horario();
        try {
            horario.generar();
        } catch (EHorarioSinAsignaturas ex) {
            Logger.getLogger(Testeo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test(expected = EHorarioSinAsignaturas.class)
    public void horarioSinAsignaturas() throws EHorarioSinAsignaturas{
        Horario horario = new Horario();
        horario.setG(new Grupo());
        try {
            horario.generar();
        } catch (EHorarioSinGrupo ex) {
            Logger.getLogger(Testeo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
