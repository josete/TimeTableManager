/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Excepciones.EHorarioSinGrupo;
import Excepciones.EProfesorSinNombre;
import Objetos.Horario;
import Objetos.Profesor;
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

    @Test(expected = EProfesorSinNombre.class)
    public void profesorSinNombre() {
        Profesor profesor = new Profesor(null, "a.dolfo@usp.ceu.es", "");
        profesor.getNombre();
    }

    @Test
    public void unProfesorConCorreo() {
        Profesor profesor = new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "");
        assertEquals("a.dolfo@usp.ceu.es", profesor.getEmail());

    }

    @Test
    public void unProfesorConDespacho() {
        Profesor profesor = new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "2.2.2");
        assertEquals("2.2.2", profesor.getDespacho());

    }
    
    @Test(expected = EHorarioSinGrupo.class)
    public void horarioSinGrupo() throws EHorarioSinGrupo{
        Horario horario = new Horario();
        horario.generar();
    }

}
