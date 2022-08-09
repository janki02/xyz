 package Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.Factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.Init_Driver(browserName);
	}

	@After(order = 0)
	public void teardown() {
		driver.quit();
	}

	@After(order = 1)
	public void screenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			String sc = scenario.getName().replace(" ", "_");
			byte b[] = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(b, "image/png", sc);
		}

	}

}
