package teste;
import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Nota;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptii.ExceptieNota;
import utils.UtilsFunctions;

public class TesteListe {

    static ArrayList<Integer> listaNote = null;
    static ArrayList<Nota> noteStudent = null;

    public TesteListe() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ExceptieNota {

        listaNote = new ArrayList<Integer>();
        listaNote.add(9);
        listaNote.add(10);
        listaNote.add(8);
        listaNote.add(9);
        listaNote.add(9);
        listaNote.add(9);
        listaNote.add(9);
        listaNote.add(10);
        listaNote.add(10);
        listaNote.add(8);
        listaNote.add(8);
        listaNote.add(9);
        listaNote.add(9);

        noteStudent = new ArrayList<Nota>();
        noteStudent.add(new Nota(9, 5));
        noteStudent.add(new Nota(10, 5));
        noteStudent.add(new Nota(9, 5));
        noteStudent.add(new Nota(9, 5));
        noteStudent.add(new Nota(8, 5));
        noteStudent.add(new Nota(7, 5));
        noteStudent.add(new Nota(9, 5));
    }

    @After
    public void tearDown() {
        noteStudent = null;
        listaNote = null;
        
    }


    @Test
    public void testMedieAritmetica() {
        UtilsFunctions obiect = new UtilsFunctions();
        double rezultat = obiect.calcMedieAritmetica(listaNote);
        assertEquals(9, rezultat, 0);
    }

    @Test
    public void testMedieAritmeticaGresit() {
        UtilsFunctions obiect = new UtilsFunctions();
        double rezultat = obiect.calcMedieAritmetica(listaNote);
        assertNotSame(10, rezultat);
    }

    @Test
    public void testMediePonderataGresit() {
        UtilsFunctions obiect = new UtilsFunctions();
        double rezultat = obiect.calcMediePonderata(noteStudent);
        assertNotSame(9, rezultat);
    }
    
    @Test
    public void testCalculeazaNoteMaxime() {
        UtilsFunctions obiect = new UtilsFunctions();
        double rezultat = obiect.calcNoteZece(listaNote);
        assertEquals(3, rezultat, 0);
    }

    @Test
    public void testverificaBursier() {
        UtilsFunctions obiect = new UtilsFunctions();
        boolean rezultat = obiect.verificaStudentBursier(listaNote);
        assertTrue(rezultat);
    }

    @Test
    public void testverificaBursierGresit() {
        UtilsFunctions obiect = new UtilsFunctions();
        listaNote.add(4);
        listaNote.add(2);
        listaNote.add(3);
        listaNote.add(3);
        boolean rezultat = obiect.verificaStudentBursier(listaNote);
        assertFalse(rezultat);
    }
}
