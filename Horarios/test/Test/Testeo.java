/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Excepciones.EHorarioSinAsignaturas;
import Excepciones.EHorarioSinGrupo;
import Excepciones.EProfesorSinNombre;
import Funcionalidad.Contenedor;
import Objetos.Asignatura;
import Objetos.Aula;
import Objetos.Grupo;
import Objetos.Horario;
import Objetos.Profesor;
import Objetos.Titulacion;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author Clara
 */
public class Testeo {

    @Test
    public void unProfesorConNombre() throws EProfesorSinNombre{
        Profesor profesor = new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "");
        assertEquals("Adolfo", profesor.getNombre());
        

    }
    
       @Test (expected = EProfesorSinNombre.class)
       public void profesorSinNombre()throws EProfesorSinNombre {
          Profesor profesor=new Profesor(null, "a.dolfo@usp.ceu.es","2.6.4",0);
          assertEquals("No puede haber un profesor sin nomnre",profesor);
        
       }
       //Tengo que poder crear un profesor sin correo.
       @Test
       public void profesorSinCorreo() throws EProfesorSinNombre{
           Profesor profesor=new Profesor("Rafael Zarza", null,"0.0.0",1);
           assertEquals(profesor,profesor);
       }
       //Tengo que poder crear un profesor sin despacho
          @Test
       public void profesorSinDespacho() throws EProfesorSinNombre{
           Profesor profesor=new Profesor("RGG","rgg@eps.ceu.es",null,2);
           assertEquals(profesor,profesor);
       }
    
       @Test
    public void unProfesorConCorreo() throws EProfesorSinNombre{
        Profesor profesor=new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "2.2.2");
        assertEquals("a.dolfo@usp.ceu.es",profesor.getEmail());
    }

    @Test
    public void unProfesorConDespacho() throws EProfesorSinNombre {
        Profesor profesor = new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "2.2.2");
        assertEquals("2.2.2", profesor.getDespacho());

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
    //Fin comprobacion -- Arreglar
 @Test
    public void anadirAsignatura() {
        Contenedor c = new Contenedor();
        Asignatura a = new Asignatura("ADE", 1, 6, 8);
        c.anadirAsignatura(a); 

    }
 @Test
    public void anadirTitulacion() {
        Contenedor c = new Contenedor();
        Titulacion t = new Titulacion("Ingenieria Soft", 240);
        c.anadidTitulacion(t);
        

    }
// @Test
//    public void anadirProfesor() {
//        Contenedor c = new Contenedor();
//        Profesor p = new Profesor();
//        c.anadirProfesor(p); 
//
//    }
 @Test
    public void anadirGrupo() {
        Contenedor c = new Contenedor();
        Titulacion t = new Titulacion("Ingenieria Soft", 240);
        Aula a = new Aula(1, "1.5.5");
        Grupo g = new Grupo(1, a, t, 1, "A");
        c.anadirGrupo(g);

    }
}
