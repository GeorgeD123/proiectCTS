
package teste;

import static org.junit.Assert.*;
import model.Profesor;
import model.Student;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.UtilsFunctions;

public class TesteProfesori {

    Student s1;
    Student s2;
    Profesor p1;
    Profesor p2;
    Profesor p3;

    public TesteProfesori() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        s1 = new Student();
        s2 = new Student();
        p1 = new Profesor();
        p2 = new Profesor();
        p3 = new Profesor();

        s1.setAdresa("Str Emil Miron, Bucuresti");
        s1.setAn(2);
        s1.setCetatenie("Roman");
        s1.setCnp("1232323232333");
        s1.setFormaFinantare("BUGET");
        s1.setId(1);
        s1.setNume("Firica");
        s1.setPrenume("Madalin");
        s1.setTelefon("0787565656");

        s2.setAdresa("Str Breaza, Bucuresti");
        s2.setAn(2);
        s2.setCetatenie("Roman");
        s2.setCnp("2232323232333");
        s2.setFormaFinantare("BUGET");
        s2.setId(2);
        s2.setNume("Manea");
        s2.setPrenume("Costina");
        s2.setTelefon("0787534656");

        p1.setCnp("2232323442333");
        p1.setId(1);
        p1.setNume("Cocianu");
        p1.setPrenume("Mihaela");
        p1.setTelefon("0787034656");
        p1.setCatedra("Informatica");

        p2.setCnp("1232323442333");
        p2.setId(2);
        p2.setNume("Ionita");
        p2.setPrenume("Cristian");
        p2.setTelefon("0787034656");
        p2.setCatedra("Informatica");

        p3.setCnp("1232323442333");
        p3.setId(2);
        p3.setNume("Ionita");
        p3.setPrenume("Cristian");
        p3.setTelefon("0787034656");
        p3.setCatedra("Informatica");

    }

    @After
    public void tearDown() {
        p1 = null;
        p2 = null;
        p3 = null;
        s1 = null;
        s2 = null;

    }

    @Test
    public void testObiecteInitializate() {
        assertNotNull(s1);
        assertNotNull(s2);
        assertNotNull(p1);
        assertNotNull(p2);
        assertNotNull(p3);
    }

    @Test
    public void testInitializare() {
        assertTrue((s1 != null) && (s2 != null));
    }

    @Test
    public void testStudentiIdentici() {
        assertNotSame(s1, s2);
    }

    @Test
    public void testProfesori() {
        assertTrue(p2.getId() == p3.getId());
    }

    @Test
    public void testProfesoriCatedra() {
        UtilsFunctions obiect = new UtilsFunctions();
        boolean rezultat = obiect.verificaProfesorCatedra(p1, p2);
        assertTrue(rezultat);
    }

    @Test
    public void testStudentiAcelasiAn() {
        
        boolean rezultat = UtilsFunctions.checkStudentiAcelasiAn(s1, s2);
        assertTrue(rezultat);
    }
    
    

}
