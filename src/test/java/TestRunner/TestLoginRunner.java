package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resource/features",
		glue = "CucumberIntegeration",
		plugin = {"pretty","html:target/htmlReport.html"},
		monochrome = true
		)


public class TestLoginRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider
	
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
