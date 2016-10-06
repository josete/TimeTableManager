/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Objetos.Asignatura;
import Objetos.Profesor;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
//dimport static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author angelnuneztorron
 */
public class NewEmptyJUnitTest extends TestCase {
    
//    public NewEmptyJUnitTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//    @Test
//    public void unProfesorConNombre(){
//        Profesor profesor=new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "");
//        assertEquals("Adolfo",profesor.getNombre());
//        
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    
    @Test
    public void testNombreAsignaturaNotNull(){
        Asignatura asignatura=new Asignatura("Software",3,6,2);
        assertNotNull(asignatura.getNombre());
        
    }
    @Test
    public void testAsignaturaSinNombre(){
        Asignatura asignatura=new Asignatura(null,3,6,2);
        boolean nombre = false;
        if(asignatura.getNombre()==null){
            nombre = true;
        }
        assertEquals(true,nombre);
    }
    @Test
    public void testAsignaturaPerteneceCurso(){
        Asignatura a=new Asignatura("www",3,6,2);
        int curso=a.getCurso();
        assertEquals(curso,3);
    }
    @Test
    public void testAsignaturaTieneNombre(){
        Asignatura a=new Asignatura("Software",3,6,2);
        String nombre=a.getNombre();
        assertEquals("Software",nombre);
    }
    @Test
    public void testAsignaturaTieneHorasSemanales(){
        Asignatura a=new Asignatura("Soft",3,6,2);
        int horasSem=a.getHorasSemanales();
        assertEquals(6,horasSem);
    }
}    