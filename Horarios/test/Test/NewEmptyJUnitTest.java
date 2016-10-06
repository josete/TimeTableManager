<<<<<<< Updated upstream
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

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
    public void unProfesorConNombre(){
        Profesor profesor=new Profesor("Adolfo", "a.dolfo@usp.ceu.es", "");
        assertEquals("Adolfo",profesor.getNombre());
        
    }
}    
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


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
public class NewEmptyJUnitTest extends TestCase{
    
    public NewEmptyJUnitTest() {
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
    public void testDeMierda(){
       boolean t=true;
       assertTrue(t);
    }
            

// TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
>>>>>>> Stashed changes
