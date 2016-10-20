/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Objetos.Titulacion;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author angelnuneztorron
 */
public class TestTitulacion extends TestCase{
    
    public TestTitulacion() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testTitulacionTieneNombre(){
        Titulacion titulacion=new Titulacion("ISI",240);
        assertEquals("ISI", titulacion.getNombre());
    }
    @Test
    public void testTitulacionTieneNumeroDeCreditosMayoresQueCero(){
        Titulacion titulacion=new Titulacion("ISI",240);
        boolean creditosMayoresQueCero=false;
        if(titulacion.getCreditos()>0){
            creditosMayoresQueCero=true;
        }
        assertTrue(creditosMayoresQueCero);
    }
    
    @Test
    public void testTitulacionToString(){
        Titulacion t = new Titulacion(1, "Ingenieria Del Software", 6);
        assertTrue("no imprime nada y deberia",  t.toString().length()>0);
    }
    
    @Test
    public void testTitulacion2ToString(){
        Titulacion t = new Titulacion("Ingenieria del Software", 6);
        assertTrue("no imprime nada y deberia", t.toString().length()>0);
        
    }
    
    @Test
    public void testTitulacionVaciaNoImprimeNada(){
        Titulacion t = new Titulacion();
        assertTrue("imprime algo y no deberia",  t.toString().length() == 0);
    }
    /*
    @Test
    public void testAsignaturaToString(){
        Asignatura a = new Asignatura("gilingenieria", 1,1,1);
        assertTrue("no imprime nada y debería", a.toString().length() > 0);
    }
    */
}
