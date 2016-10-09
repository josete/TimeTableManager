/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Excepciones.EProfesorSinNombre;
import Objetos.Profesor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static junit.framework.Assert.assertEquals;
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
public class TestProfesor extends TestCase{
    
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
    public void testProfesorTieneEmailBienEscrito() throws EProfesorSinNombre{
        boolean emailCorrecto=false;
       Profesor profesor=new Profesor("Raul","rgg@eps.ceu.es","2.1.2");
       String email;
       email =profesor.getEmail();
       Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
       Matcher mat = pat.matcher(email);
       if(mat.find()){
          emailCorrecto=true;
       }
       assertTrue(emailCorrecto);
     //commitear
    }
    
      
}
