package config;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	dryRun = false,
	monochrome = true,
	plugin = {"json:target/cucumber.json"},
	features = {"classpath:features"},
	glue = {"classpath:steps"}
	//tags = {"@tag3"}
		
)

public class RunnerTestCucumber {

}