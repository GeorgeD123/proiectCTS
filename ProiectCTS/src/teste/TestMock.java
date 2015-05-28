package teste;

//import static org.junit.Assert.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import model.Student;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

public class TestMock extends TestCase {

	Student s;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Incepere test");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	}

	@Before
	public void setUp() throws Exception {
		s=new Student();
		//s.setId(10);
		//s.setNume("Alina");
		//s.setPrenume("Enache");
		 s=Mockito.mock(Student.class);
		when(s.getId()).thenAnswer(new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				return 100;
			}
		});
		//s=Mockito.mock(Student.class);
		when(s.getNume()).thenAnswer(new Answer<String>() {

			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				return "Alina";
			}

			
		});
		//s=Mockito.mock(Student.class);
		when(s.getPrenume()).thenAnswer(new Answer<String>() {

			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				return "Enache";
			}

			
		});
	}

	@After
	public void tearDown() throws Exception {
		s=null;
	}

	@Test
	public void testMock1() {
		
		
		assertEquals(100, s.getId());
	}
	
	@Test
	public void testMock2() {
		
		
		assertEquals("Alina", s.getNume());
	}
	
	@Test
	public void testMock3() {
		
		
		assertEquals("Enache", s.getPrenume());
	}

	
	public static void main(String [] args){
		TestSuite suite = new TestSuite();
		suite.addTest(new TestMock("testMock1"));
		suite.addTest(new TestMock("testMock2"));
		suite.addTest(new TestMock("testMock3"));
		TestRunner.run(suite);
	}
	
	public TestMock(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

}
