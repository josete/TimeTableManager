/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Objetos.Asignatura;
import Objetos.Aula;
import Objetos.Profesor;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
//dimport static org.junit.Assert.*;
import junit.framework.TestCase;
import static org.junit.Assert.assertNull;

/**
 *
 * @author angelnuneztorron
 */
public class TestAsignatura extends TestCase {
    
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
    public void testCursoAsignaturaNotNull(){
       Asignatura asignatura=new Asignatura("Software",3,6,2);
        assertNotNull(asignatura.getCurso());
        
    }
    //Dar una vuerlta -- Asignatura tiene que tener nombre
    /*@Test (expected=asn)
    public void testUnaAsignaturaTieneQueTenerNombre() throws asn {
        Asignatura asignatura=new Asignatura("1isw",3,6,2);
    }*/
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
    @Test
    public void testAsignaturatieneHorasSemanalesNoNulasNinegativas(){
        Asignatura a=new Asignatura("Soft",3,6,2);
        boolean horasSemanalesMayoresQueCero=false;
       int horasSem=a.getHorasSemanales();
        if(horasSem>0){
            horasSemanalesMayoresQueCero=true;
        }
        assertTrue(horasSemanalesMayoresQueCero);
    }
    @Test
    public void testAsignaturaTieneHorasSesion(){
        Asignatura a=new Asignatura("Soft",3,6,2);
        int horasSesion=a.getHorasSesion();
        assertEquals(2,horasSesion);
    }
    @Test
    public void testAsignaturaTieneHorasSesionNoNulasNiNegativas(){
        Asignatura a=new Asignatura("Soft",3,6,1);
        boolean horasSesion=false;
        int horasSes=a.getHorasSesion();
        if(horasSes>0){
            horasSesion=true;
        }
        assertTrue(horasSesion);
    }
    
    @Test
    public void testAsignaturaToString(){
        Asignatura a = new Asignatura("gilingenieria", 1,1,1);
        assertTrue("no imprime nada y debería", a.toString().length() > 0);
    }
     @Test
    public void testAsignaturaVaciaNoImprimeNada(){
        //Asignatura a = new Asignatura("gilingenieria", 1,1,1);
        Asignatura a = new Asignatura();
        assertTrue("imprime algo y no debería", a.toString().length() == 0);
    }
    
}    