package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {".//Features/LoginDDTExcel.feature"},
                 glue={"stepsDefination", "hooks"},
                  monochrome = true,
                  plugin = {"pretty","html:reports/myreports.html",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                  dryRun=false)

public class Testngrunner extends AbstractTestNGCucumberTests
{
}

			                                   
