package teste;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.Specializare;
import model.Student;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.UtilsFunctions;

public class TestFisier {

	static BufferedReader bfreader;
	static FileReader reader;
	static UtilsFunctions u;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reader = new FileReader(new File("Studenti.txt"));
		bfreader = new BufferedReader(reader);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		u=new UtilsFunctions();
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	public void testcitireFis() {
		Student s = new Student();
		try {
			String linie = bfreader.readLine();
			while (linie != null ) {
				if(linie.startsWith("#"))
					continue;
				String[] values = linie.split(",");
					
						int nr = Integer.parseInt(values[0]);
						s.setId(nr);
						s.setNume(values[1]);
						s.setPrenume(values[2]);
						s.setCnp(values[3]);
						assertTrue(u.checkText(s.getNume()));
						assertTrue(u.checkText(s.getPrenume()));
						assertTrue(u.checkDigitsCnp(values[3]));
						
						
				}
					linie = bfreader.readLine();
			

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Test
	public void testcitireFisAlteValori() {
		Specializare sp=new Specializare();
		try {
			String linie = bfreader.readLine();
			while (linie != null ) {
				String[] values = linie.split(",");
					if (values[0].equals("#")) {
						int nr = Integer.parseInt(values[1]);
						sp.setId(nr);
						sp.setSpecializare(values[2]);
						sp.setIdFacultate(Integer.parseInt(values[3]));
						assertTrue(u.checkText(sp.getSpecializare()));
						
						
						
				}
					linie = bfreader.readLine();
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
}
