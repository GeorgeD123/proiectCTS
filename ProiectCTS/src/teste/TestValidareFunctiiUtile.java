
package teste;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.UtilsFunctions;

public class TestValidareFunctiiUtile {
    
    static String text;

    public TestValidareFunctiiUtile() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        text="TextDeVerificat";
    }

    @After
    public void tearDown() {
        text=null;
    }

    @Test
    public void testText() {
        boolean rezultat = UtilsFunctions.checkText(text);
        assertTrue(rezultat);
    }

    @Test
    public void testTextNotNull() {
        assertNotNull(text);
    }

    @Test
    public void testTextVid() {
        boolean rezultat = UtilsFunctions.checkText("");
        assertFalse(rezultat);
    }

  
    @Test
    public void testcheckNumarCifreCnp() {
        boolean rezultat = UtilsFunctions.checkDigitsCnp("2314342332432");
        assertTrue(rezultat);
    }
    
    @Test
    public void testcheckNumarCifreCnpGresit() {
        boolean rezultat = UtilsFunctions.checkDigitsCnp("231434432");
        assertFalse(rezultat);
    }
   
    @Test
    public void testcheckEmail() {
        boolean rezultat = UtilsFunctions.checkEmail("aaaa@yahoo.com");
        assertTrue(rezultat);
    }
    
    @Test
    public void testcheckEmailIncorect() {
        boolean rezultat = UtilsFunctions.checkEmail("yahoo.com");
        assertFalse(rezultat);
    }

    

}
    
 