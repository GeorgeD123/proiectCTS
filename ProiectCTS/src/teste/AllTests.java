package teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteQuery.class, TestValidareFunctiiUtile.class, TestMock.class,
		TesteProfesori.class, TesteListe.class, TestStudent.class })
public class AllTests {

}
