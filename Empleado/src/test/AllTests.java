package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmpleadoTestVacio.class, EmpleadoTestNoVacio.class, HijoTest.class })
public class AllTests {

}
