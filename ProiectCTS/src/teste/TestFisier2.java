package teste;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;




import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.UtilsFunctions;

public class TestFisier2 {

	static BufferedReader bfreader;
	static FileReader reader;
	static UtilsFunctions u;
	static ArrayList<Integer>lista;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reader = new FileReader(new File("Valori.txt"));
		bfreader = new BufferedReader(reader);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bfreader.close();
		u=null;
		lista.clear();
	}

	@Before
	public void setUp() throws Exception {
		u=new UtilsFunctions();
		lista=new ArrayList<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testcitireFis() {
		
		try {
			String linie = bfreader.readLine();
			while (linie != null ) {
				String[] val = linie.split(",");
				if (val.length>1) {
						int nr = Integer.parseInt(val[0]);
						int nr1 = Integer.parseInt(val[1]);
						int nr2 = Integer.parseInt(val[2]);
						int nr3 = Integer.parseInt(val[3]);
						int nr4 = Integer.parseInt(val[4].trim());
						lista.add(nr);
						lista.add(nr1);
						lista.add(nr2);
						lista.add(nr3);
						System.out.println(nr+" "+nr1+" "+nr2+" "+nr3+"     "+nr4);
						assertEquals(nr4, u.calcMedieAritmetica(lista));
						lista.clear();
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

