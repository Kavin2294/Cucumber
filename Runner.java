package testNgRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src/main/java/feature/cucumber.feature",glue = {"stepdefinition"}, monochrome = true, publish = true)
public class Runner extends AbstractTestNGCucumberTests{
	

}
