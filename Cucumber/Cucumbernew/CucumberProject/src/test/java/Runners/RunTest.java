package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src/test/java/Resources/Login.feature", "src/test/java/Resources/API.feature"}, glue = {"StepDefinations"},
		plugin = {"pretty", "html:target/cucumber-html-report.html"}
		
)
public class RunTest extends AbstractTestNGCucumberTests{
	
	

}
