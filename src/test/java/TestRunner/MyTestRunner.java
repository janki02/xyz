package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = {"rc/test/recorses/AppFeature"}, 
		 glue = {"StepDefinition","Hooks"},
		
		 plugin = {"pretty",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				
			},
		 monochrome = true,
		 publish = true
		
			
			)  
public class MyTestRunner {

}
