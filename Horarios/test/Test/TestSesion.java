/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Objetos.Asignatura;
import Objetos.Grupo;
import Objetos.Sesion;
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
public class TestSesion extends TestCase {
    
    public TestSesion() {
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
    public void testSesionTieneAsignatura(){
        Grupo grupo=new Grupo();
        Asignatura asignatura=new Asignatura();
        Sesion sesion=new Sesion(asignatura, grupo);
        assertEquals(asignatura,sesion.getAsignatura());
    }
    
}
