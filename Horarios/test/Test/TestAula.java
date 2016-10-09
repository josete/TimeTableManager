
package Test;

import Objetos.Aula;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertNotNull;
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
public class TestAula extends TestCase {
    
    public TestAula() {
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
    //Estaría bien una expresión regular para el nombre de las aulas
    public void testAulaTieneNombreNoNulo(){
        Aula aula=new Aula("1.5.10",true);
//        assertNotNull(aula.getnAula());
        assertEquals("1.5.10",aula.getnAula());
    }
    
    @Test
    public void testAulaEstaOcupada(){
        Aula aula=new Aula("1.5.10",true);
        assertTrue(aula.getOcupado());
    }
    @Test
    public void testAulaNoEstaOcupada(){
        Aula aula=new Aula("1.5.10",false);
        assertFalse(aula.getOcupado());
    }
}
