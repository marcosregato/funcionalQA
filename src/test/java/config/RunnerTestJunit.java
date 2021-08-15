package config;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cenarioTeste.TC_001_PaginaPrincipal;

@RunWith(Suite.class)
@SuiteClasses({
	TC_001_PaginaPrincipal.class
})

public class RunnerTestJunit {
	
	/*
	 * public static Test suite() { return new
	 * JUnit4TestAdapter(TC_001_PesquisarRoupa.class); }
	 */
}
