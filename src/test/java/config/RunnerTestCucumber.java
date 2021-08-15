package config;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	dryRun = false,
	monochrome = true,
	strict = true,
	plugin = {"json:target/cucumber.json"},
	snippets = SnippetType.UNDERSCORE,
	features = {"classpath:features"},
	glue = {"classpath:steps"}
	//tags = {"@tag3"}
		
)

public class RunnerTestCucumber {

}