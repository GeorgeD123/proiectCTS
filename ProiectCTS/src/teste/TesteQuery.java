
package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Bursier;
import model.Facultate;
import model.Materie;
import model.Nota;
import model.Profesor;
import model.Secretara;
import model.Student;
import model.StudentGrupa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.QueryDatabase;
import utils.UtilsFunctions;

public class TesteQuery {

    private static ArrayList<Nota> noteStudent;
    private static Student studentBursier;
    private static Student studentCuRestante;
    private static Bursier bursier;

    public TesteQuery() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        studentBursier = new Student();
        studentBursier.setId(2);
       
        noteStudent = QueryDatabase.getNoteStudent(studentBursier);

       
        bursier = QueryDatabase.getBursierForStudent(studentBursier);
        
        studentCuRestante = new Student();
        studentCuRestante.setId(82);

    }

    @After
    public void tearDown() {
        studentBursier = null;
        studentCuRestante=null;
        bursier=null;
        noteStudent=null;
    }

    @Test
    public void testgetStudenti() {
        ArrayList<Student> studenti = QueryDatabase.getStudenti();
        assertTrue(studenti.size() > 0);

    }
    
     @Test
    public void testCalculeazaNrNoteZece() {
        UtilsFunctions obiect = new UtilsFunctions();
        ArrayList<Integer> noteInt = new ArrayList<Integer>();
         for (Nota n : noteStudent) {
            noteInt.add(n.getNota());
        }
        double rezultat = obiect.calcNoteZece(noteInt);
        assertEquals(1, rezultat, 0);
    }


    @Test
    public void testgetBursieri() {
        ArrayList<Bursier> b = QueryDatabase.getBursieri();
        assertTrue(b.size() > 0);

    }

    @Test
    public void testgetFacultati() {
        ArrayList<Facultate> f = QueryDatabase.getFacultati();
        assertTrue(f.size() > 0);

    }

    @Test
    public void testgetMaterii() {
        ArrayList<Materie> m = QueryDatabase.getMaterii();
        assertTrue(m.size() > 0);

    }

    @Test
    public void testgetProfesori() {
        ArrayList<Profesor> profi = QueryDatabase.getProfesori();
        assertTrue(profi.size() > 0);

    }

    @Test
    public void testgetSecretare() {
        ArrayList<Secretara> s = QueryDatabase.getSecretare();
        assertTrue(s.size() > 0);

    }

    @Test
    public void testgetNoteStudent() {
        ArrayList<Nota> note = QueryDatabase.getNoteStudent(studentBursier);
        assertTrue(note.size() > 0);

    }

    @Test
    public void testgetMaxIdFromBursieri() {
        int nextId = QueryDatabase.getMaxIdFromBursieri();
        assertTrue(nextId > 0);

    }

    @Test
    public void testgetMaxIdFromFacultate() {
        int nextId = QueryDatabase.getMaxIdFromFacultate();
        assertTrue(nextId > 0);

    }

    @Test
    public void testgetMaxIdFromMaterii() {
        int nextId = QueryDatabase.getMaxIdFromMaterii();
        assertTrue(nextId > 0);

    }

    @Test
    public void testgetMaxIdFromNote() {
        int nextId = QueryDatabase.getMaxIdFromNote();
        assertTrue(nextId > 0);

    }

    @Test
    public void testgetMaxIdFromProfesori() {
        int nextId = QueryDatabase.getMaxIdFromProfesori();
        assertTrue(nextId > 0);

    }

    @Test
    public void testgetMaxIdFromSecretare() {
        int nextId = QueryDatabase.getMaxIdFromSecretare();
        assertTrue(nextId > 0);

    }

    @Test
    public void testgetMaxIdFromStudenti() {
        int nextId = QueryDatabase.getMaxIdFromStudenti();
        assertTrue(nextId > 0);

    }

    @Test
    public void testgetMaxIdFromUsers() {
        int nextId = QueryDatabase.getMaxIdFromUsers();
        assertTrue(nextId > 0);

    }

    
    @Test
    public void testMedieAritmetica() {
        UtilsFunctions obiect = new UtilsFunctions();
        ArrayList<Integer> noteInt = new ArrayList<Integer>();
        for (Nota n : noteStudent) {
            noteInt.add(n.getNota());
        }
        double rezultat = obiect.calcMedieAritmetica(noteInt);
        assertTrue(10.0 == rezultat);
    }

    @Test
    public void testStudentBursier() {
        UtilsFunctions obiect = new UtilsFunctions();
        ArrayList<Nota> note = QueryDatabase.getNoteStudent(studentBursier);
        ArrayList<Integer> noteInt = new ArrayList<Integer>();
        for (Nota n : note) {
            noteInt.add(n.getNota());
        }
        boolean rezultat = obiect.verificaStudentBursier(noteInt);
        assertTrue(rezultat);

    }

    
    @Test
    public void testCheckCardBursieri() {
        ArrayList<Bursier> bursieri = QueryDatabase.getBursieri();
        boolean ok = true;
        for (Bursier b : bursieri) {
            if (!UtilsFunctions.checkCardStudent(b)) {
                ok = false;
            }
        }
        assertTrue(ok);
    }

   
    @Test
    public void testVerificaDacaStudentulEsteBursier() {
        UtilsFunctions obiect = new UtilsFunctions();
        ArrayList<Integer> noteInt = new ArrayList<Integer>();
        for (Nota n : noteStudent) {
            noteInt.add(n.getNota());
        }
        boolean rezultat = obiect.verificaStudentBursier(noteInt);
        assertTrue(rezultat);
    }


    @Test
    public void testCalculeazNrRestanteStudent() {
       
        ArrayList<Integer> noteInt = new ArrayList<Integer>();
        for (Nota n : noteStudent) {
            noteInt.add(n.getNota());
        }
        int rezultat = UtilsFunctions.calcNrRestanteStudent(noteInt);


        assertEquals(rezultat, 0);
    }
    
   
    @Test
    public void testCalculeazaNrRestanteStudentRestantier() {
        ArrayList<Nota> note = QueryDatabase.getNoteStudent(studentCuRestante);
        ArrayList<Integer> noteInt = new ArrayList<Integer>();
        for (Nota n : note) {
            noteInt.add(n.getNota());
        }
        int rezultat = UtilsFunctions.calcNrRestanteStudent(noteInt);

      
        assertTrue(rezultat>0);
    }
    
    
    @Test
    public void testVerificaStudentCuRestanteBursier() {
       
        Bursier bursierNull = QueryDatabase.getBursierForStudent(studentCuRestante);
        assertNull(bursierNull);
    }
    

    
    @Test
    public void testCheckvalabilitateBursier() {
        boolean rezultat = UtilsFunctions.checkvalabilitateBursier(bursier);
        assertTrue(rezultat);
    }

 
    @Test
    public void testGetNrLuniDeBursa() {
        int rezultat = UtilsFunctions.getNrLuniDeBursa(bursier);
        assertEquals(rezultat, 8, 0);
    }


    @Test
    public void testGetValoareTotalaBursa() {
        double rezultat = UtilsFunctions.getValoareTotalaBursa(bursier);
        assertEquals(rezultat, 3200, 0);
    }
    
   
    @Test
    public void testVerificaStudentGrupa() {
        ArrayList<StudentGrupa> studentiGrupa = QueryDatabase.getGrupe();
        boolean rezultat = UtilsFunctions.verificaGrupeStudenti(studentiGrupa);
        assertTrue(rezultat);
    }
    
    
}
