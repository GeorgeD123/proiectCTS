package teste;

import static org.junit.Assert.*;
import model.Nota;
import model.Student;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.UtilsFunctions;
import exceptii.ExceptieCNP;
import exceptii.ExceptieId;
import exceptii.ExceptieNota;



public class TestStudent {

 Student s,s2;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		s=new Student();
	}

	@After
	public void tearDown() throws Exception {
		s=s2=null;
	}

	
	
	   

	
	@Test(expected=ExceptieCNP.class)
	
	public void testareExceptieCnp() throws ExceptieCNP {
		
	
			s.setareCnp("12345679");
			
			
	}

	
	
	@Test(expected=ExceptieId.class)
	
	public void testareExceptieId() throws ExceptieId {
		
		s.setareId(0);
	
			
	}
	
	@Test
	
	public void testareGetterId() {
		
		try {
			s.setareId(100);
			assertEquals(100, s.getId());
		} catch (ExceptieId e) {
			assertTrue(true);
		}
	
			
	}
	
	@Test
	
	public void testareGetterNume() {
		
		s.setNume("Ion");
		assertEquals("Ion", s.getNume());
			
	}
	
	@Test
	
	public void testareGetterPrenume() {
		
		s.setPrenume("Marin");
		assertEquals("Marin", s.getPrenume());
			
	}
	
	@Test
	
	public void testareinitializareStudentS() {
		
		
		assertNotNull(s);
			
	}
	
	@Test

	public void testareinitializareStudentS2() {
	
	
	assertNull(s2);
		
	}
	
	@SuppressWarnings("static-access")
	@Test

	public void testareNumeStudentGol() {
	
		s2=new Student();
		s2.setNume("");
		String ss=s2.getNume();
		UtilsFunctions u=new UtilsFunctions();
		assertFalse(u.checkText(ss));
		
	}

	@SuppressWarnings("static-access")
	@Test

	public void testareCnp13CifreTrue() {
	
		s2=new Student();
		s2.setCnp("1234567890123");
		String ss=s2.getCnp();
		UtilsFunctions u=new UtilsFunctions();
		assertTrue(u.checkDigitsCnp(ss));
		
	}
	
	
		
	@SuppressWarnings("unused")
	@Test(expected=ExceptieNota.class)
	public void testareNotaValoriExtreme() throws ExceptieNota {
		
		Nota n=new Nota(12, 5);
		//assertNotNull(n);
		
		
		
	}
}
