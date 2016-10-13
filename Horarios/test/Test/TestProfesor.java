/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Excepciones.EProfesorSinNombre;
import Objetos.Asignatura;
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
       String email =profesor.getEmail();
       Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
       Matcher mat = pat.matcher(email);
       if(mat.find()){
          emailCorrecto=true;
       }
       assertTrue(emailCorrecto);
     //commitear
    }
    /* esta prueba es mala mala, ya hay un metodo que comprueba que el nombre no puede
        ser null, no se comprobar el metodo.
    
    @Test
    public void testProfesorTieneNombre() throws EProfesorSinNombre{
        Profesor profesor = new Profesor(null, "patat@gmail.com", "1.1.1", 3);
        assertEquals((profesor.getNombre()==null), false);
    }
    */
    public void testProfesorTieneDespacho() throws EProfesorSinNombre{
        Profesor profesor = new Profesor("jose", "j.cara@gmail.com", null, 3);
        assertEquals(profesor.getDespacho()==null, true);
    }
    
    public void testProfesorTieneEmail() throws EProfesorSinNombre{
        Profesor profesor = new Profesor ("jose",  null, "1.1.1", 3);
        assertEquals((profesor.getEmail()==null),true);
    }
    
}
/*
@Test
    public void testAsignaturaSinNombre(){
        Asignatura asignatura=new Asignatura(null,3,6,2);
        boolean nombre = false;
        if(asignatura.getNombre()==null){
            nombre = true;
        }
        assertEquals(true,nombre);
    }
*/